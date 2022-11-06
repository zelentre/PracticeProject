package com.zne;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

/**
 * @author ZNE
 * @since 2022/10/29
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProTest {

    @Test
    void test01() {
//        List<String> list = List.of("1", "2", "3");
        List<String> list = null;
        List<String> list1 = Optional.ofNullable(list).orElse(List.of("1"));
        System.out.println(list1);

    }
}
