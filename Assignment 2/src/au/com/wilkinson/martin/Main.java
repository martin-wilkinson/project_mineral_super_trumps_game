package au.com.wilkinson.martin;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        int menuVal;
        String nextMove;
        Scanner input = new Scanner(System.in);
        System.out.print("press 1 to play or 2 to exit: ");
        menuVal = input.nextInt();
        if (menuVal == 1){
            Game newGame = new Game();
            int player = newGame.getHumanPlayerNo();
            Player[] players = newGame.getPlayerArraytransformed();
            System.out.println("Dealer is player 1");
            System.out.println("you are player " + newGame.getHumanPlayerNo());
            System.out.println("your cards are:");
            newGame.displayCards(newGame.getHand(newGame.getHumanPlayerNo()));
            System.out.println("player 2 to start: ");
            if (newGame.getHumanPlayerNo() == 2){
                System.out.print("enter number of card to play: ");
            }

        }
        else {
            System.out.println("have a good day.");
        }
    }



}
