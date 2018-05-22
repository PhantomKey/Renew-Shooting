package Entity;

import java.awt.Rectangle;

import Logic.GameLogic;
import Scene.SceneManager;

public abstract class CollidableEntity extends Entity {
	protected double width;
	protected double height;
	protected double speed;
	protected int damage;

	public CollidableEntity(double width, double height, double speed, int damage) {
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

		if (this.x > SceneManager.SCENE_WIDTH) {
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
		}

	}

	protected void outOfBound(BasicBullet bullet) {
		if (this.x > SceneManager.SCENE_WIDTH) {
			this.destroyed = true;
			GameLogic.removeEntity(bullet);
			System.out.println("F");
		}
		if (this.x < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(bullet);
			System.out.println("F");
		}
		if (this.y > SceneManager.SCENE_HEIGHT) {
			this.destroyed = true;
			GameLogic.removeEntity(bullet);
			System.out.println("F");
		}
		if (this.y < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(bullet);
			System.out.println("F");
		}
	}

	public Rectangle getBound(int width, int height) {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void destroy() {
		if (this instanceof Item) {
			this.destroyed = true;
			GameLogic.removeEntity((Item) this);
		} else if (this instanceof BasicBullet) {
			this.destroyed = true;
			GameLogic.removeEntity((BasicBullet) this);
		}
	}
}
