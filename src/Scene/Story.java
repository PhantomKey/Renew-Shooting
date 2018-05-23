package scene;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import shareObj.RenderableHolder;

public class Story extends Canvas {

	private Image background = RenderableHolder.story;

	public Story() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);

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
					SceneManager.goToSceneOf(new Game());
				}
			}
		});
	}
}
