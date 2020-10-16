package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Student;
import com.dbsy.student.pojo.Suspension;
import com.dbsy.student.service.StudentService;
import com.dbsy.student.service.SuspensionService;
import com.dbsy.student.util.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/suspension")
//@Authority({Role.Admin})
public class SuspensionController {
    @Autowired
    @Qualifier("SuspensionServiceImp")
    SuspensionService suspensionService;


//    @Authority({Role.Teacher})
    @RequestMapping("")
    public String suspension() {
        return "stuInfo/suspension";
    }


//    @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {

        System.out.println("map = " + map);
        Map m = new HashMap();
        m.put("total", suspensionService.listCount(map));
        m.put("rows", suspensionService.list(map));
        return m;
    }

    @ResponseBody
    @RequestMapping("/getBySearchText/{text}")
    public Map getBySearchText(@PathVariable("text") String input) {

        if(!StringUtils.isEmpty(input)){
            input= StringUtils.trim(input);
//            System.out.println("text------------->"+input);
            List<Map> mapList = suspensionService.getByText(input);
            if(mapList.isEmpty()){
                return News.fail("查无此人" );
            }
            else {
                return News.success("成功", mapList);
            }

        }
        else{
            return News.fail("请重新搜索");
        }

    }



    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (suspensionService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

//    @ResponseBody
//    @RequestMapping("/reback/{id}")
//    public Map reback(@PathVariable("id") int id) {
//
//        if (suspensionService.reback(id) > 0) {
//            return News.success("成功");
//        }
//        return News.fail("删除失败");
//    }

    @ResponseBody
    @RequestMapping("/reback")
    public Map reback(@RequestParam Map map) {

        if (suspensionService.reback(map) > 0) {
            return News.success("成功");
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (suspensionService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(Suspension suspension) {
        if (suspensionService.insert(suspension) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/updata")
    public Map update(Suspension suspension) {
        if (suspensionService.update(suspension) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    @ResponseBody
    @RequestMapping("/updateSearch")
    public Map  updateSearch(Suspension suspension) {
        if (suspensionService.updateLogic(suspension) > 0) {
            return News.success("成功");
        }
        return News.fail("添加失败");
    }



//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", suspensionService.get(id));
    }


    @ResponseBody
    @RequestMapping("/getSelf/{id}/{stuId}")
    public Map getSelf(@PathVariable(value = "id",required = false) int id,@PathVariable(value="stuId" ,required = false) int stuId) {

        Map map= new HashMap<>();
        map.put("stuInfo",suspensionService.getSelf(id));
        map.put("clNameList",suspensionService.listClName(stuId));

        return News.success("成功",map) ;
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", suspensionService.getAll());
    }

//    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getSuspensionByStudentId/{studentId}")
    public Map getSuspensionByStudentId(@PathVariable("studentId") int studentId){
        List list = suspensionService.getSuspensionByStudentId(studentId);
        if (list != null) {
            return News.success("成功",list);

        }
        return News.fail("查找失败");
    }
}
