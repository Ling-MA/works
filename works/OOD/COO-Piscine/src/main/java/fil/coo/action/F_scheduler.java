package fil.coo.action;

import java.util.List;

import fil.coo.action.Action.Status;

public class F_scheduler extends Scheduler {

	protected int m = 0;// index of action

	public F_scheduler() {
		super();

	}

	@Override
	public Status doStep() {
		int i = actions.size();

		if (this.status.equals(Status.FINISHED)) {
			System.out.println("error");
			return null;
		}
		Action k = this.actions.get(m);

		if (this.actions.isEmpty()) {
			System.out.println("vide");
		} else {

			if (k.status != Status.FINISHED) {
				k.doStep();
				this.status = Status.IN_PROGRESS;

			} else {

				return null;
			}

			if (k.status == Status.FINISHED) {
				this.actions.remove(m);

				m--;
				i--;
			}
		}
		m++;
		if (m >= i) {

			m = 0;

		}

		if (this.actions.isEmpty() && this.status.equals(Status.IN_PROGRESS)) {
			this.status = Status.FINISHED;

		}

		return status;

	}

}
