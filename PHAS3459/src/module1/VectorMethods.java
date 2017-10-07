package module1;
import java.lang.Math.*; //maths functions
public class VectorMethods {





	// Calculate the dot product between two vectors
	static double dotProduct (double []a,double []b) {
		double R=0;
		for (int i=0; i<a.length; i++) {
			R += a[i] * b[i];
		}
		return  R;
	}

	//Find the magnitude of a vector 
	static double magnitude (double[] a) {
		double M=0;
		for (int i =0; i<a.length; i++) {
			M += a[i] * a[i];
		}
		return  Math.sqrt(M);
	}

	//Find the angle between two vectors 
	static double angle (double[]a, double[]b) {
		double ang = Math.acos(dotProduct(a,b)/(magnitude(a)*magnitude(b)));   //dot product / magnitudes
		return ang;
	}


	public static void main(String[] args) {

		VectorMethods vm = new VectorMethods();

		// Assign the vectors to execute methods on
		double[] V1 = new double [] {2,3,4};
		double[] V2 = new double [] {1,3,2};
		double[] V3 = new double [] {0,0,0};


		System.out.println("The angle bewetween vectors (2,3,4) and (1,3,2) is " + VectorMethods.angle(V1,V2)+" Radians");
		System.out.println("The angle bewetween vectors (2,3,4) and (0,0,0) is " + VectorMethods.angle(V1,V3)+" Radians");
	}

}

/*
The angle between vectors (2,3,4) and (0,0,0) is calculated to be "NaN". This is because the magnitude of the vector (0,0,0) is 0, and in the
process of finding the angle, the dot product is divided by the product of the two magnitudes, resulting in an attempt to divide by 0.
This is of course an invalid calculation, so the result NaN is provided.
 */