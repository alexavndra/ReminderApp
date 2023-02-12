package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class TaskList extends EasyApp {
    private String openList;
    
    Label Title = addLabel("Lists", 220, 50, 150, 40, this);
    
    Button Open = addButton("Open List", 50, 100, 100, 40, this);
    
    Button Add = addButton("Add List", 50, 150, 100, 40, this);
    
    Button Delete = addButton("Delete List", 50, 200, 100, 40, this);
    
    Button Rename = addButton("Rename List", 50, 250, 100, 40, this);
    
    Button Refresh = addButton("Refresh Main", 50, 300, 100, 40, this);
    
    Button Sort = addButton("Sort Lists", 50, 370, 100, 40, this);
    
    Button Close = addButton("Close", 220, 370, 100, 40, this);
    
    Button Exit = addButton("Exit", 330, 370, 100, 40, this);
    
    List MainList = addList("", 220, 100, 280, 260, this);
    
    ArrayList<String> lists;
    
    public void actions(Object source, String command) {
      if (source == Open)
        Open(); 
      if (source == Add)
        new AddList(); 
      if (source == Delete)
        Delete(); 
      if (source == Rename)
        Rename(); 
      if (source == Refresh)
        Refresh(); 
      if (source == Sort)
        new SortLists(); 
      if (source == Close) {
        dispose();
        new ReminderApp();
      } 
      if (source == Exit)
        System.exit(0); 
    }
    
    public TaskList() {
      lists = new ArrayList<>();
      setTitle("Lists");
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 20));
      setBounds(80, 140, 540, 420);
    }
    
    public void totalLists() {
      try {
        File listFile = new File("List.txt");
        Scanner reader = new Scanner(listFile);
        while (reader.hasNextLine())
          lists.add(reader.nextLine()); 
        reader.close();
      } catch (IOException e) {
        e.getMessage();
      } 
    }
    
    void Open() {
      String openList = MainList.getSelectedItem();
      new IndividualList(openList);
      dispose();
    }
    
    public void Delete() {
      String targetList = MainList.getSelectedItem();
      totalLists();
      try {
        FileReader readFile = new FileReader("List.txt");
        BufferedReader reader = new BufferedReader(readFile);
        ArrayList<String> lists = new ArrayList<>();
        String indList = "";
        while ((indList = reader.readLine()) != null)
          lists.add(indList); 
        reader.close();
        FileWriter writer = new FileWriter("List.txt");
        for (String s : lists) {
          if (s.equals(targetList)) {
            writer.write("");
            writer.write("\r\n");
            File targetFiles = new File(s + ".txt");
            targetFiles.delete();
          } 
        } 
        writer.close();
      } catch (IOException e) {
        e.getMessage();
      } 
      for (int i = 0; i < lists.size(); i++) {
        String compare = lists.get(i);
        if (compare.equals(targetList))
          lists.remove(i); 
      } 
    }
    
    void Rename() {
      String listNameEdit = MainList.getSelectedItem();
      Delete();
      new RenameList(listNameEdit);
    }
    
    void Refresh() {
      MainList.removeAll();
      try {
        File listFile = new File("List.txt");
        Scanner reader = new Scanner(listFile);
        while (reader.hasNextLine())
          MainList.add(reader.nextLine()); 
      } catch (IOException e) {
        e.getMessage();
      } 
    }
  }
  
