package org.example.hometask2.task4;

import lombok.Getter;

import java.util.HashMap;

public class PriceList {
    @Getter
    private HashMap<String, Double> priceList;
    public PriceList() {
        priceList = new HashMap<>();
    }
    public PriceList(HashMap<String, Double> priceList) {
        this.priceList = priceList;
    }
    public void addPrice(String name, double price) {
        if (priceList.containsKey(name)) {
            System.out.println("Product already exists. Use changePrice() to update the price.");
        }
        else {
            priceList.put(name, price);
        }
    }
    public void addPrice(Product product) {
        addPrice(product.getName(), product.getPrice());
    }

    public void changePrice(String name, double newPrice) {
        if (priceList.containsKey(name)) {
            priceList.put(name, newPrice);
        }
        else {System.out.println("Product doesn't exist");}
    }

    public double getPrice(String name) {
        return priceList.get(name);
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "priceList=" + priceList +
                '}';
    }



}

