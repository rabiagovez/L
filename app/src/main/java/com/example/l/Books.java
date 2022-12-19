package com.example.l;

public class Books {
    private int id;
    private String name;
    private String category;
    private String writer;
    private int year;
    private String publisher;
    private String ISBN;

    public Books(int id,String name, String category, String writer, int year, String publisher, String ISBN) {
       this.id=id;
        this.name = name;
        this.category = category;
        this.writer = writer;
        this.year = year;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }
    public Books(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }





}
