package fil.coo.action;

import java.util.List;

import fil.coo.action.Action.Status;

public class S_scheduler extends Scheduler {

	public S_scheduler() {
		super();

	}

	@Override
	public Status doStep() {

		if (this.status == Status.FINISHED) {
			System.out.println("error");
			return status;
		} else if (this.actions.isEmpty()) {

			System.out.println("vide");
			return null;
		} else {
			this.status = Status.IN_PROGRESS;

			if (this.actions.get(0).doStep().equals(Status.FINISHED)) {
				this.actions.remove(0);

			}
			if (this.actions.isEmpty()) {
				this.status = Status.FINISHED;

			}

		}
		return this.status;
	}

}
