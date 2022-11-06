package com.zne.pipeline.impl;


import com.zne.enums.ReceiptType;
import com.zne.model.Receipt;
import com.zne.pipeline.IReceiptHandleChain;

import java.util.Objects;

/**
 * @author ZNE
 * @since 2022/10/8
 */
public class Mt1101ReceiptChain  implements IReceiptHandleChain {
    @Override
    public void handleReceipt(Receipt receipt) {
        if (Objects.equals(ReceiptType.MT1101.getReceiptType(),receipt.getType())) {
            System.out.println("解析报文MT1101:" + receipt.getMessage());
        }
    }
}
