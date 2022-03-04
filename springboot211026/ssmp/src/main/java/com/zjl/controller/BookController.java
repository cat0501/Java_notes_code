package com.zjl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zjl.controller.utils.R;
import com.zjl.domain.Book;
import com.zjl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author cat
 * @description
 * @date 2022/3/3 下午8:39
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // 查
    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") int id) {
        return new R(true, bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {

        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果当前页码大于了总页码，那么将最大页码值作为当前页码，重新执行查询操作
        // 源码中  long pages = this.getTotal() / this.getSize();
        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }

    // 增
    @PostMapping
    public R save(@RequestBody Book book) {

        boolean b = bookService.save(book);
        return new R(b, b ? "添加成功。" : "添加失败！");
    }

    // 改
    @PutMapping
    public R update(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) throw new IOException();
        boolean b = bookService.modify(book);
        return new R(b, b ? "修改成功。" : "修改失败！");
    }

    // 删
    @DeleteMapping("/{id}")
    public R delete(@PathVariable() int id) {
        return new R(bookService.delete(id));
    }

}
