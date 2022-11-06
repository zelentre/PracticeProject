package com.zne.entity;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 初始化类测试
 * 使用spring管理 @Resource
 *
 * @author ZNE
 * @since 2022/8/2
 */
@Data
@Component
public class Models implements InitializingBean {

    String name;
    String pwd;

    /**
     * 这个后执行因此值为这个
     */
    @Override
    public void afterPropertiesSet() {
        name = "李四";
        pwd = "233";
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void init() {
        name = "张三";
        pwd = "233";
        System.out.println("PostConstruct");
    }
}
