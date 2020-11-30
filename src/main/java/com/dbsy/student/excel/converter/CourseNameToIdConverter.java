package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dbsy.student.excel.SpringContext;
import com.dbsy.student.service.ClazzService;
import com.dbsy.student.service.CourseService;
import com.dbsy.student.service.iml.CourseServiceImp;

public class CourseNameToIdConverter implements Converter<Integer> {
    CourseService courseService = (CourseService) SpringContext.getApplicationContext().getBean("courseServiceImp");

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
        if (cellData != null && cellData.getStringValue() != null)
            return courseService.getCourseByName(cellData.getStringValue().trim()).getId();
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (integer != null)
            return new CellData(courseService.get(integer).getName());
        return null;
    }
}
