package ks222rt_assign1.Exercise_7_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class CountJava {

    private static ArrayList<File> fileList = new ArrayList<>();
    private static Scanner scan;

    public static void main(String[] args){
        try {
            Files.walk(Paths.get(args[0])).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    File f = new File(String.valueOf(filePath));
                    if (f.getName().endsWith(".java")){
                        fileList.add(f);
                    }
                }
            });

            System.out.println("Root Directory: " + args[0]);
            for (int i = 0; i < fileList.size(); i++){
                int amountOfLines = countLines(fileList.get(i));
                System.out.println((i + 1) + " " + fileList.get(i).getName() + "  lines = " + amountOfLines);
            }
        }catch(IOException e){
            System.out.println("Could not find directory/file");
        }
    }

    private static int countLines(File file){
        int count = 0;
        try{
            scan = new Scanner(file);
            while (scan.hasNextLine()){
                count++;
                scan.nextLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
}
