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
		ThreeVector UV = new ThreeVector(x/this.magnitude(), y/this.magnitude(), z/this.magnitude() ); //yaknow mathsy stuff
		return UV;
	}

	public String toString(){ //converts my "object" to a string. idk what the fuck my object is
		return "("+x+","+y+","+z+")";
	}
	
	
	static double scalarProduct(ThreeVector A, ThreeVector B){
		double SP = (A.x* B.x + A.y *B.y + A.z * B.z);
		return SP;
	}
	
	
	static ThreeVector vectorProduct(ThreeVector A, ThreeVector B) {
		double NX = A.y * B.z - A.z * B.y;
		double NY = A.x * B.z - A.z * B.x;
		double NZ = A.x * B.y - A.y * B.x;
		ThreeVector VP = new ThreeVector (NX , -NY, NZ);
		return VP;
		
	}
	
	static ThreeVector add (ThreeVector A, ThreeVector B) {
		ThreeVector a = new ThreeVector (A.x + B.x, A.y + B.y, A.z + B.z);
		return a;
		
	}
	
	static double angle (ThreeVector A, ThreeVector B) {
		double cosang = scalarProduct(A,B) / (A.magnitude() * B.magnitude());
		return Math.acos(cosang);
	}
	
	public double scalarProduct2(ThreeVector A, ThreeVector B){
		double SP2 = scalarProduct(A,B);
		return SP2;
	}
	 
	public ThreeVector vectorProduct2(ThreeVector A, ThreeVector B){
		ThreeVector VP2 = vectorProduct(A,B);
		return VP2;
	}
	
	
	public ThreeVector add2 (ThreeVector A, ThreeVector B){
		ThreeVector a2 = add(A,B); 
		return a2;
	}
	
	public double angle2(ThreeVector A, ThreeVector B) {
		double ang2 = angle(A,B);
		return ang2;
	}
	
	public static void main(String[] args) {

		ThreeVector tv = new ThreeVector(1.0,2.0,3.0); //calling a vector (1,2,3)
		ThreeVector tvt = new ThreeVector(4.0,5.0,6.0);
		
		double mag = tv.magnitude(); //do find magnitude of (1,2,3)
		ThreeVector unitv = tv.unitVector(); // find unitvector of (1,2,3)
		double scalar = scalarProduct(tv,tvt);
		ThreeVector cross = vectorProduct(tv,tvt);
		ThreeVector addition = add(tv,tvt);
		double angle = angle(tv,tvt);
		

		System.out.println(angle);
	}

}
