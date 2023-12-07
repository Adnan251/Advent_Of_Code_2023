package org.example.Day7;

import org.example.Miscenalious.FileReader;
import java.io.FileNotFoundException;
import java.util.*;

public class Task1 {
    public static List<String> theListOfInputLines;
    List<Hand> listOfHands = new ArrayList<>();
    List<String> combos = new ArrayList<>(Arrays.asList("Five of a kind", "Four of a kind", "Full house", "Three of a kind", "Two pair", "One pair", "High card"));
    String[] ranks= new String[]{"A", "K", "Q", "J", "T", "9", "8", "7", "6", "5", "4", "3", "2"};

    public Task1 (String filePath) throws FileNotFoundException {
        this.theListOfInputLines = FileReader.SingleLineReader(filePath);
        for(String s : theListOfInputLines){
            String[] split = s.split(" ");
            this.listOfHands.add(new Hand(split[0], split[1]));
        }
    }

    public void sortByTypeandRank(List<Hand> hands) {
        Collections.sort(hands, (hand1, hand2) -> {
            int typeComparison = Integer.compare(combos.indexOf(hand1.getType()), combos.indexOf(hand2.getType()));
            if (typeComparison == 0) {

                List<Character> cards1 = hand1.getCards();
                List<Character> cards2 = hand2.getCards();
                for (int i = 0; i < cards1.size(); i++) {
                    int cardComparison = Integer.compare(getRankValue(cards1.get(i)), getRankValue(cards2.get(i)));
                    if (cardComparison != 0) {
                        return cardComparison;
                    }
                }
            }
            return typeComparison;
        });
    }


    private int getRankValue(Character rank) {
        for (int i = 0; i < this.ranks.length; i++) {
            if (this.ranks[i].equals(rank.toString())) {
                return i;
            }
        }
        return -1;
    }

    public int getTheResult(){
        sortByTypeandRank(this.listOfHands);
        System.out.println(listOfHands);
        int result = 0;

        for (Hand h:listOfHands) {
           result += h.getValue()*(listOfHands.size() - listOfHands.indexOf(h));
        }

        return result;
    }


}
