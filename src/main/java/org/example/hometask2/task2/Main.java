package org.example.hometask2.task2;


public class Main {
    public static void main(String[] args){
// assume that id can't be changed after creation. So, we can't use Setters - because in case we used - anybody can change private variable
     //if we created a Constructor differs from default - default one stops work.
        //if we want it proceed works - we need to create it in class

        //перегрузка метода - два метода с одинаковым именем, но разныи аргументами, то
        Student student1 = new Student();
        Student student2 = new Student("Pete", "121");
        Student student3 = new Student("Kate");

        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        studentManager.removeStudent("121");

    }
}
