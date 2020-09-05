package com.dbsy.student;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;

@SpringBootTest
class StudentApplicationTests {

    @Test
    void contextLoads() {
        try {
            //获取系统文档
            POIFSFileSystem fspoi = new POIFSFileSystem(new FileInputStream("C:\\Users\\Administrator\\Desktop\\给水161\\2016-2017-1+给水161班.xls"));
            //创建工作薄对象
            HSSFWorkbook workbook = new HSSFWorkbook(fspoi);
            //创建工作表对象
            HSSFSheet sheet = workbook.getSheetAt(0);
            //得到Excel表格
            HSSFRow row = sheet.getRow(2);
            //得到Excel工作表指定行的单元格
            HSSFCell cell = row.getCell(0);
            System.out.println(cell);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
