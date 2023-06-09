package com.galvanize.bowling;

public class Game {

    int[] rolls = new int[21];
    int roll = 0;

    public int getScore() {
        int score = 0;
        int ball = 0;

        for (int frame = 0; frame < 10; frame++) {
            if ( rolls[ball] == 10 ) {                             //Strike
                score += 10 + rolls[ball + 1] + rolls[ball + 2];
                ball += 1;
            } else if ( rolls[ball] + rolls[ball+1] == 10 ) {      //Spare
                score += 10 + rolls[ball+2];
                ball +=2;
            } else {
                score += rolls[ball] + rolls[ball+1];
                ball +=2;
            }
        }

        return score;
    }
    public void rollBall(int pins) {
        rolls[roll] += pins;
        roll++;
    }
}
