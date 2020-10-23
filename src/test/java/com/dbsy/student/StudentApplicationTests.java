package com.dbsy.student;

import com.dbsy.student.excel.SpringContext;
import com.dbsy.student.service.CourseService;
import com.dbsy.student.service.ScoreService;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.util.PinYin;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApplicationTests {
    @Autowired
    @Qualifier("studentServiceImp")
    StudentService studentService;

    @Autowired
    @Qualifier("scoreServiceImp")
    ScoreService scoreService;

    @Autowired
    @Qualifier("courseServiceImp")
    CourseService courseService;


    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void contextLoads() {
//        PinYin.chineseToPinyin("你好(hello),世界(world)");

//        System.out.println("studentService.getSelf(1) = " + studentService.getSelf(1));
//        try {
//            //获取系统文档
//            POIFSFileSystem fspoi = new POIFSFileSystem(new FileInputStream("C:\\Users\\Administrator\\Desktop\\给水161\\2016-2017-2+给水161班.xls"));
//            //创建工作薄对象
//            HSSFWorkbook workbook = new HSSFWorkbook(fspoi);
//            //创建工作表对象
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            //获取第一行第二行的课程数据和对应学分,课程数据从第四列开始
//            HSSFRow row0 = sheet.getRow(0);
//            HSSFRow row1 = sheet.getRow(1);
//            List<Integer> cources = new ArrayList();
//            List<Double> credits = new ArrayList();
//            //log.info("LastCellNum:" + row0.getLastCellNum());
//            //LastCellNum 从1算起
//            for (int i = 3; i < row0.getLastCellNum(); i++) {
//                log.info("课程列表:" + row0.getCell(i).toString() + "--学分:" + row1.getCell(i).toString());
//                Course course = new Course();
//                course.setName(row0.getCell(i).toString());
//                courseService.insertSelective(course);
//                cources.add(course.getId());
//                credits.add(Double.parseDouble(row1.getCell(i).toString()));
//            }
//            //获取所有学生姓名学号,入库
//            //log.info("lastRownumber:" + sheet.getLastRowNum());
//            //lastRownumber 从零算起
//            List<Integer> students = new ArrayList();
//            for (int j = 2; j <= sheet.getLastRowNum(); j++) {
//                HSSFRow row = sheet.getRow(j);
//                log.info("学号:" + row.getCell(0) + "-------姓名:" + row.getCell(1));
//                Student student = new Student();
//                student.setNumber(row.getCell(0).toString());
//                student.setName(row.getCell(1).toString());
//                studentService.insertSelective(student);
//                students.add(student.getId());
//            }
//
//            //获取分数
//            for (int i = 2; i <= sheet.getLastRowNum(); i++) {
//                HSSFRow row = sheet.getRow(i);
//                for (int j = 3; j < row.getLastCellNum(); j++) {
//                    String s = row.getCell(j).toString();
//                    if (s != null && !"".equals(s.trim())) {
//                        int student = students.get(i - 2);
//                        int course = cources.get(j - 3);
//                        Double credit = credits.get(j - 3);
//                        Double score;
//                        if (s.contains(","))
//                            score = 0.0;
//                        else
//                            score = Double.parseDouble(s);
//
//                        log.info("stu:" + student + "===" + "course:" + course + "========score:" + score + "===========credit:" + credit);
//                        Score score1 = new Score();
//                        score1.setCourseId(course);
//                        score1.setStudentId(student);
//                        score1.setCredit(credit);
//                        score1.setScore(score);
//                        score1.setStudyTerm(2);
//                        scoreService.insert(score1);
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    @Test
//    void contextLoads1() {
//        StudentService studentService = (StudentService) SpringContext.getApplicationContext().getBean("studentServiceImp");
//        log.info(studentService.selectByNumber("111").toString());



    }


}


