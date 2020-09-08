package com.dbsy.student.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dbsy.student.service.StudentService;

public class StudentNumberToIdConverter implements Converter<Integer> {

    StudentService studentService = (StudentService) SpringContext.getApplicationContext().getBean("studentServiceImp");

    @Override
    public Class supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        System.out.println("cellData:" + cellData.getNumberValue().toString());
        return studentService.selectByNumber(cellData.getNumberValue().toString().split("\\.")[0]).getId();
    }

    @Override
    public CellData convertToExcelData(Integer i, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(studentService.get(i).getNumber());
    }
}
