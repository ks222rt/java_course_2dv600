package ks222rt_assign1.Exercise_7_13;

import java.util.*;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class Deck {

    ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<>();

        for (Card.Suite suite : Card.Suite.values()){
            for (Card.Rank rank : Card.Rank.values()){
                Card c = new Card(suite, rank);
                deck.add(c);
            }
        }

        this.shuffle();
    }

    public void shuffle(){
        if (this.deck.size() == 52){
            Collections.shuffle(this.deck, new Random());
        }else{
            System.out.println("Cannot shuffle the deck. It doesnt contain 52 cards");
        }
    }

    public Card handOutNextCards(){
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }

    public int deckSize(){
        return deck.size();
    }
}
