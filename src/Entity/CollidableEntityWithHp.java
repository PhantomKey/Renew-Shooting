package Entity;

import Logic.GameLogic;
import Scene.SceneManager;

public abstract class CollidableEntityWithHp extends CollidableEntity{
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
	
	public CollidableEntityWithHp (int hp,int spacialAction,int damage,double speed,int width,int height) {
		super(width,height,speed,damage);
		this.maxHp = hp;
		this.maxSpacialAction = spacialAction;
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
	
	/*protected void outOfBound(Plane tempPlane) {
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
	}*/
	
	public void takeAction(Item item) {
		/*if(item.getName().equals("Heal")){
				this.hp += 1;
		} else if (item.getName().equals("Mana")) {
				this.mana += 1;
		}
		item.hp = 0;*/
	}
	
	public int getHp() {
		return hp;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
