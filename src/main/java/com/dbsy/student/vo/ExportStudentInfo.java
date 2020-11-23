package com.dbsy.student.vo;

import com.dbsy.student.pojo.*;

import java.util.List;
import java.util.Map;

public class ExportStudentInfo {
    public Student student;
    public Department department;
    public Major major;
    public Clazz clazz;
    public List<Family> families;
    public List<Reward> rewards;
    public List<Map> score;//智育
    public List<Map> total;//综测
    public int fail;//挂科


    public ExportStudentInfo() {

    }

    @Override
    public String toString() {
        return "ExportStudentInfo{" +
                "student=" + student +
                ", department=" + department +
                ", major=" + major +
                ", clazz=" + clazz +
                ", families=" + families +
                ", rewards=" + rewards +
                ", score=" + score +
                ", total=" + total +
                ", fail=" + fail +
                '}';
    }
}
