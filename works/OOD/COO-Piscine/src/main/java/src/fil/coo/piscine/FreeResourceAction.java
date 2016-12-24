package fil.coo.piscine;

public class FreeResourceAction extends ResourceAction{

	public FreeResourceAction(String name,ResourceUser ru, ResourcePool rp) {
		super(name,ru, rp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Status doStep() {
	    Resource res = ru.getResource();
		rp.getBackResource(res);
		System.out.println(name+"'s turn");
		System.out.println(" freeing resource to from pool "+res.getClass().getSimpleName());
		this.status=Status.FINISHED;
		return status;
	}

}
