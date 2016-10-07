package com.yash.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
@Service
public class GameService {

    private static Map<String, GameSession> gamePool = new HashMap<String, GameSession>();

    public String startGameWithUniqueGameId() {
        return System.currentTimeMillis()-Math.random()+"";
    }

    public GameSession updateDoorStatusAsOpen(String gameId, Integer doorId) throws InvalidDoorException {

        GameSession gameSession=new GameSession();
        if(gameSession.getDoorStatus().containsKey(doorId)){
            gameSession.setGameId(gameId);
            gameSession.getDoorStatus().put(doorId,"Open");
        }else throw new InvalidDoorException();

        return gameSession;
    }

}
