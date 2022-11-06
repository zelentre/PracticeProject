package com.zne.singleton;

/**
 * 双重锁校验(线程安全)单例模式
 *
 * @author ZNE
 * @since 2022/10/29
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton != null) {
            return singleton;
        }
        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
