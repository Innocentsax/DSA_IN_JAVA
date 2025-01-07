package dev.Innocent.Section7.Collection;

import dev.Innocent.Section7.OOPPart1.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerGame {
    private final List<Card> deck  = Card.getStandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<Card> remainingCards;

    public PokerGame(int playerCount, int cardsInHand) {
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startPlay(){
        Collections.shuffle(deck);
        Card.printDeck(deck);
        Collections.rotate(deck, 26);
        Card.printDeck(deck);
    }
}
