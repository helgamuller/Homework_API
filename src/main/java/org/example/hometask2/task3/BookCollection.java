package org.example.hometask2.task3;

import java.util.HashSet;

public class BookCollection {
    private HashSet<Book> books;

    public BookCollection() {
        books = new HashSet<>();
    }

    public BookCollection(HashSet<Book> books) {
        this.books = books;
    }
    public HashSet<Book> getBooks() {
        return books;
    }
    public void AddBook(Book book) {
        books.add(book);
    }
    public void RemoveBook(Book book) {
        books.remove(book);
    }
    public void CheckBook(Book book) {
        if (books.contains(book)) {
            System.out.println("Book is already in the collection");
        } else {
            System.out.println("Book is not in the collection");
        }
    }

    @Override
    public String toString() {
        return "BookCollection{" +
                "books=" + books +
                '}';
    }
}
