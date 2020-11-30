package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.annotation.Remarks;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Teacher;
import com.dbsy.student.service.AdminService;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.service.TeacherService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/student")
    @Remarks("权限管理/学生")
    public String stu() {
        return "auth/student";
    }

    @RequestMapping("/assistant")
    @Remarks("权限管理/辅导员")
    public String ass() {
        return "auth/assistant";
    }

    @RequestMapping("/depLead")
    @Remarks("权限管理/院领导")
    public String deLead() {
        return "auth/departLeader";
    }

    @Remarks("权限管理/校领导")
    @RequestMapping("/scLead")
    public String admin() {
        return "auth/schLeader";
    }

    @RequestMapping("/studentList")
    @ResponseBody
    @Remarks("权限管理/学生账号列表")
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findAdminCount(map));
        m.put("rows", adminService.findAdmin(map));
        return m;
    }

    @Remarks("权限管理/管理员账号列表")
    @RequestMapping("/assistantList")
    @ResponseBody
    public Map assList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findAssistantCount(map));
        m.put("rows", adminService.findAssistant(map));
        return m;
    }

    @RequestMapping("/departList")
    @Remarks("权限管理/院领导账号列表")
    @ResponseBody
    public Map deList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findDepartLeaderCount(map));
        m.put("rows", adminService.findDepartLeader(map));
        return m;
    }

    @RequestMapping("/schList")
    @Remarks("权限管理/校领导账号列表")
    @ResponseBody
    public Map scList(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", adminService.findSchoolLeaderCount(map));
        m.put("rows", adminService.findSchoolLeader(map));
        return m;
    }

    @Autowired
    StudentService studentService;


    @ResponseBody
    @RequestMapping("/studentInsert/{number}")
    @Remarks("权限管理/新增学生账号")
    public Map insertStudent(@PathVariable("number") String number, HttpSession httpSession) {
        Student student = studentService.selectByNumber(number);
        Admin admin = (Admin) httpSession.getAttribute("user");
        if (student == null) {
            return News.fail("该学生不存在");
        }
        if (admin.getRole() == 40) {
            return News.fail("权限不足");
        }
        if (admin.getRole() > 2000 && admin.getDepartmentId() != student.getDepartmentId()) {
            return News.fail("权限不足,该名学生不属于您的管理范围");
        }
        if (admin.getRole() == 20 && admin.getDepartmentId() != student.getDepartmentId()) {
            return News.fail("权限不足,该名学生不属于您的管理范围");
        }
        Admin stuUser = adminService.findByRoleAndForeignId(40, student.getId());
        if (stuUser != null)
            return News.fail("该名学生已有系统账户");

        Admin newUser = Admin.student(student);
        if (adminService.insert(newUser) > 0) {
            return News.success();
        } else
            return News.fail();
    }

    @Autowired
    TeacherService teacherService;

    @ResponseBody
    @RequestMapping("/teacherInsert/{number}")
    @Remarks("权限管理/新增老师账号")
    public Map insertTeacher(@PathVariable("number") String number, HttpSession httpSession) {
        Teacher teacher = (Teacher) teacherService.selectByUsername(number);

        Admin admin = (Admin) httpSession.getAttribute("user");

        if (admin.getRole() == 40 || admin.getRole() > 2000) {
            return News.fail("权限不足");
        }

        Admin teaUser = adminService.findByRoleAndForeignId(teacher.getLevel(), teacher.getId());
        if (teaUser != null)
            return News.fail("该用户已有系统账户");

        Admin newUser = Admin.teacher(teacher);
        if (admin.getRole() < teacher.getLevel() && admin.getRole() <= 10) {
            if (adminService.insert(newUser) > 0) {
                return News.success();
            }
        } else if (admin.getRole() < 10) {
            if (adminService.insert(newUser) > 0) {
                return News.success();
            }
        } else if (admin.getRole() == 20 && admin.getRole() < teacher.getLevel()) {
            if (admin.getDepartmentId() == teacher.getDepartmentId())
                if (adminService.insert(newUser) > 0) {
                    return News.success();
                }
        } else if (admin.getRole() > 2000 && teacher.getLevel() == 40) {
            if (admin.getDepartmentId() == teacher.getDepartmentId())
                if (adminService.insert(newUser) > 0) {
                    return News.success();
                }
        }

        return News.fail("权限不足");

    }


    @ResponseBody
    @RequestMapping("/initPassword/{id}")
    @Remarks("权限管理/密码初始化")
    public Map initPassword(@PathVariable("id") Integer id, HttpSession httpSession) {

        Admin loginUser = (Admin) httpSession.getAttribute("user");

        Admin upUser = adminService.select(id);


        if (upUser == null) {
            return News.fail("该用户不存在");
        }

        if (upUser.getRole() == 40) {
            // 被修改的用户是学生
            Student student = studentService.get(upUser.getForeignId());
            Admin admin = new Admin();
            admin.setId(id);
            String password = null;

            if (student.getIdCard() != null) {
                password = student.getIdCard().substring(student.getIdCard().length() - 6);
            }
            if (password == null) {
                password = student.getNumber().substring(student.getNumber().length() - 6);
            }
            admin.setPassword(password);
            // 修改的是校领导或管理员
            if (loginUser.getRole() <= 10) {
                adminService.update(admin);
            }
            // 修改的是辅导员或院领导
            else if (loginUser.getRole() >= 20) {
                if (loginUser.getDepartmentId() == student.getDepartmentId()) {
                    adminService.update(admin);
                }
            }

        } else {
            // 被修改的不是学生
            Teacher teacher = teacherService.get(upUser.getForeignId());
            Admin admin = new Admin();
            admin.setId(id);
            String password = null;
            if (teacher.getPhoneNumber() != null) {
                password = teacher.getPhoneNumber().substring(teacher.getPhoneNumber().length() - 6);
            }
            if (password == null) {
                password = teacher.getUsername().substring(teacher.getUsername().length() - 6);
            }
            admin.setPassword(password);
            if (upUser.getRole() > 2000 && loginUser.getRole() == 20) {
                if (loginUser.getDepartmentId() == upUser.getDepartmentId())
                    if (adminService.update(admin) > 0)
                        return News.success();
            } else if (upUser.getRole() > 2000 && loginUser.getRole() <= 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            } else if (upUser.getRole() == 20 && loginUser.getRole() <= 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            } else if (upUser.getRole() == 10 && loginUser.getRole() < 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            }
        }
        return News.fail();
    }

    @ResponseBody
    @RequestMapping("/nagation/{id}")
    @Remarks("权限管理/激活、锁定账号")
    public Map negation(@PathVariable("id") Integer id, HttpSession httpSession) {

        Admin loginUser = (Admin) httpSession.getAttribute("user");

        Admin upUser = adminService.select(id);


        if (upUser == null) {
            return News.fail("该用户不存在");
        }


        if (upUser.getRole() == 40) {
            // 被修改的用户是学生
            Student student = studentService.get(upUser.getForeignId());
            Admin admin = new Admin();
            admin.setId(id);
            admin.setIsLock(!upUser.getIsLock());
            // 修改的是校领导或管理员
            if (loginUser.getRole() <= 10) {
                if (adminService.update(admin) > 0) return News.success();
            }
            // 修改的是辅导员或院领导
            else if (loginUser.getRole() >= 20) {
                if (loginUser.getDepartmentId() == student.getDepartmentId()) {
                    if (adminService.update(admin) > 0) return News.success();
                }
            }

        } else {
            // 被修改的不是学生
            Admin admin = new Admin();
            admin.setId(id);
            admin.setIsLock(!upUser.getIsLock());
            if (upUser.getRole() > 2000 && loginUser.getRole() == 20) {
                if (loginUser.getDepartmentId() == upUser.getDepartmentId())
                    if (adminService.update(admin) > 0)
                        return News.success();
            } else if (upUser.getRole() > 2000 && loginUser.getRole() <= 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            } else if (upUser.getRole() == 20 && loginUser.getRole() <= 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            } else if (upUser.getRole() == 10 && loginUser.getRole() < 10) {
                if (adminService.update(admin) > 0)
                    return News.success();
            }
        }
        return News.fail();
    }


    @ResponseBody
    @RequestMapping("/delete/{id}")
    @Remarks("权限管理/账号删除")
    public Map delete(@PathVariable("id") Integer id, HttpSession httpSession) {

        Admin loginUser = (Admin) httpSession.getAttribute("user");

        Admin upUser = adminService.select(id);
        if (upUser == null) {
            return News.fail("该用户不存在");
        }

        if (upUser.getRole() == 40) {
            // 被修改的用户是学生
            // 修改的是校领导或管理员
            Student student = studentService.get(upUser.getForeignId());
            if (loginUser.getRole() <= 10) {
                if (adminService.delete(id) > 0) return News.success();
            }
            // 修改的是辅导员或院领导
            else if (loginUser.getRole() >= 20) {
                if (loginUser.getDepartmentId() == student.getDepartmentId()) {
                    if (adminService.delete(id) > 0) return News.success();
                }
            }

        } else {
            // 被修改的不是学生
            if (upUser.getRole() > 2000 && loginUser.getRole() == 20) {
                if (loginUser.getDepartmentId() == upUser.getDepartmentId())
                    if (adminService.delete(id) > 0) return News.success();
            } else if (upUser.getRole() > 2000 && loginUser.getRole() <= 10) {
                if (adminService.delete(id) > 0) return News.success();
            } else if (upUser.getRole() == 20 && loginUser.getRole() <= 10) {
                if (adminService.delete(id) > 0) return News.success();
            } else if (upUser.getRole() == 10 && loginUser.getRole() < 10) {
                if (adminService.delete(id) > 0) return News.success();
            }
        }
        return News.fail();
    }
}
