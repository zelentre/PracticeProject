package com.zne.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * @author ZNE
 * @since 2022/8/7
 */
@Slf4j
@Service
public class RetryService {
    /**
     * 添加重试注解,当有异常时触发重试机制.设置重试5次,默认是3.延时2000ms再次执行,每次延时提高1.5倍.当返回结果不符合要求时,主动报错触发重试.
     *
     * @param count
     * @return
     * @throws Exception
     */
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 5, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    public String call(Integer count) throws Exception {
        if (count == 10) {
            log.info("Remote RPC call do something... {}", LocalTime.now());
            throw new RemoteAccessException("RPC调用异常");
        }
        return "SUCCESS";
    }

    /**
     * 定义回调,注意异常类型和方法返回值类型要与重试方法一致
     *
     * @param e
     * @return
     */
    @Recover
    public String recover(RemoteAccessException e) {
        log.info("Remote RPC Call fail", e);
        return "recover SUCCESS";
    }
}
