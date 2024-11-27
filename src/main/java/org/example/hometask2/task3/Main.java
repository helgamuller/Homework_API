package org.example.hometask2.task3;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("Tools of titans", "Ferris");
        Book book2 = new Book("Java Programming", "James");
        Book book3 = new Book("Java Programming", "Jack");
        Book book4 = new Book("Java Programming", "Jack");

        BookCollection bookCollection;
        bookCollection = new BookCollection();
        bookCollection.AddBook(book);
        bookCollection.AddBook(book2);
        bookCollection.AddBook(book3);
        bookCollection.AddBook(book4);


        System.out.println(bookCollection.toString());

        bookCollection.RemoveBook(book2);

        System.out.println(bookCollection.toString());




    }
}
