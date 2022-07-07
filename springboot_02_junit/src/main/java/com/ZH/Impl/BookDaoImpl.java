package com.ZH.Impl;

import com.ZH.Dao.BookDao;
import org.springframework.stereotype.Repository;
@Repository

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao is running...");
    }
}
