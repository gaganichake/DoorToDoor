package com.yash.game;

/**
 * Created by gagan.ichake on 06-10-2016.
 */
public class GameSession {

    private String gameId;
    private String options;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "{" +
                "\"gameId\" : \"" + gameId + '\"' +
                ", \"options\" : \"" + options + '\"' +
                '}';
    }
}
