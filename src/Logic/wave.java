package logic;

import java.util.Random;

import entity.Minion1;
import entity.Minion2;
import entity.Player;
import scene.SceneManager;

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
			wave();
		} else if (name == "Strike") {
			Strike();
		} else if (name == "All") {
			BadLuckGamer();
		}
	}
	
	private static void Mass() {
		posX = 650/2;
		posY = 0;
		for (int i = 0; i < 3*numberMultiply; i++) {
			GameLogic.addEntity(new Minion1(posX, posY));
			posX = (posX+80)%SceneManager.SCENE_WIDTH;
			GameLogic.addEntity(new Minion2(posX, posY));
			posX =  (posX+80)%SceneManager.SCENE_WIDTH;
		}
	}

	private static void wave() {
		posX = 120;
		posY = 0;
		for (int i = 0; i < 6*numberMultiply; i++) {
			GameLogic.addEntity(new Minion1(posX, posY));
			posX =(posX+80)%SceneManager.SCENE_HEIGHT;
			posY =  (posY-50);
		}
	}
	private static void Strike() {
		posX = 0;
		posY = 0;
		Random random = new Random();
		for (int i = 0; i < 3*numberMultiply;i++) {
			GameLogic.addEntity(new Minion1(Player.standX+posX,posY
					));
			posX += random.nextInt(20)-10;
			posY -= 30;
		}
	}
	public static void update() {
		currentStat = CWave.getSatge();
		if (currentStat == 1) {
			decreaseDelay = 0;
			numberMultiply = 1;
		} else if (currentStat == 2) {
			decreaseDelay = 30;
			numberMultiply = 2;
		} else if(currentStat == 3) {
			decreaseDelay = 60;
			numberMultiply = 3;
		}
		else if(currentStat == 4) {
			decreaseDelay = 120;
			numberMultiply = 4;
		}
		else {
			decreaseDelay = 200;
			numberMultiply = 4;
		}
		if (delay > DEFAULT_DELAY) {
			generateWave();
			delay = 0+decreaseDelay;
		}
		delay++;
		
	}
	private static void BadLuckGamer() {
		Mass();
		wave();
		Strike();
	}
	
	
}
