package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Settings extends EasyApp {
    Label Title = addLabel("Settings", 50, 50, 400, 50, this);
    
    Button ResetAll = addButton("Reset All", 50, 100, 107, 29, this);
    
    Button ClearTasks = addButton("Clear Tasks", 150, 100, 107, 29, this);
    
    Button Close = addButton("Close", 150, 150, 107, 29, this);
    
    Button Exit = addButton("Exit", 250, 150, 107, 29, this);
    
    public Settings() {
      setTitle("Settings");
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 30));
      ResetAll.setFont(new Font("Arial", 0, 12));
      ClearTasks.setFont(new Font("Arial", 0, 12));
      Close.setFont(new Font("Arial", 0, 12));
      Exit.setFont(new Font("Arial", 0, 12));
      setBounds(100, 100, 400, 200);
    }
    
    public void actions(Object source, String command) {
      if (source == ResetAll)
        new WarningResetAll(); 
      if (source == ClearTasks)
        new WarningClearAllTasks(); 
      if (source == Close) {
        dispose();
        new ReminderApp();
      } 
      if (source == Exit)
        System.exit(0); 
    }
  }
  