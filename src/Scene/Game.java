package Scene;

import Input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import shareObj.IRenderable;
import shareObj.RenderableHolder;

public class Game extends Canvas{
	public Game() {
		super(sceneManager.SCENE_WIDTH,sceneManager.SCENE_HEIGHT);
		//gamelogic = new GameLogic();
		this.isVisible();
		//addListener();
		//startBGM();
		animation.start();
	}
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.visible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
	AnimationTimer animation = new AnimationTimer() {
		public void handle(long now) {
			paintComponent();
			//gamelogic.logicUpdate();
			RenderableHolder.getInstance().update();
			//Wave.update();
			//playlightning();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//InputUtility.updateInputState();
			//checkstat();
		}
	};
}
