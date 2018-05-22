package Entity;

public abstract class BasicBullet extends CollidableEntity{
	private double rad;
	private double dx;
	private double dy;
	
	public BasicBullet(double angle, double x, double y,double width,double height,double speed,int damage) {
		super(width, height, speed, damage);
		this.x = x;
		this.y = y;
		this.rad = Math.toRadians(angle); 
		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update() {
		this.x += dx;
		this.y += dy; 
		outOfBound(this);
		//destroy();
	}

	@Override
	public int getDamage() {
		return damage;
	}

}
