package com.zne.controller;

import com.zne.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZNE
 * @since 2022/8/7
 */
@Slf4j
@RestController
@RequestMapping("/retry")
public class RetryController {
    @Resource
    private RetryService retryService;

    @GetMapping("/show/{count}")
    public String show(@PathVariable Integer count) {
        try {
            return retryService.call(count);
        } catch (Exception e) {
            log.error("RetryController.show Exception", e);
            return "Hello SUCCESS";
        }
    }

}
