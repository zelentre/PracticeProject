package com.zne.context;

import com.zne.model.Receipt;
import com.zne.service.IReceiptHandleStrategy;

import java.util.Objects;

/**
 * 上下文类，持有策略接口
 *
 * @author ZNE
 * @since 2022/9/28
 */
public class ReceiptStrategyContext {

    private IReceiptHandleStrategy receiptHandleStrategy;

    /**
     * 设置策略接口
     *
     * @param receiptHandleStrategy
     */
    public void setReceiptHandleStrategy(IReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    public void handleReceipt(Receipt receipt) {
        if (Objects.nonNull(receiptHandleStrategy)) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}
