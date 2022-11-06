package com.zne;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNE
 * @since 2022/10/8
 */
public class ConcurrentTest {

    public static void sleepMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }
    @Test
    void supplyAsyncTest(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("厨师炒菜");
            sleepMillis(200);
            printTimeAndThread("厨师打饭");
            sleepMillis(100);
            return "番茄炒蛋 + 米饭 做好了";
        });
        printTimeAndThread("小白在打游戏");
        printTimeAndThread(String.format("%s, 小白开吃", future.join()));
    }
    @Test
    void supplyAsync2Test(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("厨师炒菜");
            sleepMillis(200);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员蒸饭");
            sleepMillis(300);
            return "米饭";
        }),(dish,rice)->{
            printTimeAndThread("服务员打饭");
            sleepMillis(100);
            return String.format("%s + %s 好了",dish,rice);
        });
        printTimeAndThread("小白在打游戏");
        printTimeAndThread(String.format("%s, 小白开吃", future.join()));
    }

    @Test
    void test3(){
        System.out.println(System.getProperty("java.specification.version"));
    }
}
