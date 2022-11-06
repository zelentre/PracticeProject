package com.zne.plugin;

import com.zne.model.Receipt;
import org.springframework.plugin.core.Plugin;

/**
 * 业务接收对象 此处可以是多支付 例如 支付宝、微信、银联
 *
 * @author ZNE
 * @since 2022/10/23
 */
public interface IReceiptPluginService extends Plugin<Receipt> {
    /**
     * 插件化回执处理接口
     *
     * @param receipt
     */
    void handleReceipt(Receipt receipt);
}
