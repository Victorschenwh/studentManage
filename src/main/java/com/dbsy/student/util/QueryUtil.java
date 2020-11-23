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
        return map;
    }
}
