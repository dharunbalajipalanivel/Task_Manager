import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
<Applet code=TaskManagerApplet width=1680 height=900>
</Applet>
*/

public class TaskManagerApplet extends java.applet.Applet {
    private TextField taskNameField;
    private Button addButton, completeButton, deleteButton;
    private List taskList;
    private ArrayList<String> tasks;

    public void init() {
        setLayout(new BorderLayout());

        tasks = new ArrayList<>();

        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());

        Label taskNameLabel = new Label("Task Name:");
        taskNameField = new TextField(15);
        addButton = new Button("Add");
        completeButton = new Button("Complete");
        deleteButton = new Button("Delete");

        topPanel.add(taskNameLabel);
        topPanel.add(taskNameField);
        topPanel.add(addButton);
        topPanel.add(completeButton);
        topPanel.add(deleteButton);

        taskList = new List();
        add(taskList, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameField.getText();
                if (!taskName.isEmpty()) {
                    tasks.add(taskName);
                    taskList.add(taskName);
                    taskNameField.setText("");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tasks.remove(selectedIndex);
                    taskList.remove(selectedIndex);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    tasks.remove(selectedIndex);
                    taskList.remove(selectedIndex);
                }
            }
        });
    }
}
