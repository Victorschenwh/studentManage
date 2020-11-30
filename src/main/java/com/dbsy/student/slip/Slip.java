package com.dbsy.student.slip;

import com.dbsy.student.excel.SpringContext;
import com.dbsy.student.mapper.StudentMapper;
import com.dbsy.student.service.iml.StudentServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Slip {
    List<Map> list = new ArrayList<>();

    // StudentServiceImp studentServiceImp = (StudentServiceImp) SpringContext.getApplicationContext().getBean("studentServiceImp");

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }

    public Slip(List<Map> list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Map map = list.get(i);
                if (this.list.size() == 0) {
                    this.list.add(map);
                } else {
                    if (Integer.parseInt(map.get("id") + "") == Integer.parseInt(this.list.get(this.list.size() - 1).get("id") + "")) {
                        double preRank = Integer.parseInt(this.list.get(this.list.size() - 1).get("major_rank") + "");
                        double nowRank = Integer.parseInt(map.get("major_rank") + "");
                        if (nowRank - preRank > 0) {
                            map.put("slip", nowRank - preRank);
                            map.put("slipPercentage", (nowRank - preRank) / preRank);
                            this.list.remove(this.list.size() - 1);
                            this.list.add(map);
                        } else {
                            this.list.remove(this.list.size() - 1);
                            this.list.add(map);
                        }
                    } else {
                        // map.put("slip", Integer.parseInt(map.get("major_rank") + ""));
                        if (!this.list.get(this.list.size() - 1).containsKey("slip")) {
                            this.list.remove(this.list.size() - 1);
                        }
                        this.list.add(map);
                    }
                }
            }
        }


    }

    @Override
    public String toString() {
        return "Slip{" +
                "list=" + list +
                '}';
    }
}
