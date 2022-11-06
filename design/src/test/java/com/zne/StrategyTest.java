package com.zne;

import com.zne.context.ReceiptStrategyContext;
import com.zne.factory.ReceiptHandleStrategyFactory;
import com.zne.model.Receipt;
import com.zne.model.ReceiptBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ZNE
 * @since 2022/9/28
 */
@SpringBootTest
public class StrategyTest {
    @Test
    void strategy() {
        // 模拟回执
        List<Receipt> receipts = ReceiptBuilder.generateReceiptList();
        // 策略上下文
        ReceiptStrategyContext receiptStrategyContext = new ReceiptStrategyContext();
        for (Receipt receipt : receipts) {
            // 获取并设置策略
            receiptStrategyContext.setReceiptHandleStrategy(ReceiptHandleStrategyFactory.getReceiptHandleStrategy(receipt.getType()));
            // 执行
            receiptStrategyContext.handleReceipt(receipt);
        }
    }
}
