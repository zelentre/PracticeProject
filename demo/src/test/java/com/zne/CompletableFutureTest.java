package com.zne;


import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * JAVA8 CompletableFuture 异步
 *
 * @author ZNE
 * @see <a href="https://zhuanlan.zhihu.com/p/34921166">CompletableFuture 的 20 个例子</a>
 * @since 2021/8/23
 */
@SpringBootTest
@Slf4j
public class CompletableFutureTest {

    /**
     * 新建一个完成的CompletableFuture
     */
    @Test
    public void completeFutur0eExample() {
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message");
        Assert.isTrue(cf.isDone(), "异常");
        System.err.println("message".equals(cf.getNow(null)));
    }

    /**
     * 运行一个简单的异步stage
     */
    @Test
    public void runAsyncExample() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.err.println("1:" + Thread.currentThread().isDaemon());
            try {
                long l = RandomUtil.randomLong(500, 5000);
                System.out.println("2:" + l);
                Thread.sleep(l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("3:" + cf.isDone());
        System.err.println("4:" + Thread.interrupted());
        System.out.println("5:" + cf.isDone());

    }

    /**
     * 将方法作用于前一个Stage
     */
    @Test
    public void thenApplyExample() {
        CompletableFuture<String> message = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.err.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.err.println(message.getNow(null));
    }

    /**
     * 异步的的将方法作用于前一个Stage
     */
    @Test
    public void thenApplyAsyncExample() {
        CompletableFuture<String> message = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.err.println(message.join());
        System.out.println(message.getNow(null));
    }

    /**
     * 使用一个自定义的Executor来异步执行该方法
     */
    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "custom-executor-" + count++);
        }
    });

    @Test
    public void thenApplyAsyncWithExecutorExample() {
        CompletableFuture<String> message = CompletableFuture.completedFuture("message").thenApplyAsync(s -> {
            System.out.println("custom-executor-:" + Thread.currentThread().getName().startsWith("custom-executor-"));
            System.err.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        }, executor);
        System.out.println(message.getNow(null));
        System.err.println(message.join());
    }

    /**
     * 消费(Consume)前一个Stage的结果
     */
    @Test
    public void thenAcceptExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture("thenAccept message").thenAccept(s -> result.append(s));
        System.err.println(result.length());
        System.out.println(result);
    }

    /**
     * 异步执行Consume
     */
    @Test
    public void thenAcceptAsyncExample() {
        StringBuilder result = new StringBuilder();
        CompletableFuture<Void> cf = CompletableFuture.completedFuture("thenAcceptAsync message").thenAcceptAsync(s -> result.append(s));
        cf.join();
        System.err.println(result.length());
        System.out.println(result);
    }

    /**
     * 计算出现异常时 需要jdk9没法测
     */
    @Test
    public void completeExceptionallyExample() {
        CompletableFuture<String> message = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
        CompletableFuture<String> handle = message.handle((s, th) -> {
            return (th != null) ? "message upon cancel" : "";
        });
        message.completeExceptionally(new RuntimeException("completed exceptionally"));
        System.out.println("Was not completed exceptionally---" + message.isCompletedExceptionally());
        System.err.println(message.join());
        System.err.println(handle.join());
    }

    /**
     * 两个CompletableFuture执行异步查询
     */
//    static void getCompletableFuture() {
//        CompletableFuture<String> sina = CompletableFuture.supplyAsync(() -> {
//            return queryCode()
//        });
//    }
//
//    static String queryCode(String name, String url) {
//        System.err.println("queryCode from " + url);
//        try {
//            Thread.sleep((long) (Math.random() * 1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "sina";
//    }
}
