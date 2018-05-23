package logic;

import java.util.ArrayList;
import java.util.List;

import entity.BasicBullet;
import entity.Enemy;
import entity.Item;
import entity.Plane;
import entity.Player;
import entity.PlayerBullet;
import entity.SpacialAttack;
import scene.Background;
import scene.HUD;
import shareObj.RenderableHolder;

public class GameLogic {
	private static List<Plane> planeContainer;
	private Thread update;
	private static List<Item> itemContainer;
	private static List<BasicBullet> bulletContainer;
	private static List<Enemy> enemyContainer;
	public static Score score;
	public static Player p;

	public GameLogic() {
		p = new Player();
		HUD hud = new HUD();
		planeContainer = new ArrayList<Plane>();
		bulletContainer = new ArrayList<BasicBullet>();
		enemyContainer = new ArrayList<Enemy>();
		itemContainer = new ArrayList<Item>();
		score = new Score();
		Background bg = new Background();
		RenderableHolder.getInstance().add(bg);
		RenderableHolder.getInstance().add(hud);
		addEntity(p);

	}

	public synchronized static void addEntity(Plane entity) {
		planeContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public synchronized static void removeEntity(Plane entity) {
		planeContainer.remove(entity);
	}

	public synchronized static void addEntity(Item entity) {
		itemContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public synchronized static void removeEntity(Item entity) {
		itemContainer.remove(entity);
	}

	public synchronized static void addEntity(BasicBullet entity) {
		bulletContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public synchronized static void removeEntity(BasicBullet entity) {
		bulletContainer.remove(entity);
	}

	public synchronized static void addEntity(Enemy entity) {
		enemyContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
	}

	public synchronized static void removeEntity(Enemy entity) {
		enemyContainer.remove(entity);
	}

	public void run() {

		int i, j;

		for (i = 0; i < planeContainer.size(); i++) {
			if (!bulletContainer.isEmpty()) {
				for (j = 0; j < bulletContainer.size(); j++) {
					bulletContainer.get(j).update();
				}
			}
			if (!itemContainer.isEmpty()) {
				for (j = 0; j < itemContainer.size(); j++) {
					if (planeContainer.get(i).collision(itemContainer.get(j))) {
						planeContainer.get(i).takeAction(itemContainer.get(j));
						itemContainer.get(j).destroy();
					}
					itemContainer.get(j).update();
				}

			}

			for (j = 0; j < enemyContainer.size(); j++) {
				if (planeContainer.get(i).collision(enemyContainer.get(j))) {
					planeContainer.get(i).takeDamage(enemyContainer.get(j));
				}
			}
			planeContainer.get(i).update();

		}
		for (i = 0; i < enemyContainer.size(); i++) {
			for (j = 0; j < bulletContainer.size(); j++) {
				if (bulletContainer.get(j) instanceof PlayerBullet) {
					if (enemyContainer.get(i).collision((PlayerBullet) bulletContainer.get(j))) {
						enemyContainer.get(i).takeDamage((PlayerBullet) bulletContainer.get(j));
						bulletContainer.get(j).destroy();
					}
				} else if (bulletContainer.get(j) instanceof SpacialAttack) {
					if (enemyContainer.get(i).collision((SpacialAttack) bulletContainer.get(j))) {
						enemyContainer.get(i).takeDamage((SpacialAttack) bulletContainer.get(j));
					}
				}
			}
			enemyContainer.get(i).update();

		}
	}

	public void logicUpdate() { //////////////////////////////// BEWARE INDEX OUT OF BOUND IF THERE IS NO HERO
		//////////////////////////////// OR ENEMY /////////////////////////
		update = new Thread(this::run);
		update.start();
	}
}
