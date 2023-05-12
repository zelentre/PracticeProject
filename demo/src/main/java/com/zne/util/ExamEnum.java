package com.zne.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * @author ZNE
 * @since 2021/8/31
 */
@Getter
@AllArgsConstructor
public enum ExamEnum {
    /**
     * 测试01
     */
    EXAM_1(1, "测试01"),
    /**
     * 测试02
     */
    EXAM_2(2, "测试02"),
    ;
    /**
     * 枚举值
     */
    private final Integer codeNum;
    /**
     * 枚举名
     */
    private final String codeName;

    /**
     * 获取枚举名
     *
     * @param codeNum 枚举值
     * @return 枚举名
     */
    public static String getName(Integer codeNum) {
        return Stream.of(ExamEnum.values())
                .filter(enums -> enums.getCodeNum().equals(codeNum))
                .map(ExamEnum::getCodeName).findFirst().orElse(null);
    }

    /**
     * 获取枚举类
     *
     * @param codeNum 枚举值
     * @return 枚举名
     */
    public static ExamEnum getExamEnum(Integer codeNum) {
        return Stream.of(ExamEnum.values())
                .filter(enums -> enums.getCodeNum().equals(codeNum))
                .findFirst().orElse(null);
    }

    public static void main(String[] args) {
        System.err.println(getName(1));
        System.out.println(ExamEnum.EXAM_1.getCodeName());
    }
}
