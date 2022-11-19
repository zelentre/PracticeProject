package com.zne.map_injection;

import com.zne.map_injection.emuns.ShapeTypeEnum;
import com.zne.map_injection.factory.ShapeBeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZNE
 * @since 2022/11/19
 */
@SpringBootTest
public class ShapeTest {
    @Autowired
    private ShapeBeanFactory shapeBeanFactory;

    @Test
    void drawShape(){
        shapeBeanFactory.getShape(ShapeTypeEnum.SQUARE.getImplement()).draw();
    }
}
