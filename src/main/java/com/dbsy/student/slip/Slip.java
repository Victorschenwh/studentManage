package com.dbsy.student.slip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Slip {
    List<Map> list = new ArrayList<>();

    public List<Map> getList() {
        return list;
    }

    public void setList(List<Map> list) {
        this.list = list;
    }

    public Slip(List<Map> list) {
        if (list != null && list.size() > 0) {
            int id = 0;
            int slip = 0;
            int rank = 0;
            for (int i = 0; i < list.size(); i++) {
                Map map = list.get(i);
                if (id == Integer.parseInt(map.get("id") + "")) {
                    slip = Integer.parseInt(map.get("major_rank") + "") - rank;
                    rank = Integer.parseInt(map.get("major_rank") + "");

                    if (slip > 0) {
                        list.get(i - 1).put("slip", slip);
                        if (this.list.size() > 0 && id == Integer.parseInt(this.list.get(this.list.size() - 1).get("id") + "")) {
                            this.list.remove(this.list.size() - 1);
                        }
                        this.list.add(list.get(i - 1));
                    }

                } else {
                  /*  if (slip > 0) {
                        list.get(i - 1).put("slip", slip);
                        this.list.add(list.get(i - 1));
                    }*/
                    id = Integer.parseInt(map.get("id") + "");
                    rank = Integer.parseInt(map.get("major_rank") + "");
                    slip = 0;
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
