package com.springcloud.controller;

import com.springcloud.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yi.ren on 2017/6/7.
 */
@RestController
public class HiController {
    @Autowired
    //@Qualifier("schedualServiceHi")
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/ihi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
