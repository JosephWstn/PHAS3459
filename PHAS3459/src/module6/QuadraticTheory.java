package module6;

public class QuadraticTheory implements Theory{

	double a, b, c, x;
	
	QuadraticTheory(double x){
		this.x = x;
	}
	
	public double y (double x) {
		return a * Math.pow(x,2) + b*x + c;
	}
	
	public String toString() {
		return (this.a + "x^2 + " + this.b + "x + " + this.c );
	}
	
}
