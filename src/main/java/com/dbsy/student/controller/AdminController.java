package com.dbsy.student.controller;

import com.dbsy.student.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/student")
    String admin() {
        return "auth/student";
    }

    @RequestMapping("/list")
    Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findAdminCount(map));
        m.put("rows", adminService.findAdmin(map));
        return m;
    }
}
