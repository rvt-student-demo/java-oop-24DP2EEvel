package rvt;

import java.util.Scanner;

public class UiToDo {
    private final ToDoList todoList;
    private final Scanner scanner;

    public UiToDo(ToDoList theList, Scanner theScanner) {
        this.todoList = theList;
        this.scanner = theScanner;
    }

    public void start() {
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();

            switch (command) {
                case "stop":
                    return;
                case "list":
                    todoList.print();
                    break;
                case "add":
                    addItem();
                    break;
                case "remove":
                    removeItem();
                    break;
                default:
                    break;
            }
        }
    }

    private void addItem() {
        System.out.print("To add: ");
        String item = scanner.nextLine();
        todoList.add(item);
    }

    private void removeItem() {
        System.out.print("Which one is removed? ");
        int itemNumber = Integer.parseInt(scanner.nextLine());
        todoList.remove(itemNumber);
    }
}
