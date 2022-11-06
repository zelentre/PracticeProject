package com.zne.enums;

import com.zne.service.IReceiptHandleStrategy;
import com.zne.service.impl.Mt1101ReceiptHandleStrategy;
import com.zne.service.impl.Mt2101ReceiptHandleStrategy;
import com.zne.service.impl.Mt8104ReceiptHandleStrategy;
import com.zne.service.impl.Mt9999ReceiptHandleStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * ReceiptType枚举类
 *
 * @author ZNE
 * @since 2022/9/28
 */
@Getter
@AllArgsConstructor
public enum ReceiptType {

    /**
     * MT1101
     */
    MT1101("MT1101", new Mt1101ReceiptHandleStrategy()),
    /**
     * MT2101
     */
    MT2101("MT2101", new Mt2101ReceiptHandleStrategy()),
    /**
     * MT8104
     */
    MT8104("MT8104", new Mt8104ReceiptHandleStrategy()),
    /**
     * MT9999
     */
    MT9999("MT9999", new Mt9999ReceiptHandleStrategy());

    /**
     * receiptType
     */
    private final String receiptType;
    /**
     * receiptHandleStrategy
     */
    private final IReceiptHandleStrategy receiptHandleStrategy;

    /**
     * 获取对应策略
     *
     * @param receiptType receiptType
     * @return IReceiptHandleStrategy
     */
    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType) {
        return Stream.of(ReceiptType.values())
                .filter(receipt -> Objects.equals(receiptType, receipt.getReceiptType()))
                .map(ReceiptType::getReceiptHandleStrategy).findFirst().orElse(null);
    }
}
