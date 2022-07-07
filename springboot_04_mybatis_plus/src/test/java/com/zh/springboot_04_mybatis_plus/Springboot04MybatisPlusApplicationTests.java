package com.zh.springboot_04_mybatis_plus;

import com.zh.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04MybatisPlusApplicationTests {

	@Autowired
	private BookDao bookDao;

	@Test
	void contextLoads() {
		System.out.println(bookDao.selectById(2));
	}

}
