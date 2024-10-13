package org.example.practice1.Student;

public class Main {
    public static void main(String[] args) {
        // id не меняется после создания
    Student student1 = new Student();
    Student student2 = new Student("Pete", "001");
    Student student3 = new Student("Ivan");

    System.out.println(student1.toString());
    System.out.println(student2.toString());
    System.out.println(student3.toString());


    StudentManager studentManager = new StudentManager();
    studentManager.addStudent(student1);
    studentManager.addStudent(student2);
    studentManager.addStudent(student3);

    studentManager.removeStudent(student3.getId());

    System.out.println(studentManager.getStudents());
    }

}
