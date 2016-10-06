package com.yash.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
public class GameController {

    @Autowired
    GameService gameService;

    public ResponseEntity startGame() {

        GameSession gameSession = new GameSession();
        gameSession.setGameId(gameService.generateGameId().toString());
        gameSession.setOptions("Options[ 1 : Door1, 2 : Door2, 3 : Door3, 0 : Terminate Game]");

        return new ResponseEntity(gameSession, HttpStatus.OK);
    }
}
