package com.zne.singleton;

/**
 * 静态内部类创建单例
 * 这种方法是利用了Java的特性，即当外部类InnerClassSingleton被加载的时候，
 * 并不会创建SingletonInner的实例对象，只有调用getInstance方法获取对象时，
 * SingletonInner对象才会被加载，并且创建对象InnerClassSingleton。
 * 所以：线程安全，唯一性都由JVM来保证，不需要我们加锁。
 *
 * @author ZNE
 * @since 2022/11/3
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
