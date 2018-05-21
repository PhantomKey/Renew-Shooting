package Entity;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import shareObj.RenderableHolder;

public class Item extends CollidableEntity{
	private static String[] ITEM_LIST = {"Heal","SP","UP"};
	private String name;
	public static Image sp = RenderableHolder.Sp;
	public static Image regen = RenderableHolder.Regen;
	public static Image power = RenderableHolder.Power;
	
	
	public Item(double x, double y) {
		super(24, 19, 1, 0);
		this.x = x;
		this.y = y;
		
		Random random = new Random();
		int n = random.nextInt(100)+1;
		if(n <= 20) {
			name = ITEM_LIST[1];
		}else if(20 < n && n>= 80) {
			name= ITEM_LIST[1];
		}else {
			name = ITEM_LIST[3];
		}
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		this.y -= 0.5;
		Random random = new Random();
		int n = random.nextInt(100)+1;
		if(n <= 50) {
			this.x -= speed;
		}else {
			this.y += speed;
		}
		outOfBound(this);
	}
 
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		if(name.equals("Heal")) {
			gc.drawImage(regen, x, y, 24, 19);
		}else if(name.equals("SP")) {
			gc.drawImage(sp, x, y, 24, 19);
		}else if(name.equals("UP")) {
			gc.drawImage(power, x, y, 24, 19);
		}
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 
}
