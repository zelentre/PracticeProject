package com.zne;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZNE
 * @since 2022/10/3
 */
@SpringBootTest
public class BreakTest {

    @Test
    void test() {
        // 注意这里的标识
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    //跳到循环外的ok出，即终止整个循环
                    break ok;
                }
                System.out.println(String.format("i:{%s},j:{%s}", i, j));
            }
            System.out.println(String.format("i:{%s}", i));
        }

    }

}
