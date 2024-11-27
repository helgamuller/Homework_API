package org.example.hometask2.task2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;
    //If we understand, that we need to set full object data structure(переопределять), then setter, if we need to add one by one - constructor is our choice
    public StudentManager(ArrayList<Student> students) {
        this.students = students;
        //we assume that we already had students
    }
    public StudentManager() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
           this.students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
    public void removeStudent(String id) {
        // variant 1:
        //find student by id
        //remove student
        Student targetstudent = null;
        for (Student student : students) {
            //conditional operators - if -then-else
            if (student.getId().equals(id)) {
                targetstudent = student;
            }
        }
            //== = for numbers only
        //students.removeIf(student -> student.getId().equals(id));
        if (targetstudent !=null) {
            students.remove(targetstudent);
        }
        else {
            System.out.println("Student with id " + id + " not found");
        }
    }


}
