package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class SortLists extends EasyApp {
    Label Title = addLabel("Sort Lists", 30, 50, 100, 30, this);
    
    Button SortAZ = addButton("A-Z", 30, 80, 50, 30, this);
    
    Button SortZA = addButton("Z-A", 80, 80, 50, 30, this);
    
    Button Back = addButton("Go back", 100, 130, 100, 30, this);
    
    public SortLists() {
      setTitle("Sort Lists");
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 20));
      SortAZ.setFont(new Font("Arial", 0, 12));
      SortZA.setFont(new Font("Arial", 0, 12));
      Back.setFont(new Font("Arial", 0, 12));
      setBounds(400, 400, 230, 170);
    }
    
    public void actions(Object source, String command) {
      if (source == SortAZ)
        sortListAZ(); 
      if (source == SortZA)
        sortListZA(); 
      if (source == Back)
        dispose(); 
    }
    
    public void sortListAZ() {
      try {
        FileReader readFile = new FileReader("List.txt");
        BufferedReader reader = new BufferedReader(readFile);
        ArrayList<String> lists = new ArrayList<>();
        String indList = "";
        while ((indList = reader.readLine()) != null)
          lists.add(indList); 
        reader.close();
        Collections.sort(lists);
        FileWriter writer = new FileWriter("List.txt");
        for (String s : lists) {
          writer.write(s);
          writer.write("\r\n");
        } 
        writer.close();
      } catch (IOException e) {
        e.getMessage();
      } 
    }
    
    public void sortListZA() {
      try {
        FileReader readFile = new FileReader("List.txt");
        BufferedReader reader = new BufferedReader(readFile);
        ArrayList<String> lists = new ArrayList<>();
        String indList = "";
        while ((indList = reader.readLine()) != null)
          lists.add(indList); 
        reader.close();
        Collections.sort(lists, Collections.reverseOrder());
        FileWriter writer = new FileWriter("List.txt");
        for (String s : lists) {
          writer.write(s);
          writer.write("\r\n");
        } 
        writer.close();
      } catch (IOException e) {
        e.getMessage();
      } 
    }
  }
  
