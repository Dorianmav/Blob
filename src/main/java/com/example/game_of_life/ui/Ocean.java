package com.example.game_of_life.ui;

import java.util.Random;

public class Ocean {
    
    public static Cell[][] ocean;

    public Ocean(int row, int colum){
        ocean = new Cell[row][colum];
        setOcean();
    }

    public void setOcean(){
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                ocean[i][j] = new Cell(i * 10, j * 10,  false); // Create new Cell objects
            }
        }
    }

    public void setCell(int x, int y, boolean bool) {
        ocean[x][y].alive = bool;
    }

    public void setDefaultOcean(){
		setCell(0, 1, true);
		setCell(0, 5, true);
		setCell(1, 1, true);
		setCell(1, 3, true);
		setCell(2, 3, true);
		setCell(3, 1, true);
		setCell(3, 3, true);
		setCell(3, 4, true);
		setCell(4, 0, true);
		setCell(4, 1, true);
		setCell(5, 0, true);
		setCell(5, 1, true);
		setCell(5, 4, true);
		setCell(6, 5, true);
		setCell(7, 0, true);
		setCell(7, 1, true);
		setCell(7, 4, true);
    }
    
    

    public void setDefaultOcean2(){
        ocean = new Cell[][]{
            {new Cell(0, 0, true),new Cell(0, 5, false),new Cell(0, 10, false),new Cell(0, 15, false),new Cell(0, 20, false),new Cell(0, 25, true)},
            {new Cell(5, 0, false),new Cell(5, 5, true),new Cell(5, 10, false),new Cell(5, 15, true),new Cell(5, 20, false),new Cell(5, 25, false)},
            {new Cell(10, 0, false),new Cell(10, 5, false),new Cell(10, 10, false),new Cell(10, 15, true),new Cell(10, 20, false),new Cell(10, 25, false)},
            {new Cell(15, 0, false),new Cell(15, 5, true),new Cell(15, 10, false),new Cell(15, 15, true),new Cell(15, 20, true),new Cell(15, 25, false)},
            {new Cell(20, 0, true),new Cell(20, 5, true),new Cell(20, 10, false),new Cell(20, 15, false),new Cell(20, 20, false),new Cell(20, 25, false)},
            {new Cell(25, 0, true),new Cell(25, 5, true),new Cell(25, 10, false),new Cell(25, 15, false),new Cell(25, 20, true),new Cell(25, 25, false)},
            {new Cell(30, 0, false),new Cell(30, 5, false),new Cell(30, 10, false),new Cell(30, 15, false),new Cell(30, 20, false),new Cell(30, 25, true)},
            {new Cell(35, 0, true),new Cell(35, 5, true),new Cell(35, 10, false),new Cell(35, 15, false),new Cell(35, 20, true),new Cell(35, 25, false)},
        };
    }

    /* public void random() {
        Random r = new Random();
        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                ocean[i][j] = r.nextBoolean();
                System.out.print(ocean[i][j] + " ");
            }
            System.out.println();
        }
    } */
}
