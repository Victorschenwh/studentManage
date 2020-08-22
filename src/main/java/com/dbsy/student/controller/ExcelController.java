package com.dbsy.student.controller;

import com.alibaba.excel.EasyExcel;
import com.dbsy.student.excel.DataListener;
import com.dbsy.student.pojo.Employment;
import com.dbsy.student.service.iml.EmploymentServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ExcelController {

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(new EmploymentServiceImp())).sheet().doRead();
        return "success";
    }
}
