package ks222rt_assign1.Exercise_1_to_6;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by Kristoffer on 2016-08-29.
 */
public class HighLow {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int chances = 10;
        int guesses = 1;
        int randomNumber = rand.nextInt(100) + 1;

        System.out.println("Time to guess the number between 1 and 100, you´ve got 10 chances!");

        while(true) {
            System.out.print("Guess " + guesses + ": ");
            try {
                int value = scan.nextInt();
                if (value <= 0){
                    System.out.println("Guess on a number above zero!");
                    continue;
                }else{
                    if (guesses == chances){
                        System.out.println("You are out of guesses, You lost!");
                        break;
                    }

                    if (value == randomNumber) {
                        System.out.println("Congrats, you won after " + guesses + " guesses");
                        break;
                    }else if(value <= randomNumber){
                        System.out.println("Hint: Higher!");
                    }else{
                        System.out.println("Hint: Lower!");
                    }
                    guesses++;
                }

            }catch(InputMismatchException e){
                System.out.println("Error, thats not a number!");
                scan.next();
            }

        }
    }
}
