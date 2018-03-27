package org.bird.breeze.edu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author pompey
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "org.bird.breeze.edu.dao")
@ComponentScan(basePackages = "org.bird.breeze.edu")
public class AdminSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminSpringBootApplication.class, args);
    }
}
