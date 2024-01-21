package com.ahmad.spring.bookstore.controller;


import com.ahmad.spring.bookstore.entity.Book;
import com.ahmad.spring.bookstore.entity.MyBook;
import com.ahmad.spring.bookstore.service.BookService;
import com.ahmad.spring.bookstore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {


    MyBookService myBookService;

    BookService bookService;

    public BookController(BookService bookService, MyBookService myBookService) {
        this.bookService = bookService;
        this.myBookService = myBookService;
    }


    @GetMapping("/")
    public  String home(){
        return "home";
    }

    @GetMapping("/newbook")
    public String addBook(){
        return "book_add";
    }

    @GetMapping("/books")
    public ModelAndView listBook(){
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book){
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/mybooks")
    public ModelAndView listMyBook(){
        List<MyBook> list = myBookService.getAllMyBook();
        return new ModelAndView("my_books","mybook",list);
    }


    @RequestMapping("/mylist/{id}")
    public  String getList(@PathVariable("id") int id){
            Book book = bookService.getBookById(id);
            MyBook myBook = new MyBook(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
            myBookService.createMyBook(myBook);

            return "redirect:/mybooks";

    }

    @RequestMapping("/edit/{id}")
    public String bookEdit(@PathVariable("id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "bookEdit";
    }

    @GetMapping("book/delete/{id}")
    public String DeleteMyBook(@PathVariable ("id") int id){
        bookService.DeleteById(id);
        return"redirect:/books";
    }


}
