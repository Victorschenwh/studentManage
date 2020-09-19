package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.service.ScoreService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score")
//@Authority({Role.Admin})
public class ScoreController {
    @Autowired
    @Qualifier("scoreServiceImp")
    ScoreService scoreService;

    //   @Authority({Role.Teacher})
    @RequestMapping("")
    public String score() {
        return "scoinfo/score";
    }

    @RequestMapping("/total")
    public String total() {
        return "scoinfo/total";
    }

    //   @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", scoreService.countRank(map));
        m.put("rows", scoreService.listRank(map));
        return m;
    }

    @RequestMapping("/totalList")
    @ResponseBody
    public Map totalList(@RequestParam Map map) {
        Map m = new HashMap();
        // m.put("total", scoreService.countRank(map));
        m.put("data", scoreService.listTotal(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (scoreService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (scoreService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Score score) {
        if (scoreService.insert(score) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map update(Score score) {
        if (scoreService.update(score) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", scoreService.get(id));
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", scoreService.getAll());
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getScoreByStudentId/{studentId}")
    public Map getScoreByStudentId(@PathVariable("studentId") int studentId) {
        List list = scoreService.getScoreByStudentId(studentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }
}
