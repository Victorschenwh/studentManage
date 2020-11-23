package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.service.ScoreService;
import com.dbsy.student.util.News;
import com.dbsy.student.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class ScoreController {
    @Autowired
    @Qualifier("scoreServiceImp")
    ScoreService scoreService;


    @RequestMapping("/slip")
    public String slip() {
        return "stuInfo/slip";
    }

    @RequestMapping("/slipList")
    @ResponseBody
    public Map slipList(@RequestParam Map map) {
        // 获取全部下滑学生
        List list = scoreService.slip(map);
        Map m = new HashMap();
        m.put("total", list.size());
        m.put("rows", list.subList(Integer.parseInt(map.get("start") + ""), (Integer.parseInt(map.get("start") + "") + Integer.parseInt(map.get("pageSize") + ""))
                > list.size() ? list.size() : (Integer.parseInt(map.get("start") + "") + Integer.parseInt(map.get("pageSize") + ""))));
        return m;
    }

    //   @Authority({Role.Teacher})
    @RequestMapping("")
    public String score() {
        return "scoinfo/score";
    }

    @RequestMapping("/total")
    public String total() {
        return "scoinfo/total";
    }

    @RequestMapping("/gradePoint")
    public String gradePoint() {
        return "scoinfo/gradePoint";
    }

    //   @Authority({Role.Teacher})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map list(@RequestParam Map map) {
        String str = (String) map.get("search");
        if (str.matches("[a-zA-Z]+")) {
            map.put("abbrName", str);
            map.put("search", "");
        }
        Map m = new HashMap();
        m.put("total", scoreService.countRank(map));
        m.put("rows", scoreService.listRank(map));
        return m;
    }

    @RequestMapping(value = "/totalList", method = RequestMethod.GET)
    @ResponseBody
    public Map totalList(@RequestParam Map map) {
        String str = (String) map.get("search");
        if (str.matches("[a-zA-Z]+")) {
            map.put("abbrName", str);
            map.put("search", "");
        }
        Map m = new HashMap();
        m.put("total", scoreService.countTotal(map));
        m.put("rows", scoreService.listTotal(map));
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
