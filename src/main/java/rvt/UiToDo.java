package rvt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class UiToDo {
    private final ToDoList todoList;
    private final DefaultListModel<String> listModel;

    public UiToDo(ToDoList theList) {
        this.todoList = theList;
        this.listModel = new DefaultListModel<>();
    }

    public void start() {
        SwingUtilities.invokeLater(this::createWindow);
    }

    private void createWindow() {
        JFrame frame = new JFrame("To Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 320);
        frame.setLocationRelativeTo(null);

        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JLabel infoLabel = new JLabel("Write a task and press Add.");

        JList<String> taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Task:"));
        topPanel.add(taskField);
        topPanel.add(addButton);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(removeButton);
        bottomPanel.add(infoLabel);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addItem(taskField, infoLabel));
        removeButton.addActionListener(e -> removeItem(taskList, infoLabel));
        taskField.addActionListener(e -> addItem(taskField, infoLabel));

        refreshList();
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }

    private void addItem(JTextField taskField, JLabel infoLabel) {
        String item = taskField.getText().trim();

        if (item.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task field is empty.");
            return;
        }

        todoList.add(item);
        refreshList();
        taskField.setText("");
        infoLabel.setText("Task added.");
    }

    private void removeItem(JList<String> taskList, JLabel infoLabel) {
        int selectedIndex = taskList.getSelectedIndex();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "Select a task to remove.");
            return;
        }

        todoList.remove(selectedIndex + 1);
        refreshList();
        infoLabel.setText("Task removed.");
    }

    private void refreshList() {
        listModel.clear();
        for (String item : todoList.getItems()) {
            listModel.addElement(item);
        }
    }
}
