package logic;

import java.util.ArrayList;
import java.util.List;

import application.GameMain;
import graphic.CanvasManager;
import graphic.InGame;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class GameLogic {

	private static final int FPS = 60;
	private static final long LOOP_TIME = 1000000000 / FPS;

	private GameModel model;
	private InGame ingame;
	private Thread gameLogic;
	private List<Items> gameObj;
	private Button button1, button2, button3;

	private static boolean isGameRunning;

	public GameLogic(InGame ingame) {
		model = CanvasManager.getModel();
		this.ingame = ingame;
		gameObj = new ArrayList<Items>();
		button1 = new Button(60, 670, KeyCode.A);
		button2 = new Button(180, 670, KeyCode.S);
		button3 = new Button(300, 670, KeyCode.D);
		addObj(button1);
		addObj(button2);
		addObj(button3);
		isGameRunning = false;
	}

	private void addObj(Items item) {
		gameObj.add(item);
		RenderableHolder.getInstance().add(item);
	}

	public void startGame() {
		isGameRunning = true;
		gameLogic = new Thread(this::gameLoop);
		gameLogic.start();
	}

	// public void pauseGame() {
	// try {
	// gameLogic.wait();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// public void resumeGame() {
	// //gameLogic.notify();
	// }

	public void stopGame() {
		isGameRunning = false;
	}

	private void gameLoop() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long lastLoopStartTime = System.nanoTime();
		while (isGameRunning) {
			long elapsedTime = System.nanoTime() - lastLoopStartTime;
			if (elapsedTime >= LOOP_TIME) {
				lastLoopStartTime += LOOP_TIME;
				button1.update();
				button2.update();
				button3.update();
				updateGame(elapsedTime);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void updateGame(long elapsedTime) {
		model.getCountDownTimer().countDown(elapsedTime);
		if (model.getCountDownTimer().getTimeSecond() == 0) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameMain.stopInGame();
		}
	}
}
