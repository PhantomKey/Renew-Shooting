package Scene;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import shareObj.IRenderable;
import shareObj.RenderableHolder;

public class Background implements IRenderable {
	private static Image background = RenderableHolder.backgroundspace;
	private static double moveY;
	private static double scrollY;


	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(background, 0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		System.out.println("d");

	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visible() {
		// TODO Auto-generated method stub
		return true;
	}
}
