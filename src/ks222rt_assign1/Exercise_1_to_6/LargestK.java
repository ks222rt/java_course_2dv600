package ks222rt_assign1.Exercise_1_to_6;

/**
 * Created by Kristoffer on 2016-08-29.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class LargestK {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int numN = 0;
        int numK = 0;
        int sum = 0;

        while(true){
            try{
                System.out.print("Please write a positive number over ZERO: ");
                numN = scan.nextInt();
                if(numN <= 0){
                    System.out.println("Thats not a number above zero ");
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("Error: Not a positive number!");
                scan.next();
            }
        }

        while ((sum + (numK + 2)) <= numN) {
            numK += 2;
            sum += numK;
        }

        System.out.println("Largest K is: " + numK);
    }
}
