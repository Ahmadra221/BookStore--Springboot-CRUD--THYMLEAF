package com.ahmad.spring.bookstore.controller;


import com.ahmad.spring.bookstore.entity.Book;
import com.ahmad.spring.bookstore.entity.MyBook;
import com.ahmad.spring.bookstore.service.BookService;
import com.ahmad.spring.bookstore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyBookController {


    public MyBookController(MyBookService myBookService) {
        this.myBookService = myBookService;
    }

    MyBookService myBookService;

    @GetMapping("/delete/{id}")
    public String DeleteMyBook(@PathVariable ("id") int id){
        myBookService.DeleteById(id);
        return"redirect:/mybooks";
    }


}
