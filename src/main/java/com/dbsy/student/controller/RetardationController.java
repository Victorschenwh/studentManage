package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.service.RetardationService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/retardation")
//@Authority({Role.Admin})
public class RetardationController {
    @Autowired
    @Qualifier("retardationServiceImp")
    RetardationService retardationService;

//    @Authority({Role.Teacher})
    @RequestMapping("")
    public String transfer() {
        return "baseInfo/retardation";
    }


//    @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", retardationService.listCount(map));
        m.put("rows", retardationService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (retardationService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (retardationService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Retardation retardation) {
        if (retardationService.insert(retardation) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map update(Retardation retardation) {
        if (retardationService.update(retardation) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", retardationService.get(id));
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", retardationService.getAll());
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByStudentId/{studentId}")
    public Map getRetardationByStudentId(@PathVariable("studentId") int studentId){
        List list = retardationService.getRetardationByStudentId(studentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByOldDepartmentId/{oldDepartmentId}")
    public Map getRetardationByOldDepartmentId(@PathVariable("oldDepartmentId") int oldDepartmentId){
        List list = retardationService.getRetardationByOldDepartmentId(oldDepartmentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByOldMajorId/{oldMajorId}")
    public Map getRetardationByOldMajorId(@PathVariable("oldMajorId") int oldMajorId){
        List list = retardationService.getRetardationByOldMajorId(oldMajorId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByOldClazzId/{oldClazzId}")
    public Map getRetardationByOldClazzId(@PathVariable("oldClazzId") int oldClazzId) {
        List list = retardationService.getRetardationByOldClazzId(oldClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByNewDepartmentId/{newDepartmentId}")
    public Map getRetardationByNewDepartmentId(@PathVariable("newDepartmentId") int newDepartmentId) {
        List list = retardationService.getRetardationByNewDepartmentId(newDepartmentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByNewMajorId/{newMajorId}")
    public Map getRetardationByNewMajorId(@PathVariable("newMajorId") int newMajorId) {
        List list = retardationService.getRetardationByNewMajorId(newMajorId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByNewClazzId/{newClazzId}")
    public Map getRetardationByNewClazzId(@PathVariable("newClazzId") int newClazzId) {
        List list = retardationService.getRetardationByNewClazzId(newClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }
}
