package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.annotation.Remarks;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.ScoreService;
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
import java.util.Map;

@Controller
@RequestMapping("/preWarning")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class PreWarningController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("")
    @Remarks("学业预警页面")
    public String preWarning() {
        return "stuInfo/preWarning";
    }


    @RequestMapping("/list")
    @ResponseBody
    @Remarks("学业预警列表")
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", scoreService.preWarmingCount(map));
        m.put("rows", scoreService.preWarming(map));
        return m;
    }

}
