package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Note extends Items {

	private int position;

	public Note(double y, int position) {
		this.position = position;
		this.y = y;
		this.z = 100;
	}

	@Override
	public void draw(GraphicsContext gc, int count) {
		gc.setFill(Color.YELLOW);
		gc.setStroke(Color.YELLOWGREEN);
		double Y = count * model.getSpeed()
				+ 120 * (model.getAllSongs().get(model.getSelectedSong()).getSongDuration() - y) - 3500; // MINUS FOR
																											// GOING UP
		gc.fillOval(90 + (position - 1) * 120, Y, 50, 50);
		gc.strokeOval(90 + (position - 1) * 120, Y, 50, 50);
	}

	public void update() {
		
		Song selectedSong = model.getAllSongs().get(model.getSelectedSong());
		int time_now = selectedSong.getSongDuration() - model.getCountDownTimer().getTimeSecond();
		
		if(model.isTouchButton1() && position == 1 && selectedSong.getSongNoteMaps().containsKey((Double) (double) time_now)) {
			selectedSong.getSongNoteMaps().remove((Double) (double)time_now);
			isPressed = true;
			visible = false;
		}
		if(model.isTouchButton2() && position == 2 && selectedSong.getSongNoteMaps().containsKey((Double) (double) time_now)) {
			selectedSong.getSongNoteMaps().remove((Double) (double)time_now);
			isPressed = true;
			visible = false;
		}
		if(model.isTouchButton3() && position == 3 && selectedSong.getSongNoteMaps().containsKey((Double) (double) time_now)) {
			selectedSong.getSongNoteMaps().remove((Double) (double)time_now);
			isPressed = true;
			visible = false;
		}

	}

}
