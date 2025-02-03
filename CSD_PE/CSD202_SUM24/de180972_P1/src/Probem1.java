package de180972_P1.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task implements Comparable<Task>{
    String taskID;
    String taskDescription;
    int priority;

    public Task() {
    }

    public Task(String taskID, String taskDescription, int priority) {
        this.taskID = taskID;
        this.taskDescription = taskDescription;
        this.priority = priority;
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return"TaskID= " + taskID + ", taskDescription= " + taskDescription + ", priority= " + priority;
    }
    @Override
    public int compareTo(Task that) {
        return Integer.compare(that.priority, this.priority);
    }
}
class Node {
    Node next;
    Task task;

    public Node(Task task) {
        this.next = null;
        this.task = task;
    }
}
class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }
    public void addTask(String id, String description, int priority) {
        Node current = head;
        Node father = null;

        while (current != null && !current.task.getTaskID().equals(id)) {
            father = current;
            current = current.next;
        }

        if (current != null) {
            current.task.setTaskDescription(description);
            current.task.setPriority(priority);
        } else {
            Node newNode = new Node(new Task(id, description, priority));
            if (head == null) {
                head = newNode;
            } else {
                father.next = newNode;
            }
        }
    }
    public void removeTask(String id) {
        head = remove(id, head);
    }

    private Node remove(String productId, Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }

        if (head.task.getTaskID().equals(productId)) {
            return head.next;
        }

        Node current = head;
        Node father = null;

        while (current != null && !current.task.getTaskID().equals(productId)) {
            father = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found");
            return head;
        }

        father.next = current.next;
        return head;
    }
    public Task searchTask(String id) {
        Node current = head;

        while (current != null) {
            if (current.task.getTaskID().equals(id)) {
                return current.task;
            }
            current = current.next;
        }

        System.out.println("Task not found");
        return null;
    }
    public List<Task> listTasksByPriority() {
        List<Task> taskArrayList = new ArrayList<>();
        Node current = head;

        while (current != null) {
            taskArrayList.add(current.task);
            current = current.next;
        }

        Collections.sort(taskArrayList);
        return taskArrayList;
    }

}
public class Probem1 {
    public static void main(String[] args) {
        TaskManagement system = new TaskManagement();
        system.addTask("T1", "Task 1 description", 5);
        system.addTask("T2", "Task 2 description", 8);
        system.addTask("T3", "Task 3 description", 3);
        System.out.println("List of Tasks by Priority: " +
                system.listTasksByPriority());
        System.out.println("Search Task T1: " + system.searchTask("T1"));

        system.removeTask("T2");
        System.out.println("List of Tasks after removing T2: " +
                system.listTasksByPriority());
    }
}
