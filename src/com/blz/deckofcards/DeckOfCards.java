package com.blz.deckofcards;
public class DeckOfCards {
    static String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    static String[] deckOfCard = new String[suit.length * rank.length];

    public void getUniqueCards() {
        int index = 0;// intialising deck index to zero
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deckOfCard[index] = suit[i] + " : " + rank[j];
                index++;// incrementing index
            }
        }
    }


    public void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to deck of cards simulation");
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.getUniqueCards();
        System.out.println("Unique cards are");
        deckOfCards.printArray(deckOfCard);
    }
}