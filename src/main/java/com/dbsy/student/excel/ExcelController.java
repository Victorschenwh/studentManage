package com.dbsy.student.excel;

import com.alibaba.excel.EasyExcel;
import com.dbsy.student.pojo.*;
import com.dbsy.student.service.ScoreService;
import com.dbsy.student.service.iml.*;
import com.dbsy.student.util.News;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    @Qualifier("employmentServiceImp")
    EmploymentServiceImp employmentServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    DepartmentServiceImp departmentServiceImp;
    @Autowired
    FamilyServiceImp familyServiceImp;
    @Autowired
    MajorServiceImp majorServiceImp;
    @Autowired
    ClazzServiceImp clazzServiceImp;
    @Autowired
    TransferServiceImp transferServiceImp;
    @Autowired
    SuspensionServiceImp suspensionServiceImp;
    @Autowired
    RetardationServiceImp retardationServiceImp;
    @Autowired
    RewardServiceImp rewardServiceImp;
    @Autowired
    CourseServiceImp courseServiceImp;
    @Autowired
    ScoreService scoreService;

    @RequestMapping("/up")
    public String excel() {
        return "excel/upload";
    }


    @PostMapping("/upload")
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        switch (type) {
            case "employment":
                EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(employmentServiceImp)).sheet().doRead();
                break;
            case "student":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(studentServiceImp)).sheet().doRead();
                break;
            case "department":
                EasyExcel.read(file.getInputStream(), Employment.class, new DataListener(departmentServiceImp)).sheet().doRead();
                break;
            case "family":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(familyServiceImp)).sheet().doRead();
                break;
            case "major":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(majorServiceImp)).sheet().doRead();
                break;
            case "transfer":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(transferServiceImp)).sheet().doRead();
                break;
            case "suspension":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(suspensionServiceImp)).sheet().doRead();
                break;
            case "retardation":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(retardationServiceImp)).sheet().doRead();
                break;
            case "reward":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(retardationServiceImp)).sheet().doRead();
                break;
            case "course":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(courseServiceImp)).sheet().doRead();
                break;
            case "clazz":
                EasyExcel.read(file.getInputStream(), Student.class, new DataListener(clazzServiceImp)).sheet().doRead();
                break;

            case "score":
                try {
                    //获取系统文档
                    POIFSFileSystem fspoi = new POIFSFileSystem(file.getInputStream());
                    //创建工作薄对象
                    HSSFWorkbook workbook = new HSSFWorkbook(fspoi);
                    //创建工作表对象
                    HSSFSheet sheet = workbook.getSheetAt(0);
                    //获取第一行第二行的课程数据和对应学分,课程数据从第四列开始
                    HSSFRow row0 = sheet.getRow(0);
                    HSSFRow row1 = sheet.getRow(1);
                    //第二行第一列  获取学期
                    int study_term = Integer.parseInt(row1.getCell(0).toString());

                    List<Integer> cources = new ArrayList();
                    List<Double> credits = new ArrayList();
                    //log.info("LastCellNum:" + row0.getLastCellNum());
                    //LastCellNum 从1算起
                    int cols = row0.getLastCellNum();
                    for (int i = 3; i < cols; i++) {
                        String ss = row1.getCell(i).toString().trim().replaceAll("　", "");
                        if ("".equals(ss)) {
                            break;
                        }
                        Course course = new Course();
                        course.setName(row0.getCell(i).toString());
                        courseServiceImp.insertSelective(course);
                        cources.add(course.getId());
                        credits.add(Double.parseDouble(ss));
                    }
                    //获取所有学生姓名学号,入库
                    //log.info("lastRownumber:" + sheet.getLastRowNum());
                    //lastRownumber 从零算起
                    List<Integer> students = new ArrayList();
                    for (int j = 2; j <= sheet.getLastRowNum(); j++) {
                        HSSFRow row = sheet.getRow(j);
                        Student student = new Student();
                        student.setNumber(row.getCell(0).toString().trim());
                        student.setName(row.getCell(1).toString().trim());
                        studentServiceImp.insertSelective(student);
                        students.add(student.getId());
                    }

                    //获取分数
                    for (int i = 2; i <= sheet.getLastRowNum(); i++) {
                        HSSFRow row = sheet.getRow(i);
                        for (int j = 3; j < row.getLastCellNum(); j++) {
                            String s = row.getCell(j).toString().trim();

                            if (s != null && !"".equals(s)) {
                                int student = students.get(i - 2);
                                int course = cources.get(j - 3);
                                Double credit = credits.get(j - 3);
                                Double score;
                                if (s.contains(","))
                                    score = 0.0;
                                else if ("优秀".equals(s)) score = 90.0;
                                else if ("良好".equals(s)) score = 80.0;
                                else if ("中等".equals(s)) score = 70.0;
                                else if ("及格".equals(s)) score = 60.0;
                                else
                                    score = Double.parseDouble(s);
                                Score score1 = new Score();
                                score1.setCourseId(course);
                                score1.setStudentId(student);
                                score1.setCredit(credit);
                                score1.setScore(score);
                                score1.setStudyTerm(study_term);
                                //System.out.println(score1);
                                scoreService.insert(score1);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return News.success();
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, @RequestParam("type") String type, @RequestParam Map map) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(UUID.randomUUID().toString(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        switch (type) {
            case "employment":
                EasyExcel.write(response.getOutputStream(), Employment.class).sheet("就业表").doWrite(employmentServiceImp.list(map));
                break;
            case "student":
                EasyExcel.write(response.getOutputStream(), Student.class).sheet("学生表").doWrite(studentServiceImp.list(map));
                break;
            case "department":
                EasyExcel.write(response.getOutputStream(), Department.class).sheet("学院表").doWrite(departmentServiceImp.list(map));
                break;
            case "family":
                EasyExcel.write(response.getOutputStream(), Family.class).sheet("家庭表").doWrite(familyServiceImp.list(map));
                break;
            case "major":
                EasyExcel.write(response.getOutputStream(), Major.class).sheet("专业表").doWrite(majorServiceImp.list(map));
                break;
            case "transfer":
                EasyExcel.write(response.getOutputStream(), Transfer.class).sheet("转专业表").doWrite(transferServiceImp.list(map));
                break;
            case "suspension":
                EasyExcel.write(response.getOutputStream(), Suspension.class).sheet("就业表").doWrite(suspensionServiceImp.list(map));
                break;
            case "retardation":
                EasyExcel.write(response.getOutputStream(), Retardation.class).sheet("就业表").doWrite(retardationServiceImp.list(map));
                break;
            case "reward":
                EasyExcel.write(response.getOutputStream(), Reward.class).sheet("奖惩表").doWrite(rewardServiceImp.list(map));
                break;
            case "course":
                EasyExcel.write(response.getOutputStream(), Course.class).sheet("课程表").doWrite(courseServiceImp.list(map));
                break;
            case "clazz":
                EasyExcel.write(response.getOutputStream(), Clazz.class).sheet("就业表").doWrite(clazzServiceImp.list(map));
                break;

            case "score":
                EasyExcel.write(response.getOutputStream(), Score.class).sheet("就业表").doWrite(null);
                break;
        }
        //EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }
}