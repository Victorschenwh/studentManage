package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class GenderConverter implements Converter<Boolean> {
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

        try {
            if (cellData == null || "".equals(cellData.toString().trim())) {
                return null;
            }
            if ("男".equals(cellData.toString().trim())) {
                return true;
            } else if ("女".equals(cellData.toString().trim())) {
                return false;
            } else if ("0".equals(cellData.toString().trim())) {
                return false;
            } else if ("1".equals(cellData.toString().trim())) {
                return true;
            } else
                return null;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public CellData convertToExcelData(Boolean aBoolean, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return aBoolean ? new CellData("男") : new CellData("女");
    }
}
