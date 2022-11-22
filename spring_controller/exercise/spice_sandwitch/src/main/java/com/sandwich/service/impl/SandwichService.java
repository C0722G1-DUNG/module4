package com.sandwich.service.impl;

import com.sandwich.service.ISandwichService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SandwichService implements ISandwichService {
    @Override
    public List<String> choise(String choise) {
        List<String> list = new ArrayList<>();
        list.add(choise);
        return list;
    }


}
