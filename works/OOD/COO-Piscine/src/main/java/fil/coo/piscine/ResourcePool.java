package fil.coo.piscine;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool<T extends Resource> {

	protected LinkedList<T> resource;
	protected LinkedList<T> nresource;
	int nb;

	public ResourcePool(int nb) {
		this.resource = new LinkedList<T>();
		this.nresource = new LinkedList<T>();
		this.nb = nb;
		for (int i = 0; i < nb; i++) {
			resource.add(i, creatResource());
		}

	}

	protected abstract T creatResource();

	public T provideResource() {
		if (resource.isEmpty()) {
			return null;
		} else {
			T res = resource.pop();
			nresource.add(res);
			return res;
		}

	}

	public static void main(String args[]) {
		BasketPool baskets = new BasketPool(6);
		Basket m = baskets.provideResource();
		System.out.println(m);
	}

	public void getBackResource(T res) throws IllegalArgumentException {
		if (!nresource.contains(res)) {
			throw new IllegalArgumentException();

		}
		nresource.remove(res);
		resource.add(res);
	}
}
