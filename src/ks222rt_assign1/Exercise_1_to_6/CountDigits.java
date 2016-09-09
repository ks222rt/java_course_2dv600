package ks222rt_assign1.Exercise_1_to_6;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kristoffer on 2016-08-29.
 */

public class CountDigits {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int value = 0, oddNumbers = 0, zeroNumbers = 0, evenNumbers = 0, sum = 0;

        while(true){
            try{
                System.out.print("Input a positive integer: ");
                value = scan.nextInt();
                if (value <= 0){
                    System.out.println("Thats not a positive number!");
                    continue;
                }
                break;
            }catch(InputMismatchException e){
                System.out.println("Error: Not a number");
                scan.next();
            }
        }

        String temp = Integer.toString(value);
        String[] tempArray = temp.split("");
        int[] tempIntArray = new int[tempArray.length];

        for (int i = 0; i < tempArray.length; i++){
            int number = Integer.parseInt(tempArray[i]);
            if (number == 0){
                zeroNumbers += 1;
            }else if(number % 2 == 0){
                evenNumbers += 1;
            }else{
                oddNumbers += 1;
            }

            tempIntArray[i] = number;
        }

        for (int k = 0; k < tempIntArray.length; k++){
            sum += tempIntArray[k];
        }
        System.out.println("Even: " + evenNumbers);
        System.out.println("Odd: " + oddNumbers);
        System.out.println("Zero: " + zeroNumbers);
        System.out.println("Sum of all: " + sum);


    }
}
