package com.galvanize.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        game =  new Game();
    }

//    Can create a new game
//    Initialize Game
    @Test
    public void testCreateGame () {
        // Setup
        // Execution
        // Assertions
        assertNotNull(game, "Create game object, shout not be null");
    }
//    Score should be zero
    @Test
    public void testNewGameScoreZero () {
        // Setup
        int expected = 0;
        // Execution
        int actual = game.getScore();
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
        game.rollBall(5);
        game.rollBall(5);
        game.rollBall(3);
        for (int i = 0; i < 17; i++) {
            game.rollBall(0);
        }
        int actual = game.getScore();
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
        game.rollBall(10);
        game.rollBall(3);
        game.rollBall(3);
        for (int i = 0; i < 16; i++) {
            game.rollBall(0);
        }
        int actual = game.getScore();
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
        for (int i = 0; i < 12; i++) {
            game.rollBall(10);
        }
        int actual = game.getScore();
        // Assertions
        assertEquals(expected, actual, "Roll a perfect game");
    }

}