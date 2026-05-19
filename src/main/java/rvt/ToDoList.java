package rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final ArrayList<String> todoList = new ArrayList<>();
    private final String filePath = "src/main/java/rvt/todo.csv";

    public ToDoList() {
        loadFromFile();
    }

    public void add(String item) {
        todoList.add(item);
        updateFile();
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(todoList.get(i));
        }
    }

    public void remove(int index) {
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            updateFile();
        }
    }

    public List<String> getItems() {
        return new ArrayList<>(todoList);
    }

    private void updateFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, false))) {
            pw.println("id,task");
            for (int i = 0; i < todoList.size(); i++) {
                pw.println((i + 1) + "," + todoList.get(i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void loadFromFile() {
        String line;
        boolean isHeader = true;
        todoList.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    String[] parts = trimmedLine.split(",", 2);
                    if (parts.length == 2) {
                        todoList.add(parts[1].trim());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
