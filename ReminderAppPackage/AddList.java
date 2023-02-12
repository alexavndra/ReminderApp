package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class AddList extends EasyApp {

    private String list;

    Label Title = addLabel("Add New List", 50, 50, 400, 50, this);
    TextField ListName = addTextField("", 50, 100, 200, 29, this);
    Button AddList = addButton("Add List", 50, 150, 107, 29, this);
    Button Close = addButton("Close", 150, 150, 107, 29, this);
    Button Exit = addButton("Exit", 250, 150, 107, 29, this);

    public AddList() {
        setTitle("Add New List");
        Title.setForeground(Color.black);
        Title.setFont(new Font("Arial", 0, 30));
        ListName.setFont(new Font("Arial", 0, 12));
        AddList.setFont(new Font("Arial", 0, 12));
        Close.setFont(new Font("Arial", 0, 12));
        Exit.setFont(new Font("Arial", 0, 12));
        setBounds(100, 100, 400, 200);
    }

    public AddList(String list) {
        setTitle("Add New List");
        Title.setForeground(Color.black);
        Title.setFont(new Font("Arial", 0, 30));
        ListName.setFont(new Font("Arial", 0, 12));
        AddList.setFont(new Font("Arial", 0, 12));
        Close.setFont(new Font("Arial", 0, 12));
        Exit.setFont(new Font("Arial", 0, 12));
        setBounds(100, 100, 400, 200);
        list = list;
        int index1 = 0;
        int index2 = list.indexOf("~");
        ListName.setText(list.substring(0, index2));
    }

    public void actions(Object source, String command) {
        if (source == AddList) {
            Add();
        }
        if (source == Close) {
            dispose();
            new TaskList();
        }
        if (source == Exit) {
            System.exit(0);
        }
    }

    void Add() {
        String list = ListName.getText();
        if (list.equals("")) {
            outputString("Put a list name");
        } else {
            try {
                FileWriter listFile = new FileWriter("List.txt", true);
                BufferedWriter writer = new BufferedWriter(listFile);
                writer.write(list + "\n");
                writer.close();
            } catch (IOException e) {
                e.getMessage();
            }
            subListTask();
            ListName.setText("");
        }
    }


    void subListTask() {
        String list = ListName.getText();
        try {
            File subListFile = new File(list + ".txt");
            if (subListFile.createNewFile()) {
                boolean fileExists = true;
            } else {
                boolean fileExists = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

