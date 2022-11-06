package com.zne.factory;

import com.zne.enums.ReceiptType;
import com.zne.service.IReceiptHandleStrategy;

/**
 * 策略工厂
 *
 * @author ZNE
 * @since 2022/9/28
 */
public class ReceiptHandleStrategyFactory {
//    private Map<String, IReceiptHandleStrategy> receiptHandleStrategyMap;
//
//    /**
//     * 个人感觉完全可以用个枚举类啊
//     */
//    public ReceiptHandleStrategyFactory() {
//        receiptHandleStrategyMap = new HashMap<>();
//        receiptHandleStrategyMap.put("MT1101", new Mt1101ReceiptHandleStrategy());
//        receiptHandleStrategyMap.put("MT2101", new Mt2101ReceiptHandleStrategy());
//        receiptHandleStrategyMap.put("MT8104", new Mt8104ReceiptHandleStrategy());
//        receiptHandleStrategyMap.put("MT9999", new Mt9999ReceiptHandleStrategy());
//        //
//    }

    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType) {
        return ReceiptType.getReceiptHandleStrategy(receiptType);
    }

}
