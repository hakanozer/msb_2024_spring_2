package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Util {

    public static ResponseEntity success(Object object) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", true);
        map.put("result", object);
        return ResponseEntity.ok(map);
    }

    public static ResponseEntity fail(Object object, HttpStatus httpStatus) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", false);
        map.put("result", object);
        return ResponseEntity.status(httpStatus).body(map);
    }


}
