package com.shunyi.autoparts.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shunyi Chen
 * @create 2020-12-09 22:43
 */
@Data
@AllArgsConstructor
@Builder
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;
}