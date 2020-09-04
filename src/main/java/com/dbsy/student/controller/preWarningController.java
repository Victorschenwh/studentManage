package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Clazz;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.ClazzService;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/preWarning")
@Authority({Role.Admin})
public class preWarningController {

//    @Autowired
//    @Qualifier("clazzServiceImp")
//    ClazzService clazzService;

    @Autowired
    @Qualifier("studentServiceImp")
    StudentService studentService;

    @Authority({Role.Teacher})
    @RequestMapping("")
    public String preWarning() {
        return "stuInfo/preWarning";
    }



    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", studentService.listCount(map));
        m.put("rows", studentService.list(map));
        return m;
    }


    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (studentService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {
        if (studentService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Student student) {
        if (studentService.insert(student) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }


    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        Student student = studentService.get(id);
        return student != null ? News.success("OK", student) : News.fail("不存在");
    }


}
