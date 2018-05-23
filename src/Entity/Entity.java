package entity;

import shareObj.IRenderable;

public abstract class Entity implements IRenderable{
	protected double x,y;
	protected int z;
	protected boolean visible,destroyed;

	
	protected Entity() {
		this.visible = true;
		this.destroyed = false;
	}
	
	public int getZ() {
		return z;
	}
	public boolean visible() {
		return visible;
	}
	public boolean isDestroyed() { 
		return destroyed;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	public void update() {

	}

	
}
