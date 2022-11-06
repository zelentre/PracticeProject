package com.zne;

import com.zne.model.Receipt;
import com.zne.model.ReceiptBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

/**
 * 传统做法-if-else分支
 *
 * @author ZNE
 * @since 2022/9/28
 */
@SpringBootTest
public class TraitTest {
    @Test
    void deal() {
        List<Receipt> receipts = ReceiptBuilder.generateReceiptList();
        for (Receipt receipt : receipts) {
            if (Objects.equals("MT2101",receipt.getType())) {
                System.out.println("接收到MT2101回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (Objects.equals("MT1101",receipt.getType())) {
                System.out.println("接收到MT1101回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (Objects.equals("MT8104",receipt.getType())) {
                System.out.println("接收到MT8104回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
            } else if (Objects.equals("MT9999",receipt.getType())) {
                System.out.println("接收到MT9999回执");
                System.out.println("解析回执内容");
                System.out.println("执行业务逻辑");
                System.out.println("推送邮件");
            }
            // ......未来可能还有好多个else if
        }
    }

}
