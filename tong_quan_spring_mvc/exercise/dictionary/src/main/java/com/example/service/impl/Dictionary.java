package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class Dictionary implements IDictionaryService {
    private static Map<String,String> stringMap = new HashMap<>();
    static {
        stringMap.put("hello","tạm biệt");
        stringMap.put("red", "đỏ");
        stringMap.put("blue", "xanh");

    }
    @Override
    public String search(String input) {
        String result = stringMap.get(input);
        return result;
    }
}
