package com.ZH.service;

import com.ZH.domain.Book;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private IBookService bookService;

    @Test
    void getById() {
        bookService.getById(10);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setId(18);
        book.setType("test4");
        book.setName("test4");
        book.setDescription("test4");
        bookService.save(book);

    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("test3");
        book.setName("test3");
        book.setDescription("test3...");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        bookService.removeById(18);
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.list());
    }

    @Test
    void testGetPage(){
        Page<Book> bookPage = new Page<>(2, 5);
        bookService.page(bookPage,null);
    }


}
