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
		return "("+x+" + "+y+"i,)";
	}

	public static Complex setFromModulusAngle(double mag, double ang){
		double im = mag * Math.sin(ang);
		double re = mag * Math.cos(ang);
		Complex cm = new Complex (re,im);
		return cm;
	}

	public static Complex add(Complex a, Complex b){
		Complex sum = new Complex (a.x + b.x, a.y + b.y);
		return sum;
	}

	public static Complex subtract (Complex a, Complex b){
		Complex s = new Complex (a.x - b.x , a.y - b.y);
		return s;
	}

	public static Complex multiply (Complex a, Complex b){
		Complex m = new Complex (a.x * b.x - a.y*b.y , a.x * b.y + a.y*b.x);
		return m;
	}
	
	public static Complex divide (Complex a, Complex b){
		Complex d = new Complex ((a.x*b.x + a.y*b.y)/(b.x*b.x+b.y*b.y),(a.y*b.x-a.x*b.y)/(b.x*b.x+b.y*b.y));
		return d;
		
	}
	
	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex(0,0);
	static Complex I = new Complex (0,1);


		public static void main(String[] args) {
			Complex cn = new Complex (2,3);
			Complex cn2 = new Complex (6,7);
			System.out.println(divide(cn,cn2));
		}


	}
