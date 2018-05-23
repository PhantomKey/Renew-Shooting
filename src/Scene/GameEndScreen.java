package scene;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.PlayBGM;
import logic.Score;
import shareObj.RenderableHolder;

public class GameEndScreen extends Canvas {
	private Image gameEnd = RenderableHolder.end;
	private static final Font score = Font.loadFont(ClassLoader.getSystemResource("Fipps-Regular.otf").toString(), 50);
	private AudioClip endSong = RenderableHolder.endSong;
	private PlayBGM playBGM;
	private boolean isBGMRunning;
	public static Thread processBGM;
	public GameEndScreen() {
		super(SceneManager.SCENE_WIDTH, SceneManager.SCENE_HEIGHT);
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.drawImage(gameEnd, 0, 0);
		
		gc.setFill(Color.CORAL);
		gc.setFont(score);
		gc.fillText(""+Score.getScore(), 360, 250);
		startBGM();
		addKeyEventHandler();
		
	}
	
	public void startBGM() {
		endSong.setPriority(10);
		endSong.setVolume(0.5);
		playBGM = new PlayBGM(endSong,24);
		processBGM = new Thread(playBGM);
		processBGM.start();
	}
	public void stopBGM() {
		playBGM.setBGMRunning(false);
		processBGM.interrupt();
	}
	private void addKeyEventHandler() {
		this.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ENTER) {
					stopBGM();
					Platform.exit();
				}
			}
		});
	}
}
