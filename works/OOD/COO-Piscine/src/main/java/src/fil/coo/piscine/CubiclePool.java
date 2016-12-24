package fil.coo.piscine;

import java.util.NoSuchElementException;

public class CubiclePool extends ResourcePool<Cubicle>{

	public CubiclePool(int nb) {
		super(nb);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Cubicle creatResource() {
		// TODO Auto-generated method stub
		return new Cubicle();
	}
	public Cubicle provideResource() throws NoSuchElementException{
		
		Cubicle res=resource.get(0);
		
		return res;
	}
	public void getBackResource(Cubicle res) throws IllegalArgumentException{
		
	}
}
