package com.zjl.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjl.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/4/17 上午10:58
 */
public interface UserMapper extends BaseMapper<User> {

    // 当通用Mapper无法满足我们的需求时，我们可以自定义基于Mapper接口的xml文件，并在xml文件中配置SQL语句
    List<User> selectAllByName(String name);

    /**
     * 查询 : 根据年龄查询用户列表，分页显示
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位
     * @param age 年龄
     * @return 分页对象
     */
    IPage<User> selectPageByPage(Page<?> page, @Param("age") Integer age);


}
