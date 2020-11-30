package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class StringToBooleanConverter implements Converter<Boolean> {
    @Override
    public Class supportJavaTypeKey() {
        return Boolean.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Boolean convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (cellData != null && cellData.getNumberValue() != null)
            return cellData.getNumberValue().equals(1) ? true : false;
        return null;

    }

    @Override
    public CellData convertToExcelData(Boolean aBoolean, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (aBoolean != null)
            return new CellData(aBoolean ? "1" : "0");
        return null;
    }
}
