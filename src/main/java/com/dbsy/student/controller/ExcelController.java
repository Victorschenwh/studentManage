package com.dbsy.student.controller;

import com.alibaba.excel.EasyExcel;
import com.dbsy.student.excel.DataListener;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.DepartmentService;
import com.dbsy.student.service.FamilyService;
import com.dbsy.student.service.iml.*;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    @Qualifier("employmentServiceImp")
    EmploymentServiceImp employmentServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    FamilyServiceImp familyServiceImp;

    @Autowired
    MajorServiceImp majorServiceImp;

    @PostMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        switch (type) {
            case "employment":
                EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(employmentServiceImp)).sheet().doRead();
                break;
            case "student":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(studentServiceImp)).sheet().doRead();
                break;
            case "department":
                EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(departmentServiceImp)).sheet().doRead();
                break;
            case "family":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(familyServiceImp)).sheet().doRead();
                break;
            case "major":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(majorServiceImp)).sheet().doRead();
                break;
        }
        return News.success();
    }
}
