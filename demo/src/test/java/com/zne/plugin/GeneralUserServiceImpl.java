package com.zne.plugin;

import org.springframework.stereotype.Service;

/**
 * @author ZNE
 * @since 2022/10/23
 */
@Service(value = "GeneralUserServiceImpl")
public class GeneralUserServiceImpl implements OrderService {
    @Override
    public String order(OrderInfo orderInfo) {
        return "普通用户下单";
    }

    @Override
    public boolean supports(OrderInfo orderInfo) {
        return orderInfo.getUserId().equals(1L);
    }
}
