package com.dbsy.student.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.util.Date;

public class DateFormatConverter implements Converter<Date> {
    @Override
    public Class supportJavaTypeKey() {
        return Date.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Date convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        System.out.println(cellData.toString());
        Date date = new Date();
        date.setYear(Integer.parseInt(cellData.toString().substring(0, 4)));
        date.setMonth(Integer.parseInt(cellData.toString().substring(4, 6)));
        date.setDate(Integer.parseInt(cellData.toString().substring(6, 8)));
        return date;
    }

    @Override
    public CellData convertToExcelData(Date date, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
