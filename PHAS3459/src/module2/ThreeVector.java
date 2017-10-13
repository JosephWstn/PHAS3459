package module2;
import java.lang.Math.*; //maths functions
// variables lower case
public class ThreeVector {

	double x,y,z; //member variables

	//constructor ThreeVector
	public ThreeVector(double x, double y, double z) {
		this.x = x; 
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

	public double scalarProduct(ThreeVector a){
		double SP2 = scalarProduct(this,a);
		return SP2;
	}

	public ThreeVector vectorProduct(ThreeVector a){
		ThreeVector VP2 = vectorProduct(this,a);
		return VP2;
	}


	public ThreeVector add (ThreeVector a){
		ThreeVector a2 = add(this,a); 
		return a2;
	}

	public double angle(ThreeVector a) {
		double ang2 = angle(this,a);
		return ang2;
	}
}


