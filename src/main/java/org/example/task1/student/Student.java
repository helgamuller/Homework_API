package org.example.task1.student;

public class Student implements Printable {
    private String name;
    private String number;
    private String grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public void print() {
        System.out.println(this.name + " " + this.number + " " + this.grade);
    }

}
