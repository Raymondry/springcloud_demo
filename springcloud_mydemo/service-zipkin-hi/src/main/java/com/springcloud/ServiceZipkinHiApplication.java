package com.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceZipkinHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinHiApplication.class, args);
    }

    private static final Logger log = Logger.getLogger(ServiceZipkinHiApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        log.log(Level.INFO, "calling trace service-zipkin-hi");
        return restTemplate.getForObject("http://127.0.0.1:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        log.log(Level.INFO, "calling trace service-hi ");
        return "i'm service-hi";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
