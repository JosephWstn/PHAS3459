package module6;

/*
 * A theory that returns x^n
 */
public class PowerLawTheory implements Theory{

	//member variables
	double n, x;
	
	//Constructor to assign n 
	PowerLawTheory(double n){
		this.n = n;
	}
	 
	/*
	 * Using the theory interface
	 * method to return x^n
	 */
	public double y(double x) {
		return Math.pow(x,n);
	}
	
	//to print out y=x^n
	public String toString() {
		return ("y = x^" + this.n);
	}

}
