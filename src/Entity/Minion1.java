package Entity;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class Minion1 extends Minion{

	
	public Minion1(double x, double y) {
		super(20,0,1,5,45,45);
		Random random = new Random();
		this.speed = random.nextInt(3)+3;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	public void update() {
		this.y -= speed;
		destroy();
		outOfBound(this);
	}

}
