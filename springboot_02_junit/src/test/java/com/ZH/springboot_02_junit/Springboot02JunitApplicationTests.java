package com.ZH.springboot_02_junit;

import com.ZH.Dao.BookDao;
import com.ZH.Springboot02JunitApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot02JunitApplication.class)
class Springboot02JunitApplicationTests {

	@Autowired
	private BookDao bookDao;
	@Test
	void contextLoads() {
		System.out.println("test...");
		bookDao.save();
	}

}
