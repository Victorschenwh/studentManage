package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dbsy.student.excel.SpringContext;
import com.dbsy.student.service.DepartmentService;
import com.dbsy.student.service.iml.DepartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class DepartmentNameToIdConverter implements Converter<Integer> {

    DepartmentService departmentService = (DepartmentService) SpringContext.getApplicationContext().getBean("departmentServiceImp");

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
            return departmentService.getByName(cellData.getStringValue().trim()).getId();
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (integer != null)
            return new CellData(departmentService.get(integer).getName());
        return null;
    }
}