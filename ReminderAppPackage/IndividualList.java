package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class IndividualList extends EasyApp {
    private String listName;
    
    Button Open = addButton("Open Task", 50, 100, 100, 40, this);
    
    Button Add = addButton("Add Task", 50, 150, 100, 40, this);
    
    Button Complete = addButton("Complete Task", 50, 200, 100, 40, this);
    
    Button Edit = addButton("Edit Task", 50, 250, 100, 40, this);
    
    Button RefreshList = addButton("Refresh List", 50, 300, 100, 40, this);
    
    Button Close = addButton("Close", 220, 370, 100, 40, this);
    
    Button Exit = addButton("Exit", 330, 370, 100, 40, this);
    
    Button Search = addButton("Search", 400, 45, 100, 40, this);
    
    TextField SearchField = addTextField("Search for Task", 220, 50, 170, 29, this);
    
    List SubjectList = addList("", 220, 100, 280, 260, this);
    
    ArrayList<String> subList;
    
    int l;
    
    public IndividualList(String listName) {
      subList = new ArrayList<>();
      Label Title = addLabel(listName, 50, 50, 130, 40, this);
      setTitle(listName);
      Title.setForeground(Color.black);
      Title.setFont(new Font("Arial", 0, 20));
      setBounds(80, 140, 540, 420);
      this.listName = listName;
    }
    
    public void actions(Object source, String command) {
      if (source == Open) {
        String openTask = SubjectList.getSelectedItem();
        new IndividualTask(openTask);
      } 
      if (source == Add)
        new AddTask(listName); 
      if (source == Complete)
        DeleteTask(); 
      if (source == Edit)
        EditTask(); 
      if (source == Search)
        Search(); 
      if (source == RefreshList)
        RefreshList(); 
      if (source == Close) {
        dispose();
        new TaskList();
      } 
      if (source == Exit)
        System.exit(0); 
    }
    
    public String getListName() {
      return listName;
    }
    
    public void setListName(String listName) {
      listName = listName;
    }
    
    public void totalTasks() {
      l = 0;
      try {
        File subListFile = new File(listName + ".txt");
        Scanner reader = new Scanner(subListFile);
        while (reader.hasNextLine())
          subList.add(reader.nextLine()); 
        reader.close();
      } catch (IOException e) {
        e.getMessage();
      } 
    }
    
    public void DeleteTask() {
      String targetTask = SubjectList.getSelectedItem();
      totalTasks();
      try {
        FileReader readFile = new FileReader(listName + ".txt");
        BufferedReader reader = new BufferedReader(readFile);
        ArrayList<String> lists = new ArrayList<>();
        String indList = "";
        while ((indList = reader.readLine()) != null)
          lists.add(indList); 
        reader.close();
        FileWriter writer = new FileWriter(listName + ".txt");
        for (String s : lists) {
          if (s.equals(targetTask)) {
            writer.write("");
            File targetFiles = new File(s + ".txt");
            targetFiles.delete();
          } 
        } 
        writer.close();
      } catch (IOException e) {
        e.getMessage();
      } 
      for (int i = 0; i < subList.size(); i++) {
        String compare = subList.get(i);
        if (compare.equals(targetTask))
          subList.remove(i); 
      } 
    }
    
    void EditTask() {
      String editTask = SubjectList.getSelectedItem();
      DeleteTask();
      new EditTask(editTask, listName);
    }
    
    void RefreshList() {
      SubjectList.removeAll();
      try {
        File subListFile = new File(listName + ".txt");
        Scanner reader = new Scanner(subListFile);
        while (reader.hasNextLine())
          SubjectList.add(reader.nextLine()); 
      } catch (IOException e) {
        e.getMessage();
      } 
    }
    
    void Search() {
      String search = SearchField.getText();
      try {
        File subListFile = new File(listName + ".txt");
        Scanner reader = new Scanner(subListFile);
        while (reader.hasNextLine()) {
          if (reader.nextLine().equals(search))
            new IndividualTask(search); 
        } 
        reader.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } 
    }
  }
  
