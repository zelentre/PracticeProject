package com.zne.plugin.impl;

import com.zne.enums.ReceiptType;
import com.zne.model.Receipt;
import com.zne.plugin.IReceiptPluginService;
import org.springframework.stereotype.Service;

/**
 * @author ZNE
 * @since 2022/10/23
 */
@Service
public class Mt1101ReceiptPluginServiceImpl implements IReceiptPluginService {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT1101:" + receipt.getMessage());
    }

    @Override
    public boolean supports(Receipt receipt) {
        return ReceiptType.MT1101.getReceiptType().equals(receipt.getType());
    }
}
