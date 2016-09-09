package ks222rt_assign1.Exercise_7_13;

import java.util.ArrayList;

/**
 * Created by Kristoffer on 2016-09-01.
 */
public class PlayCardsMain {

    public static void main(String[] args){
        // Creating a new deck
        Deck d = new Deck();
        ArrayList<Card> tempDeck = new ArrayList<>();

        // Dealing 5 cards
        for (int i = 0; i < 5; i++){
            Card card = d.handOutNextCards();
            System.out.println("Your card is " + card.getRank() +  " " + card.getSuite());
            tempDeck.add(card);
        }

        // Checking how many cards are left. Should be 47
        System.out.println(d.deckSize());

        // Showing the cards you´ve got from the deck
        for (Card c : tempDeck){
            System.out.println(c.getRank() + " " + c.getSuite());
        }
    }
}
