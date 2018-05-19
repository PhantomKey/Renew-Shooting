package Scene;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Tutorial extends Canvas {

	public Tutorial() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);

		GraphicsContext gc = this.getGraphicsContext2D();

		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		this.addKeyEventHandler();
	}

	private void addKeyEventHandler() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if (key.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				} else if (key.getCode() == KeyCode.ENTER) {
					SceneManager.goToSceneOf(new Story());
				}
			}
		});
	}
}
