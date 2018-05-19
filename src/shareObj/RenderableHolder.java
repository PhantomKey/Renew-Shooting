package shareObj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();
	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	//////////////////////// Resource//////////////////////
	//////////////////////////////////////////////////////

	static {
		loadResources();
	}

	public static void loadResources() {

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
