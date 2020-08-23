package com.dbsy.student.controller;

import com.alibaba.excel.EasyExcel;
import com.dbsy.student.excel.DataListener;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.service.iml.EmploymentServiceImp;
import com.dbsy.student.service.iml.StudentServiceImp;
import com.dbsy.student.util.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class ExcelController {

    @PostMapping("/upload")
    @ResponseBody
    public Map upload(MultipartFile file, String type) throws IOException {
        switch (type) {
            case "employment":
                EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(new EmploymentServiceImp())).sheet().doRead();
                break;
            case "student":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(new StudentServiceImp())).sheet().doRead();
                break;
        }

        return News.success();
    }
}
