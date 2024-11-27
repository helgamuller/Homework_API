package org.example.hometask2.task5;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("Chores", 2);
        Task task2 = new Task("Making Money", 1);
        Task task3 = new Task("Studying", 3);

        System.out.println(task.toString());
        System.out.println(task2.toString());
        System.out.println(task3.toString());

        TaskManager taskManager = new TaskManager();
        taskManager.addTask(task);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        System.out.println(taskManager);

        System.out.println("Before sorting:");
        for (Task t : taskManager.getTasks()) {
            System.out.println(t);
        }

        taskManager.getTasks().sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));

        System.out.println("\nAfter sorting:");
        for (Task t : taskManager.getTasks()) {
            System.out.println(t);


        }
    }
}
