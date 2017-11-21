package graphic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MainMenu extends Application implements EventHandlerable{
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;
	public static final Font start_font = new Font("Times new Roman", 50);
	
	public void setBackGround(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
	}

	public void setText(GraphicsContext gc) {
		gc.setFont(start_font);
		gc.setFill(Color.AQUA);

		gc.fillText("Welcome to LapLap Game", SCENE_WIDTH/5, SCENE_HEIGHT/2);
		gc.setTextAlign(TextAlignment.CENTER);
	}
	public void start(Stage firstStage) {
		Canvas cv = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
		StackPane groot = new StackPane();
		Scene sc = new Scene(groot);
		GraphicsContext gc = cv.getGraphicsContext2D();
		
		setBackGround(gc);
		setText(gc);
		groot.getChildren().addAll(cv);
		firstStage.setScene(sc);
		firstStage.setTitle("LapLap");
		firstStage.show();
		EventHandler();
		}
	private void EventHandler(){
		StackPane root = new StackPane();
		root.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ESCAPE)){
		    	Platform.exit(); }
			} }); 
		}
	public static void main(String[] args) {
		launch(args); }
}