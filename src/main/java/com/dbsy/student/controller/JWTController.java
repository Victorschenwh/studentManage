package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.*;
import com.dbsy.student.service.*;
import com.dbsy.student.util.JWTUtils;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Authority(Role.Student)
@Controller
@RequestMapping("/mini")
@ResponseBody
public class JWTController {
    @Autowired
    StudentService studentService;
    @Autowired
    FamilyService familyService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    @Qualifier("retardationServiceImp")
    RetardationService retardationService;
    @Autowired
    @Qualifier("rewardServiceImp")
    RewardService rewardService;
    @Autowired
    @Qualifier("SuspensionServiceImp")
    SuspensionService suspensionService;
    @Autowired
    @Qualifier("employmentServiceImp")
    EmploymentService employmentService;
    @Autowired
    TransferService transferService;


    @RequestMapping("/student")
    public Map student(String token) {
        Student student = studentService.get(JWTUtils.parseToken(token).get("studentId").asInt());
        return student != null ? News.success("ok", student) : News.fail();
    }

    @RequestMapping("/family")
    public Map family(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        List<Family> familyList = familyService.getFamilyByStudentId(studentId);
        return familyList != null && familyList.size() > 0 ? News.success("ok", familyList) : News.fail();
    }

    @RequestMapping("/employ")
    public Map employ(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        Employment employment = employmentService.getByStudentId(studentId);
        return employment != null ? News.success("ok", employment) : News.fail();
    }


    @RequestMapping("/retardation")
    public Map retardation(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        List<Retardation> retardations = retardationService.getRetardationByStudentId(studentId);
        return retardations != null && retardations.size() > 0 ? News.success("ok", retardations) : News.fail();
    }


    @RequestMapping("/transfer")
    public Map transfer(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        List<Transfer> transfers = transferService.getTransferByStudentId(studentId);
        return transfers != null && transfers.size() > 0 ? News.success("ok", transfers) : News.fail();
    }

    @RequestMapping("/suspension")
    public Map suspension(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        List<Suspension> suspensions = suspensionService.getSuspensionByStudentId(studentId);
        return suspensions != null && suspensions.size() > 0 ? News.success("ok", suspensions) : News.fail();
    }

    @RequestMapping("/reward")
    public Map reward(String token) {
        int studentId = JWTUtils.parseToken(token).get("studentId").asInt();
        List<Reward> rewards = rewardService.getRewardByStudentId(studentId);
        return rewards != null && rewards.size() > 0 ? News.success("ok", rewards) : News.fail();
    }
}
