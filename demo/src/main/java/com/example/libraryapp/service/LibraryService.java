package com.example.libraryapp.service;
import com.example.bookapi.model.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private Map<String,Book> books=new HashMap<>();
    public void addBook(Book book)
    {
        books.put(book.getId(),book);
    }
    public Book getBook(String id)
    {
        return books.get(id);
    }
}
