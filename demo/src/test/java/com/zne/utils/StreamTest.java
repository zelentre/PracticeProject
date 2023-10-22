package com.zne.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ZNE
 * @since 2023/10/22
 * @see <a href="https://mp.weixin.qq.com/s/wxMTQkVTXFblzZRXWZ-1mQ">简洁又高效的Stream流</a>
 * @see <a href="https://mp.weixin.qq.com/s/krfbyhDMiLr6H2Q-jqSzTw">必须熟练使用的Stream流操作（1）</a>
 * @see <a href="https://mp.weixin.qq.com/s/hd-CeMM47fyudg11WbUTWQ">必须熟练使用的Stream流操作（2）</a>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StreamTest {

    /**
     * 从集合(Collection)创建流
     */
    @Test
    void test01() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 通过集合的stream()方法创建流
        Stream<Integer> stream = numbers.stream();
        // 通过集合的parallelStream()方法创建并行流
        Stream<Integer> parallelStream = numbers.parallelStream();
    }

    /**
     * 使用Stream.of()方法创建流
     */
    @Test
    void test02() {
        Stream<String> stream = Stream.of("a", "b", "c");
    }

    /**
     * 使用数组创建流
     */
    @Test
    void test03(){
        int[] array = {1, 2, 3, 4, 5};

        // 通过Arrays.stream()创建流
        IntStream intStream = Arrays.stream(array);
        // 通过Stream.of()和装箱操作创建流
        Stream<Integer> boxed = intStream.boxed();
    }

    /**
     * 使用Stream.iterate()创建无限流
     */
    @Test
    void test04(){
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(5);
        limit.forEach(System.out::println);
    }
    /**
     * 使用Stream.generate()创建无限流
     */
    @Test
    void test05(){
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }
    @Test
    void test06(){
        int[] array = {1, 2, 3, 4, 5};

        // 通过Arrays.stream()创建流
        IntStream intStream = Arrays.stream(array);
        OptionalInt reduce = intStream.reduce((a, b) -> a + b);
        System.out.println(reduce);
    }
}
