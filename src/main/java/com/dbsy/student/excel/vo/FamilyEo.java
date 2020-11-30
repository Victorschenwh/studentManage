package com.dbsy.student.excel.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.dbsy.student.excel.converter.ClazzNameToIdConverter;
import com.dbsy.student.excel.converter.DepartmentNameToIdConverter;
import com.dbsy.student.excel.converter.MajorNameToIdConverter;

@ContentRowHeight(10)
@HeadRowHeight(20)
@ColumnWidth(25)
public class FamilyEo {
    @ExcelProperty("学号")
    private String number;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(value = "班级名", converter = ClazzNameToIdConverter.class)
    private Integer clazzId;

    @ExcelProperty(value = "专业名", converter = MajorNameToIdConverter.class)
    private Integer majorId;

    @ExcelProperty(value = "学院名", converter = DepartmentNameToIdConverter.class)
    private Integer departmentId;

    @ExcelProperty("年级")
    private Integer grade;

    @ExcelProperty("家庭成员姓名")
    private String fname;

    @ExcelProperty("工作单位")
    private String work;

    @ExcelProperty("与本人关系")
    private String relationship;

    @ExcelProperty("年龄")
    private Integer age;

}
