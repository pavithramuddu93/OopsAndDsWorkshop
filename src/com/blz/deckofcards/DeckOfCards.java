package com.blz.deckofcards;
import java.util.*;

public class DeckOfCards {
    public static String[] suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static String[] deckOfCard = new String[suit.length * rank.length];
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Player> playerList = new ArrayList<>();
    static String[][] playerCardStrings = new String[4][9];
    static Map<String, Integer> map = new HashMap<>();

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

    public int numOfPlayers() {
        System.out.println("Enter the number of players,range must be from 2 to 4");
        int playerCount = scanner.nextInt();
        if (playerCount >= 2 && playerCount <= 4) {

            for (int i = 0; i < playerCount; i++) {
                System.out.println("Enter player " + (i + 1) + " name");
                String name = scanner.next();
                int playerNo = (i + 1);
                playerList.add(new Player(name, playerNo));
            }
            System.out.println(playerCount + " players will play the game");
        } else {
            System.out.println("please enter the correct range");
            this.numOfPlayers();
            scanner.close();
        }
        return playerCount;
    }

    public void seqOfPlayer(int playerCount) {
        System.out.println("\nSequence of cards are below : ");
        for (int i = 0; i < playerCount; i++) {
            Player p = playerList.get(i);
            System.out.println("\nPlayer " + p.getPlayerNo() + "  " + p.getPlayerName() + " Getting card.............");
        }
    }

    public void shuffleCards() {
        Random random = new Random();
        for (int i = 0; i < deckOfCard.length; i++) {
            int index = random.nextInt(deckOfCard.length);
            String temp = deckOfCard[i];
            deckOfCard[i] = deckOfCard[index];
            deckOfCard[index] = temp;
        }
    }

    public void cardDistribution(int playerCount) {
        int index = 0;
        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < playerCardStrings[i].length; j++) {
                playerCardStrings[i][j] = deckOfCard[index];
//                System.out.println(playerCardStrings[i][j]);
                index++;
            }
            System.out.println();
        }
    }

    public void verifyCards(int playerCount) {
        int clubsCount = 0;
        int dimondsCount = 0;
        int heartsCount = 0;
        int spadesCounts = 0;
        char ch;
        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < playerCardStrings[i].length; j++) {
                for (int k = j + 1; k < playerCardStrings[i].length; k++) {
                    if (playerCardStrings[i][j].compareTo(playerCardStrings[i][k]) == 0) {
                        System.out.println("player" + (i + 1) + " didnot get unique cards");
                        return;
                    }
                }
                ch = playerCardStrings[i][j].charAt(0);
                if (ch == 'C')
                    clubsCount++;
                if (ch == 'D')
                    dimondsCount++;
                if (ch == 'H')
                    heartsCount++;
                if (ch == 'S')
                    spadesCounts++;
            }
            map.put("Clubs", clubsCount);
            map.put("Dimonds", dimondsCount);
            map.put("Hearts", heartsCount);
            map.put("spade", spadesCounts);

            System.out.println("player" + (i + 1) + "");
            System.out.println(map);
            clubsCount = dimondsCount = heartsCount = spadesCounts = 0;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to deck of cards simulation");
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.getUniqueCards();
        System.out.println("Unique cards are");
        deckOfCards.printArray(deckOfCard);
        deckOfCards.shuffleCards();
        deckOfCards.printArray(deckOfCard);
        int playerCount = deckOfCards.numOfPlayers();
        System.out.println(playerList);
        deckOfCards.cardDistribution(playerCount);
        deckOfCards.verifyCards(playerCount);
    }
}