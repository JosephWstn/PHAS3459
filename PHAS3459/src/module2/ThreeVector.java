package module2;
import java.lang.Math.*; //maths functions

public class ThreeVector {

	double x,y,z; 

	public ThreeVector() {};
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double magnitude() {

		double m = x*x + y*y + z*z;
		return Math.sqrt(m);
	}

	public ThreeVector unitVector() {
		ThreeVector tv = new ThreeVector();
		
		ThreeVector UV = ThreeVector(x,y,z) / tv.magnitude(x,y,z);

	}

	public static void main(String[] args) {
		ThreeVector tv = new ThreeVector(1.0,2.0,3.0);
		
		double mag = tv.magnitude();
		System.out.println(mag);

	}

}
