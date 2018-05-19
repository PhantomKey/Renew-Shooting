package Entity;

import Logic.GameLogic;
import Scene.SceneManager;

public abstract class CollidableEntity extends Entity {
	protected int width;
	protected int height;
	protected double speed;
	protected int damage;
	
	public CollidableEntity(int width,int height,double speed,int damage) {
		this.damage = damage;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	public double getSpeed() {
		return speed;
	}

	public int getDamage() {
		return damage;
	}
	
	protected void outOfBound(Item item) {
		/*if (this.x > SceneManager.SCENE_WIDTH) {
			this.destroyed = true;
			GameLogic.removeEntity(item);
		}
		if (this.x < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(item);
		}
		if (this.y > SceneManager.SCENE_HEIGHT) {
			this.destroyed = true;
			GameLogic.removeEntity(item);
		}
		if (this.y < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(item);
		}*/
	}
}
