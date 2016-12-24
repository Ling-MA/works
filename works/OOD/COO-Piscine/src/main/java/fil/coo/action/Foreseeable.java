
package fil.coo.action;

public class Foreseeable extends Action {

	protected int sum;
	protected int nb;
	protected String movement;
	protected String name;

	public Foreseeable(String name, String movement, int nb) {
		this.nb = nb;
		this.movement = movement;
		this.name = name;
	}

	public Status foresee(int l) {
		Foreseeable f = new Foreseeable(name, movement, l);
		while (this.status == Status.IN_PROGRESS) {
			status = f.doStep();

		}

		return this.status;
	}

	public Status doStep() {
		if (this.status == Status.FINISHED) {

		} else {

			sum++;
			System.out.println(name + "'s turn");
			System.out.println(" " + movement + " (" + sum + "/" + nb + ") ");

			if (sum == nb) {
				this.status = Status.FINISHED;
			} else {
				this.status = Status.IN_PROGRESS;
			}
		}

		return this.status;
	}

}
