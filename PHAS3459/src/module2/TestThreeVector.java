package module2;

public class TestThreeVector {

	public static void main(String[] args) {

		ThreeVector v1 = new ThreeVector(3,5,2);
		ThreeVector v2 = new ThreeVector(2,4,1);
		ThreeVector v3 = new ThreeVector (0,0,0);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);

		
		// Using non static methods
		System.out.println(v1.unitVector());
		System.out.println(v2.unitVector());
		System.out.println(v3.unitVector());
		
		System.out.println(v1.scalarProduct(v2));
		System.out.println(v1.scalarProduct(v3));
		System.out.println(v1.vectorProduct(v2));
		System.out.println(v1.vectorProduct(v3));
		
		//Using static methods
		System.out.println(ThreeVector.scalarProduct(v1,v2));
		System.out.println(ThreeVector.scalarProduct(v1,v3));
		System.out.println(ThreeVector.vectorProduct(v1,v2));
		System.out.println(ThreeVector.vectorProduct(v1,v3));
		
		//non static angles
		System.out.println(v1.angle(v2));
		System.out.println(v1.angle(v3));
		
		//static angles
		System.out.println(ThreeVector.angle(v1,v2));
		System.out.println(ThreeVector.angle(v1, v3));
		

		System.out.println("The output when there is no 'toString' method is 'module2.ThreeVector@15db9742'. This output is because java is trying to print \nthe object 'ThreeVector', and it has no explicit way to convert this object made of doubles to a readable string \nwith a toString method it has an explicit way to convert these double in the object to a string of doubles.");
		
		
		
	}

}
