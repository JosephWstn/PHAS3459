package module3;

public class Complex {

	// member variables
	double r,i;

	//Constructor for complex numbers r= real, i=imaginary
	public Complex(double r, double i) {
		this.r = r; 
		this.i = i;
	}

	//return real component
	public double real() {
		return (this.r);
	}

	//return imaginary component
	public double imag() {
		return (this.i);
	}

	//return modulus of complex number
	public double modulus() {
		//square root of the sum of the squares
		return (Math.sqrt(Math.pow(this.r,2) + Math.pow(this.i,2)));
	}

	//find the argument of a complex number
	public double angle (){
		return Math.atan(this.i/this.r);
	}

	//find complex conjugate of complex number
	public Complex conjugate(){
		//make imaginary part negative
		Complex con = new Complex (r , -i);
		return con;
	}

	//normalise the complex number
	public Complex normalised() throws Exception{
		//divide each component by the modulus
		if (this.r==0 && this.i ==0) {
			throw new Exception("Trying to divide by zero");
		}
		Complex norm = new Complex (r/this.modulus(), i/this.modulus());
		return norm;
	}

	//return true if two complex numbers are the same
	public boolean equals (Complex c){
		boolean eq = (c.r == r) && (c.i == i);
		return eq;
	}

	// returns in the form of Re + Im*i
	public String toString(){ 
		return "("+r+", + " +i+"i)";
	}


	//find the complex number corresponding to a given magnitude and argument
	public static Complex setFromModulusAngle(double mag, double ang){
		//find real and imaginary parts seperately
		double im = mag * Math.sin(ang);
		double re = mag * Math.cos(ang);
		Complex cm = new Complex (re,im);
		return cm;
	}


	// using static methods with arguments

	//static method adding complex numbers
	public static Complex add(Complex a, Complex b){
		//add corresponding Re and Im parts
		Complex sum = new Complex (a.r + b.r, a.i + b.i);
		return sum;
	}

	//subtract two complex numbers
	public static Complex subtract (Complex a, Complex b){
		Complex s = new Complex (a.r - b.r , a.i - b.i);
		return s;
	}

	//multiply two complex numbers
	public static Complex multiply (Complex a, Complex b){
		//input the Re and Im parts of the multiplied out complex numbers
		Complex m = new Complex (a.r * b.r - a.i*b.i , a.r * b.i + a.i*b.r);
		return m;
	}

	//divide two complex numbers
	public static Complex divide (Complex a, Complex b) throws Exception{
		//Re and Im parts after rationalising the denominator
		if (b.r==0 && b.i ==0) {
			throw new Exception("Trying to divide by zero");
		}
		Complex d = new Complex ((a.r*b.r + a.i*b.i)/(b.r*b.r+b.i*b.i),(a.i*b.r-a.r*b.i)/(b.r*b.r+b.i*b.i));
		return d;

	}

	// define one, zero, and i
	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex(0,0);
	static Complex I = new Complex (0,1);
}
