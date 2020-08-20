package com.dbsy.student.util;

import java.util.HashMap;
import java.util.Map;

public class News {
    private News() {
    }

    public static Map success() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("msg", "成功");
        return map;
    }

    public static Map success(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("msg", msg);
        return map;
    }

    public static Map success(String msg, Object data) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 1);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static Map fail(int code, String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    public static Map fail() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", -1);
        map.put("msg", "失败");
        return map;
    }

    public static Map fail(String msg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", -1);
        map.put("msg", msg);
        return map;
    }
}
