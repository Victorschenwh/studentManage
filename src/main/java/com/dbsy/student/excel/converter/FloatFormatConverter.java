package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class FloatFormatConverter implements Converter<Float> {
    @Override
    public Class supportJavaTypeKey() {
        return Float.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Float convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if ("无".equals(cellData.toString()) || "".equals(cellData.toString()) || "忘了".equals(cellData.toString()))
            return null;
        else {
            return Float.parseFloat(cellData.toString()) > 0 ? Float.parseFloat(cellData.toString()) : null;
        }
    }

    @Override
    public CellData convertToExcelData(Float aFloat, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
