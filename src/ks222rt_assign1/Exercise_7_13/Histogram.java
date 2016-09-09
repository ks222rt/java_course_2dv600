package ks222rt_assign1.Exercise_7_13;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class Histogram {

    public static void main(String[] args){
        if (args[0] != null){
            try {
                File f = new File(args[0]);
                if (f.exists() && !f.isDirectory()) {
                    System.out.println("Reading from file: " + args[0]);
                    readFile(args[0]);
                }else{
                    System.out.println("File not found!");
                }
            }catch(Exception e){
                System.out.print("Error: No file given");
            }
        }else{
            System.out.println("No file given!");
        }
    }

    private static void readFile(String path){
        try(Scanner scan = new Scanner(new FileReader(path))){
            int[] numberArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            String[] nameArray = {"1 - 10   ", "11 - 20  ", "21 - 30  ",
                                  "31 - 40  ", "41 - 50  ", "51 - 60  ",
                                  "61 - 70  ", "71 - 80  ", "81 - 90  ",
                                  "91 - 100 ", "101 - 200"};
            while(scan.hasNext()) {
                if (scan.hasNextInt()){
                    int c = scan.nextInt();
                    if (c > 0 && c < 11) {
                        numberArray[0] += 1;
                    } else if (c > 10 && c < 21) {
                        numberArray[1] += 1;
                    } else if (c > 20 && c < 31) {
                        numberArray[2] += 1;
                    } else if (c > 30 && c < 41) {
                        numberArray[3] += 1;
                    } else if (c > 40 && c < 51) {
                        numberArray[4] += 1;
                    } else if (c > 50 && c < 61) {
                        numberArray[5] += 1;
                    } else if (c > 60 && c < 71) {
                        numberArray[6] += 1;
                    } else if (c > 70 && c < 81) {
                        numberArray[7] += 1;
                    } else if (c > 80 && c < 91) {
                        numberArray[8] += 1;
                    } else if (c > 90 && c < 101) {
                        numberArray[9] += 1;
                    } else if (c > 100 && c < 201) {
                        numberArray[10] += 1;
                    }
                }
                else{
                    scan.next();
                }
            }

            System.out.println("Number of integers in the interval [1, 100]: ");
            System.out.println("Number of integers in the interval [101, 200]: ");
            System.out.println("Histogram");
            for (int i = 0; i < numberArray.length; i++){
                System.out.print(nameArray[i] + "|  ");
                for (int k = 0; k < numberArray[i]; k ++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
