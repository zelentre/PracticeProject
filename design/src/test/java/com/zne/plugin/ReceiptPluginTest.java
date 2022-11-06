package com.zne.plugin;

import com.zne.model.Receipt;
import com.zne.model.ReceiptBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;

import java.util.List;

/**
 * @author ZNE
 * @since 2022/10/23
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@EnablePluginRegistries(value = {IReceiptPluginService.class})
public class ReceiptPluginTest {

    @Autowired
    private PluginRegistry<IReceiptPluginService, Receipt> registry;

    @Test
    public void pluginTest() {
        // 模拟回执
        List<Receipt> receipts = ReceiptBuilder.generateReceiptList();
        for (Receipt receipt : receipts) {
            registry.getPluginFor(receipt).ifPresent(f -> f.handleReceipt(receipt));
        }

    }
}
