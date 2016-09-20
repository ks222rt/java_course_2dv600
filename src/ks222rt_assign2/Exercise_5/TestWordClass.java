package ks222rt_assign2.Exercise_5;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class TestWordClass {
    public static void main(String[] args){
        Word word1 = new Word("Testing");
        Word word2 = new Word("TESTING");
        Word word3 = new Word("testing");
        Word word4 = new Word("Hello");

        System.out.println(word1.toString());
        System.out.println(word2.toString());
        System.out.println(word3.toString());
        System.out.println(word4.toString());

        System.out.println(word1.hashCode());
        System.out.println(word2.hashCode());
        System.out.println(word3.hashCode());
        System.out.println(word4.hashCode());

        System.out.println(word1.compareTo(word2));
        System.out.println(word1.compareTo(word3));
        System.out.println(word1.compareTo(word4));

        System.out.println(word1.equals(word2));
        System.out.println(word1.equals(word3));
        System.out.println(word1.equals(word4));
    }
}
