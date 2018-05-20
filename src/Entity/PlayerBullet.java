package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class PlayerBullet extends BasicBullet {
	
	private static Image bullet = RenderableHolder.playerBullet;
	
	public PlayerBullet(double angle, double x, double y) {
		super(angle, x, y, bullet.getWidth(), bullet.getHeight(),5, 20);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(bullet, this.x, this.y);
		System.out.println("Draw");
		
	}
	

}
