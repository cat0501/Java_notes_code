package com.zjl.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cat
 * @description
 * @date 2022/4/17 上午10:57
 */
@Data
// 实体类的名字是User，数据库表名是t_user
// 注解1
@TableName(value = "t_user")
public class User {
    // 注解2
    // 默认情况下数据库的id列使用的是基于雪花算法的策略生成
    @TableId(value = "uid", type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    // 用户明确定义了属性值，则无需自动填充，否则使用自动填充
    @TableField(fill = FieldFill.INSERT)
    private Integer age;

    private String email;

    // 注解3
    // 我们可以使用自动填充功能维护这两个字段
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    // 注解4
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer deleted;


}
