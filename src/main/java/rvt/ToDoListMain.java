package rvt;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        UiToDo ui = new UiToDo(list);
        ui.start();
    }
}
