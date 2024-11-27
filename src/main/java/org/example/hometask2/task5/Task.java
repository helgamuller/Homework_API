package org.example.hometask2.task5;

public class Task {
    private String task;
    private int taskPriority;

    public Task(String task, int taskPriority) {
        this.task = task;
        this.taskPriority = taskPriority;
    }
    public int getPriority() {
        return taskPriority;
    }
    public String getTask() {
        return task;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + task + '\'' +
                ", taskPriority=" + taskPriority +
                '}';
    }
}
