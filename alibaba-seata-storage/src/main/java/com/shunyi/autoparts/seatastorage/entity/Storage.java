package com.shunyi.autoparts.seatastorage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author esehhuc
 * @create 2021-01-26 22:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Long id;
    private Long productId;
    /** 剩余库存 */
    private Integer residue;
    /** 总共库存 */
    private Integer total;
    /** 已用库存 */
    private Integer used;
}
