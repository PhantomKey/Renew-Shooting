package Scene;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import shareObj.IRenderable;
import shareObj.RenderableHolder;

public class Background implements IRenderable {
	//private static Image star = RenderableHolder.star;
	private static Image background = RenderableHolder.backgroundspace;
	private static double moveY;
	private static double ScrollY;


	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		setMoveY(1.5);
		ScrollY -= getMoveY();
			gc.drawImage(background, 0 ,-ScrollY, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
			gc.drawImage(background, 0,gc.getCanvas().getWidth()-ScrollY, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
			if (ScrollY<0) {
				ScrollY += 650;
			}
	}
	@Override
	public boolean isDestroyed() {
		return false;
	}

	@Override
	public boolean visible() {
		return true;
	}

	public static double getMoveY() {
		return moveY;
	}

	public static void setMoveY(double moveY) {
		Background.moveY = moveY;
	}

	public static double getScrollY() {
		return ScrollY;
	}

	public void setScrollY(double ScrollY) {
		this.ScrollY = ScrollY;
	}
}
