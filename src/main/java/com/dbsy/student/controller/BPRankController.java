package com.dbsy.student.controller;

import com.dbsy.student.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bprank")
public class BPRankController {

    @Autowired
    @Qualifier("scoreServiceImp")
    ScoreService scoreService;

    @RequestMapping("")
    public String bprank() {
        return "scoinfo/bpRank";
    }



    @RequestMapping("/list")
    @ResponseBody
    public Map listRank(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", scoreService.listCountRank(map));
        m.put("rows", scoreService.listRank(map));
        return m;
    }

}
