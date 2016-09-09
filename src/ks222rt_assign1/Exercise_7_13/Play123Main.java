package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-09-05.
 */
public class Play123Main {

    private static int wonTheGame = 0;
    private static int lostTheGame = 0;
    private static double probability = 0.000000000000;
    private static Deck deck;

    public static void main(String[] args){
        System.out.println("Starting game...");
        for (int i = 0; i < 10000; i++){
            if (play123()){
                wonTheGame++;
            }else{
                lostTheGame++;
            }
        }

        if (lostTheGame == 0){
            probability = 100;
        }else{
            probability = (wonTheGame * 1.0 / lostTheGame) * 100;
        }

        System.out.println("played the game 10000 times.");
        System.out.println("Won games - " + wonTheGame);
        System.out.println("Lost games - " + lostTheGame);
        System.out.println("The probability to win 1-2-3 is = " + String.format("%.5f", probability) + " %");
    }

    private static boolean play123(){
        deck = new Deck();
        int count = 0;
        for (Card c : deck.deck){
            count++;
            if (count == c.getRank().value){
                return false;
            }

            if (count == 3){
                count = 0;
            }
        }
        return true;
    }
}
