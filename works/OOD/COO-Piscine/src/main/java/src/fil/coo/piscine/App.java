package fil.coo.piscine;

import fil.coo.action.F_scheduler;

import fil.coo.action.Action.Status;;

public class App {
	public static void main(String[] args) {
		BasketPool baskets = new BasketPool(1);
		CubiclePool cubicles = new CubiclePool(3);
		F_scheduler f = new F_scheduler();
		f.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		f.addAction(new Swimmer("Lois",baskets, cubicles, 2, 10, 4));
		//f.addAction(new Swimmer("Maé",baskets, cubicles, 10, 18, 10));
		//f.addAction(new Swimmer("Angé",baskets, cubicles, 3, 7, 5));
		//f.addAction(new Swimmer("Louison",baskets, cubicles, 18, 3, 3));
		//f.addAction(new Swimmer("Charlie",baskets, cubicles, 3, 6, 10));
		//f.addAction(new Swimmer("Alexis",baskets, cubicles, 6, 5, 7));
		int nbs = 0;

		while (f.doStep() != Status.FINISHED) {
			nbs++;
		}

		System.out.println("Finished in " + nbs + "steps");
	}
}
