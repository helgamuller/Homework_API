package org.example;

import org.example.task1.book.Book;
import org.example.task1.car.Car;
import org.example.task1.clock.Clock;
import org.example.task1.point.Point;
import org.example.task1.student.Student;

public class Main {
    public static void main(String[] args) {
        /* Book task */
        Book book1 = new Book();
        book1.setAuthor("Backman");
        book1.setName("Nervous people");
        book1.setYear("2015");
        book1.display();
        /* Student task */
        Student student1 = new Student();
        student1.setName("Ivanoff");
        student1.setNumber("12345");
        student1.setGrade("4.8");
        student1.print();

        /* Point task */

        Point point1 = new Point();
        point1.setX(10);
        point1.setY(15);
        point1.moveUp();
        point1.moveDown();
        point1.moveLeft();
        point1.moveRight();

        /* Clock task */

        Clock clock1 = new Clock();
        clock1.setHours(11);
        clock1.setMinutes(34);
        clock1.setSeconds(48);
        clock1.tick();
        clock1.readTime();

        /* Car task */
        Car car1;
        car1 = new Car();
        car1.setManufacturer("Volvo");
        car1.setModel("XC60");
        car1.setYear("2023");

    }


}