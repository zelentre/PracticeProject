package com.zne.prod;

import com.zne.prod.entity.TProd;
import com.zne.prod.service.TProdService;
import com.zne.prod.service.TSkuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author ZNE
 * @since 2023/4/9
 */
@SpringBootTest
public class ProdTest {
    @Resource
    private TProdService prodService;
    @Resource
    private TSkuService skuService;

    @Test
    void test() {
        List<TProd> list = prodService.list();
        list.forEach(p -> p.setSkuList(skuService.getSkuList(p.getId()))
        );
        System.out.println(list);
    }

    /**
     * @see <a href="https://juejin.cn/post/7067437023656673288">CompletableFuture 用于for循环开启异步,并且等全部执行完毕，再走后续流程</a>
     *
     */
    @Test
    void test02() {
        List<TProd> list = prodService.list();
        CompletableFuture.allOf(list.stream().map(prod -> CompletableFuture.runAsync(() -> {
            // 编写你的业务代码
            prod.setSkuList(skuService.getSkuList(prod.getId()));
        })).toArray(CompletableFuture[]::new)).join();
        System.out.println(list);
    }
}