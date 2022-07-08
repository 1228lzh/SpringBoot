package com.ZH.controller;


import com.ZH.controller.utils.R;
import com.ZH.controller.utils.R2;
import com.ZH.domain.Book;
import com.ZH.service.IBookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController3 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R2 getAll(){
        //return bookService.list();
        List<Book> list = bookService.list();
        //return new R(true,bookService.list());
        return R2.ok().data("items",list);
    }

    @PostMapping
    public R2 save(@RequestBody Book book){//注意加上@RequestBody

        bookService.save(book);
        //return new R(bookService.save(book));
        return R2.ok();

    }

    @PutMapping
    public R2 update(@RequestBody Book book){
        bookService.updateById(book);
        //return bookService.updateById(book);
        //return new R(bookService.updateById(book));
        return R2.ok();
    }

    @DeleteMapping("/{id}")
    public R2 delete(@PathVariable Integer id){//参数的来源 @PathVariable In
        //return bookService.removeById(id);
        bookService.removeById(id);
        //return new R(bookService.removeById(id));
        return R2.ok();
    }

    //查询类全部返回true
    @GetMapping("/{id}")
    public R2 getById(@PathVariable Integer id){
        //return bookService.getById(id);
        Book byId = bookService.getById(id);
        //return new R(true,bookService.getById(id));
        return R2.ok().data("byId",byId);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R2 getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        //return bookService.getPage(currentPage,pageSize);
        Page<Book> page = bookService.getPage(currentPage, pageSize);
        //return new R(true,bookService.getPage(currentPage,pageSize));
        return R2.ok().data("rows",page);
    }
}
