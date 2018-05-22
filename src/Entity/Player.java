package Entity;

import Input.InputUtility;
import Logic.GameLogic;
import Scene.SceneManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
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
		super(3, 2, 0, 5, spaceShip.getWidth(), spaceShip.getHeight());
		this.y = SceneManager.SCENE_HEIGHT - this.height - 50;
		this.x = SceneManager.SCENE_WIDTH / 2;
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
		if (powerLevel < 2) {
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x, this.y)));
		} else if (powerLevel < 4) {
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x - 10, this.y)));
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x + 10, this.y)));
		} else {
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x, this.y)));
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(275, this.x + 5, this.y)));
			GameLogic.addEntity((BasicBullet) (new PlayerBullet(265, this.x - 5, this.y)));
		}

	}

	public void ultimate() {

		if (InputUtility.getKeyPressed(KeyCode.X) && this.spacialAction > 0) {
			if (time == 0) {
				Bom.play();
				System.out.println("hell");
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
