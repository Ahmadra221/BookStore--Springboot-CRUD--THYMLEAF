package com.ahmad.spring.bookstore.repository;

import com.ahmad.spring.bookstore.entity.Book;
import com.ahmad.spring.bookstore.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer> {


}
