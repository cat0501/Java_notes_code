package com.zjl.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午2:44
 */
@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试数据");
        book.setType("测试类型");
        bookDao.insert(book);
    }

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    /**
     * @description 分页功能（Mp拦截器配合）
     * @author Lemonade
     * @param:
     * @updateTime 2022/3/3 下午3:49
     */
    @Test
    void testGetPage(){
        IPage page = new Page(1,1);
        bookDao.selectPage(page,null);
    }


    /**
     * @description 条件查询功能
     * @author Lemonade
     * @param:
     * @updateTime 2022/3/3 下午3:50
     */
    @Test
    void testGetByCondition(){
        IPage page = new Page(1,10);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Book::getName,"Spring");
        bookDao.selectPage(page,lqw);
    }

    @Test
    void testGetByCondition2(){
        QueryWrapper<Book> qw = new QueryWrapper<Book>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

}
