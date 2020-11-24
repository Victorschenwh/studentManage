package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.annotation.Remarks;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reward")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class RewardController {
    @Autowired
    @Qualifier("rewardServiceImp")
    RewardService rewardService;


    @RequestMapping("")
    @Remarks("奖惩界面")
    public String reward() {
        return "rewinfo/reward";
    }


    @RequestMapping("/list")
    @ResponseBody
    @Remarks("奖惩列表")
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", rewardService.listCount(map));
        m.put("rows", rewardService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    @Remarks("移除单条奖惩记录")
    public Map remove(@PathVariable("id") int id) {
        if (rewardService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    @Remarks("批量移除奖惩记录")
    public Map batchRemove(int[] ids) {

        if (rewardService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @Remarks("添加单条奖惩记录")
    @RequestMapping("/insert")
    public Map insert(Reward reward) {
        if (rewardService.insert(reward) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    @Remarks("修改奖惩记录")
    public Map update(Reward reward) {
        if (rewardService.update(reward) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    @Remarks("获取单条奖惩记录")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", rewardService.get(id));
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    @Remarks("获取全部奖惩记录")
    public Map getAll() {
        return News.success("成功", rewardService.getAll());
    }

    //   @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRewardsByStudentId/{studentId}")
    @Remarks("获取某学生的所有奖惩记录")
    public Map getRewardsByStudentId(@PathVariable("studentId") int studentId) {
        List list = rewardService.getRewardByStudentId(studentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    @ResponseBody
    @RequestMapping("/getRewardsByStudentIdAndStudyTerm/{studentId}/{studyTerm}")
    @Remarks("获取某学生某个学期的所有奖惩记录")
    public Map getRewardsByStudentIdAndStudyTerm(@PathVariable("studentId") int studentId, @PathVariable("studyTerm") int studyTerm) {
        List list = rewardService.getRewardsByStudentIdAndStudyTerm(studentId, studyTerm);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }
}
