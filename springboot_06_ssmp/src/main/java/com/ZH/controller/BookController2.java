package com.ZH.controller;


import com.ZH.controller.utils.R;
import com.ZH.domain.Book;
import com.ZH.service.IBookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        //return bookService.list();
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){//注意加上@RequestBody
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);

        return new R(bookService.save(book));

    }

    @PutMapping
    public R update(@RequestBody Book book){

        //return bookService.updateById(book);
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){//参数的来源 @PathVariable In
        //return bookService.removeById(id);
        return new R(bookService.removeById(id));
    }

    //查询类全部返回true
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        //return bookService.getById(id);
        return new R(true,bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        //return bookService.getPage(currentPage,pageSize);
        return new R(true,bookService.getPage(currentPage,pageSize));
    }
}
