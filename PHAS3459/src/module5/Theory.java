package module5;
import java.lang.Math;

public class Theory {

	double n;
	
	
	public Theory(double n){
		this.n= n;
	}
	
	public double y(double x){ 
		return Math.pow(x,this.n);
	}


}

