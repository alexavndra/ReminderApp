package ReminderAppPackage;
import java.awt.*;
import java.io.*;
import java.util.*;

public class IndividualTask extends EasyApp {


    private String taskName;


    TextArea Description = addTextArea("", 50, 100, 270, 100, this);


    Button Complete = addButton("Complete", 50, 220, 107, 29, this);


    Button Load = addButton("Load Desc", 150, 220, 107, 29, this);


    Button Close = addButton("Close", 250, 220, 107, 29, this);


    public IndividualTask(String taskName) {
        Label Title = addLabel(taskName, 50, 50, 400, 50, this);
        setTitle(taskName);
        Title.setForeground(Color.black);
        Title.setFont(new Font("Arial", 0, 20));
        setBounds(700, 300, 400, 280);
        this.taskName = taskName;
    }


    public void actions(Object source, String command) {
        if (source == Complete) {
            CompletedTask();
        }
        if (source == Load) {
            LoadText();
        }
        if (source == Close) {
            if (!Description.getText().equals("")) {
                saveText();
                }
            dispose();
        }
    }


    void saveText() {
        String taskNotes = Description.getText();
        try {
            FileWriter writer = new FileWriter(taskName + ".txt");
            writer.write(taskNotes);
            writer.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    void LoadText() {
        try {
            File taskFile = new File(taskName + ".txt");
            Scanner reader = new Scanner(taskFile);
            while (reader.hasNextLine()) {
                Description.setText(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }


    void CompletedTask() {
        setTitle("TASK COMPLETED");
    }


    public String getTaskName() {
        return taskName;
    }
}
