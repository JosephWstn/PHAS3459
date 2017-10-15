package module2;

public class TestThreeVector {

	public static void main(String[] args) {

		// define three vectors to test vector methods
		ThreeVector v1 = new ThreeVector(3,5,2);
		ThreeVector v2 = new ThreeVector(2,4,1);
		ThreeVector v3 = new ThreeVector (0,0,0);

		
		//print the vectors
		System.out.println("Vector 1: " + v1);
		System.out.println("Vector 2: " + v2);
		System.out.println("Vector 3: " + v3);
		
		System.out.println();
		
		System.out.println("The following results were obtatined by calling non-static methods");
		// Using non static methods
		System.out.println("Unit Vector of Vector 1: " + v1.unitVector());
		System.out.println("Unit Vector of Vector 2: " + v2.unitVector());
		System.out.println("Unit Vector of Vector 1: " + v3.unitVector());
		
		System.out.println();
		
		System.out.println("Scalar Product of Vector 1 and Vector 2: " + v1.scalarProduct(v2));
		System.out.println("Scalar Product of Vector 1 and Vector 3: " + v1.scalarProduct(v3));
		
		System.out.println();
		
		System.out.println("Vector Product of Vector 1 and Vector 2: " + v1.vectorProduct(v2));
		System.out.println("Vector Product of Vector 1 and Vector 3: " + v1.vectorProduct(v3));
		
		System.out.println();
		
		System.out.println("The following results were obtained by calling static methods");
		//Using static methods
		System.out.println("Scalar Product of Vector 1 and Vector 2: " + ThreeVector.scalarProduct(v1,v2));
		System.out.println("Scalar Product of Vector 1 and Vector 3: " + ThreeVector.scalarProduct(v1,v3));
		
		System.out.println();
		
		System.out.println("Vector Product of Vector 1 and Vector 2: " + ThreeVector.vectorProduct(v1,v2));
		System.out.println("Vector Product of Vector 1 and Vector 3: " + ThreeVector.vectorProduct(v1,v3));
		
		System.out.println();
		
		System.out.println("The following angles were found by calling non-static methods");
		//non static angles
		System.out.println("Angle between Vector 1 and Vector 2: " + v1.angle(v2));
		System.out.println("Angle between Vector 1 and Vector 3: " + v1.angle(v3));
		
		System.out.println();
		
		System.out.println("The following angles were found by calling static methods");
		//static angles
		System.out.println("Angle between Vector 1 and Vector 2: " + ThreeVector.angle(v1,v2));
		System.out.println("Angle between Vector 1 and Vector 3: " + ThreeVector.angle(v1, v3));
		
		System.out.println();
		

		System.out.println("The output when there is no 'toString' method is 'module2.ThreeVector@15db9742' or something similar. This output is because java is trying to print \nthe object 'ThreeVector', and it has no explicit way to convert this object made of doubles to a readable string. \nWith a toString method it has an explicit way to convert these double in the object to a string of doubles.");
		
		
		
	}

}
