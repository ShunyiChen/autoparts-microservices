package com.shunyi.autoparts.seataorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Shunyi Chen
 *
 * @create 2021-01-26 13:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /** 0-创建中 1-已完结 */
    private Integer status;
}
