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
public class GameSessionTest {

    @InjectMocks
    GameSession gameSession;

    @Test
    public void toStringAsJSON() throws Exception {

        String expectedJSONInToString = "{\"gameId\" : \"12\"," +" \"options\" : \"XYZ\"" + "}";

        GameSession gameSession = new GameSession();
        gameSession.setGameId("12");
        gameSession.setOptions("XYZ");

        String actualToString = gameSession.toString();

        assertEquals(expectedJSONInToString,actualToString);

    }
}