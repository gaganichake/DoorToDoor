package com.yash.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
@Service
public class GameService {



    public Integer generateGameId() {


        return new Integer(0);
    }

    public GameSession updateDoorStatusAsOpen(String gameId, Integer doorId) {
        GameSession gameSession=new GameSession();
        gameSession.setGameId(gameId);
        gameSession.getDoorStatus().put(doorId,"Open");
        return gameSession;
    }
}
