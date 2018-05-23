package shareObj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;

	public static AudioClip shoot1;
	public static AudioClip d1;
	public static Image backgroundspace;
	public static Image backgroundgame;
	public static Image spaceship;
	public static Image main;
	public static Image enermy;
	public static Image playerBullet;
	public static Image Instruction;
	public static Image star;
	public static Image enermy1;
	public static Image Life;
	public static Image Power;
	public static Image Regen;
	public static Image Sp;
	public static Image SpGate;
	public static AudioClip BMG;
	public static AudioClip Bom;
	public static Image blast;
	public static AudioClip take;
	public static Image enermy2;
	public static Font point;
	public static Image end;
	public static AudioClip endSong;
	public static Image story;
	

	static {
		loadResources();
	}

	public static void loadResources() {
		System.out.println("load");
		shoot1 = new AudioClip(ClassLoader.getSystemResource("2.wav").toString());
		d1 = new AudioClip(ClassLoader.getSystemResource("d1.wav").toString());
		backgroundspace = new Image(ClassLoader.getSystemResource("bggame.png").toString());
		spaceship = new Image(ClassLoader.getSystemResource("3.png").toString());
		playerBullet = new Image(ClassLoader.getSystemResource("1.png").toString());
		Instruction = new Image(ClassLoader.getSystemResource("Instruction.png").toString());
		star = new Image(ClassLoader.getSystemResource("star.gif").toString(), 100, 100, false, false);
		enermy1 = new Image(ClassLoader.getSystemResource("10.png").toString());
		enermy2 = new Image(ClassLoader.getSystemResource("11.png").toString());
		Life = new Image(ClassLoader.getSystemResource("FullLife.png").toString());
		Power = new Image(ClassLoader.getSystemResource("PowerUp1.png").toString());
		Regen = new Image(ClassLoader.getSystemResource("PowerUp3.png").toString());
		Sp = new Image(ClassLoader.getSystemResource("PowerUp6.png").toString());
		SpGate = new Image(ClassLoader.getSystemResource("wrench.png").toString());
		BMG = new AudioClip(ClassLoader.getSystemResource("3.wav").toString());
		Bom = new AudioClip(ClassLoader.getSystemResource("explosion-1.wav").toString());
		blast = new Image(ClassLoader.getSystemResource("bigbombx.gif").toString());
		take = new AudioClip(ClassLoader.getSystemResource("powerUp2.wav").toString());
		point = Font.loadFont(ClassLoader.getSystemResource("Fipps-Regular.otf").toString(), 15);
		end = new Image(ClassLoader.getSystemResource("gameoverfinal.png").toString());
		endSong = new AudioClip(ClassLoader.getSystemResource("1.wav").toString());
		main = new Image(ClassLoader.getSystemResource("mainmenu.png").toString(),650,650,false,false);
		story = new Image(ClassLoader.getSystemResource("story.png").toString());
		
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public void add(IRenderable entity) {
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
