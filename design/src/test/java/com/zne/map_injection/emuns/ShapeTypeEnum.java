package com.zne.map_injection.emuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ZNE
 * @since 2022/11/19
 */
@Getter
@AllArgsConstructor
public enum ShapeTypeEnum {

    RECTANGLE("1","rectangle", "矩形"),

    SQUARE("2","square", "正方形"),

    CIRCLE("3","circle", "圆形"),
    ;
    public String code;
    //接口的实现类名
    public String implement;
    //备注
    public String desc;


}
