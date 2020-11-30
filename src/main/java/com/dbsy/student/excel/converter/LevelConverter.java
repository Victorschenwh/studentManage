package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class LevelConverter implements Converter<Integer> {
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
        if ("院级".equals(cellData.toString().trim())) {
            return 20;
        } else if ("校级".equals(cellData.toString().trim())) {
            return 10;
        } else if (cellData.toString().trim().matches("\\d+")) {
            return Integer.parseInt(cellData.toString().trim());
        } else if (cellData.toString().trim().matches("\\d+级")) {
            return Integer.parseInt(cellData.toString().trim().substring(0, cellData.toString().trim().length() - 1));
        }
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
