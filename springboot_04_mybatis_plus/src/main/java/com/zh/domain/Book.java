package com.zh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_book")
public class Book {
    private int id;
    private String type;
    private String name;
    private String description;
}
