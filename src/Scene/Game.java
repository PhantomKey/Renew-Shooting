package Scene;

import Input.InputUtility;
import Logic.CWave;
import Logic.GameLogic;
import Logic.PlayBGM;
import Logic.Wave;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import shareObj.IRenderable;
import shareObj.RenderableHolder;

public class Game extends Canvas {
	private GameLogic gamelogic;
	private static AudioClip BGM = RenderableHolder.BMG;
	private PlayBGM playBGM;
	private boolean isBGMRunning;
	public static Thread processBGM;
	private CWave  countWave;
	
	public Game() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		gamelogic = new GameLogic();
		countWave = new CWave();
		this.isVisible();
		addListener();
		startBGM();
		animation.start();
	}

	public void startBGM() {
		BGM.setPriority(10);
		playBGM = new PlayBGM(BGM, 18);
		processBGM = new Thread(playBGM);
		processBGM.start();
	}

	public void stopBGM() {
		playBGM.setBGMRunning(false);
		processBGM.interrupt();
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
			Wave.update();
			countWave.count();
			countWave.stage();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			checkstat();
		}
	};

	private void checkstat() {
		if (GameLogic.p.getHealth() == 0) {
			stopBGM();
			animation.stop();
			SceneManager.goToSceneOf(new GameEndScreen());
			// } else if (GameLogic.xmen.getHealth() <= 0) {
			// stopBGM();
			// lightning.stop();
			// animation.stop();
			// SceneManager.gotoSceneOf(new WinScreen());
		}
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
