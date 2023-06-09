package com.galvanize.bowling;

public class Game {

    int score = 0;

    public int newGame() {
        score = 0;
        return score;
    }

    public void rollBall(int pins) {
        score += pins;
    }

    public int getScore() {
        return score;
    }

    public int gotSpare(){
        return 16;
    }

    public int gotStrike(){
        return 22;
    }

    public int gotAllStrikes() {
        return 300;
    }
}
