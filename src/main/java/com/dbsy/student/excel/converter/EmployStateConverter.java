package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

public class EmployStateConverter implements Converter<Integer> {
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
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer integer, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        /**
         * 毕业去向
         * 0：不就业拟升学；
         * 1：待就业、拟参加公招考试；
         * 2：待就业、签约中；
         * 3：待就业、求职中；
         * 4：其他暂不就业；
         * 5：签就业协议形式就业；
         * 6：签劳动合同形式就业；
         * 7：升学；
         */
        switch (integer) {
            case 0:
                return new CellData("不就业拟升学");
            case 1:
                return new CellData("待就业、拟参加公招考试");
            case 2:
                return new CellData("待就业、签约中");
            case 3:
                return new CellData("待就业、求职中");
            case 4:
                return new CellData("其他暂不就业");
            case 5:
                return new CellData("签就业协议形式就业");
            case 6:
                return new CellData("签劳动合同形式就业");
            case 7:
                return new CellData("升学");
        }
        return null;
    }
}
