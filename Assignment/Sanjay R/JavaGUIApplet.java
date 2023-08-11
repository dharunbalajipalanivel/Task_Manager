import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
<Applet code=JavaGUIApplet width=500 height=200>
</Applet>
*/

public class JavaGUIApplet extends Applet {
    private TextField textField;
    private Label label;

    public void init() {
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        textField = new TextField(20);
        label = new Label("You entered:");
        label.setAlignment(Label.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        Button button = new Button("Click Me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                label.setText("You entered: " + input);
            }
        });

        add(textField);
        add(button);
        add(label);
    }
}
