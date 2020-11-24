package com.dbsy.student.util;

import java.util.Map;

public class QueryUtil {
    public static Map query(Map map) {
        if (map.get("page") != null) {
            int page = Integer.parseInt(map.get("page") + "");
            int pageSize = Integer.parseInt(map.get("pageSize") + "");
            map.put("start", (page - 1) * pageSize);
            map.put("pageSize", pageSize);
        }
        if (map.containsKey("search")) {
            if ((map.get("search") + "").matches("[a-zA-Z]+")) {
                map.put("abbrName", (map.get("search") + "").toLowerCase());
                map.remove("search");
            } else if ((map.get("search") + "").matches("\\d+")) {
                map.put("number", map.get("search"));
                map.remove("search");
            } else {
                map.put("name", map.get("search"));
                map.remove("search");
            }
        }
        return map;
    }
}
