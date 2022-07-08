package com.ZH.service.impl;

import com.ZH.dao.BookDao;
import com.ZH.domain.Book;
import com.ZH.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Page<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public Page<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        //like(条件判断,属性,属性值)
        queryWrapper.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        queryWrapper.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        queryWrapper.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        Page<Book> page = new Page<>();
        bookDao.selectPage(page,queryWrapper);
        return page;


    }
}
