package module6;

/*
 * A theory that returns ax^2 + bx + c
 */
public class QuadraticTheory implements Theory{
	
	//member variables a, b, c and x
	double a, b, c, x;
	
	//constructor of QuadraticTheory
	QuadraticTheory(double a, double b, double c){
		this.a = a; 
		this.b = b;
		this.c = c;
	}
	
	//returning ax^2 + bx + c
	public double y (double x) {
		return a * Math.pow(x,2) + b*x + c;
	}
	
	//print out a quadratic equation
	public String toString() {
		return ("y= "+this.a + "x^2 + " + this.b + "x + " + this.c );
	}
	
}
