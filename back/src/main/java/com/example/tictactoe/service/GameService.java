package com.example.tictactoe.service;

import com.example.tictactoe.model.GameResponse;
import com.example.tictactoe.model.MoveRequest;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameResponse processMove(MoveRequest request) {
        String[] board = updateBoard(request.getCellIndex(), request.getPlayer());

        String winner = checkWinner(board);

        if (request.getMode().equals("pvc") && winner == null) {
            int aiMove = findBestMove(board);
            board[aiMove] = "O";
            winner = checkWinner(board);
        }

        GameResponse response = new GameResponse();
        response.setBoard(board);
        response.setWinner(winner);
        return response;
    }

    private String[] updateBoard(int index, String player) {
        String[] board = new String[9];
        board[index] = player;
        return board;
    }

    private String checkWinner(String[] board) {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] != null &&
                    board[pattern[0]].equals(board[pattern[1]]) &&
                    board[pattern[1]].equals(board[pattern[2]])) {
                return board[pattern[0]]; // "X" или "O"
            }
        }

        for (String cell : board) {
            if (cell == null) return null; // Игра продолжается
        }
        return "DRAW";
    }

    private int findBestMove(String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) return i;
        }
        return -1;
    }
}