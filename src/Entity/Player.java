package Entity;

import Scene.SceneManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Plane{
	
	private String name = "player";
	
	public Player() {
		super(3,1,1,5,50,50);
		this.y = SceneManager.SCENE_HEIGHT-this.height-50;
		this.x = SceneManager.SCENE_WIDTH/2;
	}
	
	
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLUEVIOLET);
		gc.fillOval(x, y, 50, 50);
	}
	
	@Override
	public void update() {
		super.update();
	}

}
