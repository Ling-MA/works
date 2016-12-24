package fil.coo.piscine;

import fil.coo.action.F_scheduler;

public class TakeResourceAction<T extends Resource> extends ResourceAction {

	public TakeResourceAction(String name, ResourceUser ru, ResourcePool rp) {
		super(name, ru, rp);

	}

	@Override
	public Status doStep() {

		T resource = (T) rp.provideResource();
		ru.setResource(resource);
		ru.getResource();
		if (resource != null) {
			System.out.println(name + "'s turn");
			System.out.println(" " + name + " trying to take resource from pool " + resource.getClass().getSimpleName()
					+ "........Success");
			this.status = Status.FINISHED;
			return status;
		} else {
			System.out.println(name + "'s turn");
			System.out.println(" " + name + " trying to take resource from pool........Failed");
			this.status = Status.READY;
			return status;
		}

	}

}
