package com.ZH.service.impl;

import com.ZH.dao.BookDao;
import com.ZH.domain.Book;
import com.ZH.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

//@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;//业务层调用Dao层,调用它的方法

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book)>0;//操作状态,成功失败
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public Page getPage(int currentPage, int pageSize) {
        Page page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page,null);
    }


}
