package Entity;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class Minion2  extends Minion{

	private static Image minion = RenderableHolder.enermy2;

	public Minion2(double x, double y) {
		super(3, 0, 1, 3, minion.getWidth(), minion.getHeight());
		Random random = new Random();
		this.speed = random.nextInt(3) + 3;
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
