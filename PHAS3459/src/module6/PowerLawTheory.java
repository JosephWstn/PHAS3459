package module6;

public class PowerLawTheory implements Theory{

	double n, x;
	PowerLawTheory(double x, double n){
		this.x = x;
		this.n = n;
	}
	
	
	public double y(double x) {
		return Math.pow(x,n);
	}
	
	public String toString() {
		return ("x^" + this.n);
	}

}
