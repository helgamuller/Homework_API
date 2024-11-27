package org.example.hometask2.task5;

import java.util.ArrayList;
import java.util.HashMap;

    public class TaskManager {
    private ArrayList<Task> tasks;
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
   public void removeTask(Task task) {
        this.tasks.remove(task);
   }
   public ArrayList<Task> getTasks() {
        return tasks;
   }

        @Override
        public String toString() {
            return "TaskManager{" +
                    "tasks=" + tasks +
                    '}';
        }
    }
