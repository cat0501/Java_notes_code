package com.zjl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zjl.domain.Book;

import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午4:16
 */
public interface IBookService {

    boolean save(Book book);

    boolean delete(Integer id);

    boolean update(Book book);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getByPage(int currentPage, int pageSize);
}
