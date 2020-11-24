package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Retardation;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.RetardationService;
import com.dbsy.student.util.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/retardation")
@Authority({Role.Admin, Role.Department, Role.Assistant, Role.School})
public class RetardationController {
    @Autowired
    @Qualifier("retardationServiceImp")
    RetardationService retardationService;


    @RequestMapping("")
    public String transfer() {
        return "stuInfo/retardation";
    }


    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {
        // log.info(map.toString());
        String isPass = map.get("isPass") + "";
        if ("".equals(isPass)) {
            map.remove("isPass");
        }
        if ("true".equals(isPass)) {
            map.put("isPass", true);
        }
        if ("false".equals(isPass)) {
            map.put("isPass", false);
        }

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

    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", retardationService.get(id));
    }


    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", retardationService.getAll());
    }


    @ResponseBody
    @RequestMapping("/getRetardationByStudentId/{studentId}")
    public Map getRetardationByStudentId(@PathVariable("studentId") int studentId){
        List list = retardationService.getRetardationByStudentId(studentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }


    @ResponseBody
    @RequestMapping("/getRetardationByOldDepartmentId/{oldDepartmentId}")
    public Map getRetardationByOldDepartmentId(@PathVariable("oldDepartmentId") int oldDepartmentId){
        List list = retardationService.getRetardationByOldDepartmentId(oldDepartmentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }


    @ResponseBody
    @RequestMapping("/getRetardationByOldMajorId/{oldMajorId}")
    public Map getRetardationByOldMajorId(@PathVariable("oldMajorId") int oldMajorId){
        List list = retardationService.getRetardationByOldMajorId(oldMajorId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }

    //@Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByOldClazzId/{oldClazzId}")
    public Map getRetardationByOldClazzId(@PathVariable("oldClazzId") int oldClazzId) {
        List list = retardationService.getRetardationByOldClazzId(oldClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }


    @ResponseBody
    @RequestMapping("/getRetardationByNewDepartmentId/{newDepartmentId}")
    public Map getRetardationByNewDepartmentId(@PathVariable("newDepartmentId") int newDepartmentId) {
        List list = retardationService.getRetardationByNewDepartmentId(newDepartmentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //@Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getRetardationByNewMajorId/{newMajorId}")
    public Map getRetardationByNewMajorId(@PathVariable("newMajorId") int newMajorId) {
        List list = retardationService.getRetardationByNewMajorId(newMajorId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }


    @ResponseBody
    @RequestMapping("/getRetardationByNewClazzId/{newClazzId}")
    public Map getRetardationByNewClazzId(@PathVariable("newClazzId") int newClazzId) {
        List list = retardationService.getRetardationByNewClazzId(newClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }
    @ResponseBody
    @RequestMapping("/getOpposite/{id}")
    public Map getOpposite(@PathVariable("id") int id) {
        Map opposite = retardationService.getOpposite(id);
        if (opposite != null)
            return News.success("成功", opposite);
        else
            return News.fail();
    }

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @RequestMapping("/updateSelective")
    public Map updateSelective(Retardation retardation) {
        log.info(retardation.toString());
        retardation.getSaveDate();
        int i = retardationService.updateSelective(retardation);
        if (i > 0) News.success();
        return News.fail();
    }

}
