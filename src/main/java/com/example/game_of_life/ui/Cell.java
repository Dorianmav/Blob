package com.example.game_of_life.ui;

import java.awt.Color;
import java.awt.Rectangle;

public class Cell extends Rectangle{

    Color color;
    Boolean alive = false;

    public Cell(int x, int y, boolean alive){
        this.x = x;
        this.y = y;
        this.width = 10;
        this.height = 10;
        this.alive = alive;
        this.color = alive ? Color.black : Color.white;
    }
    
    public Cell(int x, int y, int w, int h, boolean alive){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.alive = alive;
        this.color = alive ? Color.black : Color.white;
    }

}