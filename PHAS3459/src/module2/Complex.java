package module2;

public class Complex {
	
	// member variables
	double x,y;
	
	//Constructor for complex numbers
	public Complex(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	
	public double real() {
		return (this.x);
	}
	
	public double imag() {
		return (this.y);
	}
	
	public double modulus() {
		return (Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2)));
	}
	
	
}
