package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("")
    @Authority({Role.Teacher, Role.Admin})
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    @Authority({Role.Teacher, Role.Admin})
    public String home(Model model) {
        return "home/home";
    }

}
