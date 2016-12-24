package fil.coo.action;

import java.util.List;

import fil.coo.action.Action.Status;

public class S_scheduler extends Scheduler {

	public S_scheduler() {
		super();

	}

	
	 public static void main (String [] args){ 
	  Foreseeable b=new Foreseeable("dd","sleep",5);
	  S_scheduler f = new S_scheduler();
	 
	  f.addAction(new Foreseeable("dd","take",9));
	 
	  f.addAction(b); // for (int i = 0; i <15; i++) { //f.doStep(); //}
	  f.addAction(new Foreseeable("dd","swim",8));
	  while(f.doStep()!= Status.FINISHED);
	 
	  }
	 
	@Override
	public Status doStep() {
		//System.out.println(status.name());
		if (this.status == Status.FINISHED) {
			// error
			System.out.println("error");
			return status;
		} else if (this.actions.isEmpty()) {
			// exception non itialiser
			System.out.println("vide");
			return null;
		} else {
			this.status = Status.IN_PROGRESS;
			
			if (this.actions.get(0).doStep().equals(Status.FINISHED)) {
				this.actions.remove(0);
				
			   //System.out.println(status.name());
				//System.out.println("This action is finished and is removed.");//once
			}
			if (this.actions.isEmpty()) {
				this.status = Status.FINISHED;
				

			}

		}
		return this.status;
	}

}
