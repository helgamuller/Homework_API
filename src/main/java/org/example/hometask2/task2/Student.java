package org.example.hometask2.task2;

public class Student {
    private String name;
    private String id;

    public Student() {
        this.name = "Unknown";
        this.id = "Unknown";
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
        this.id="id_"+ name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
