package org.example.practice1.Student;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
        //создали шаблон массива, но он по дефолту null пока
    }
   public StudentManager() {
       //конструктор без аргументов -  сперва нужно создать структуру данных, без данных. Но пока добавлять нельзя, так как к нулл не добавить
       // а теперь создаем пустой лист
       this.students = new ArrayList<>();
   }
    //конструктор без аргументов

    public ArrayList<Student>getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
    public void removeStudent(String id) {
       //вариант 1 :
        //найти студента по ид
        //удалить
        // 1234567809

        Student targetStudent = null;

        for (Student student: students) {
            // условные операторы если - то- иначе
            if (student.getId().equals(id)) {
                //строки сравниваются через equals, а также и все классы
                targetStudent = student;
            }
        }
        if (targetStudent != null) {
            students.remove(targetStudent);
        } else {
            System.out.println("Student with id " +id + " not found");
        }

        }
        }




