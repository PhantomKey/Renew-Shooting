package Main;

import Scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		SceneManager.initialize(primaryStage);
		SceneManager.gotoMainMenu();
		primaryStage.setTitle("Shoot! Shoot");
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
	}
	
	public void stop() {
		//GameScreen.processBGM.interrupt();
		//WinScreen.processBGM.interrupt();
		//GameoverScreen.processBGM.interrupt();
	}

}
