package com.galvanize.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        game =  new Game();
    }

//    Can create a new game
//    Score should be zero
    @Test
    public void testNewGameScoreZero () {
        // Setup
        int expected = 0;
        // Execution
        int actual = game.newGame();
        // Assertions
        assertEquals(expected, actual, "Create new game return score of zero");
    }

//    Can record rolling of ball
//    Should accept an integer for the number of pins knocked down in that roll
    @Test
    public void testRollingABall () {
        // Setup
        int expected = 5;
        // Execution
        game.rollBall(5);
        int actual = game.getScore();
        // Assertions
        assertEquals(expected, actual, "Create new game return score of zero");
    }
//    Can score a game of all (20) gutters
//    Score of zero
    @Test
    public void testAllGutterBalls () {
        // Setup
        int expected = 0;
        // Execution
        for (int i = 0; i < 19; i++) {
            game.rollBall(0);
        }
        int actual = game.getScore();
        // Assertions
        assertEquals(expected, actual, "Roll all zeros return score of zero");
    }
//    Can score a game of all (20) ones
//    Score of 20
    @Test
    public void testRollAllOnes () {
        // Setup
        int expected = 20;
        // Execution
        for (int i = 0; i < 20; i++) {
            game.rollBall(1);
        }
        int actual = game.getScore();
        // Assertions
        assertEquals(expected, actual, "Roll all ones return score of 20");
    }
//    Can score a game with one spare (say two fives), followed by one roll with three pins down, and the rest (17) gutters
//    Score of 16
    @Test
    public void testRollSpare () {
        // Setup
        int expected = 16;
        // Execution
        int actual = game.gotSpare();
        // Assertions
        assertEquals(expected, actual, "Roll a spare with a 3 fill and all zeros");
    }
//    Can score a game with one strike, followed by two rolls with three pins down each, and the rest (16) gutters
//    Score of 22
    @Test
    public void testRollStrike () {
        // Setup
        int expected = 22;
        // Execution
        int actual = game.gotStrike();
        // Assertions
        assertEquals(expected, actual, "Roll a strike with a 6 fill and all zeros");
    }
//    Can score a perfect game - ten strikes + two bonus 10s in the tenth frame
//    Score of 300
    @Test
    public void testPerfectGame () {
        // Setup
        int expected = 300;
        // Execution
        int actual = game.gotAllStrikes();
        // Assertions
        assertEquals(expected, actual, "Roll a perfect game");
    }

}