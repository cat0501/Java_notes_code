package com.zjl.domain;

import lombok.Data;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午1:59
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
