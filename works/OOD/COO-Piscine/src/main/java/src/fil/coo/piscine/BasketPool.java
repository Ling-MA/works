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
	public Basket provideResource() throws NoSuchElementException{
		
		Basket res=resource.get(0);
		
		return res;
	}
	public void getBackResource(Basket res) throws IllegalArgumentException{
		
	}
}
