package com.ahmad.spring.bookstore.service;


import com.ahmad.spring.bookstore.entity.Book;
import com.ahmad.spring.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
    }

    private BookRepository bookRepository;


    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBook(){
      return  bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public void DeleteById(int id){
        bookRepository.deleteById(id);
    }


}
