package Logic;

import java.util.Random;

import Entity.Minion1;
import Entity.Player;
import Scene.SceneManager;

public class Wave {
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
		posX = 0;
		posY = 0;
		for (int i = 0; i < 3*numberMultiply; i++) {
			GameLogic.addEntity(new Minion1(posX, posY));
			posY = (posY+80)%SceneManager.SCENE_WIDTH;
			GameLogic.addEntity(new Minion1(posX, posY));
			posY =  (posY+80)%SceneManager.SCENE_WIDTH;
		}
	}

	private static void Wave() {
		posX = 0;
		posY = 0;
		for (int i = 0; i < 6*numberMultiply; i++) {
			GameLogic.addEntity(new Minion1(posX, posY));
			posX = (posX+50);
			posY = (posY+80)%SceneManager.SCENE_HEIGHT;
		}
	}
	private static void Strike() {
		posX = 0;
		posY = 0;
		Random random = new Random();
		for (int i = 0; i < 3*numberMultiply;i++) {
			GameLogic.addEntity(new Minion1(Player.standX+posX,Player.standY+posY));
			posX += random.nextInt(20)-10;
			posY += 30;
		}
	}
	public static void update() {
		decreaseDelay = 0;
		numberMultiply = 1;
		if (delay > DEFAULT_DELAY) {
			generateWave();
			delay = 0+decreaseDelay;
		}
		delay++;
		
	}
	private static void BadLuckGamer() {
		Mass();
		Wave();
		Strike();
	}
	
	
}
