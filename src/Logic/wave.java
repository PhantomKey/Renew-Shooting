package Logic;

import java.util.Random;

import Entity.Minion1;
import Scene.SceneManager;

public class wave {
	private static final String[] WAVE_LIST = {"Mass","Mass","Mass","Wave","Wave","Wave","Strike","Strike","Strike","All"};
	private static String name;
	private static int posX;
	private static int posY;
	private static final int DEFAULT_DELAY = 360;
	private static int delay;
	private static int currentStat;
	private static int decreaseDelay;
	private static int numberMultiply;

	private static void generateWave() {
		Random random = new Random();
		name = WAVE_LIST[random.nextInt(WAVE_LIST.length)];
		if (name == "Mass") {
			Mass();
		} else if (name == "Wave") {
			Wave();
		} else if (name == "Strike") {
			Strike();
		} else if (name == "All") {
			BadLuckGamer();
		}
	}
	
	private static void Mass() {
		posX = 650;
		posY = 0;
		for (int i = 0; i < 3*numberMultiply; i++) {
			GameLogic.addEntity(new Ship(posX, posY));
			posY = (posY+80)%SceneManager.SCENE_HEIGHT;
			GameLogic.addEntity(new Ship2(posX, posY));
			posY = (posY+80)%SceneManager.SCENE_HEIGHT;
		}
	}

	private static void Wave() {
		posX = 650;
		posY = 0;
		for (int i = 0; i < 6*numberMultiply; i++) {
			GameLogic.addEntity(new Ship(posX, posY));
			posX = (posX+40);
			posY = (posY+80)%SceneManager.SCENE_HEIGHT;
		}
	}
	private static void Strike() {
		posX = 800;
		posY = 0;
		Random random = new Random();
		for (int i = 0; i < 3*numberMultiply;i++) {
			GameLogic.addEntity(new Ship2(Hero.standX+posX,Hero.standY+posY));
			posX += 40;
			posY += random.nextInt(20)-10;
		}
	}
	public static void update() {
		
	}
	private static void BadLuckGamer() {
		Mass();
		Wave();
		Strike();
	}
	
	
}
