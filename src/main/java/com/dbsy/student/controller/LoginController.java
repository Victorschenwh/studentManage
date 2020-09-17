package com.dbsy.student.controller;

import com.dbsy.student.annotation.Login;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.pojo.Teacher;
import com.dbsy.student.service.AdminService;
import com.dbsy.student.service.TeacherService;
import com.dbsy.student.util.Check;
import com.dbsy.student.util.JWTUtils;
import com.dbsy.student.util.News;
import com.dbsy.student.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    @Qualifier("adminServiceImp")
    AdminService adminService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 登陆失败,次数加1,缓存时间为1小时
     *
     * @param key
     */
    public void limit(String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, Integer.parseInt(redisTemplate.opsForValue().get(key) + "") + 1);
        } else {
            redisTemplate.opsForValue().set(key, 0, 1, TimeUnit.HOURS);
        }
    }


    @RequestMapping("/admin")
    @Login
    @ResponseBody
    public Map admin(String username, String password, HttpSession httpSession, HttpServletRequest request) {

        Admin admin = null;

        if (username != null) {
            admin = adminService.selectByUsernameAndPassword(username, password);

        }

        if (admin == null) {
            String ip = request.getRemoteAddr();
            this.limit(username);
            this.limit(ip);
            return News.fail("用户名或密码不正确");
        }

        if (!admin.getIsLock()) {
            //不是学生登录
            if (admin.getRole() != Role.Student.getRole()) {
                httpSession.setAttribute("user", admin);
                return News.success();
            }
            //学生登录
            Map map = new HashMap<String, String>();
            map.put("studentId", admin.getForeignId());
            map.put("id", admin.getId());
            return News.success("ok", JWTUtils.getToken(map));
        } else {
            return News.fail("操作过于频繁,被锁定,请联系管理员!");
        }

    }


    @RequestMapping("/emailLogin")
    @Login
    @ResponseBody
    public Map emailLogin(String email, String captcha, HttpServletRequest request, HttpSession httpSession) {
        String ip = request.getRemoteAddr();

        if (captcha != null && captcha.equals(redisTemplate.opsForValue().get(ip + email) + "")) {
            Admin admin = adminService.selectByEmail(email);
            //不是学生登录
            if (admin.getRole() != Role.Student.getRole()) {
                httpSession.setAttribute("user", admin);
                return News.success();
            }
            //学生登录
            Map map = new HashMap<String, String>();
            map.put("id", admin.getId());
            map.put("studentId", admin.getForeignId());
            return News.success("ok", JWTUtils.getToken(map));
        }
        this.limit(email);
        return News.fail("验证码错误");

    }

    @RequestMapping("/send")
    @Login
    @ResponseBody
    public Map send(String email, HttpServletRequest request) {

        String ip = request.getRemoteAddr();

        if (!Check.isEmail(email)) {
            return News.fail("邮箱格式有问题");
        }
        String captcha = new Random().nextInt(1000000) + "";

        redisTemplate.opsForValue().set(ip + email, captcha, 60, TimeUnit.SECONDS);

        SendEmail.send(email, "student 系统", captcha);

        return News.success();
    }


}
