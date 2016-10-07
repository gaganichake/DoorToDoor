package com.yash.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    GameService gameService;

    @Test
    public void generateGameId() throws Exception {

       assertNotNull(gameService.generateGameId());
    }

    @Test
    public void generateGameIdAsInteger() throws Exception {

        Integer id = gameService.generateGameId();

        assertNotNull(id);
    }

    @Test
    public void ShouldReturnGameId(){
        String gameId = "0";
        Integer doorNumber = 1;

        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        GameSession actualGameSession=gameService.updateDoorStatusAsOpen(gameId.toString(),doorNumber);
        assertNotNull(actualGameSession);
        assertEquals(expectedGameSession.getGameId(),actualGameSession.getGameId());
    }

    @Test
    public void DoorNumberShouldHaveOpenStatus() {
        String gameId = "0";
        Integer doorNumber = 1;

        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        expectedGameSession.getDoorStatus().put(doorNumber,"Open");
        GameSession actualGameSession=gameService.updateDoorStatusAsOpen(gameId.toString(),doorNumber);
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber), expectedGameSession.getDoorStatus().get(doorNumber));
    }

    @Test
    public void WhenDoor1IsOpenedAllOtherDoorsShouldBeClosed() {
        String gameId = "0";
        Integer doorNumber = 1;
        Integer doorNumber2 = 2;
        Integer doorNumber3=3;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        expectedGameSession.getDoorStatus().put(doorNumber, "Open");
        expectedGameSession.getDoorStatus().put(doorNumber2, "Closed");
        expectedGameSession.getDoorStatus().put(doorNumber3, "Closed");

        GameSession actualGameSession = gameService.updateDoorStatusAsOpen(gameId.toString(), doorNumber);
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber), expectedGameSession.getDoorStatus().get(doorNumber));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber2), expectedGameSession.getDoorStatus().get(doorNumber2));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber3), expectedGameSession.getDoorStatus().get(doorNumber3));
    }

    @Test
    public void WhenDoor2IsOpenedAllOtherDoorsShouldBeClosed() {
        String gameId = "0";
        Integer doorNumber = 1;
        Integer doorNumber2 = 2;
        Integer doorNumber3=3;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        expectedGameSession.getDoorStatus().put(doorNumber, "Closed");
        expectedGameSession.getDoorStatus().put(doorNumber2, "Open");
        expectedGameSession.getDoorStatus().put(doorNumber3, "Closed");

        GameSession actualGameSession = gameService.updateDoorStatusAsOpen(gameId.toString(), doorNumber2);
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber), expectedGameSession.getDoorStatus().get(doorNumber));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber2), expectedGameSession.getDoorStatus().get(doorNumber2));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber3), expectedGameSession.getDoorStatus().get(doorNumber3));
    }
    @Test
    public void WhenDoor3IsOpenedAllOtherDoorsShouldBeClosed() {
        String gameId = "0";
        Integer doorNumber = 1;
        Integer doorNumber2 = 2;
        Integer doorNumber3=3;
        GameSession expectedGameSession = new GameSession();
        expectedGameSession.setGameId(gameId.toString());
        expectedGameSession.getDoorStatus().put(doorNumber, "Closed");
        expectedGameSession.getDoorStatus().put(doorNumber2, "Closed");
        expectedGameSession.getDoorStatus().put(doorNumber3, "Open");

        GameSession actualGameSession = gameService.updateDoorStatusAsOpen(gameId.toString(), doorNumber3);
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber), expectedGameSession.getDoorStatus().get(doorNumber));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber2), expectedGameSession.getDoorStatus().get(doorNumber2));
        assertEquals(actualGameSession.getDoorStatus().get(doorNumber3), expectedGameSession.getDoorStatus().get(doorNumber3));
    }
}