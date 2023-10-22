package com.zne.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ZNE
 * @see <a href="https://mp.weixin.qq.com/s/wxMTQkVTXFblzZRXWZ-1mQ">简洁又高效的Stream流</a>
 * @see <a href="https://mp.weixin.qq.com/s/krfbyhDMiLr6H2Q-jqSzTw">必须熟练使用的Stream流操作（1）</a>
 * @see <a href="https://mp.weixin.qq.com/s/hd-CeMM47fyudg11WbUTWQ">必须熟练使用的Stream流操作（2）</a>
 * @since 2023/10/22
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
    void test03() {
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
    void test04() {
        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(5);
        limit.forEach(System.out::println);
    }

    /**
     * 使用Stream.generate()创建无限流
     */
    @Test
    void test05() {
        Stream<Double> stream = Stream.generate(Math::random);
        stream.forEach(System.out::println);
    }

    // ----------------实操-------------------------------

    /**
     * 使用filter操作来筛选出所有年龄大于18岁的人
     */
    @Test
    void test06() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));

        List<Person> adults = persons.stream()
                .filter(p -> p.getAge() > 18)
                .collect(Collectors.toList());

        // 输出结果为 [Person(name=Alice, age=25), Person(name=Charlie, age=30)]
        System.out.println(adults);
    }

    /**
     * 使用map操作将所有人名转换成大写字母
     */
    @Test
    void test07() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));

        List<String> names = persons.stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());

        // 输出结果为 [ALICE, BOB, CHARLIE]
        System.out.println(names);
    }

    /**
     * 使用sorted操作将所有人按照年龄从小到大排序
     */
    @Test
    void test08() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));

        List<Person> sortedPersons = persons.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());

        // 输出结果为 [Person(name=Bob, age=17), Person(name=Alice, age=25), Person(name=Charlie, age=30)]
        System.out.println(sortedPersons);
    }

    /**
     * 使用distinct操作去除列表中的重复数字
     */
    @Test
    void test09() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // 输出结果为 [1, 2, 3, 4, 5]
        System.out.println(distinctNumbers);
    }

    /**
     * 使用limit操作获取列表中的前三个数字
     */
    @Test
    void test10() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> limitedNumbers = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());

        // 输出结果为 [1, 2, 3]
        System.out.println(limitedNumbers);
    }

    /**
     * 使用skip操作跳过列表中的前两个数字
     */
    @Test
    void test11() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> skippedNumbers = numbers.stream()
                .skip(2)
                .collect(Collectors.toList());

        // 输出结果为 [3, 4, 5]
        System.out.println(skippedNumbers);
    }

    /**
     * 使用forEach操作输出列表中的每个数字
     */
    @Test
    void test12() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream().forEach(n -> System.out.println(n));
    }

    /**
     * 使用collect操作将所有年龄大于18岁的人收集到一个List集合中
     */
    @Test
    void test13() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));

        List<Person> adults = persons.stream()
                .filter(p -> p.getAge() > 18)
                .collect(Collectors.toList());

        // 输出结果为 [Person(name=Alice, age=25), Person(name=Charlie, age=30)]
        System.out.println(adults);
    }

    /**
     * 使用reduce操作计算所有数字的和
     */
    @Test
    void test14() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        // 输出结果为 15
        System.out.println(sum);
    }

    /**
     * 使用flatMap操作将多个字符串列表合并成一个字符串列表
     */
    @Test
    void test15() {
        List<String> list1 = Arrays.asList("Java", "Python", "C++");
        List<String> list2 = Arrays.asList("JavaScript", "Ruby");

        List<String> mergedList = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // 输出结果为 [Java, Python, C++, JavaScript, Ruby]
        System.out.println(mergedList);
    }

    /**
     * 使用partitioningBy操作将一组数字按照是否为偶数进行分区
     */
    @Test
    void test16() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Map<Boolean, List<Integer>> partitionByEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // 输出结果为 {false=[1, 3, 5], true=[2, 4]}
        System.out.println(partitionByEven);
    }

    /**
     * 使用anyMatch操作判断列表中是否有大于5的数字
     */
    @Test
    void test17() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean hasNumberGreaterThan5 = numbers.stream().anyMatch(n -> n > 5);

        // 输出结果为 false
        System.out.println(hasNumberGreaterThan5);
    }

    /**
     * 使用allMatch操作判断列表中是否所有数字都小于10
     */
    @Test
    void test18() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean allNumbersLessThan10 = numbers.stream().allMatch(n -> n < 10);

        // 输出结果为 true
        System.out.println(allNumbersLessThan10);
    }

    /**
     * 使用noneMatch操作判断列表中是否没有负数
     */
    @Test
    void test19() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean containsNegativeNumber = numbers.stream().noneMatch(n -> n < 0);

        // 输出结果为 true
        System.out.println(containsNegativeNumber);
    }

    /**
     * 使用groupingBy操作将一组单词按照首字母进行分组
     */
    @Test
    void test20() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Map<Character, List<String>> groupByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        // 输出结果为 {a=[apple], b=[banana], c=[cherry], d=[date], e=[elderberry]}
        System.out.println(groupByFirstLetter);
    }

    /**
     * 使用findFirst操作获取列表中的第一个数字
     */
    @Test
    void test21() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> firstNumber = numbers.stream().findFirst();

        // 输出结果为 Optional[1]
        System.out.println(firstNumber);
    }

    /**
     * 用findAny操作获取列表中的任意一个数字
     */
    @Test
    void test22() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> anyNumber = numbers.stream().findAny();

        // 输出结果为 Optional[1] 或者 Optional[2] 或者其他任意一个数字
        System.out.println(anyNumber);
    }

    /**
     * 使用max操作获取列表中的最大数字
     */
    @Test
    void test23() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo);

        // 输出结果为 Optional[5]
        System.out.println(maxNumber);
    }

    /**
     * 使用min操作获取列表中的最小数字
     */
    @Test
    void test24() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> minNumber = numbers.stream()
                .min(Integer::compareTo);

        // 输出结果为 Optional[1]
        System.out.println(minNumber);
    }

    /**
     * 使用count操作获取列表中数字的数量
     */
    @Test
    void test25() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        long count = numbers.stream().count();

        // 输出结果为 5
        System.out.println(count);
    }

    /**
     * 使用toArray操作将所有年龄大于18岁的人转换为数组
     */
    @Test
    void test26() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 17));
        persons.add(new Person("Charlie", 30));

        Person[] adultsArray = persons.stream()
                .filter(p -> p.getAge() > 18)
                .toArray(Person[]::new);

        // 输出结果为 [Person(name=Alice, age=25), Person(name=Charlie, age=30)]
        System.out.println(Arrays.asList(adultsArray));
    }

    /**
     * 使用peek操作在每个数字被处理时输出一条日志
     */
    @Test
    void test27() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream()
                .peek(n -> System.out.println("Processing number: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // 输出结果为：
        // Processing number: 1
        // Processing number: 2
        // Processing number: 3
        // Processing number: 4
        // Processing number: 5
        System.out.println(numbers);
    }

    /**
     * collect(Collectors.joining) 这个方法可以将Stream中的所有元素连接成一个字符串。
     * 它接受一个可选的分隔符和可选的前缀和后缀
     */
    @Test
    void test28() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String result = names.stream()
                .collect(Collectors.joining(", ", "Names: ", " are cool."));
        // 输出结果为：Names: Alice, Bob, Charlie are cool.
        System.out.println(result);
    }

    /**
     * collect(Collectors.maxBy) 这个方法可以在Stream中查找最大值的元素，并返回一个Optional对象
     */
    @Test
    void test29() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 1);

        Optional<Integer> maxNumber = numbers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));
        // 输出结果为：Optional[8]
        System.out.println(maxNumber);
    }

}
