package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Teacher;
import com.dbsy.student.service.TeacherService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
@Authority(Role.Admin)
public class TeacherController {
    @Autowired
    @Qualifier("teacherServiceImp")
    TeacherService teacherService;


    @RequestMapping("")
    @Authority(Role.Teacher)
    public String teacher() {
        return "baseInfo/teacher";
    }


    @RequestMapping("/list")
    @ResponseBody
    @Authority(Role.Teacher)
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", teacherService.listCount(map));
        m.put("rows", teacherService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (teacherService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (teacherService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Teacher teacher) {
        if (teacherService.insert(teacher) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map update(Teacher teacher) {
        if (teacherService.update(teacher) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    @Authority(Role.Teacher)
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", teacherService.get(id));
    }

    @ResponseBody
    @RequestMapping("/getAll")
    @Authority(Role.Teacher)
    public Map getAll() {
        return News.success("成功", teacherService.getAll());
    }

}
