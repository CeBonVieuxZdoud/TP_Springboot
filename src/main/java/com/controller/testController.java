package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        System.out.println("get");
        return "Index";
    }
}
