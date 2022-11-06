package com.zne.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 业务接收对象
 * 此处可以是多支付 例如 支付宝、微信、银联
 *
 * @author ZNE
 * @see <a href="https://mp.weixin.qq.com/s/dEqb8c3S2LlgWow6WUg0zA">用设计模式来干掉 if-else</a>
 * @since 2022/9/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receipt implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 回执信息
     */
    String message;

    /**
     * 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999`)
     */
    String type;
}
