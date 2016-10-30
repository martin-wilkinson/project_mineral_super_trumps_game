package au.com.wilkinson.martin;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Created by jimji on 4/10/2016.
 */
public class Game {
    private int numPlayers = 4;
    private ArrayList playerArray = new ArrayList();
    private Player[] playerArray2 = new Player[4];
    private ArrayList gameDeck;
    private int humanPlayerNo;
    private String[] categories = new String[5];
    private String currentCategory;

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory) {
        this.currentCategory = currentCategory;
    }

    public String[] getCategories() {
        categories[0] = "Hardness";
        categories[1] = "Specific Gravity";
        categories[2] = "Cleavage";
        categories[3] = "Crustal Abundance";
        categories[4] = "Economic Value";
        return categories;
    }

    public int getHumanPlayerNo() {
        return humanPlayerNo;
    }

    public void setHumanPlayerNo(int humanPlayerNo) {
        this.humanPlayerNo = humanPlayerNo;
    }

    public ArrayList getGameDeck() {
        return gameDeck;

    }

    public void setGameDeck(ArrayList gameDeck) {
        this.gameDeck = gameDeck;
    }

    public Game() {
        GameCard[] deck = DeckBuilder.buildDeck();
        shuffleCards(deck);
        fillPlayerArray();
        gameDeck = dealCards(deck);
    }

    private ArrayList dealCards(GameCard[] deck) {
        ArrayList deckList = new ArrayList();
        for (int i1 = 0; i1 < deck.length; i1++){
            deckList.add(deck[i1]);
        }
        int handSize = 8;
        GameCard[] hand = new GameCard[8];
        Random rn = new Random();
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < handSize; j++) {
                int temp = rn.nextInt(deckList.size());
                hand[j] = (GameCard) deckList.get(temp);
                deckList.remove(temp);
            }
            Player currentPlayer;
            currentPlayer = (Player) playerArray.get(i);
            currentPlayer.setHand(hand);
        }
        return deckList;
    }

    private void shuffleCards(GameCard[] deck) {
        Random rn = new Random();
        GameCard temp;
        for (int i = 0; i < deck.length; i++) {
            int randCardPos = rn.nextInt(deck.length - 1);
            temp = deck[i];
            deck[i] = deck[randCardPos];
            deck[randCardPos] = temp;
        }
    }

    private void fillPlayerArray() {
        playerArray.add(0, new HumanPlayer());
        for (int j =1; j < 4; j++){
            playerArray.add(j, new AIPlayer());
        }
        Random rn = new Random();
        Player temp;
        for(int i = 0; i < playerArray.size(); i++) {
            int playerPos = rn.nextInt(numPlayers);
            temp = (Player) playerArray.get(i);
            playerArray.add(i, playerArray.get(playerPos));
            playerArray.remove(i + 1);
            playerArray.add(playerPos, temp);
            playerArray.remove(playerPos + 1);
        }
        for (int i = 0; i < playerArray.size(); i++) {
            temp = (Player) playerArray.get(i);
            if (temp.getClass().equals(HumanPlayer.class)){
                humanPlayerNo = i + 1;
            }
            temp.setPlayerNumber(playerArray.indexOf(temp));

        }

    }

    public Player[] getPlayerArraytransformed() {
        ArrayList tempPlayArray = playerArray;
        tempPlayArray.toArray(playerArray2);
        return playerArray2;
    }

    public void setPlayerArray(ArrayList playerArray) {
        this.playerArray = playerArray;
    }

    public Player[] getPlayerArray2() {
        return playerArray2;
    }

    public void setPlayerArray2(Player[] playerArray2) {
        this.playerArray2 = playerArray2;
    }

    public void displayCards(GameCard[] hand) {
        for (int i = 0; i < getHand(0).length; i++) {
            System.out.println(getPlayerArraytransformed()[getHumanPlayerNo()].getHand()[i].toString());
        }
    }

    public GameCard[] getHand (int player) {
        Player temp1 = (Player) playerArray.get(player);
        return temp1.getHand();
    }

    public void firstMove(String nextMove) {

    }
}
