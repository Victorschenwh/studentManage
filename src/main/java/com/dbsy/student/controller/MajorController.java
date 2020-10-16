package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Major;
import com.dbsy.student.service.MajorService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/major")
public class MajorController {
    @Autowired
    @Qualifier("majorServiceImp")
    MajorService majorService;

    @Authority({Role.Teacher})
    @RequestMapping("")
    public String major() {
        return "baseInfo/major";
    }


    @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", majorService.listCount(map));
        m.put("rows", majorService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (majorService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (majorService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Major major) {
        if (majorService.insert(major) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map update(Major major) {
        if (majorService.update(major) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }


    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", majorService.get(id));
    }


    @ResponseBody
    @RequestMapping(value = "/getAll")
    public Map getAll() {

        return News.success("成功", majorService.getAll());
    }


    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getMajorsByDpartmentId/{departmentId}")
    public Map getMajorsByDpartmentId(@PathVariable("departmentId") int departmentId){
        List list = majorService.getMajorsByDpartmentId(departmentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }


}
