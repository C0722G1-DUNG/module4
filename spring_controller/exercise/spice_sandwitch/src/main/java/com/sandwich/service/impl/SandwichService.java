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
while (true){
    switch (choise){
        case "lettuce":
            list.add("lettuce");
            break;
        case "tomato":
            list.add("tomato");
            break;
        case "mustard":
            list.add("mustard");
            break;
        case "sprouts":
            list.add("sprouts");
            break;
        default:

    }
    return list;
}

//        if (choise!= ""){
//            list.add(choise);
//        }
//            return list;
        }


}
