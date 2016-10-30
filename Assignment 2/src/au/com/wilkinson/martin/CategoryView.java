package au.com.wilkinson.martin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by jimji on 24/10/2016.
 */
public class CategoryView {

        private JFrame frame;
        private JPanel panel;
        private JComboBox comboBox;
        private JButton button2;
        private Game tempcurrentGame;

        public CategoryView(Game currentGame) {
            tempcurrentGame = currentGame;
            String categories[] = currentGame.getCategories();
            frame = new JFrame("Select Category");
            frame.setVisible(true);
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            panel = new JPanel();
            panel.setVisible(true);
            panel.setBackground(Color.CYAN);
            panel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            comboBox = new JComboBox(categories);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 40;      //make this component tall
            c.ipadx = 50;
            c.weightx = 0.0;
            c.gridwidth = 2;
            c.gridx = 0;
            c.gridy = 1;
            comboBox.addActionListener(new ComboBoxListener());
            panel.add(comboBox, c);
            //button1.setFont(new Font("Arial", Font.PLAIN, 40));
            //button1.setPreferredSize(new Dimension(200, 50));


            frame.add(panel);

        }


        private class ComboBoxListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JComboBox combo = (JComboBox)e.getSource();
                String currentQuantity = (String)combo.getSelectedItem();
                tempcurrentGame.setCurrentCategory(currentQuantity);
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
        }

    }
