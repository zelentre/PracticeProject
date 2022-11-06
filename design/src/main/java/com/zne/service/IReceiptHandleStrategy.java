package com.zne.service;

import com.zne.model.Receipt;

/**
 * 回执处理策略接口
 *
 * @author ZNE
 * @since 2022/9/28
 */
public interface IReceiptHandleStrategy {

    /**
     * 回执处理策略接口
     *
     * @param receipt
     */
    void handleReceipt(Receipt receipt);
}
