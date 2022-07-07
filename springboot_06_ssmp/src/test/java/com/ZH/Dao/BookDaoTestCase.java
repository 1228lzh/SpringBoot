package com.ZH.Dao;

import com.ZH.dao.BookDao;
import com.ZH.domain.Book;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(16));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setId(16);
        book.setType("选修课");
        book.setName("建筑学");
        book.setDescription("有意思");
        bookDao.insert(book);

    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(16);
        book.setType("选修课");
        book.setName("建筑学");
        book.setDescription("测试数据...");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(16);
    }

    @Test
    void testGetAll(){
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testGetPage(){
        Page page = new Page(2,5);
        bookDao.selectPage(page,null);

        page.getCurrent();
        page.getPages();
        page.getRecords();
        page.getSize();
        page.getTotal();
    }

    @Test
    void testGetByCondition(){//条件查询
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","Spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetByCondition2(){
        String name = "Spring";
        Page<Book> bookPage = new Page<>(1,3);
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(name!=null,Book::getName,name);//添加条件
        bookDao.selectPage(bookPage,lambdaQueryWrapper);
    }
}
