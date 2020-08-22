package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Reward;
import com.dbsy.student.pojo.Score;
import com.dbsy.student.service.RewardService;
import com.dbsy.student.service.ScoreService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score")
@Authority({Role.Admin})
public class RewardController {
    @Autowired
    @Qualifier("rewardServiceImp")
    RewardService rewardService;

    @Authority({Role.Teacher})
    @RequestMapping("")
    public String reward() {
        return "baseInfo/reward";
    }


    @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", rewardService.listCount(map));
        m.put("rows", rewardService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (rewardService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (rewardService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Reward reward) {
        if (rewardService.insert(reward) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map update(Reward reward) {
        if (rewardService.update(reward) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", rewardService.get(id));
    }

    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", rewardService.getAll());
    }

    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRewardByStudentId/{studentId}")
    public Map getRewardByStudentId(@PathVariable("studentId") int studentId){
        List list = rewardService.getRewardByStudentId(studentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }
}
