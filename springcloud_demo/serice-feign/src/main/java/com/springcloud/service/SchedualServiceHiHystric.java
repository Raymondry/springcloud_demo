package com.springcloud.service;

import com.springcloud.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by yi.ren on 2017/6/8.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,error!"+name;
    }
}
