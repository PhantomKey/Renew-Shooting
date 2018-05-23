package entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class SpacialAttack extends BasicBullet{
	private int showTime = 0;
	private static final int DEFAULT_TIME = 120;
	private static Image blast = RenderableHolder.blast;
	
	public SpacialAttack() {
		super(0,0,0,650,650,0,999);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(blast, 0, 0,650,650);
		if(showTime >= DEFAULT_TIME) {
			this.destroy();
			showTime = 0;
		}
		showTime++;
		
	}
	
	public void update() {
		outOfBound(this);
		//destroy();
	}
	
	public int getDamage() {
		return this.damage;
		
	}
}
