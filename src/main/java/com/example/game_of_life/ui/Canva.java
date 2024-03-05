package com.example.game_of_life.ui;

import javax.swing.JPanel;

import com.example.game_of_life.BlobApplication;

import java.awt.Color;
import java.awt.Graphics;

public class Canva extends JPanel {

    // boolean[][] ocean;
    int size = 10;

    /* public Canva() {
        this.ocean = this.generate(500, 500);
    } */

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < BlobApplication.zone.ocean.length; i++) {
            for (int j = 0; j < BlobApplication.zone.ocean[i].length; j++) {

                if (BlobApplication.zone.ocean[i][j]) {
                    g.fillRect(i * size, j * size, size, size);
                }
            }
        }
        
    }

    /* public boolean[][] generate(int width, int height) {
        // Création d'un objet Random pour générer des nombres aléatoires
        Random random = new Random();

        // Déclaration et création de la matrice
        boolean[][] matrice = new boolean[width][height];

        // Remplissage de la matrice avec des valeurs aléatoires
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                // Générer un booléen aléatoire (true/false)
                matrice[i][j] = random.nextBoolean();
            }
        }

        return matrice;
    } */
}