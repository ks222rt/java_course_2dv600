package ks222rt_assign1.Exercise_1_to_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Kristoffer on 2016-08-30.
 */
public class CountChars {

    public static void main(String[] args){
        if (args[0] != null){
            try{
                File f = new File(args[0]);
                if (f.exists() && !f.isDirectory()){
                    System.out.println("Reading from file: " + args[0]);
                    readFile(args[0]);
                }else{
                    System.out.println("File not found!");
                }
            }catch(Exception e){
                System.out.println("Error: No file given!");
            }
        }else{
            String newFilePath = getFilePath();
            readFile(newFilePath);
        }
    }

    private static String getFilePath(){
        String path;

        while(true) {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter filepath: ");
                path = scan.nextLine();
                File f = new File(path);

                if (f.exists() && !f.isDirectory()) {
                    System.out.println("File does exists!");
                    break;
                }
                System.out.println("File doesn´t exists, try again!");
            } catch (Exception e) {
                System.out.println("Error: Something happened!");
            }
        }
        return path;
    }

    private static void readFile(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String text;
            int numbers = 0, lowerCase = 0, upperCase = 0, whitespaces = 0, others = 0;

            while((text = br.readLine()) != null){
                for (char c : text.toCharArray()){
                    if (Character.isLowerCase(c)){
                        lowerCase++;
                    }else if(Character.isUpperCase(c)){
                        upperCase++;
                    }else if(Character.isWhitespace(c)){
                        whitespaces++;
                    }else if(Character.isDigit(c)){
                        numbers++;
                    }else{
                        others++;
                    }
                }
            }

            System.out.println("There is " + upperCase + " UPPERCASE letters in the text");
            System.out.println("There is " + lowerCase + " LOWERCASE letters in the text");
            System.out.println("There is " + whitespaces + " WHITESPACES in the text");
            System.out.println("There is " + others + " OTHER characters in the text");
            System.out.println("There is " + numbers + " DIGITS in the text");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
