package com.dbsy.student.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.dbsy.student.service.MajorService;
import org.springframework.stereotype.Component;

public class MajorNameToIdConverter implements Converter<Integer> {

    MajorService majorService = (MajorService) SpringContext.getApplicationContext().getBean("majorServiceImp");

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
            return majorService.getByName(cellData.getStringValue().trim()).getId();
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (integer != null)
            return new CellData(majorService.get(integer).getName());
        return null;
    }
}
