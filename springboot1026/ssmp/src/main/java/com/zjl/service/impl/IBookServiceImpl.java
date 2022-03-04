package com.zjl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjl.dao.BookDao;
import com.zjl.domain.Book;
import com.zjl.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午5:09
 */
@Service
public class IBookServiceImpl implements IBookService {

    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    public boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    public IPage<Book> getByPage(int currentPage, int pageSize) {
        IPage page = new Page<Book>(currentPage,pageSize);
        return bookDao.selectPage(page,null);
    }

}
