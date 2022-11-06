package com.zne.plugin;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZNE
 * @since 2022/10/23
 */
@Data
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

}
