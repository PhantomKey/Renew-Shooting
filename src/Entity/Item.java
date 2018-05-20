package Entity;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Item extends CollidableEntity{
	private static String[] ITEM_LIST = {"Heal","SP","UP"};
	private String name;
	private Image heard = null;
	private Image sp = null;
	
	
	public Item(double x, double y) {
		super(0, 0, 1, 0);
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
	}
 
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
 
}
