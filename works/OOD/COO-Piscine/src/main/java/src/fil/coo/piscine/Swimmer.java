package fil.coo.piscine;

import fil.coo.action.Foreseeable;
import fil.coo.action.S_scheduler;
import fil.coo.action.Scheduler;

public class Swimmer extends S_scheduler{
String name;
BasketPool bp;
CubiclePool cp;
int t_undr;
int t_swim; 
int t_dr;
ResourceUser ru =new ResourceUser();
public Swimmer(String name, BasketPool bp,CubiclePool cp,int t_undr,int t_swim, int t_dr){
	this.name=name;
	this.bp=bp;
	this.cp=cp;
	this.t_undr=t_undr;
	this.t_swim=t_swim;
	this.t_dr=t_dr;
	ResourceUser<Basket> busr=new ResourceUser<Basket>();
	ResourceUser<Cubicle>cusr=new ResourceUser<Cubicle>();
	this.addAction(new TakeResourceAction(name,busr, bp));//take backet ressource
	
	this.addAction(new TakeResourceAction(name,cusr,cp));//take cubicle ressource

	this.addAction(new Foreseeable(name,"undressing",t_undr));//get undressed
	this.addAction(new FreeResourceAction(name,cusr,cp));//free cubicle
	
	this.addAction(new Foreseeable(name,"swim",t_swim));//swim
	this.addAction(new TakeResourceAction(name,cusr,cp));//take cubicle ressource
	
	this.addAction(new Foreseeable(name,"dressing",t_dr));//get dressed
	this.addAction(new FreeResourceAction(name,cusr,cp));//free cubicle
	
	this.addAction(new FreeResourceAction(name,busr,bp));//free basket

}
public void march(){
	 while(this.doStep()!= Status.FINISHED);
}

public static void main(String []args){
	BasketPool baskets=new BasketPool(6);
    CubiclePool cubicles=new CubiclePool(3);
	Swimmer g=new Swimmer("dd",baskets,cubicles,6,2,4);
   
	g.march();
	
}


}