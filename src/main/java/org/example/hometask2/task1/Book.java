package org.example.hometask2.task1;

public class Book implements Displayable {
private String name;
private String author;
private String year;


    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public void display() {
    System.out.println(this.author + " " + this.name + " " + this.year);
    }
}
