package com.zjl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zjl.domain.Book;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午5:46
 */
public interface BookService extends IService<Book> {

    // 追加的操作与原始操作通过名称区分，功能类似
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

}
