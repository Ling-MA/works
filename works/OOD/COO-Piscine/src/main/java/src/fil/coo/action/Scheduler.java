package fil.coo.action;

import java.util.LinkedList;
import java.util.List;

import fil.coo.action.Action.Status;

public abstract class Scheduler extends Action {

	List<Action> actions = new LinkedList<Action>();

    
	public Scheduler() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public void addAction(Action action) {
		if (action.status == Status.IN_PROGRESS) {
			// print ou esception
			return;
		} else
			this.actions.add(action);
	}

}
