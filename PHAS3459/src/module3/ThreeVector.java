package module3;
import java.lang.Math.*; //maths functions
public class ThreeVector {

	//member variables
	double x,y,z; 

	//constructor ThreeVector
	public ThreeVector(double x, double y, double z) {
		this.x = x; 
		this.y = y;
		this.z = z;
	}

	// to find the magnitude of a threevector 
	public double magnitude() { 
		double m = x*x + y*y + z*z;
		return Math.sqrt(m);
	}

	// Find the unitvector of a vector
	public ThreeVector unitVector() throws Exception {
		//exception if trying to find unitvector of (0,0,0)
		if (this.x == 0 && this.y == 0 && this.z ==0) {
			throw new Exception("ThreeVector (0,0,0) has no unit vector");
		}
		// divide each component by the magnitude
		ThreeVector uv = new ThreeVector(x/this.magnitude(), y/this.magnitude(), z/this.magnitude() ); 
		return uv;
	}

	//To convert ThreeVector to a string x,y,z
	public String toString(){ 
		return "("+x+","+y+","+z+")";
	}

	// find scalar product of 2 vectors
	static double scalarProduct(ThreeVector a, ThreeVector b){
		// multiply corresponding coponents
		double sp = (a.x* b.x + a.y *b.y + a.z * b.z);
		return sp;
	}

	// find vector product of 2 vectors
	static ThreeVector vectorProduct(ThreeVector a, ThreeVector b) {
		// find the components of the new vector seperately
		double nx = a.y * b.z - a.z * b.y;
		double ny = a.x * b.z - a.z * b.x;
		double nz = a.x * b.y - a.y * b.x;
		//piece together the new vector
		ThreeVector vp = new ThreeVector (nx , -ny, nz);
		return vp;

	}

	// add together 2 vectors
	static ThreeVector add (ThreeVector a, ThreeVector b) {
		//add the corresponding components
		ThreeVector p = new ThreeVector (a.x + b.x, a.y + b.y, a.z + b.z);
		return p;

	}

	//find the angle between two vectors
	static double angle (ThreeVector a, ThreeVector b) throws Exception{
		//exception if eithe vector is (0,0,0)
		if ((a.x ==0 && a.y==0 && a.z == 0) || (b.x ==0 && b.y == 0 && b.z ==0)) {
			throw new Exception("Trying to divide by 0 magnitude");
		}
		//to find the cosine of the angle
		double cosang = scalarProduct(a,b) / (a.magnitude() * b.magnitude());
		return Math.acos(cosang);
	}


	// non-static methods that calls on static methods

	//non-static version of scalar product
	public double scalarProduct(ThreeVector a){
		//takes one argument, and dots it with the specified vector
		double sp = scalarProduct(this,a);
		return sp;
	}

	// non-static vector product
	public ThreeVector vectorProduct(ThreeVector a){
		//cross product the argument with specified vector
		ThreeVector vp = vectorProduct(this,a);
		return vp;
	}

	//non-static vector addition
	public ThreeVector add (ThreeVector a){
		//add argument with specified vectors
		ThreeVector s = add(this,a); 
		return s;
	}

	//non-static angle between two vectors
	public double angle(ThreeVector a) throws Exception{
		//exception if either vector is (0,0,0)
		if ((a.x ==0 && a.y==0 && a.z == 0) || (this.x ==0 && this.y == 0 && this.z ==0)) {
			throw new Exception("Tyring to divide by 0 magnitude");
		}
		//finds angle between argument and specified vector
		double ang = angle(this,a);
		return ang;
	}

}


