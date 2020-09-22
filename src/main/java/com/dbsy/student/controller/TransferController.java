package com.dbsy.student.controller;

import com.dbsy.student.annotation.Authority;
import com.dbsy.student.myenum.Role;
import com.dbsy.student.pojo.Admin;
import com.dbsy.student.pojo.Transfer;
import com.dbsy.student.service.DepartmentService;
import com.dbsy.student.service.TransferService;
import com.dbsy.student.util.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/transfer")
//@Authority({Role.Admin})
public class TransferController {
    @Autowired
    @Qualifier("transferServiceImp")
    TransferService transferService;
    @Autowired
    DepartmentService departmentService;

    //    @Authority({Role.Teacher})
    @RequestMapping("")
    public String transfer(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("user");
        if (admin.getRole() == 0)
            return "stuInfo/leaderTransfer";
        else
            return "stuInfo/transfer";
    }


    //    @Authority({Role.Teacher})
    @RequestMapping("/list")
    @ResponseBody
    public Map list(@RequestParam Map map) {
        Map m = new HashMap();
        m.put("total", transferService.listCount(map));
        m.put("rows", transferService.list(map));

        return m;
    }

    @ResponseBody
    @RequestMapping("/remove/{id}")
    public Map remove(@PathVariable("id") int id) {
        if (transferService.delete(id) > 0) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/batchRemove")
    public Map batchRemove(int[] ids) {

        if (transferService.batchRemove(ids) == ids.length) {
            return News.success();
        }
        return News.fail("删除失败");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map insert(@RequestParam Map map) {
        if (transferService.insert(map) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }


    @ResponseBody
    @RequestMapping("/update")
    public Map update(Transfer transfer) {
        if (transferService.update(transfer) > 0) {
            return News.success();
        }
        return News.fail("添加失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/get/{id}")
    public Map get(@PathVariable("id") int id) {
        return News.success("成功", transferService.get(id));
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getAll")
    public Map getAll() {
        return News.success("成功", transferService.getAll());
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByStudentId/{studentId}")
    public Map getTransferByStudentId(@PathVariable("studentId") int studentId) {
        List list = transferService.getTransferByStudentId(studentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByOldDepartmentId/{oldDepartmentId}")
    public Map getTransferByOldDepartmentId(@PathVariable("oldDepartmentId") int oldDepartmentId) {
        List list = transferService.getTransferByOldDepartmentId(oldDepartmentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByOldMajorId/{oldMajorId}")
    public Map getTransferByOldMajorId(@PathVariable("oldMajorId") int oldMajorId) {
        List list = transferService.getTransferByOldMajorId(oldMajorId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByOldClazzId/{oldClazzId}")
    public Map getTransferByOldClazzId(@PathVariable("oldClazzId") int oldClazzId) {
        List list = transferService.getTransferByOldClazzId(oldClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByNewDepartmentId/{newDepartmentId}")
    public Map getTransferByNewDepartmentId(@PathVariable("newDepartmentId") int newDepartmentId) {
        List list = transferService.getTransferByNewDepartmentId(newDepartmentId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByNewMajorId/{newMajorId}")
    public Map getTransferByNewMajorId(@PathVariable("newMajorId") int newMajorId) {
        List list = transferService.getTransferByNewMajorId(newMajorId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    //    @Authority({Role.Teacher})
    @ResponseBody
    @RequestMapping("/getTransferByNewClazzId/{newClazzId}")
    public Map getTransferByNewClazzId(@PathVariable("newClazzId") int newClazzId) {
        List list = transferService.getTransferByNewClazzId(newClazzId);
        if (list != null) {
            return News.success("成功", list);

        }
        return News.fail("查找失败");
    }

    @ResponseBody
    @RequestMapping("/getOpposite/{id}")
    public Map getOpposite(@PathVariable("id") int id) {
        Map opposite = transferService.getOpposite(id);
        if (opposite != null)
            return News.success("成功", opposite);
        else
            return News.fail();
    }

    private Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     * 审批或修改审批
     *
     * @param transfer
     * @return
     */
    @ResponseBody
    @RequestMapping("/examine")
    Map examine(Transfer transfer) {
        //log.info(transfer.toString());
        transfer.setNewInDate(new Date());
        int i = transferService.updateSelective(transfer);
        if (i > 0) News.success();
        return News.fail();
    }
}
