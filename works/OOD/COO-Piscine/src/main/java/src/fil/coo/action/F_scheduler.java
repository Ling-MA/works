package fil.coo.action;

import java.util.List;

import fil.coo.action.Action.Status;

public class F_scheduler extends Scheduler {
	
	protected int m=0;//index of action 
	public F_scheduler() {
		super();
        
	}

	@Override
	public Status doStep() {
		int i = actions.size();
		//System.out.println(i);
		
		if (this.status.equals(Status.FINISHED)){
			//error fini
			return null;
		}
		Action k=this.actions.get(m);
			
		if(this.actions.isEmpty()){ System.out.println("vide");}
		else{
			
			if(k.status!=Status.FINISHED){
			k.doStep();
			//System.out.println(status.name());//once
			this.status=Status.IN_PROGRESS;
			
			}
			else {//error
				//System.out.println("action fini");//once
				return null;
			}
			//System.out.println("hi "+k.status.name());//once
			//System.out.println("hi 3 "+this.actions.get(m).status);//once
			if (k.status==Status.FINISHED){
				this.actions.remove(m);
				//System.out.println("This action is finished");//once 
				m--;
				i--;
			}
		}
			m++;
			if(m>=i){
		    	//actions.removeAll(actions);
		    	//this.status=Status.FINISHED;
                m=0;
				//this.status=Status.IN_PROGRESS;
				//System.out.println(status.name());
				
			}
			
		
			
			if (this.actions.isEmpty() && this.status.equals(Status.IN_PROGRESS)){
				this.status = Status.FINISHED;
				//System.out.println("all the actions est finished");//once
			}
		
		    return status;
		
	}

	public static void main(String[] args) {
		Foreseeable b = new Foreseeable("dd","cry",5);
		F_scheduler f = new F_scheduler();

		f.addAction(new Foreseeable("dd","laugh",9));

		f.addAction(b);
	
		while (f.doStep() != Status.FINISHED);
			

	}
	
	}


