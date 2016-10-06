package com.yash.game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
public class GameController {

    public ResponseEntity startGame() {
        return new ResponseEntity("",HttpStatus.OK);
    }
}
