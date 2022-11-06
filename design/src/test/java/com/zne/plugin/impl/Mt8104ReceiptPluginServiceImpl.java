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
public class Mt8104ReceiptPluginServiceImpl implements IReceiptPluginService {

    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT8104:" + receipt.getMessage());
    }

    @Override
    public boolean supports(Receipt receipt) {
        return ReceiptType.MT8104.getReceiptType().equals(receipt.getType());
    }
}
