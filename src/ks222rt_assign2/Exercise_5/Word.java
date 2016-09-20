package ks222rt_assign2.Exercise_5;

/**
 * Created by Kristoffer on 2016-09-20.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str){  this.word = str;  }

    public String toString(){  return this.word;  }

    @Override
    public int hashCode(){
        int hc = 0;
        for (int i = 0; i < this.word.length(); i++){
            char c = this.word.charAt(i);
            hc += Character.getNumericValue(c);
        }
        return hc;
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Word) {
            Word otherWord = (Word) other;
            return word.equals(otherWord.word);
        }
        return false ;
    }

    @Override
    public int compareTo(Word o) {
        return word.compareToIgnoreCase(o.toString());
    }
}
