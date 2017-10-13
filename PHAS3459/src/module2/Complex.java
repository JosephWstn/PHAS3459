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
	
	public double angle (){
		return Math.atan(this.y/this.x);
	}
	
	public Complex conjugate(){
		Complex con = new Complex (x , -y);
		return con;
	}
	
	public Complex normalised(){
		Complex norm = new Complex (x/this.modulus(), y/this.modulus());
		return norm;
	}
	
	public boolean equals (Complex c){
		boolean eq = (c.x == x) && (c.y == y);
		return eq;
	}
	
	public String toString(){ //converts my "object" to a string. idk what the fuck my object is
		return "("+x+","+y+"i,)";
	}

	public static Complex setFromModulusAngle(double mag, double ang){
		double im = mag * Math.sin(ang);
		double re = mag * Math.cos(ang);
		Complex cm = new Complex (re,im);
		return cm;
	}
	
	public static void main(String[] args) {
		System.out.println(setFromModulusAngle(5,0.931596));
	}

}
