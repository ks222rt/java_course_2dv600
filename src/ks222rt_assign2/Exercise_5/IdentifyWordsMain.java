package ks222rt_assign2.Exercise_5;

import java.io.*;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class IdentifyWordsMain {
    public static void main(String[] args){
        if  (args[0] != null){
            String fileName = args[0];
            String newFile = "C:\\Users\\Kristoffer\\workspace\\java_courses\\src\\ks222rt_assign2\\Exercise_5\\Words.txt";

            try {
                String line;
                BufferedReader bReader = new BufferedReader(new FileReader(fileName));
                BufferedWriter bWrite = new BufferedWriter(new FileWriter(newFile, false));

                while((line = bReader.readLine()) != null){
                  for (char i : line.toCharArray()){
                        if (Character.isWhitespace(i) || Character.isLetter(i)){
                            bWrite.write(i);

                        }
                  }
                    bWrite.write("\r\n");
                }

                bWrite.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            throw new IllegalArgumentException("You must pass a file to the method!");
        }
    }
}
