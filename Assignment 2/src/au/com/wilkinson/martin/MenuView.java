package au.com.wilkinson.martin;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by jimji on 17/10/2016.
 */
public class MenuView {
    private JFrame frame;
    private JPanel panel;
    private JButton button1;
    private JButton button2;

    public MenuView() {
        frame = new JFrame("Mineral Super Trumps");
        frame.setVisible(true);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setVisible(true);
        panel.setBackground(Color.CYAN);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        button1 = new JButton("Start Game");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.ipadx = 50;
        c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        button1.setActionCommand("Start");
        button1.addActionListener(new ButtonClickedListener());
        panel.add(button1, c);
        button1.setFont(new Font("Arial", Font.PLAIN, 40));
        button1.setPreferredSize(new Dimension(400, 200));


        frame.add(panel);

    }


    private class ButtonClickedListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Game newGame = new Game();
            new GameView(newGame);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

        }
    }

}



