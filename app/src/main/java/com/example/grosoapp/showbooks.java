package com.example.grosoapp;

class showbook {
    String name,author,category;
    int number;
    int bookid;

    boolean isselected;



    public showbook(boolean isselected, String name, String author, int number, int bookid, String category) {
        this.name = name;
        this.author = author;
        this.number= number;
        this.bookid= bookid;
        this.isselected = isselected;
        this.category = category;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBookId() {
        return bookid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBookId(int bookid) {
        this.bookid = bookid;
    }

    public boolean isIsselected() {
        return isselected;
    }

    public void setIsselected(boolean isselected) {
        this.isselected = isselected;
    }

}
