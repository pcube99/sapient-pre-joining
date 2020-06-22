package com.sapient.meetingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.sapient.meetingService")
public class MeetingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingServiceApplication.class, args);
    }
}
