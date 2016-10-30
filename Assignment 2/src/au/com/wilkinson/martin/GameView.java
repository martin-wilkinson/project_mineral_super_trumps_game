package au.com.wilkinson.martin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by jimji on 18/10/2016.
 */
public class GameView {
    private JFrame frame;
    private JPanel panelTop;
    private JPanel panelMid;
    private JPanel panelbottom;
    private Game newGUIGame;
    private int currentPlayerNo = 2;
    private JLabel currentPlayer;
    private JButton buttons;
    private JLabel currentCard;
    private String currentCategory = "empty";

    public Game getNewGUIGame() {
        return newGUIGame;
    }

    private int humanPlayerNo;
    private JButton[] buttonArray = new JButton[8];
    private int gameOver;
    private String currentCardTitle = "start";
    private String[] cardTitles = new String[8];
    private JLabel category;

    public GameView(Game newGame) {
        gameOver = 0;
        newGUIGame = newGame;
        prepareGUI();
//        humanPlayerNo = newGame.getHumanPlayerNo();
        humanPlayerNo = 2;
        if (humanPlayerNo == 2){
            new CategoryView(newGUIGame);

            currentCategory = newGUIGame.getCurrentCategory();
        }
        for (int rand = 0; rand < 12; rand++) {
            while (currentPlayerNo != humanPlayerNo){
                if (currentCardTitle.equals("start")) {
                    String[] tempAr = newGUIGame.getCategories();
                    Random rn = new Random();
                    GameCard[] tempHand = newGUIGame.getHand(2);
                    GameCard randCard = tempHand[rn.nextInt(7)];
                    ImageIcon temp = new ImageIcon("F:\\Assignment 1\\src\\au\\com\\wilkinson\\martin\\images\\" + randCard.getImage());
                    ImageIcon temp1 = new ImageIcon(temp.getImage().getScaledInstance(150, 400, Image.SCALE_SMOOTH));
                    currentCategory = tempAr[rn.nextInt(4)];
                    currentCard.setIcon(temp1);
                    currentCardTitle = randCard.getTitle();
                    currentPlayerNo = getNextPlayer(currentPlayerNo);
                    currentPlayer.setText("current player is: " + currentPlayerNo);
                    panelTop.add(currentPlayer);
                }
            }

        }


    }

    private void prepareGUI() {
        frame = new JFrame("Mineral Super Trumps");
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(3840, 2160);
        panelTop = new JPanel();
        panelTop.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel playerNo = new JLabel("You are player: " + newGUIGame.getHumanPlayerNo());
        playerNo.setFont(new Font("Serif", Font.BOLD, 24));
        playerNo.setForeground(Color.white);
        c.weightx = 0.8;
        c.gridx = 0;
        c.gridy = 0;
        panelTop.add(playerNo, c);
        currentPlayer = new JLabel("current player is: " + currentPlayerNo);
        currentPlayer.setFont(new Font("Serif", Font.BOLD, 24));
        currentPlayer.setForeground(Color.white);
        c.gridy = 0;
        c.gridx = 1;
        c.anchor = GridBagConstraints.PAGE_START;
        panelTop.add(currentPlayer, c);
        category = new JLabel(currentCategory);
        category.setFont(new Font("Serif", Font.BOLD, 24));
        category.setForeground(Color.white);
        c.gridy = 0;
        c.gridx = 2;
        panelTop.add(category, c);
        currentCard = new JLabel();
        ImageIcon temp2 = new ImageIcon("F:\\Assignment 1\\src\\au\\com\\wilkinson\\martin\\images\\Slide66.jpg");
        currentCard.setPreferredSize(new Dimension(400, 700));
        ImageIcon temp3 = new ImageIcon(temp2.getImage().getScaledInstance(400, 700, Image.SCALE_SMOOTH));
        currentCard.setIcon(temp3);
        c.gridx = 1;
        c.gridy = 1;
        panelTop.add(currentCard, c);
        FlowLayout layout = new FlowLayout();
        panelTop.setBackground(Color.BLACK);
        //panelMid = new JPanel(layout);
        panelbottom = new JPanel(layout);
        layout.setHgap(20);
        layout.setVgap(20);
        panelTop.add(playerNo, FlowLayout.LEFT);
        for (int i = 0; i < 8; i++) {
            buttons = new JButton();
            GameCard[] tempCards = newGUIGame.getHand(newGUIGame.getHumanPlayerNo() - 1);
            ImageIcon temp = new ImageIcon("D:\\Assignment 1\\src\\au\\com\\wilkinson\\martin\\images\\" + tempCards[i].getImage());
            /*int scale = 2;
            int width = temp.getIconWidth();
            int newWidth = width / scale;
            label.setIcon(new ImageIcon(temp.getImage().getScaledInstance(newWidth, -1,
                    java.awt.Image.SCALE_SMOOTH)));*/

            buttons.setLayout(new FlowLayout(FlowLayout.CENTER));

            buttons.setPreferredSize(new Dimension(400, 700));
            ImageIcon temp1 = new ImageIcon(temp.getImage().getScaledInstance(400, 700, Image.SCALE_SMOOTH));
            buttons.setIcon(temp1);
            buttons.addActionListener(new ButtonClickedListener());
            panelbottom.add(buttons, FlowLayout.LEFT);
            buttonArray[i] = buttons;
            cardTitles[i] = tempCards[i].getTitle();
        }


        frame.add(panelTop);
        //frame.add(panelMid);
        frame.add(panelbottom);
        frame.setVisible(true);





    }
    private class ButtonClickedListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentPlayerNo == humanPlayerNo) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton btn = (JButton)source;
                    if (btn == buttonArray[0]) {
                        currentCard.setIcon(buttonArray[0].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[0];
                    }
                    else if (btn == buttonArray[1]) {
                        currentCard.setIcon(buttonArray[1].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[1];
                    }
                    else if (btn == buttonArray[2]) {
                        currentCard.setIcon(buttonArray[2].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[2];
                    }
                    else if (btn == buttonArray[3]) {
                        currentCard.setIcon(buttonArray[3].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[3];
                    }
                    else if (btn == buttonArray[4]) {
                        currentCard.setIcon(buttonArray[4].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[4];
                    }
                    else if (btn == buttonArray[5]) {
                        currentCard.setIcon(buttonArray[5].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[5];
                    }
                    else if (btn == buttonArray[6]) {
                        currentCard.setIcon(buttonArray[6].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[6];
                    }
                    else if (btn == buttonArray[7]) {
                        currentCard.setIcon(buttonArray[7].getIcon());
                        currentPlayerNo = getNextPlayer(currentPlayerNo);
                        currentCardTitle = cardTitles[7];
                    }
                }

            }

        }
    }

    private int getNextPlayer(int currentPlayer) {
        int temp = currentPlayer;
        if (temp == 4){
            temp = 1;
        }
        else {
            temp++;
        }
        return temp;
    }
}
