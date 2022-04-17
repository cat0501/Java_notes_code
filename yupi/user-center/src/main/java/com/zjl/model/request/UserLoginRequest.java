package com.zjl.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cat
 * @description 用户注册请求体
 * @date 2022/3/27 上午11:03
 */
@Data
public class UserLoginRequest implements Serializable {

    // 添加方法见博客：https://blog.csdn.net/aa494661239/article/details/80520418
    private static final long serialVersionUID = 782400260035317851L;

    private String userAccount;
    private String userPassword;

}
