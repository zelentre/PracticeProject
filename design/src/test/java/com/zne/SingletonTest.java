package com.zne;

import com.zne.singleton.InnerClassSingleton;
import com.zne.singleton.Singleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ZNE
 * @since 2022/11/3
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SingletonTest {

    @Test
    void innerClassSingletonTest() {
        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }

    @Test
    void SingletonTest(){
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton1);
    }
}
