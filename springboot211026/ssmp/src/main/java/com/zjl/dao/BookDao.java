package com.zjl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjl.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午2:23
 */
@Mapper
@Component
public interface BookDao extends BaseMapper<Book> {

}
