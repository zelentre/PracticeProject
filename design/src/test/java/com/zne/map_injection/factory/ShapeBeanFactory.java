package com.zne.map_injection.factory;

import com.zne.map_injection.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author ZNE
 * @since 2022/11/19
 */
@Component
public class ShapeBeanFactory {
    @Autowired
    private Map<String, Shape> shapeMap;

    public Shape getShape(String shapeType) {
        return shapeMap.get(shapeType);
    }
}
