package com.dbsy.student.controller;

import com.dbsy.student.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/student")
    String stu() {
        return "auth/student";
    }

    @RequestMapping("/assistant")
    String ass() {
        return "auth/assistant";
    }

    @RequestMapping("/depLead")
    String deLead() {
        return "auth/departLeader";
    }

    @RequestMapping("/scLead")
    String admin() {
        return "auth/schLeader";
    }

    @RequestMapping("/studentList")
    @ResponseBody
    Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findAdminCount(map));
        m.put("rows", adminService.findAdmin(map));
        return m;
    }

    @RequestMapping("/assistantList")
    @ResponseBody
    Map assList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findAssistantCount(map));
        m.put("rows", adminService.findAssistant(map));
        return m;
    }

    @RequestMapping("/departList")
    @ResponseBody
    Map deList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findDepartLeaderCount(map));
        m.put("rows", adminService.findDepartLeader(map));
        return m;
    }

    @RequestMapping("/schList")
    @ResponseBody
    Map scList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findSchoolLeaderCount(map));
        m.put("rows", adminService.findSchoolLeader(map));
        return m;
    }
}
