package com.zne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author ZNE
 * @since 2022/8/7
 */
@EnableRetry
@SpringBootApplication
public class RetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class);
    }
}
