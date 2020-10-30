package com.dbsy.student.controller;

import com.dbsy.student.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping("")
    String history() {
        return "history/history";
    }

    @RequestMapping("/list")
    @ResponseBody
    Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", historyService.count(map));
        m.put("rows", historyService.list(map));
        return m;
    }

}
