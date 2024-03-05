package com.example.game_of_life;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class GameOfLifeTests {

    Blob gameoLife;

    @Test
    void isTooIsolated() throws Exception {
        gameoLife = new Blob();
        gameoLife.initialize(6, 6);

        gameoLife.set(5, 5, true);

        gameoLife.set(5, 4, true);
        gameoLife.set(0, 0, true);
        assertTrue(gameoLife.isIsolated(5, 4));
    }

    @Test
    void isReasonablySurrounded() throws Exception {
        gameoLife = new Blob();
        gameoLife.initialize(6, 6);

        gameoLife.set(2, 2, true);

        gameoLife.set(2, 1, true);
        gameoLife.set(2, 3, true);
        gameoLife.set(1, 2, true);
        // gameoLife.set(1, 1, true);
        assertTrue(gameoLife.isReasonablySurrounded(2, 2));
    }

    @Test
    void isOvercrowded() throws Exception {
        gameoLife = new Blob();
        gameoLife.initialize(6, 6);

        gameoLife.set(2, 2, true);

        gameoLife.set(1, 1, true);
        gameoLife.set(1, 2, true);
        gameoLife.set(1, 3, true);
        gameoLife.set(2, 3, true);
        gameoLife.set(3, 3, true);
        gameoLife.set(3, 2, true);
        gameoLife.set(3, 1, true);
        gameoLife.set(2, 1, true);

        assertTrue(gameoLife.isOvercrowded(2, 2));
    }

    @Test
    void canRevive() throws Exception {
        gameoLife = new Blob();
        gameoLife.initialize(6, 6);
        System.out.println("Ocean array dimensions: " + gameoLife.ocean.length + " x " + gameoLife.ocean[0].length);

        gameoLife.set(2, 2, false);

        gameoLife.set(1, 1, true);
        gameoLife.set(1, 2, true);
        gameoLife.set(1, 3, true);

        // gameoLife.set(2, 3, true);

        assertTrue(gameoLife.canRevive(2, 2));
    }

    @Test
    void ok() throws Exception {
        gameoLife = new Blob();
        // gameoLife.setOcean();

        boolean[][] newOcean = new boolean[8][6];

        boolean[][] expected = {
                { false, false, false, false, false, false },
                { false, false, true, false, true, false },
                { false, false, false, true, false, false },
                { true, true, false, true, true, false },
                { false, false, false, true, true, false },
                { true, true, false, false, false, false },
                { false, false, false, false, true, true },
                { false, false, false, false, false, false },
        };

        for (int i = 0; i < gameoLife.ocean.length; i++) {
            for (int j = 0; j < gameoLife.ocean[0].length; j++) {
                if (gameoLife.ocean[i][j] == true) {

                    if (gameoLife.isIsolated(i, j)) {
                        // System.out.println("le point (" + i + "," + j + ") est isolé");
                        newOcean[i][j] = !gameoLife.ocean[i][j];
                    }

                    if (gameoLife.isReasonablySurrounded(i, j)) {
                        // System.out.println("le point (" + i + "," + j + ") est bien entouré");
                        newOcean[i][j] = gameoLife.ocean[i][j];
                    }

                    if (gameoLife.isOvercrowded(i, j)) {
                        // System.out.println("le point (" + i + "," + j + ") est trop entouré");
                        newOcean[i][j] = !gameoLife.ocean[i][j];
                    }
                } else {
                    if (gameoLife.canRevive(i, j)) {
                        // System.out.println("le point (" + i + "," + j + ") peut vivre");
                        newOcean[i][j] = !gameoLife.ocean[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
               assertEquals(expected[i][j], newOcean[i][j]);
            }
            System.out.println();
        }

    }

}
