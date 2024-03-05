package com.example.game_of_life;

import javax.swing.JFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.game_of_life.ui.Canva;

@SpringBootApplication
public class BlobApplication {

	public static JFrame jFrame;

	public static Canva canva;

	public static Blob zone = new Blob();

	public static int frameHeight;

	public static int frameWidth;

	public static Thread thread;

	public static boolean[][] deepCloneMatrix(boolean[][] source) {
        int rows = source.length;
        int cols = source[0].length;
        boolean[][] target = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                target[i][j] = source[i][j];
            }
        }

        return target;
    }

	public static void main(String[] args) {

		jFrame = new JFrame("Game of life");
		canva = new Canva();

		frameWidth = 760;
		frameHeight = 660;

		jFrame.setSize(frameWidth, frameHeight);
		jFrame.setContentPane(canva);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		zone.initialize(700, 600);
		zone.generate(700, 600);

		new Thread(new Runnable() {

			@Override
			public void run() {
				var newZone = deepCloneMatrix(zone.ocean); 
				while (true) {

					try {

						for (int i = 0; i < zone.ocean.length; i++) {
							for (int j = 0; j < zone.ocean[0].length; j++) {
								if (zone.ocean[i][j]) {

									if (zone.isIsolated(i, j)) {
										newZone[i][j] = !zone.ocean[i][j];
									}

									if (zone.isReasonablySurrounded(i, j)) {
										newZone[i][j] = zone.ocean[i][j];
									}

									if (zone.isOvercrowded(i, j)) {
										newZone[i][j] = !zone.ocean[i][j];
									}
								} else {
									if (zone.canRevive(i, j)) {
										newZone[i][j] = !zone.ocean[i][j];
									}
								}
							}
						}
						zone.ocean = newZone; 
						Thread.sleep(100);
					 
						canva.repaint();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
