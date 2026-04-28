package rvt;

import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<String> todoList = new ArrayList<>();

    public void add(String item) {
        todoList.add(item);
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(todoList.get(i));
        }
    }

    public void remove(int index) {
        todoList.remove(index - 1);
    }
}
