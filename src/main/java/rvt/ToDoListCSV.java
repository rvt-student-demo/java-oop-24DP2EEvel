package rvt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ToDoListCSV {
    private final ArrayList<String> todoList;
    private final String filePath = "src/main/java/rvt/todo.csv";
    private final String valueRegex = "^[A-Za-z0-9 ]{3,}$";

    public ToDoListCSV() {
        this.todoList = new ArrayList<>();
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ": " + todoList.get(i));
        }
    }

    private void updateFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, false))) {
            pw.println("id,task");
            for (int i = 0; i < todoList.size(); i++) {
                int index = i + 1;
                pw.println(index + "," + todoList.get(i));
            }
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
        }
    }

    public void remove(int index) {
        todoList.remove(index - 1);
        updateFile();
    }

    public void loadFromFile() {
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
                    String task = parts.length == 2 ? parts[1].trim() : trimmedLine;
                    todoList.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int getLastID() {
        return todoList.size();        
    }
    
    public void add(String task) throws Exception {
        checkEventString(task);
        todoList.add(task);
        updateFile();
    }

    private boolean checkEventString(String value) throws Exception {
        if (value.matches(valueRegex)) {
            return true;
        } else {
            throw new Exception("Invalid format. Enter a normal task."); 
        }
    }
}
