package org.example.practice1.Student;

import java.util.ArrayList;

public class Student {
        private String name;
        private String id;

    //перегрузка методов - два с одинаковым именем
    //constructor student3
    public Student() {
        this.name = "unknown";
        this.id = "unknown";
    }

    //constructor student2
    public Student(String name, String id) {
        /* тут name, id аргументы конструктора, а не поля класса */
        this.name = name;
        this.id = id;

    }
//constructor student3
    public Student(String name) {
        this.name = name;
        this.id = "id_"+ name;

    }


        //getter

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
