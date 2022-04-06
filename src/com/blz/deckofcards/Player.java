package com.blz.deckofcards;
public class Player {
    private String playerName;
    private int playerNo;

    public Player(String playerName, int playerNo) {
        this.playerName = playerName;
        this.playerNo = playerNo;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerNo=" + playerNo +
                '}';
    }
}