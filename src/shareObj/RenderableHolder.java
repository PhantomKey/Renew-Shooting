package shareObj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	
	public static AudioClip shoot1;
	public static AudioClip d1;
	public static Image backgroundspace ;
	public static Image backgroundgame ;
	public static Image spaceship ;
	public static Image boss1 ;
	public static Image boss2 ;
	public static Image boss3 ;
	public static Image enermy ;
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
	
	
	static {
		loadResources();
	}

	public static void loadResources() {
		System.out.println("load");
		shoot1 = new AudioClip(ClassLoader.getSystemResource("2.wav").toString());
		d1 = new AudioClip(ClassLoader.getSystemResource("d1.wav").toString());
		//shoot3 = new AudioClip(ClassLoader.getSystemResource("source/gunshot3.wav").toString());
		backgroundspace = new Image(ClassLoader.getSystemResource("bggame.png").toString());
		//backgroundgame = new Image("bggame.gif");
		spaceship = new Image(ClassLoader.getSystemResource("3.png").toString());
		//boss1 = new Image("alien1.png");
		//boss2 = new Image(ClassLoader.getSystemResource("alien2.png").toString());
		//boss3 = new Image("alien3.png");
		//enermy = new Image("enermy.png");
		playerBullet = new Image(ClassLoader.getSystemResource("1.png").toString());
		Instruction = new Image(ClassLoader.getSystemResource("Instruction.png").toString());
		star = new Image(ClassLoader.getSystemResource("star.gif").toString(),100,100,false,false);
		enermy1 = new Image(ClassLoader.getSystemResource("10.png").toString());
		Life= new Image(ClassLoader.getSystemResource("FullLife.png").toString());
		Power = new Image(ClassLoader.getSystemResource("PowerUp1.png").toString());
		Regen = new Image(ClassLoader.getSystemResource("PowerUp3.png").toString());
		Sp = new Image(ClassLoader.getSystemResource("PowerUp6.png").toString());
		SpGate = new Image(ClassLoader.getSystemResource("wrench.png").toString());
		BMG = new  AudioClip(ClassLoader.getSystemResource("3.wav").toString());
		Bom = new AudioClip(ClassLoader.getSystemResource("explosion-1.wav").toString());
		blast = new Image(ClassLoader.getSystemResource("bigbombx.gif").toString());
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
		Collections.sort(entities,comparator);
	}
	
	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (entities.get(i).isDestroyed()) {
				entities.remove(i);
			}
		}
	}
	
	public List<IRenderable> getEntities(){
		return entities;
	}
}
