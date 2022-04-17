package com.zjl.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author cat
 * @description
 * @date 2022/4/17 下午2:16
 */

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;

}
