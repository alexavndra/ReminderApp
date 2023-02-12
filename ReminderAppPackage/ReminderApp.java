package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class ReminderApp extends EasyApp{
    Label Title = addLabel("Welcome to the Reminder App!", 70, 40, 500, 30, this);
    Button Settings = addButton("Settings", 60, 110, 120, 60, this);
    Button TaskList = addButton("Lists and Tasks", 220, 110, 120, 60, this);
    Button Exit = addButton("Exit", 140, 200, 120, 60, this);
    Label Date = addLabel("", 155, 250, 500, 60, this);
    Label Time = addLabel("", 185, 290, 500, 60, this);
    
    public ReminderApp(){
        setTitle("Welcome to the Reminder App!");
        Title.setForeground(Color.black);
        Title.setFont(new Font("Arial", 0, 20));
        Settings.setFont(new Font("Arial", 0, 15));
        TaskList.setFont(new Font("Arial", 0, 15));
        Exit.setFont(new Font("Arial", 0, 15));
        Date.setFont(new Font("Arial", 0, 20));
        Time.setFont(new Font("Arial", 0, 15));
        setBounds(50, 50, 400, 350);
        CurrentDate();
    }

    public void actions(Object source, String command) {
        if (source == Settings) {
          new Settings();
          dispose();
        } 
        if (source == TaskList) {
          taskListMainframe();
          dispose();
        } 
        if (source == Exit)
          System.exit(0); 
      }
      
      private void CurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText((month + 1) + "/" + day + "/" + year);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        if (minute < 10) {
          Time.setText("" + hour + ":0" + hour);
        } else {
          Time.setText("" + hour + ":" + minute);
        }
      }
      
      void taskListMainframe() {
        try {
          File listFile = new File("List.txt");
          if (listFile.createNewFile()) {
            boolean fileExists = true;
          } else {
            boolean fileExists = false;
          } 
        } catch (IOException e) {
          e.printStackTrace();
        } 
        new TaskList();
      }
    }
    
}