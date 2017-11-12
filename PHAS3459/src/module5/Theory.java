package module5;
import java.lang.Math;

public class Theory {

	double n;

	//Constructor to set n 
	public Theory(double n){
		this.n= n;
	}

	//equation y=x^n
	public double y(double x){ 
		return Math.pow(x,this.n);
	}
}