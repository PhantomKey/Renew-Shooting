package Scene;

import javafx.scene.canvas.GraphicsContext;
import com.sun.javafx.tk.FontLoader;
import com.sun.javafx.tk.Toolkit;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import shareObj.IRenderable;
import shareObj.RenderableHolder;
import Logic.GameLogic;

public class HUD implements IRenderable {
	private Image heart = RenderableHolder.Life;
	private Image SP = RenderableHolder.SpGate;
	private int posX = 5;
	private int posY = 10;
	private static final Font POINT = RenderableHolder.point;

	public HUD() {
		System.out.println(GameLogic.p.getHealth()); 
	}

	@Override
	public int getZ() {
		return 100;

	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.RED);
		gc.setFont(POINT);
		gc.fillText("Point : "+GameLogic.score.getScore() , 500, 30);
		for (int i = 0; i < GameLogic.p.getHealth(); i++) {
			gc.drawImage(heart, 10 + posX, posY);
			posX += 25;
		}
		posX = 10;
		for (int i = 0; i < GameLogic.p.getSpacialAction(); i++) {
			gc.drawImage(SP, 10 + posX, posY + 30);
			posX += 20;

		}
		posX = 10;

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
