package com.zne.optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author ZNE
 * @since 2022/12/24
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OptionalTest {
    @Test
    void test01() {
        // optional是什么？ 如何用
        Optional<Student> optional = Optional.of(new Student());
        Optional<Student> optional1 = Optional.ofNullable(new Student());
        Optional<Object> empty = Optional.empty();

        // optional实际使用案例
        // 避免NPE
        // 打印学生姓名
        Student stu = new Student("张三", 20, 100.0);
        if (!Objects.isNull(stu)) {
            String name = stu.getName();
            System.out.println("一般方法: " + name);
        }
        // 常见"错误"用法 不优雅
        Optional<Student> optionalStu = Optional.ofNullable(stu);
        if (optionalStu.isPresent()) {
            System.out.println(optionalStu.get().getName());
        }
        // 正确用法
        optionalStu.ifPresent(student -> {
            System.out.println(student.getName());
        });
        // 这样也可以
        optionalStu.map(Student::getName).ifPresent(System.out::println);
    }

    @Test
    void test02() {
        Optional<Student> optionalStudent = Optional.ofNullable(new Student("张三", 20, 100.0));
        // orElse和orElseGet的区别
        Student orElse = optionalStudent.orElse(this.createStudent());
        Student orElseGet = optionalStudent.orElseGet(this::createStudent);
        System.out.println(orElse + "----------" + orElseGet);

        // 过滤
        optionalStudent.filter(student -> student.getAge() > 10).ifPresent(student -> System.out.println(student.getName()));
        // map 和 flatmap
        
    }

    private Student createStudent() {
        System.out.println("called from orElse");
        return new Student();
    }
}
