package Entity;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class Minion1 extends Minion{
	
	private static Image minion = RenderableHolder.enermy1;
	
	public Minion1(double x, double y) {
		super(1,0,1,5,minion.getWidth(),minion.getHeight());
		Random random = new Random();
		this.speed = random.nextInt(3)+3;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(minion, this.x, this.y);
	}
	
	public void update() {
		this.y += speed;
		destroy();
		outOfBound(this);
	}

}
