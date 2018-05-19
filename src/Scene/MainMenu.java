package Scene;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.application.Platform;
import javafx.event.EventHandler;

public class MainMenu extends Canvas{
	
	private static final Font Tiltle = new Font("Codia New", 80);
	private static final Font Menu = new Font("Codia New", 50);
	//private Image bg = ;
	
	
	public MainMenu() {
		super(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		
		
		GraphicsContext gc = this.getGraphicsContext2D();
		//gc.drawImage(img, x, y);
		
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		
		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setFont(Tiltle);
		gc.fillText("ShootingSpace",SceneManager.SCENE_WIDTH / 2,SceneManager.SCENE_HEIGHT / 4);
		gc.setFont(Menu);
		gc.fillText("Press Enter to start", SceneManager.SCENE_WIDTH / 2, SceneManager.SCENE_HEIGHT * 3 / 4);
		
		this.addKeyEventHandler();
	}
	
	private void addKeyEventHandler() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if (key.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				} else if (key.getCode() == KeyCode.ENTER) {
					SceneManager.goToSceneOf(new Tutorial());
				}
			}
			});
	}
}
