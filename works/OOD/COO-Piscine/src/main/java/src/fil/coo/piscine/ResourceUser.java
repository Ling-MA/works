package fil.coo.piscine;

public class ResourceUser<T extends Resource> {
protected T resource;

public T getResource() {
	return resource;
}

public void setResource(T resource) {
	this.resource = resource;
}
public void resetResource(){
	this.resource=null;
}


}
