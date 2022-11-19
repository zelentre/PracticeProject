package com.zne.map_injection.impl;

import com.zne.map_injection.Shape;
import org.springframework.stereotype.Service;

/**
 * @author ZNE
 * @since 2022/11/19
 */
@Service(value = "square")
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
