package fil.coo.piscine;

import fil.coo.action.F_scheduler;

public class TakeResourceAction<T extends Resource> extends ResourceAction{


	public TakeResourceAction(String name,ResourceUser ru, ResourcePool rp) {
		super(name,ru, rp);
		
	}

	@Override
	public Status doStep() {
		
		 T resource =(T) rp.provideResource();
		 ru.setResource(resource);
		 ru.getResource();
		if(resource!=null){
		System.out.println(name+"'s turn");
		System.out.println(" "+name+" trying to take resource from pool "+resource.getClass().getSimpleName()+"........Success");}
		else{
		System.out.println(name+"'s turn");
		System.out.println(" "+name+" trying to take resource from pool "+resource.getClass().getSimpleName()+"........Failed");
		}
	    this.status=Status.FINISHED;
		return status;
	}
  public static void main(String args[]){
	  ResourceUser<Basket> ru1=new ResourceUser<Basket>();
	  ResourcePool rp=new BasketPool(1);
	  ResourceAction ba=new TakeResourceAction("minmin",ru1,rp);
	  ResourceAction bb=new TakeResourceAction("mimi",ru1,rp);
	  F_scheduler f=new F_scheduler();
	  f.addAction(ba);
	  f.addAction(bb);
	  while(f.getStatus()!=Status.FINISHED){
		  f.doStep();
	  }
  }
	


}
/*
 *
 *public Status doStep() {
	    T resource =(T) rp.provideResource();
	    ru.setResource(resource);
		return status;
	}
*/