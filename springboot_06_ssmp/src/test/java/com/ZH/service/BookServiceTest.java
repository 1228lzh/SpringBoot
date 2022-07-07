package com.ZH.service;

import com.ZH.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    void getById() {
        bookService.getById(10);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setId(17);
        book.setType("test1");
        book.setName("test1");
        book.setDescription("test1");
        bookService.save(book);

    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("test2");
        book.setName("test2");
        book.setDescription("test2...");
        bookService.update(book);
    }

    @Test
    void testDelete(){
        bookService.delete(17);
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.getAll());
    }

    @Test
    void testGetPage(){

        bookService.getPage(2,5);
    }


}