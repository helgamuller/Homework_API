package org.example.hometask2.task4;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Phone", 1000);
        Product product2 = new Product("Tablet", 2000);
        Product product3 = new Product("Mouse", 100);
        Product product4 = new Product("Laptop", 3000);

        PriceList priceList = new PriceList();
        priceList.addPrice(product);
        priceList.addPrice(product2);
        priceList.addPrice(product3);
        priceList.addPrice(product4);


        System.out.println(priceList.toString());

        priceList.changePrice("Mouse", 122);

        System.out.println(priceList.toString());




    }
}
