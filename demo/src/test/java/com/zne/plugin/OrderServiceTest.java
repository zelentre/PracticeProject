package com.zne.plugin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

/**
 * @author ZNE
 * @since 2022/10/23
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnablePluginRegistries(value = {OrderService.class})
public class OrderServiceTest {

    @Autowired
    private PluginRegistry<OrderService, OrderInfo> registry;

    @Test
    public void testOrderService() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(1L);
        registry.getPluginFor(orderInfo).ifPresent(f -> {
            String order = f.order(orderInfo);
            System.out.println(order);
        });
    }
}
