package com.ZH.service;

import com.ZH.domain.Book;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService{
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    Page getPage(int currentPage,int pageSize);

    //void getByCondition();
}