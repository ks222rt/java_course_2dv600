package ks222rt_assign1.Exercise_7_13;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class Card {

    public enum Suite{
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }

    public enum Rank{
        Ace (1),
        Two (2),
        Three (3),
        Four (4),
        Five (5),
        Six (6),
        Seven (7),
        Eight (8),
        Nine (9),
        Ten (10),
        Knight (11),
        Queen (12),
        King (13);

        int value;
        Rank(int v){
            value = v;
        }
    }

    private Suite the_suite;
    private Rank the_rank;

    public Card(Suite a_suite, Rank a_rank){
        this.the_suite = a_suite;
        this.the_rank = a_rank;
    }

    public Suite getSuite(){
        return this.the_suite;
    }

    public Rank getRank(){
        return this.the_rank;
    }


}
