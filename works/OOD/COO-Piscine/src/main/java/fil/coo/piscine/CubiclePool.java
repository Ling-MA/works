package fil.coo.piscine;

import java.util.NoSuchElementException;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nb) {
		super(nb);

	}

	@Override
	protected Cubicle creatResource() {

		return new Cubicle();
	}

}
