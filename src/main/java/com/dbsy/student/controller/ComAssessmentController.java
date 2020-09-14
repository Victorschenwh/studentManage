package com.dbsy.student.controller;

import com.dbsy.student.pojo.Score;
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
@RequestMapping("/assessment")
public class ComAssessmentController {

    @Autowired
    @Qualifier("scoreServiceImp")
    ScoreService scoreService;

    @RequestMapping("")
    public String assessment() {
        return "scoinfo/comAssessment";
    }



    @RequestMapping("/list")
    @ResponseBody
    public Map listScore(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", scoreService.listCountSelf(map));
        m.put("rows", scoreService.listScore(map));
        return m;
    }

}
