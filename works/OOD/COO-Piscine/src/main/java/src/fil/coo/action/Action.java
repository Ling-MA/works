package fil.coo.action;

public abstract class Action {

	public enum Status {
		READY, IN_PROGRESS, FINISHED
	}

	protected Status status = Status.READY;
	protected int sum = 0;

	public abstract Status doStep();

	public Status getStatus() {
		return status;
	}
	

}
