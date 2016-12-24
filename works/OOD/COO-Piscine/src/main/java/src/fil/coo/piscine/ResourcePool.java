package fil.coo.piscine;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ResourcePool < T extends Resource>  {

protected LinkedList<T> resource;
protected LinkedList<T> nresource;
int nb;
public ResourcePool(int nb){
this.resource=new LinkedList<T>();
this.nb=nb;
for(int i=0;i<nb;i++){
	resource.add(i,creatResource());
}

}
protected abstract T creatResource();

public T provideResource() {
	if(resource.isEmpty()){
		System.out.println("failed");
		return null;
	}else{
		T res=resource.pop();
		nresource.add(res);
		return res;
	}
	
	
}	
	
	
	/*if(resource.size()==0){
		//throw new NoSuchElementException();
		//throws NoSuchElementException
	}else{
	T res=resource.get(0);
	nresource.add(res);
	resource.remove(0);
	return res;}
}*/
public void getBackResource(T res) throws IllegalArgumentException{
	if(!nresource.contains(res)){
		throw new IllegalArgumentException();
		
	}
	nresource.remove(res);
	resource.add(res);
}
}
