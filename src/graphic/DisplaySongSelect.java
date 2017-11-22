package graphic;

import application.GameMain;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import window.SceneManager;

public class DisplaySongSelect extends Canvas implements Drawable {
	
	private GraphicsContext gc = this.getGraphicsContext2D();
	
	public DisplaySongSelect() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		setBackGround();
		setText();
		EventHandler();
	}
	
	public void setBackGround(){
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);
	}
	
	public void setText(){
		gc.setFill(Color.YELLOWGREEN);
		gc.setFont(TEXT_FONT);
		gc.fillText("TEST Song Select", SCENE_WIDTH/3, SCENE_HEIGHT/2);
	}
	
	private void EventHandler() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                	GameMain.gotoModeSelect();
                }
                else if(event.getCode().equals(KeyCode.ENTER)){
                	GameMain.gotoInGame();
                }
			}
		}); 
	}
}
