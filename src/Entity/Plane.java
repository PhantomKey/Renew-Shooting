package Entity;

import Input.InputUtility;
import Logic.GameLogic;
import Scene.SceneManager;
import javafx.scene.input.KeyCode;

public abstract class Plane extends CollidableEntityWithHp{
	
	public static double standX, standY;
	private int powerLevel;
	private int power;
	private int[] requiredPower = {2,4,6,8,10};
	
	
	public Plane(int hp, int spacialAction, int damage, double speed, double width, double height) {
		super(hp, spacialAction, damage, speed, width, height);
		this.power  = 0;
		this.powerLevel = 0;
		// TODO Auto-generated constructor stub
	}
	
	private void up() {
		this.y -= speed;
	}

	private void left() {
		this.x -= speed;
	}

	private void right() {
		this.x += speed;
	}

	private void down() {
		this.y += speed;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public int getPower() {
		return power;
	}

	public int[] getRequiredPower() {
		return requiredPower;
	}

	private void inBound() {
		if (this.x > SceneManager.SCENE_WIDTH-this.width)
			x = SceneManager.SCENE_WIDTH-this.width;
		if (this.x < 0)
			x = 0;
		if (this.y> SceneManager.SCENE_HEIGHT-this.height)
			y = SceneManager.SCENE_HEIGHT-this.height;
		if (this.y< 0)
			y = 0;
	}
	public void update() {
		/*if (flashing) {
			if (flashCounter == 0) {
				this.visible = true;
				flashing = false;
			} else {
				if (flashDurationCounter > 0) {
					this.visible = flashCounter <= 5;
					flashDurationCounter--;
				} else {
					this.visible = true;
					flashDurationCounter = 10;
					flashCounter--;
				}
			}
		}*/
			if (InputUtility.getKeyPressed(KeyCode.UP)) {
				up();
			}
			if (InputUtility.getKeyPressed(KeyCode.LEFT)) {
				left();
			}
			if (InputUtility.getKeyPressed(KeyCode.RIGHT)) {
				right();
			}
			if (InputUtility.getKeyPressed(KeyCode.DOWN)) {
				down();
			}
			
			
			standX = this.x; 
			standY = this.y; 
			inBound();
			outOfBound(this);
		
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
	
	public void increasePower(int i) {
		power += i;
		if(powerLevel == 4) {
			if(power > requiredPower[powerLevel]) {
				power = requiredPower[powerLevel];
			}
			return;
		}
		if(power >= requiredPower[powerLevel]) {
			power -= requiredPower[powerLevel];
			powerLevel++;
		}
	}

	public void setHealth(int health) {
		this.hp = health;
	}

	public int getSpacialAction() {
		return this.spacialAction;
		
	}

	public void setSpacialAction(int spacialAction) {
		this.spacialAction = spacialAction;
	}

}
