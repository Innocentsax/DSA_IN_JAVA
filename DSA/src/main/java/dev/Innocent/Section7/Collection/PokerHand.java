package dev.Innocent.Section7.Collection;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {
    private List<Card> hand;
    private List<Card> keepers;
    private List<Card> discards;
    private Ranking score = Ranking.NONE;
    private int playerNo;

    public PokerHand(int playerNo, List<Card> hand){
        hand.sort(Card.sortRankReversedSuit());
        this.hand = hand;
        this.playerNo = playerNo;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }


}
