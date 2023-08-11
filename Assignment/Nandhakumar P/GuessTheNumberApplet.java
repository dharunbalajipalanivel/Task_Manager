import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
<Applet code=GuessTheNumberApplet width=1080 height=720>
</Applet>
*/

public class GuessTheNumberApplet extends Applet {
    private static final int MAX_NUMBER = 100;

    private Label titleLabel;
    private Label guessLabel;
    private TextField guessTextField;
    private Button guessButton;
    private Label resultLabel;

    private int targetNumber;
    private int attempts;

    public void init() {
        setLayout(new GridLayout(4, 1));

        titleLabel = new Label("Guess the Number");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        targetNumber = generateRandomNumber();

        guessLabel = new Label("Enter your guess (1-" + MAX_NUMBER + "):");
        add(guessLabel);

        guessTextField = new TextField();
        add(guessTextField);

        guessButton = new Button("Guess");
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        add(guessButton);

        resultLabel = new Label();
        add(resultLabel);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER) + 1;
    }

    private void checkGuess() {
        String guessText = guessTextField.getText();
        if (!guessText.isEmpty()) {
            try {
                int guess = Integer.parseInt(guessText);
                attempts++;

                if (guess == targetNumber) {
                    resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessTextField.setEnabled(false);
                    guessButton.setEnabled(false);
                } else if (guess < targetNumber) {
                    resultLabel.setText("Too low. Try again.");
                } else {
                    resultLabel.setText("Too high. Try again.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid guess. Please enter a valid number.");
            }
        }
        guessTextField.setText("");
        guessTextField.requestFocus();
    }
}