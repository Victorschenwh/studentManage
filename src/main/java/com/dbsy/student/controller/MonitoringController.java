package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.annotation.Remarks;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.vo.ExportStudentInfoService;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/monitoring")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class MonitoringController {

    @Autowired
    @Qualifier("studentServiceImp")
    StudentService studentService;

    @Autowired
    ExportStudentInfoService exportStudentInfoService;

    @RequestMapping("")
    @Remarks("学业监控页面")
    public String monitoring() {
        return "stuInfo/monitoring";
    }

    @RequestMapping("/pdf/{id}")
    @Remarks("个人学业监控表格")
    public String pdf(@PathVariable("id") int id, Model model) {
        model.addAttribute("exportStudentInfo",exportStudentInfoService.get(id));
        return "stuInfo/profile";
    }


    @RequestMapping("/list")
    @ResponseBody
    @Remarks("学业监控列表")
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", studentService.listCount(map));
        m.put("rows", studentService.list(map));
        return m;
    }

}
