package ks222rt_assign1.Exercise_1_to_6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kristoffer on 2016-08-29.
 */
public class Diamond {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = 0, spaces = 0, steps = 1;

        while(true){
            try{
                System.out.print("Enter a positive ODD number: ");
                size = scan.nextInt();

                if (size % 2 == 0 || size <= 0){
                    System.out.println("Error: Thats not a positive ODD number, try again!");

                }else {
                    spaces = size/2;

                    for (int i = 1; i <= size; i++){
                        for (int k = spaces; k >= 1; k--) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= steps; j++) {
                            System.out.print("*");
                        }
                        System.out.println();

                        if (i < size/2+1) {
                            steps += 2;
                            spaces -= 1;
                        } else {
                            steps -= 2;
                            spaces += 1;

                        }
                    }
                }

                break;
            }catch(InputMismatchException e){
                System.out.println("Error: Not a number");
                scan.next();
            }
        }
    }
}
