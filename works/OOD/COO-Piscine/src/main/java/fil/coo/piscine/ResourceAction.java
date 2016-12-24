package fil.coo.piscine;

import fil.coo.action.Action;

public abstract class ResourceAction<T extends Resource> extends Action {
	protected ResourceUser<T> ru;
	protected ResourcePool<T> rp;
	protected String name;

	public ResourceAction(String name, ResourceUser<T> ru, ResourcePool<T> rp) {
		this.name = name;
		this.rp = rp;
		this.ru = ru;
	}

}
