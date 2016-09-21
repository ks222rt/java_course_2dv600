package ks222rt_assign2.Exercise_5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Kristoffer on 2016-09-21.
 */
public class WordCount2Main {
    private static HashWordSet hashSet = new HashWordSet();
    private static TreeWordSet treeSet = new TreeWordSet();

    public static void main(String[] args){
        if (args[0] != null){
            String fileName = args[0];

            try {
                Scanner scanner = new Scanner(new File(fileName));

                while(scanner.hasNext()){
                    String words = scanner.next().toLowerCase();
                    if (!words.isEmpty()){
                        hashSet.add(new Word(words.toLowerCase()));
                        treeSet.add(new Word(words.toLowerCase()));
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            int count = 0;

            Iterator it = treeSet.iterator();
            while(it.hasNext()){
                System.out.println(it.next() + " " + ++count);
            }

            System.out.println("--------------------------------");
            count = 0;

            it = hashSet.iterator();
            while(it.hasNext()){
                System.out.println(it.next() + " " + ++count);
            }

            System.out.println("Hashset size = " + hashSet.size());
            System.out.println("TreeSet size = " + treeSet.size());
        }else{
            throw new IllegalArgumentException("You must pass a parameter to the method!");
        }
    }
}
