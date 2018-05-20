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
	
	public static AudioClip shoot1 ;
	public static AudioClip shoot2 ;
	public static AudioClip shoot3 ;
	public static Image backgroundspace ;
	public static Image backgroundgame ;
	public static Image spaceship ;
	public static Image boss1 ;
	public static Image boss2 ;
	public static Image boss3 ;
	public static Image enermy ;
	public static Image playerBullet;
	
	static {
		loadResources();
	}

	public static void loadResources() {
		System.out.println("load");
		//shoot1 = new AudioClip(ClassLoader.getSystemResource("source/gunshot1.wav").toString());
		//shoot2 = new AudioClip(ClassLoader.getSystemResource("source/gunshot2.wav").toString());
		//shoot3 = new AudioClip(ClassLoader.getSystemResource("source/gunshot3.wav").toString());
		backgroundspace = new Image(ClassLoader.getSystemResource("bggame.gif").toString());
		//backgroundgame = new Image("bggame.gif");
		spaceship = new Image(ClassLoader.getSystemResource("spaceship.png").toString(),17.4375,50,false,false
				);
		//boss1 = new Image("alien1.png");
		//boss2 = new Image(ClassLoader.getSystemResource("alien2.png").toString());
		//boss3 = new Image("alien3.png");
		//enermy = new Image("enermy.png");
		playerBullet = new Image(ClassLoader.getSystemResource("bullet1.png").toString());
	
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
