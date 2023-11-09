import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.WEST;

public class Main extends JFrame {
    /**
     * The actions a player may use
     */
    private String[] actions = {"Rock", "Paper", "Scissors"};

    /**
     * The button locations
     */
    private String[] locations = {WEST, CENTER, EAST};

    /**
     * The listener for all 3 buttons
     */
    private ActionListener buttonListener = e -> {
        // Generate a random action
        int random = ThreadLocalRandom.current().nextInt(0, 3);
        String comAction = actions[random];

        // Rate the current situation
        String rating = rate(e.getActionCommand(), comAction);

        // Show a result alert
        JOptionPane.showMessageDialog(null, rating);
    };

    /**
     * Private constructor invoked by SwingUtils.invokeLater()
     * Creates the GUI and shows it
     */
    private Main() {
        setTitle("Rock, Paper, Scissors");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 150));

        // Create a container that holds the buttons
        JPanel container = new JPanel();

        // Set the layout
        container.setLayout(new BorderLayout());

        // Create the buttons
        for (int i = 0; i < actions.length; i++) {
            JButton temp = new JButton(actions[i]);
            temp.addActionListener(buttonListener);
            container.add(temp, locations[i]);
        }

        // Finish
        add(container);
        pack();

        // Display the frame
        setVisible(true);
    }

    /**
     * Runs the private constructor
     *
     * [MENTION=1985011]param[/MENTION] args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    /**
     * Rates the current situation and returns a result string.
     * Probably way too complicated, but hey:
     *  You get the idea what it does, right?
     *
     * [MENTION=1985011]param[/MENTION] userAction
     * [MENTION=1985011]param[/MENTION] comAction
     * [MENTION=326673]return[/MENTION]
     */
    private String rate(String userAction, String comAction) {
        String msg = "";

        switch (userAction) {
            case "Rock":
                switch (comAction) {
                    case "Rock":
                        msg = "Draw. Both chose Rock!";
                        break;

                    case "Paper":
                        msg = "You lost. Paper wraps stone!";
                        break;

                    case "Scissors":
                        msg = "You won. Rock breaks scissors!";
                        break;
                }
                break;

            case "Paper":
                switch (comAction) {
                    case "Rock":
                        msg = "You won. Paper wraps stone!";
                        break;

                    case "Paper":
                        msg = "Draw. Both chose paper!";
                        break;

                    case "Scissors":
                        msg = "You lost. Scissors cuts paper!";
                        break;
                }
                break;

            case "Scissors":
                switch (comAction) {
                    case "Rock":
                        msg = "You lost. Rock breaks scissors!";
                        break;

                    case "Paper":
                        msg = "You won. Scissors cuts paper!";
                        break;

                    case "Scissors":
                        msg = "Draw. Both chose scissors!";
                        break;
                }
                break;
        }

        return msg;
    }
}
