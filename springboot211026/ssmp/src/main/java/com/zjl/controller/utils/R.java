package com.zjl.controller.utils;

import lombok.Data;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午8:41
 */
@Data
public class R {

    private boolean flag;
    private Object data;
    private String msg;

    public R() {
    }

    public R(boolean flag) {
        this.flag = flag;
    }

    public R(Object data) {
        this.data = data;
    }

    public R(String msg) {
        this.msg = msg;
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
}
