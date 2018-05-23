package entity;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import logic.GameLogic;
import scene.SceneManager;
import shareObj.RenderableHolder;

public class Player extends Plane implements Shootable {

	private String name = "player";
	private static Image spaceShip = RenderableHolder.spaceship;
	private static final int DEFAULT_COOLDOWN = 20;
	private int shootCooldown;
	private AudioClip shoot = RenderableHolder.shoot1;
	private AudioClip Bom = RenderableHolder.Bom;
	private int delay;
	private int time;

	public Player() {
		super(3, 1, 0, 5, spaceShip.getWidth(), spaceShip.getHeight());
		this.y = SceneManager.SCENE_HEIGHT - this.height - 50;
		this.x = SceneManager.SCENE_WIDTH / 2-20;
		delay = 20;
		time = 0;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(spaceShip, x, y);
	}

	@Override
	public void update() {
		super.update();
		if (InputUtility.getKeyPressed(KeyCode.Z)) {
			if (shootCooldown == 0) {
				shoot();
				shootCooldown = DEFAULT_COOLDOWN;
			}
		}
		ultimate();
		shootCooldown--;
		if (shootCooldown < 0) {
			shootCooldown = 0;
		}
		invulnerableTime--;
		checkHpAndSpacialAttack();
		destroy();
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		shoot.play();
		int powerLevel = this.getPowerLevel();
		PlayerBullet bullet1 =  new PlayerBullet(270, this.x, this.y);
		PlayerBullet bullet2=  new PlayerBullet(270, this.x-10, this.y);
		PlayerBullet bullet3 =  new PlayerBullet(270, this.x+10, this.y);
		PlayerBullet bullet4 =  new PlayerBullet(275, this.x+5, this.y);
		PlayerBullet bullet5 =  new PlayerBullet(265, this.x-5, this.y);
		
		if(powerLevel == 0) {
			GameLogic.addEntity((BasicBullet) bullet1);
		}else if(powerLevel == 1) {
			bullet1.upDamage(1);
			GameLogic.addEntity((BasicBullet) bullet1);
		}else if(powerLevel == 2) {
			GameLogic.addEntity((BasicBullet) bullet2);
			GameLogic.addEntity((BasicBullet) bullet3);
		}else if(powerLevel == 3) {
			bullet2.upDamage(1);
			bullet3.upDamage(1);
			GameLogic.addEntity((BasicBullet) bullet2);
			GameLogic.addEntity((BasicBullet) bullet3);
		}else if(powerLevel == 4) {
			bullet1.upDamage(1);
			bullet4.upDamage(1);
			bullet5.upDamage(1);
			GameLogic.addEntity((BasicBullet) bullet1);
			GameLogic.addEntity((BasicBullet) bullet4);
			GameLogic.addEntity((BasicBullet) bullet5);
		}else {
			bullet1.upDamage(2);
			bullet4.upDamage(2);
			bullet5.upDamage(2);
			GameLogic.addEntity((BasicBullet) bullet1);
			GameLogic.addEntity((BasicBullet) bullet4);
			GameLogic.addEntity((BasicBullet) bullet5);
		}
	}

	public void ultimate() {

		if (InputUtility.getKeyPressed(KeyCode.X) && this.spacialAction > 0) {
			if (time == 0) {
				Bom.play();
				GameLogic.addEntity(new SpacialAttack());
				this.spacialAction -= 1;
				time = delay;
			}

		}
		time--;
		if (time < 0) {
			time = 0;
		}
	}

}
