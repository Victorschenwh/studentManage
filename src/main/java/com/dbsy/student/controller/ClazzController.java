package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.annotation.Remarks;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Clazz;
import com.dbsy.student.service.ClazzService;
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
@RequestMapping("/clazz")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School, Role.Student})
public class ClazzController {

    @Autowired
    @Qualifier("clazzServiceImp")
    ClazzService clazzService;


    @RequestMapping("")
    public String clazz() {
        return "baseInfo/clazz";
    }


    @RequestMapping("/list")
    @ResponseBody
    @Remarks("获取班级列表")
    public Map list(Map map) {
        Map m = new HashMap();
        m.put("total", clazzService.listCount(map));
        m.put("rows", clazzService.list(map));
        return m;
    }


    @ResponseBody
    @RequestMapping("/remove/{id}")
    @Remarks("移除班级")
    public Map remove(@PathVariable("id") int id) {
        if (clazzService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    @Remarks("批量移除班级")
    public Map batchRemove(int[] ids) {

        if (clazzService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    @Remarks("添加班级")
    public Map insert(Clazz clazz) {
        if (clazzService.insert(clazz) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/update")
    @Remarks("修改班级")
    public Map update(Clazz clazz) {
        if (clazzService.update(clazz) > 0) {
            return News.success();
        }
        return News.fail("修改失败");
    }


    @ResponseBody
    @RequestMapping("/get/{id}")
    @Remarks("获取班级信息")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", clazzService.get(id));
    }


    @ResponseBody
    @RequestMapping("/getAll")
    @Remarks("获取全部班级")
    public Map getAll() {
        return News.success("成功", clazzService.getAll());
    }


    @ResponseBody
    @RequestMapping("/getClazzByMajorId/{majorId}")
    @Remarks("根据专业获取班级列表")
    public Map getClazzBymajorId(@PathVariable("majorId") int majorId) {
        List list = clazzService.getClazzByMajorId(majorId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }


}
