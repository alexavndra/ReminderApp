package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AddTask extends EasyApp{
    private String listName;

    Label Title = addLabel("Add New Task", 50, 50, 400, 50, this);
    TextField TaskName = addTextField("Task Name", 50, 100, 120, 29, this);
    TextField DueDate = addTextField("Due Date", 190, 100, 120, 29, this);
    Button AddTask = addButton("Add Task", 150, 150, 107, 29, this);
    Button Cancel = addButton("Cancel", 250, 150, 107, 29, this);

    public AddTask(String listName) {
        setTitle("Add New Task");
        Title.setForeground(Color.black);
        Title.setFont(new Font("Arial", 0, 30));
        TaskName.setFont(new Font("Arial", 0, 12));
        DueDate.setFont(new Font("Arial", 0, 12));
        AddTask.setFont(new Font("Arial", 0, 12));
        Cancel.setFont(new Font("Arial", 0, 12));
        setBounds(100, 100, 400, 200);
        this.listName = listName;
    }

    public void actions(Object source, String command) {
        if (source == AddTask) {
            Add();
        }
        if (source == Cancel) {
            dispose();
        }
    }

    void Add() {
        String taskName = TaskName.getText();
        String dueDate = DueDate.getText();
        taskNoteFile();
        if (taskName.equals("") || dueDate.equals("")) {
            outputString("fill in ALL boxes");
        } else {
            try {
                FileWriter subListFile = new FileWriter(listName + ".txt", true);
                BufferedWriter writer = new BufferedWriter(subListFile);
                writer.write(taskName + ": Due " + dueDate + "\n");
                writer.close();
            } catch (IOException e) {
                e.getMessage();
            }
            TaskName.setText("");
            DueDate.setText("");
        }
    }

    void taskNoteFile() {
        String taskName = TaskName.getText();
        boolean bool;
        try {
            File taskFile = new File(taskName + ".txt");
            if (taskFile.createNewFile()) {
                bool = true;  
            }
            } catch (IOException e) {
                e.getMessage();
            }
        }
}
