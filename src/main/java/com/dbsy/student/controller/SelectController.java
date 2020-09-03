package com.dbsy.student.controller;

import com.dbsy.student.pojo.Department;
import com.dbsy.student.service.ClazzService;
import com.dbsy.student.service.DepartmentService;
import com.dbsy.student.service.MajorService;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/select")
public class SelectController {


    @Autowired
    @Qualifier("majorServiceImp")
    MajorService majorService;


    @Autowired
    @Qualifier("clazzServiceImp")
    ClazzService clazzService;


    @Autowired
    @Qualifier("studentServiceImp")
    StudentService studentService;

    @Autowired
    @Qualifier("departmentServiceImp")
    DepartmentService departmentService;

    @RequestMapping("/department/getAll")
    public Map department() {
        List list = departmentService.getAll();
        if (list != null && list.size() > 0)
            return News.success("ok", list);
        else
            return News.fail();
    }

    @RequestMapping("/major/{departmentId}")
    public Map major(@PathVariable("departmentId") int departmentId) {
        List list = majorService.getMajorsByDpartmentId(departmentId);
        if (list != null && list.size() > 0)
            return News.success("ok", list);
        else
            return News.fail();
    }

    @RequestMapping("/clazz/{majorId}/{grade}")
    public Map clazz(@PathVariable("majorId") int majorId, @PathVariable("grade") int grade) {
        List list = null;
        if (grade >= 0)
            list = clazzService.getClazzsByMajorIdAndGrade(majorId, grade);
        else {
            list = clazzService.getClazzByMajorId(majorId);
        }
        if (list != null && list.size() > 0)
            return News.success("ok", list);
        else
            return News.fail();
    }


}
