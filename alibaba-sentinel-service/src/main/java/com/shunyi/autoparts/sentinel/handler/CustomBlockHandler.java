package com.shunyi.autoparts.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shunyi.autoparts.common.entities.CommonResult;

/**
 * @author Simeon Chen
 *
 * @create 2021-01-21 17:02
 */
public class CustomBlockHandler {

    public static CommonResult handlerException1(BlockException blockException) {
        return CommonResult.builder().code(444).message(blockException.getClass().getCanonicalName()+"\t global block handler1").build();
    }

    public static CommonResult handlerException2(BlockException blockException) {
        return CommonResult.builder().code(444).message(blockException.getClass().getCanonicalName()+"\t global block handler2").build();
    }
}
