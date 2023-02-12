package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class WarningClearAllTasks extends EasyApp {
    private String taskName;
    
    Label Title = addLabel("Are you sure you want to clear all tasks?", 50, 50, 400, 50, this);
    
    Button Reset = addButton("Clear All", 150, 100, 107, 29, this);
    
    Button Cancel = addButton("Cancel", 250, 100, 107, 29, this);
    
    public WarningClearAllTasks() {
      setTitle("Warning!");
      this.taskName = taskName;
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 15));
      Reset.setFont(new Font("Arial", 0, 12));
      Cancel.setFont(new Font("Arial", 0, 12));
      setBounds(200, 250, 400, 150);
    }
    
    public void actions(Object source, String command) {
      if (source == Reset) {
        ClearTasks();
        dispose();
      } 
      if (source == Cancel)
        dispose(); 
    }
    
    public void ClearTasks() {
      try {
        FileReader readFile = new FileReader("List.txt");
        BufferedReader reader = new BufferedReader(readFile);
        ArrayList<String> lists = new ArrayList<>();
        String indList = "";
        while ((indList = reader.readLine()) != null)
          lists.add(indList); 
        reader.close();
        for (String s : lists) {
          File subListFile = new File(s + ".txt");
          subListFile.delete();
          if (subListFile.delete()) {
            boolean bool = true;
            continue;
          } 
          boolean subFileDeleted = false;
        } 
      } catch (IOException e) {
        e.getMessage();
      } 
    }
  }
  
