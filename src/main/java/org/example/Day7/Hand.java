package org.example.Day7;

import java.util.*;

public class Hand {
    private String type;
    private List<Character> cards;
    private int value;

    public Hand(String cards, String value){
        this.value = Integer.parseInt(value);
        this.cards = this.convertToListOfCards(cards);
        this.type = getTheType();
    }

    private List<Character> convertToListOfCards(String cards){
        List<Character> result = new ArrayList<>();

        for(char c: cards.toCharArray()){
            result.add(c);
        }

        return result;
    }
    //For Task 1
    /*public String getTheType(){
        String result= "";
        Map<Character, Integer> cardCount = new HashMap<>();

        for(char c : this.cards){
            if(!cardCount.containsKey(c)){
                cardCount.put(c,1);
            }
            else {
                cardCount.replace(c, cardCount.get(c)+1);
            }
        }
        switch (cardCount.size()){
            case 1:
                result = "Five of a kind";
            break;
            case 2:
                for(char c : cardCount.keySet()){
                    if(cardCount.get(c) == 4){
                        result = "Four of a kind";
                        break;
                    }
                    else{
                        result = "Full house";
                    }
                }

            break;
            case 3:

                for(char c : cardCount.keySet()){
                    if(cardCount.get(c) == 3){
                        result = "Three of a kind";
                        break;
                    }
                    else{
                        result = "Two pair";
                    }
                }

            break;
            case 4:
                result = "One pair";
            break;
            case 5:
                result = "High card";
            break;
        }

        return result;
    }*/

    //For Task 2
    public String getTheType() {
        String result = "";
        Map<Character, Integer> cardCount = new HashMap<>();

        for (char c : this.cards) {
            if (!cardCount.containsKey(c)) {
                cardCount.put(c, 1);
            } else {
                cardCount.replace(c, cardCount.get(c) + 1);
            }
        }

        if (cardCount.containsKey('J')) {
            char maxChar = Collections.max(cardCount.entrySet(), Map.Entry.comparingByValue()).getKey();
            int maxCount = cardCount.get(maxChar);
            cardCount.replace(maxChar, maxCount + cardCount.get('J'));
            cardCount.remove('J');
        }

        switch (cardCount.size()) {
            case 1:
                result = "Five of a kind";
                break;
            case 2:
                for (char c : cardCount.keySet()) {
                    if (cardCount.get(c) == 4) {
                        result = "Four of a kind";
                        break;
                    } else {
                        result = "Full house";
                    }
                }

                break;
            case 3:

                for (char c : cardCount.keySet()) {
                    if (cardCount.get(c) == 3) {
                        result = "Three of a kind";
                        break;
                    } else {
                        result = "Two pair";
                    }
                }

                break;
            case 4:
                result = "One pair";
                break;
            case 5:
                result = "High card";
                break;
        }
        return result;
    }

    public String getType() {
        return type;
    }

    public List<Character> getCards() {
        return cards;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return "[Type: " + this.type + "; Value: " + this.value + "]";
    }
}
