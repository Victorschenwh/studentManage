package com.dbsy.student.controller;

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
public class PreWarningController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("")
    public String preWarning() {
        return "stuInfo/preWarning";
    }


    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {
        String str= (String) map.get("search");
        if(str.matches("[a-zA-Z]+")){
            map.put("abbrName",str);
            map.put("search","");
        }
        Map m = new HashMap();
        m.put("total", scoreService.preWarmingCount(map));
        m.put("rows", scoreService.preWarming(map));
        return m;
    }

}
