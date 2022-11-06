package com.zne.pipeline.impl;

import com.zne.enums.ReceiptType;
import com.zne.model.Receipt;
import com.zne.pipeline.IReceiptHandleChain;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author ZNE
 * @since 2022/10/8
 */
@Component
public class Mt9999ReceiptChain implements IReceiptHandleChain {
    @Override
    public void handleReceipt(Receipt receipt) {
        if (Objects.equals(ReceiptType.MT9999.getReceiptType(),receipt.getType())) {
            System.out.println("解析报文MT9999:" + receipt.getMessage());
        }
    }
}
