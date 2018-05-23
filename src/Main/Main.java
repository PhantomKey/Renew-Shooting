package main;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.Game;
import scene.GameEndScreen;
import scene.SceneManager;

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
	
	@SuppressWarnings("deprecation")
	public void stop() {
		Game.processBGM.stop();
		GameEndScreen.processBGM.interrupt();
	}

}
