package Entity;

import Input.InputUtility;
import Logic.GameLogic;
import Scene.SceneManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import shareObj.RenderableHolder;

public class Player extends Plane implements Shootable {

	private String name = "player";
	private static Image spaceShip = RenderableHolder.spaceship;
	private static final int DEFAULT_COOLDOWN = 20;
	private int shootCooldown;

	public Player() {
		super(3, 1, 0, 5, spaceShip.getWidth(), spaceShip.getHeight());
		this.y = SceneManager.SCENE_HEIGHT - this.height - 50;
		this.x = SceneManager.SCENE_WIDTH / 2;
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
			shoot();
		}
		/*
		 * chargeShoot(); heal(); ultimate(); invulnerableTime--; healDelay--; shoot();
		 * destroy(); recoveryMana(); checkHPAndMana();
		 */
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		System.out.println("shoot");
		if (shootCooldown == 0) {
			// laser.setVolume(0.5);
			// laser.play();
			int powerLevel = this.getPowerLevel();
			if (powerLevel < 2) {
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x, this.y)));
			} else if (powerLevel < 4) {
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x - 5, this.y)));
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x + 5, this.y)));
			} else {
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(270, this.x, this.y)));
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(275, this.x+5, this.y)));
				GameLogic.addEntity((BasicBullet) (new PlayerBullet(265, this.x-5, this.y)));
			}

			shootCooldown = DEFAULT_COOLDOWN;
		} else {
			shootCooldown--;
		}
	}

}
