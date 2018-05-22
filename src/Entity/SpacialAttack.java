package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class SpacialAttack extends Plane{
	private int showTime = 0;
	private static final int DEFAULT_TIME = 100;
	private static Image blast = RenderableHolder.blast;
	
	public SpacialAttack() {
		super(1,0,9999,0,650,650);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(blast, 0, 0,650,650);
		if(showTime >= DEFAULT_TIME) {
			this.hp = 0;
			showTime = 0;
		}
		showTime++;
	}
	
	public void update() {
		outOfBound(this);
		destroy();
	}
	
	public int getDamage() {
		return this.damage;
		
	}
}
