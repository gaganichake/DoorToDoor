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
}