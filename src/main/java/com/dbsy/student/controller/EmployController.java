package com.dbsy.student.controller;

import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.EmploymentService;
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
@RequestMapping("/employ")
public class EmployController {
    @Autowired
    @Qualifier("employmentServiceImp")
    EmploymentService employmentService;

    @RequestMapping("")
    public String employ() {
        return "employ/employ";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", employmentService.listCount(map));
        m.put("rows", employmentService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        Student student = employmentService.get(id);
        return student != null ? News.success("OK", student) : News.fail("学生不存在");
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (employmentService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {
        if (employmentService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Employment employment) {
        if (employmentService.insert(employment) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }
}