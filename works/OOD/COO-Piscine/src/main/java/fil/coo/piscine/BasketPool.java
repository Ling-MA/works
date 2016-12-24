package fil.coo.piscine;

import java.util.NoSuchElementException;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nb) {
		super(nb);
	}

	@Override
	protected Basket creatResource() {
		return new Basket();
	}

}
