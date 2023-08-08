package com.example.jinnie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //domain 패키지 내 BaseEntity의 AuditingEntityListeners 를 활성화 시키기 위한 설정
public class JinnieApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinnieApplication.class, args);
    }

}
