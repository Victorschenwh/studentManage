package com.dbsy.student.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        System.out.println("日期转换开始" + cellData.toString());
        try {
            if (cellData == null) {
                return null;
            }
            if (cellData.toString().contains("-")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return simpleDateFormat.parse(cellData.toString());
            } else if (cellData.toString().contains("/")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                return simpleDateFormat.parse(cellData.toString());
            } else if (cellData.toString().matches("\\d+") && cellData.toString().length() == 8) {
                Date date = new Date();
                date.setYear(Integer.parseInt(cellData.toString().substring(0, 4)));
                date.setMonth(Integer.parseInt(cellData.toString().substring(4, 6)));
                date.setDate(Integer.parseInt(cellData.toString().substring(6, 8)));
                return date;
            } else if (cellData.toString().matches("\\d+") && cellData.toString().length() == 5) {
                Calendar c = Calendar.getInstance();
                c.set(1900, 0, 1);
                c.add(Calendar.DATE, Integer.parseInt(cellData.toString()) - 2);
                return c.getTime();
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("日期转换错误");
            e.printStackTrace();
        }

        return null;


    }

    @Override
    public CellData convertToExcelData(Date date, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
