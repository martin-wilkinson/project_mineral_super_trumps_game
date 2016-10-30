package au.com.wilkinson.martin;

import java.util.Random;

/**
 * Created by jimji on 10/10/2016.
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Random rn = new Random();
            int humanPos = rn.nextInt(4);
            System.out.println(humanPos);
        }
    }
}
