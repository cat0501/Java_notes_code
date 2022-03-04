package com.zjl;

import com.zjl.dao.BookDao;
import com.zjl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmpApplicationTests {

	private BookDao bookDao;


	@Test
	void testSave(){
		Book book = new Book();
		book.setName("测试数据");
		book.setType("测试类型");
		bookDao.insert(book);
	}

	@Test
	void contextLoads() {
	}

}
