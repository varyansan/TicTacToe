package com.example.tictactoe.model;

public class MoveRequest {
    private String player;
    private int cellIndex;
    private String mode;

    // Геттеры и сеттеры
    public String getPlayer() { return player; }
    public void setPlayer(String player) { this.player = player; }

    public int getCellIndex() { return cellIndex; }
    public void setCellIndex(int cellIndex) { this.cellIndex = cellIndex; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
}
