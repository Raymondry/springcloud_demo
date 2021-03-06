package com.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class ServiceZipkinMiyaApplication {

    private static final Logger log = Logger.getLogger(ServiceZipkinMiyaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinMiyaApplication.class, args);
    }

    @RequestMapping("/hi")
    public String home() {
        log.log(Level.INFO, "hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        log.log(Level.INFO, "info is being called");
        return restTemplate.getForObject("http://127.0.0.1:8988/info", String.class);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
