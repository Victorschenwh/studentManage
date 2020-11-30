package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.service.DepartmentService;
import com.dbsy.student.vo.IndexVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School, Role.Student})
public class IndexController {
    @Autowired
    DepartmentService departmentService;

    @Autowired
    IndexVoService indexVoService;

    @RequestMapping("")
    //@Authority({Role.Teacher, Role.Admin})
    public String index(HttpSession session, Model model) {
        session.setAttribute("departments", departmentService.getAll());

        return "index";
    }

    @RequestMapping("/home")
    //@Authority({Role.Teacher, Role.Admin})
    public String home(Model model) {
        model.addAttribute("indexVo", indexVoService.indexVo());
        return "home/start";
    }

}
