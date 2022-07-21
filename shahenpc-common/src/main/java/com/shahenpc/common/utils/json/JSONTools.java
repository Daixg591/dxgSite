package com.shahenpc.common.utils.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.List;
import java.util.Map;

public class JSONTools {
    public static String obj2json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static Object jsonStr2obj(String json) {
        return JSON.parse(json);
    }

    public static <T> T jsonStr2obj(String json, Class<T> classes) {
        return JSON.parseObject(json, classes);
    }

    public static <T> List<T> jsonStr2Array(String json, Class<T> classes) {
        return JSON.parseArray(json, classes);
    }

    public static Map<String, Object> convertJsonStrToMap(String jsonStr) {
        Map<String, Object> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }
}
