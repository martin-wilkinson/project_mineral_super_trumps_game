package au.com.wilkinson.martin;

/**
 * Created by jimji on 10/10/2016.
 */
public abstract class Player {
    private int playerNumber;
    private GameCard[] hand;

    public Player() {

    }

    public  int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public GameCard[] getHand() {
        return hand;
    }

    public void setHand(GameCard[] hand) {
        this.hand = hand;
    }
}
