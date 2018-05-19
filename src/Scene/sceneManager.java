package Scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class sceneManager {
	
	private static Stage primaryStage;
	private static Canvas mainMenuCanvas = new MainMenu();
	private static Scene mainMenuScene = new Scene(new Pane(mainMenuCanvas));
	public static final int SCENE_WIDTH = 650;
	public static final int SCENE_HEIGHT = 650;
	
	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.show();
	}
	
	public static void gotoMainMenu() {
		primaryStage.setScene(mainMenuScene);
		mainMenuCanvas.requestFocus();
	}
	
	public static void goToSceneOf(Canvas canvas) {
		Scene scene = new Scene(new Pane(canvas));
		canvas.requestFocus();
		primaryStage.setScene(scene);
	}
}
