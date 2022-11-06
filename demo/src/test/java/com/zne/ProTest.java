package com.zne;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZNE
 * @since 2022/9/25
 */
@SpringBootTest
public class ProTest {

    @Test
    void contextLoads() {
        int[] array = {5, 2, 3};
        bubble(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void bubble(int[] array) {
        int count = array.length - 1;
        for (; ; ) {
            int lastIndex = 0;
            for (int i = 0; i < count; i++) {
                if (array[i] > array[i + 1]) {
                    lastIndex = i;
                    swap(array, i, i + 1);
                }
            }
            count = lastIndex;
            if (count == 0) {
                break;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
