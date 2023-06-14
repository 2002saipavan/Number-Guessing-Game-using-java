import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.Random;

class Rounds extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel userLabel;
    final JTextField textField1;

    Rounds() {
        userLabel = new JLabel();
        userLabel.setText("Enter the number of rounds:");
        textField1 = new JTextField(10);
        b1 = new JButton("enter");
        newPanel = new JPanel(new GridLayout(2, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(b1);
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("GAME STARTS");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        if (!userValue.equals("")) {
            new GameBegin(Integer.parseInt(userValue));
            dispose(); // close the Rounds window after starting the game
        } else {
            textField1.setText("Enter the  Number of rounds:");
            JOptionPane.showMessageDialog(this, "enter the number of rounds to play");
        }
    }
}

class GameBegin extends JFrame implements ActionListener {
    private int rounds;

    GameBegin(int rounds) {
        this.rounds = rounds;

        int min = 1;
        int max = 100;
        int score = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        JOptionPane.showMessageDialog(null, "Guess the Correct Number");

        for (int i = 1; i <= rounds; i++) {

            String number = JOptionPane.showInputDialog("Guess the number from 1 to 100");
            int guessNumber = Integer.parseInt(number);

            if (guessNumber == randomNumber) {
                JOptionPane.showMessageDialog(null, "WINNER " + guessNumber + " in " + i + " attempts.");
                score = rounds - i + 1;
                break;
            } else if (guessNumber < randomNumber) {
                JOptionPane.showMessageDialog(null, "Here is a hint: ANSWER is higher than you think. Only" + (rounds - i) + " attempts left.");
            } else {
                JOptionPane.showMessageDialog(null, "Here is a hint: ANSWER is lower than you think. Only " + (rounds - i) + " attempts left.");
            }
        }

        if (score > 0) {
            JOptionPane.showMessageDialog(null, "Your SCORE is:" + score);
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, Better luck next time! :(");
        }

        dispose(); // close the GameBegin window after the game is over
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

public class GuessNumber {
    public static void main(String[] args) {
        try {
            Rounds x = new Rounds();
            x.setSize(400, 150);
            x.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}