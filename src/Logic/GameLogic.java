package Logic;

import java.util.ArrayList;
import java.util.List;
import Scene.Background;
import Entity.BasicBullet;
import Entity.Enemy;
import Entity.Item;
import Entity.Plane;
import Entity.Player;
import shareObj.RenderableHolder;


public class GameLogic {
	private static List<Plane> planeContainer;
	private Thread update;
	private static List<Item> itemContainer;
	private static List<BasicBullet> bulletContainer;
	private static List<Enemy> enemyContainer;
	
	
	private Player p;
	
	public GameLogic() {
		planeContainer = new ArrayList<Plane>();
		bulletContainer = new ArrayList<BasicBullet>();
		Background bg = new Background();
		RenderableHolder.getInstance().add(bg);
		Player p = new Player();
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
		System.out.println("add");
		bulletContainer.add(entity);
		System.out.println(bulletContainer.size());
		RenderableHolder.getInstance().add(entity);
	}

	public synchronized static void removeEntity(BasicBullet entity) {
		System.out.println("remove");
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
			if(!bulletContainer.isEmpty()) {
				for (j = 0; j < bulletContainer.size(); j++) {
					bulletContainer.get(j).update();
					System.out.println(j);
				}
			}	/*if (!(planeContainer.get(i) instanceof HeroBullet) && !(planeContainer.get(i) instanceof HeroChargeBullet
						&& !(planeContainer.get(i) instanceof HeroUltimate))) {
					if (planeContainer.get(i).collision(itemContainer.get(j))) {
						planeContainer.get(i).takeAction(itemContainer.get(j));
					}
				}
				itemContainer.get(j).update();*/
				
			
			/*for (j = 0; j < enemyContainer.size(); j++) {
				if (planeContainer.get(i).collision(enemyContainer.get(j))) {
					planeContainer.get(i).takeDamage(enemyContainer.get(j));
				}
			}*/
			planeContainer.get(i).update();
		/*}
		for (i = 0; i < enemyContainer.size(); i++) {
			for (j = 0; j < planeContainer.size(); j++) {
				if (enemyContainer.get(i).collision(planeContainer.get(j))) {
					enemyContainer.get(i).takeDamage(planeContainer.get(j));
				}
			}
			enemyContainer.get(i).update();*/
		}
	}
	
	public void logicUpdate() { //////////////////////////////// BEWARE INDEX OUT OF BOUND IF THERE IS NO HERO
		//////////////////////////////// OR ENEMY /////////////////////////
		update = new Thread(this::run);
		update.start();
	}
}
