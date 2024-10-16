package com.example.libraryapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookapi.model.Book;
import com.example.libraryapp.service.BeanRetreival;
import com.example.libraryapp.service.LibraryService;
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final BeanRetreival beanRetreival;

    @Autowired
    public AdminController(BeanRetreival beanRetreival)
    {
        this.beanRetreival=beanRetreival;
    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book book)
    {
        LibraryService ls=beanRetreival.getBean(LibraryService.class);
        ls.addBook(book);
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable String id)
    {
        LibraryService ls=beanRetreival.getBean(LibraryService.class);
        return ls.getBook(id);
    }
}
