package module6;

public class PowerLawTheory implements Theory{

	double n, x;
	PowerLawTheory(double n){
		this.n = n;
	}
	
	
	public double y(double x) {
		return Math.pow(x,n);
	}
	
	public String toString() {
		return ("y = x^" + this.n);
	}

}
