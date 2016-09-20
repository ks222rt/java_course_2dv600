package ks222rt_assign2.Exercise_5;

import java.io.*;
import java.util.*;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class WordCount1Main {
    private static Set<Word> hashSet = new HashSet();
    private static Set<Word> treeSet = new TreeSet();

    public static void main(String[] args){
        if (args[0] != null){
            String fileName = args[0];

            try{
                Scanner scan = new Scanner(new File(fileName));

                while(scan.hasNext()){
                    String word = scan.next().toLowerCase();
                    if (!word.isEmpty()){
                        if (hashSet.add(new Word(word.toLowerCase()))){
                            treeSet.add(new Word(word.toLowerCase()));
                        }
                    }
                }

                System.out.println("HashSet size = " + hashSet.size());
                System.out.println("TreeSet size = " + treeSet.size());

                Iterator it = treeSet.iterator();
                while(it.hasNext()){
                    System.out.println(it.next());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }else{
            throw new IllegalArgumentException("You have to pass a parameter to the method!");
        }
    }

}
