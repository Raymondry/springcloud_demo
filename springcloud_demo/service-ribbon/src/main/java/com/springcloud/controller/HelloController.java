package com.springcloud.controller;

import com.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yi.ren on 2017/6/7.
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/sayhi")
    public String sayHi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
