package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dbsy.student.excel.SpringContext;
import com.dbsy.student.service.ClazzService;
import com.dbsy.student.service.iml.ClazzServiceImp;

public class ClazzNameToIdConverter implements Converter<Integer> {


    ClazzService clazzService = (ClazzService) SpringContext.getApplicationContext().getBean("clazzServiceImp");

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
            return clazzService.getByName(cellData.getStringValue()).getId();
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        //System.out.println("------------------------" + integer + "---------------------------");
        if (integer != null)
            return new CellData(clazzService.get(integer).getName());
        return null;
    }
}
