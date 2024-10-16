package com.example.bookapi.model;
public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    public void setId(String id)
    {
        this.id=id;
    }
    public String getId()
    {
        return id;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return title;
    }
    public void setYear(int year)
    {
        this.year=year;
    }
    public int getYear()
    {
        return year;
    }
    Book(String id,String title,String author,int year)
    {
        this.id=id;
        this.title=title;
        this.author=author;
        this.year=year;
    }
}
