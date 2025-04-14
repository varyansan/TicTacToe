package com.example.tictactoe.controller;

import com.example.tictactoe.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*") // Разрешить все origins для тестов
public class GameController {

    @PostMapping("/move")
    public ResponseEntity<GameResponse> makeMove(@RequestBody MoveRequest request) {
        // Простая реализация для теста
        String[] board = new String[9];
        board[request.getCellIndex()] = request.getPlayer();

        GameResponse response = new GameResponse();
        response.setBoard(board);
        response.setWinner(checkWinner(board));

        return ResponseEntity.ok(response);
    }

    private String checkWinner(String[] board) {
        // Заглушка - реализуйте логику проверки победы
        return null;
    }
}
