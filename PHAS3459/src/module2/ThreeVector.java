package module2;
import java.lang.Math.*; //maths functions

public class ThreeVector {

	double x,y,z; 

	public ThreeVector() {}; //this is a constructor apparently. what the fuck is that.
	public ThreeVector(double x, double y, double z) {
		this.x = x; //no fucking clue what these do
		this.y = y;
		this.z = z;
	}


	public double magnitude() { //find the magnitude

		double m = x*x + y*y + z*z;
		return Math.sqrt(m);
	}


	public ThreeVector unitVector() { //find unit vector of a vector
		ThreeVector V = new ThreeVector(x, y, z);
		ThreeVector UV = new ThreeVector(x/V.magnitude(), y/V.magnitude(), z/V.magnitude() ); //yaknow mathsy stuff
		return UV;
	}

	public String toString(){ //converts my "object" to a string. idk what the fuck my object is
		return "("+x+","+y+","+z+")";
	}

//THIS BIT 
	static double scalarProduct(ThreeVector A, ThreeVector B){

		
		double E = (A.x* B.x + A.y *B.y + A.z * B.z);
		return E;
	}
	
	 
	public static void main(String[] args) {

		ThreeVector tv = new ThreeVector(1.0,2.0,3.0); //calling a vector (1,2,3)
		ThreeVector tvt = new ThreeVector(4.0,5.0,6.0);
		double mag = tv.magnitude(); //do find magnitude of (1,2,3)
		ThreeVector unitv = tv.unitVector(); // find unitvector of (1,2,3)
		
		double scalar = scalarProduct(tv,tvt);
		
		//System.out.print(unitv); //print dat shit
		//System.out.println(mag);
		//System.out.println(tv);
		System.out.println(scalar);
	}

}
