package com.zne.service.impl;

import com.zne.model.Receipt;
import com.zne.service.IReceiptHandleStrategy;
import org.springframework.stereotype.Service;

/**
 * @author ZNE
 * @since 2022/9/28
 */
@Service
public class Mt2101ReceiptHandleStrategy implements IReceiptHandleStrategy {
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT2101:" + receipt.getMessage());
    }
}
