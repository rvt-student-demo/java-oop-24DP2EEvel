package rvt;

import java.util.Scanner;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        UiToDo ui = new UiToDo(list, scanner);
        ui.start();
    }
}
