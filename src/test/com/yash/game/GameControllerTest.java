package com.yash.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
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

    @Mock
    GameService gameService;

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

    @Test
    public void generateGameIdCalled() throws Exception {

        gameController.startGame();
        Mockito.verify(gameService).generateGameId();
    }

    @Test
    public void startGameReturnsGameSession() throws Exception {

        HttpStatus expectedStatus = HttpStatus.OK;
        Integer id = 34563;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(id.toString());
        expectedGameSession.setOptions("Options[ 1 : Door1, 2 : Door2, 3 : Door3, 0 : Terminate Game]");

        Mockito.when(gameService.generateGameId()).thenReturn(id);

        ResponseEntity responseEntity = gameController.startGame();
        HttpStatus actualStatus = responseEntity.getStatusCode();
        GameSession actualGameSession = (GameSession)responseEntity.getBody();

        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(actualGameSession);
        assertEquals(expectedGameSession.getGameId(), actualGameSession.getGameId());
        assertEquals(expectedGameSession.getOptions(), actualGameSession.getOptions());

    }

    @Test
    public void openDoorWithOK() {

        HttpStatus expectedStatus = HttpStatus.OK;
        ResponseEntity responseEntity = gameController.openDoor("0", 0);
        HttpStatus actualStatus = responseEntity.getStatusCode();

        assertEquals(expectedStatus.value(), actualStatus.value());
    }

    @Test
    public void openDoorWithMessageBody() throws Exception {

        HttpStatus expectedStatus = HttpStatus.OK;
        ResponseEntity responseEntity = gameController.openDoor("0", 0);
        HttpStatus actualStatus = responseEntity.getStatusCode();

        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void openDoorReturnsGameSession() throws Exception {

        HttpStatus expectedStatus = HttpStatus.OK;
        String gameId = "0";
        Integer doorNumber = 1;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId);
        expectedGameSession.setOptions("Options[ 1 : Door1, 2 : Door2, 3 : Door3, 0 : Terminate Game]");

        ResponseEntity responseEntity = gameController.openDoor(gameId, doorNumber);
        HttpStatus actualStatus = responseEntity.getStatusCode();
        GameSession actualGameSession = (GameSession)responseEntity.getBody();

        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(actualGameSession);
        assertEquals(expectedGameSession.getGameId(), actualGameSession.getGameId());
        assertEquals(expectedGameSession.getOptions(), actualGameSession.getOptions());

    }

    @Test
    public void openDoorReturnsGameStatus() throws Exception {

        HttpStatus expectedStatus = HttpStatus.OK;

        String gameId = "0";
        Integer doorNumber = 1;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId);
        expectedGameSession.setOptions("Options[ 1 : Door1, 2 : Door2, 3 : Door3, 0 : Terminate Game]");
        java.util.Map<Integer, String> doorStatus = expectedGameSession.getDoorStatus();
        doorStatus.put(doorNumber, "Open");

        ResponseEntity responseEntity = gameController.openDoor(gameId, doorNumber);

        HttpStatus actualStatus = responseEntity.getStatusCode();
        GameSession actualGameSession = (GameSession)responseEntity.getBody();
        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(actualGameSession);
        assertEquals(expectedGameSession.getGameId(), actualGameSession.getGameId());
        assertEquals(expectedGameSession.getOptions(), actualGameSession.getOptions());

        assertEquals(expectedGameSession.getDoorStatus().get(doorNumber), actualGameSession.getDoorStatus().get(doorNumber));

    }

    @Test
    public void openDoorShouldCallGameService() throws Exception {

        gameController.openDoor("0", 0);
        Mockito.verify(gameService).updateDoorStatusAsOpen("0", 0);
    }

    @Test
    public void openDoorShouldGetGameSessionFromService() throws Exception {

        HttpStatus expectedStatus = HttpStatus.OK;
        String gameId = "0";
        Integer doorNumber = 1;

        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        expectedGameSession.setOptions("XYZ");
        java.util.Map<Integer, String> doorStatus = expectedGameSession.getDoorStatus();//

        Mockito.when(gameService.updateDoorStatusAsOpen(gameId, doorNumber)).thenReturn(expectedGameSession);

        ResponseEntity responseEntity = gameController.openDoor(gameId, doorNumber);

        HttpStatus actualStatus = responseEntity.getStatusCode();
        GameSession actualGameSession = (GameSession)responseEntity.getBody();

        assertEquals(expectedStatus.value(), actualStatus.value());
        assertNotNull(actualGameSession);
        assertEquals(expectedGameSession.getGameId(), actualGameSession.getGameId());
        assertEquals(expectedGameSession.getOptions(), actualGameSession.getOptions());
        assertEquals(expectedGameSession.getDoorStatus().get(doorNumber), actualGameSession.getDoorStatus().get(doorNumber));

    }

}