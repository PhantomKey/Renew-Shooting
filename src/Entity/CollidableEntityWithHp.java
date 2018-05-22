package Entity;

import java.awt.Rectangle;
import java.util.Random;

import Logic.GameLogic;
import Scene.SceneManager;
import shareObj.RenderableHolder;

public abstract class CollidableEntityWithHp extends CollidableEntity {
	protected int maxHp;
	protected int hp;
	protected int maxSpacialAction;
	protected int spacialAction;
	protected int dropChance;
	protected boolean invulnerable;
	protected int invulnerableTime;
	protected boolean flashing = false;
	protected int flashCounter = 0;
	protected int flashDurationCounter = 0;

	public CollidableEntityWithHp(int hp, int spacialAction, int damage, double speed, double width, double height) {
		super(width, height, speed, damage);
		this.maxHp = hp;
		this.maxSpacialAction = 3;
		this.hp = hp;
		this.spacialAction = spacialAction;
	}

	public void checkHpAndSpacialAttack() {
		if (this.hp > maxHp) {
			this.hp = maxHp;
		}
		if (this.spacialAction > maxSpacialAction) {
			this.spacialAction = maxSpacialAction;
		}
	}

	public void takeAction(Item item) {
		RenderableHolder.take.play();
		if (item.getName().equals("Heal")) {
			this.hp += 1;
		} else if (item.getName().equals("SP")) {
			this.spacialAction += 1;
		} else if (item.getName().equals("UP")) {
			if (this instanceof Player) {
				((Player) this).increasePower(1);
			}
		}

		item.destroy();
	}

	public void takeDamage(PlayerBullet pBullet) {
		int damage = pBullet.getDamage();
		if (damage < 1) {
			damage = 1;
		}
		this.hp -= damage;
	}
	
	public void takeDamage(SpacialAttack pBullet) {
		int damage = pBullet.getDamage();
		if (damage < 1) {
			damage = 1;
		}
		this.hp -= damage;
	}

	public void takeDamage(Enemy enemy) {
		int damage = enemy.getDamage();
		if (damage < 1) {
			damage = 1;
		}
		if (!invulnerable) {
			this.hp -= damage;
		}
		if (this instanceof Player && (!this.invulnerable)) {
			invulnerable = true;
			invulnerableTime = 120;
			flashing = true;
			flashCounter = 16;
			flashDurationCounter = 10;
		}
		if (invulnerableTime <= 0) {
			invulnerable = false;
		}
	}

	public boolean collision(PlayerBullet player) {
		return this.getBound((int) width, (int) height).intersects(player.getBound((int) player.width, (int) player.height));
	}
	
	public boolean collision(SpacialAttack player) {
		return this.getBound((int) width, (int) height).intersects(player.getBound((int) player.width, (int) player.height));
	}

	public boolean collision(Enemy enemy) {
		return this.getBound((int) width, (int) height)
				.intersects(enemy.getBound((int) enemy.width, (int) enemy.height));
	}

	/*
	 * public boolean collision(PlayerBullet hero){ return this.getBound((int)width,
	 * (int)height).intersects(hero.getBound((int)hero.width,(int)hero.height)); }
	 */
	protected void dropItem() {
		Random random = new Random();
		dropChance = random.nextInt(100)+1;
		if (dropChance >= 0 && dropChance < 30 /* && !(this instanceof EnemyBullet) */) { ////////////// Drop Chance																					////////////// 10%///////////////////////////
			GameLogic.addEntity(new Item(this.x, this.y));
		}
	}

	public int getHp() {
		return hp;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public void destroy() {
		super.destroy();
		if (this.hp <= 0) {
			this.destroyed = true;
			if (this instanceof Plane) {
				GameLogic.removeEntity((Plane) this);
			} else if (this instanceof Enemy) {
				RenderableHolder.d1.play();
				dropItem();
				GameLogic.removeEntity((Enemy) this);
				
			}
		}

	}

	protected void outOfBound(Enemy tempEnemy) {
		if (this.x > 650-tempEnemy.getWidth()) {
			this.destroyed = true;
			GameLogic.removeEntity(tempEnemy);
		}
		if (this.x < 0+tempEnemy.getWidth()) { // not sure
			this.destroyed = true;
			GameLogic.removeEntity(tempEnemy);
		}
		if (this.y > SceneManager.SCENE_HEIGHT + 50) {
			this.destroyed = true;
			GameLogic.removeEntity(tempEnemy);
		}
	}

	protected void outOfBound(Plane tempPlane) {
		if (this.x > SceneManager.SCENE_WIDTH) {
			this.destroyed = true;
			GameLogic.removeEntity(tempPlane);
		}
		if (this.x < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(tempPlane);
		}
		if (this.y > SceneManager.SCENE_HEIGHT) {
			this.destroyed = true;
			GameLogic.removeEntity(tempPlane);
		}
		if (this.y < 0) {
			this.destroyed = true;
			GameLogic.removeEntity(tempPlane);
		}
	}
}
