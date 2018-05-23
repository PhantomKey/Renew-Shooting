package entity;

public abstract class Enemy extends CollidableEntityWithHp{

	public Enemy(int hp, int spacialAction, int damage, double speed, double width, double height) {
		super(hp, spacialAction, damage, speed, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		
	}
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return hp;
	}

	public void setHealth(int health) {
		this.hp = health;
	}

}
