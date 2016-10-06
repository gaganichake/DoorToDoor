package com.yash.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @InjectMocks
    GameController gameController;

    @Test
    public void startGameWithOK() throws Exception {

        ResponseEntity responseEntity = gameController.startGame();
        HttpStatus actualStatus = responseEntity.getStatusCode();

        HttpStatus expectedStatus = HttpStatus.OK;

        assertEquals(expectedStatus.value(), actualStatus.value());
    }

    @Test
    public void startGameWithMessageBody() throws Exception {

        ResponseEntity responseEntity = gameController.startGame();
        HttpStatus actualStatus = responseEntity.getStatusCode();

        HttpStatus expectedStatus = HttpStatus.OK;

        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(responseEntity.getBody());
    }

//    @Test
//    public void startGameWithGameSession() throws Exception {
//        HttpStatus expectedStatus = HttpStatus.OK;
//
//        GameSession expectedGameSession = new GameSession();
//        expectedGameSession.setGameId("34563");
//        expectedGameSession.setOptions("Options[ 1 : Door1, 2 : Door2, 3 : Door3, 0 : Terminate Game]");
//
//        Mockito.when()
//
//        ResponseEntity responseEntity = gameController.startGame();
//
//
//
//        HttpStatus actualStatus = responseEntity.getStatusCode();
//
//        assertEquals(expectedStatus.value(), actualStatus.value());
//        assertNotNull(responseEntity.getBody());
//
//    }
}