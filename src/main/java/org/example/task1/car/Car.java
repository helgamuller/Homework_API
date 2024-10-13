package org.example.task1.car;

public class Car implements Drivable {
    private String manufacturer;
    private String model;
    private String year;

    //setters
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    //getters
    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this. model;
    }

    public String getYear() {
        return this.year;
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void drive() {

    }
}


