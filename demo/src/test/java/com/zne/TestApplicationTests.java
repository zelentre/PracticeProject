package com.zne;

import com.zne.entity.Models;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class TestApplicationTests {

    @Resource
    Models models;

    @Test
    void contextLoads() {
        System.out.println(models.getName());
    }

    @Test
    void test01() {
        List<String> list = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        System.out.println(dealList(list, 2));
    }

    /**
     * 数据要是已经排序的话就不需要在排序了
     *
     * @param list list
     * @param key key
     */
    List<String> dealList(List<String> list, int key) {
        //Comparator.comparing(XXX)你的排序字段
        List<String> collect = list.stream().sorted().limit(key).collect(Collectors.toList());
        List<String> c1 = list.stream().filter(i -> Integer.parseInt(i) > key).sorted().collect(Collectors.toList());
        c1.addAll(collect);
        return c1;
    }

}
