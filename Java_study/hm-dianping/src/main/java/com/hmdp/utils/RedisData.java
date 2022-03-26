package com.hmdp.utils;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RedisData {
    private LocalDateTime expireTime;
    // 完全不需要对原来的实体做任何修改
    private Object data;
}
