package com.itheima.domain;

import java.util.List;

/**
 * @author cat
 * @date 2022/2/13 下午3:03
 */
public class VO {

    private List<User> userList;


    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
