package com.zne.plugin;

import org.springframework.plugin.core.Plugin;

/**
 * @author ZNE
 * @since 2022/10/23
 */
public interface OrderService extends Plugin<OrderInfo> {

    String order(OrderInfo orderInfo);
}
