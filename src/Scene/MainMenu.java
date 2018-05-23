package scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import shareObj.RenderableHolder;
import javafx.application.Platform;
import javafx.event.EventHandler;

public class MainMenu extends Canvas{
	

	private Image background = RenderableHolder.main;
	
	
	public MainMenu() {
		super(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(background, 0, 0);
		
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
