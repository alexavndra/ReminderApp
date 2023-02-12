package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class WarningResetAll extends EasyApp {
    private String taskName;
    
    Label Title = addLabel("Are you sure you want to reset everything?", 50, 50, 400, 50, this);
    
    Button Reset = addButton("Reset All", 150, 100, 107, 29, this);
    
    Button Cancel = addButton("Cancel", 250, 100, 107, 29, this);
    
    public WarningResetAll() {
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
        ResetAll();
        dispose();
      } 
      if (source == Cancel)
        dispose(); 
    }
    
    public void ResetAll() {
      File listFile = new File("List.txt");
      File subListFile = new File("subList.txt");
      if (listFile.delete() && subListFile.delete()) {
        boolean fileDeleted = true;
      } else {
        boolean fileDeleted = false;
      } 
    }
  }
  