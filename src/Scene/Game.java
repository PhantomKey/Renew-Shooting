package Scene;

import Input.InputUtility;
import Logic.GameLogic;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import shareObj.IRenderable;
import shareObj.RenderableHolder;

public class Game extends Canvas{
	private GameLogic gamelogic;
	
	public Game() {
		super(SceneManager.SCENE_WIDTH,SceneManager.SCENE_HEIGHT);
		gamelogic = new GameLogic();
		this.isVisible();
		addListener();
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
			gamelogic.logicUpdate();
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
	
	private void checkstat() {
		//if (GameLogic.a.getHealth() == 0) {
			//stopBGM();
			//lightning.stop();
			//animation.stop();
			//SceneManager.gotoSceneOf(new GameoverScreen());
		//} else if (GameLogic.xmen.getHealth() <= 0) {
			//stopBGM();
			//lightning.stop();
			//animation.stop();
			//SceneManager.gotoSceneOf(new WinScreen());
		//}
	}
	public void addListener() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});
	}
}
