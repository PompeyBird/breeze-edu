package org.bird.breeze.edu.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "org.bird.breeze.edu.dao")
@ComponentScan(basePackages = "org.bird.breeze.edu")
public class WechatSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(WechatSpringBootApplication.class, args);
    }
}
