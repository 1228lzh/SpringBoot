package com.ZH.controller;


import com.ZH.controller.utils.R;
import com.ZH.controller.utils.ResultMsg;
import com.ZH.domain.Book;
import com.ZH.service.IBookService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

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
    public R save(@RequestBody Book book) throws IOException {//注意加上@RequestBody
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        if (book.getName().equals("123")) throw new IOException();
        Boolean flag = bookService.save(book);
        //return new R(flag,flag?"添加成功":"添加失败");
        return new R(flag,flag? ResultMsg.SUCCESS:ResultMsg.ERROR);

    }

    @PutMapping
    public R update(@RequestBody Book book){

        //return bookService.updateById(book);
        Boolean flag = bookService.updateById(book);
        //return new R(bookService.updateById(book));
        return new R(flag,flag? ResultMsg.UPDATESUCCESS:ResultMsg.UPDATEERROR);
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){//参数的来源 @PathVariable In
        //return bookService.removeById(id);
        Boolean flag = bookService.removeById(id);
        return new R(flag,flag?ResultMsg.DELETESUCCESS:ResultMsg.UPDATEERROR);
    }

    //查询类全部返回true
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        //return bookService.getById(id);
        return new R(true,bookService.getById(id));
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        //return bookService.getPage(currentPage,pageSize);
//        Page<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码数>总页码数,则将当前页码数置为最大页码数
//        if (currentPage>page.getPages()){
//            page = bookService.getPage((int) page.getPages(),pageSize);//重新查询
//        }
//        return new R(true,page);
//    }


    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        //System.out.println("参数--->"+book);

        Page<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码数>总页码数,则将当前页码数置为最大页码数
        if (currentPage>page.getPages()){
            page = bookService.getPage((int) page.getPages(),pageSize,book);//重新查询
        }

        return new R(true,page);
    }
}
