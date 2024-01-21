package com.ahmad.spring.bookstore.service;


import com.ahmad.spring.bookstore.entity.Book;
import com.ahmad.spring.bookstore.entity.MyBook;
import com.ahmad.spring.bookstore.repository.BookRepository;
import com.ahmad.spring.bookstore.repository.MyBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {


    public MyBookService(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    private MyBookRepository myBookRepository;


    public void createMyBook(MyBook myBook){
        myBookRepository.save(myBook);
    }

    public List<MyBook> getAllMyBook(){
      return  myBookRepository.findAll();
    }

    public void DeleteById(int id){
        myBookRepository.deleteById(id);
    }
}
