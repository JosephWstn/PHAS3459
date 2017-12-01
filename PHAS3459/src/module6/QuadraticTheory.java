package module6;

public class QuadraticTheory implements Theory{

	double a, b, c, x;
	
	QuadraticTheory(double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double y (double x) {
		return a * Math.pow(x,2) + b*x + c;
	}
	
	public String toString() {
		return ("y= "+this.a + "x^2 + " + this.b + "x + " + this.c );
	}
	
}
