package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class RenameList extends EasyApp {
    private String list;
    
    Label Title = addLabel("Edit List Name", 50, 50, 400, 50, this);
    
    TextField ListName = addTextField("", 50, 100, 200, 29, this);
    
    Button EditList = addButton("Edit List", 50, 150, 107, 29, this);
    
    Button Close = addButton("Close", 150, 150, 107, 29, this);
    
    Button Exit = addButton("Exit", 250, 150, 107, 29, this);
    
    public RenameList(String list) {
      setTitle("Edit List Name");
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 30));
      ListName.setFont(new Font("Arial", 0, 12));
      EditList.setFont(new Font("Arial", 0, 12));
      Close.setFont(new Font("Arial", 0, 12));
      Exit.setFont(new Font("Arial", 0, 12));
      setBounds(100, 100, 400, 200);
      this.list = list;
      
      int index1 = 0;
      int index2 = list.indexOf("~");
      ListName.setText(list.substring(0, index2));
    }
    
    public void actions(Object source, String command) {
      if (source == EditList)
        Edit(); 
      if (source == Close) {
        dispose();
        new TaskList();
      } 
      if (source == Exit)
        System.exit(0); 
    }
    
    void Edit() {
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
  
