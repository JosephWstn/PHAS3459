package module1;

public class DataTypes {

	public static void main(String[] args) {

		// compare differences of double, float, int, long and byte
		double doubVar= 10.0;
		float floatVar = 10;
		int intVar = 10;
		long longVar = 10;
		byte byteVar = 10;
		System.out.println(doubVar);
		System.out.println(floatVar);
		System.out.println(intVar);
		System.out.println(longVar);
		System.out.println(byteVar);
		System.out.println(doubVar*doubVar);
		System.out.println(floatVar*floatVar);
		System.out.println(intVar*intVar);
		System.out.println(longVar*longVar);
		System.out.println(byteVar*byteVar);

		// Investigating mixing data types
		char charVar = '7';
		System.out.println(charVar +1);
		char charVar2 = 'c'+8;
		System.out.println(charVar2);
		byte eight = 8;
		float pi = 3.14f;
		System.out.println(eight+pi);

		// Investigating a non-initialised variable
		// Commented out as it prevents code from running
		//int j=1;
		//int i;
		//int = i+1;

		//Investigating double to int casts
		double a = 4.99;
		System.out.println(a); //prints double 4.99
		a = (int) a ;
		System.out.println(a); //prints integer 4.0

		/*
		As a double, a is printed as 4.99
		As an int, a is printed as 4.0.
		It prints out 4.0 as java will always round down when rounding to an integer, and since
		a is now classed as an integer, it will round down to an integer, which is 4.0.
		 */
	}
}
