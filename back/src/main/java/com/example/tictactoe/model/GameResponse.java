package com.example.tictactoe.model;

public class GameResponse {
    private String[] board;
    private String winner;

    // Геттеры и сеттеры
    public String[] getBoard() { return board; }
    public void setBoard(String[] board) { this.board = board; }

    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
}
