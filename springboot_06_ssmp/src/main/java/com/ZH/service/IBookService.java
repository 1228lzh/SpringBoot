package com.ZH.service;

import com.ZH.domain.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

public interface IBookService extends IService<Book> {
    Page<Book> getPage(int currentPage, int pageSize);

    Page<Book> getPage(int currentPage, int pageSize, Book book);
}
