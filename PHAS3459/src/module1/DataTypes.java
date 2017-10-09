package module1;

public class DataTypes {

	public static void main(String[] args) {

		// compare differences between double, float, int, long and byte
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
		System.out.println( charVar +1); //mix char number and int 
		System.out.println("'char 7' + 'integer 1' = 56 because it is adding the ASCII value of the char,\nand the character (known as glyph) of 7 (binary 011 0111) corresponds to the decimal of 55. Adding 1 to this makes 56.\n");
		char charVar2 = 'c'+8;
		System.out.println(charVar2); //mix char letter and int
		System.out.println("'char c' + 'integer 8' = k because the ASCII value of c is 67, and adding\n8 to this gives 75, which corresponds to k. \nYou can also notice that k is 8 letters in the alphabet later than c, making this one rather intuitive.\n");
		byte eight = 8;
		float pi = 3.14f;
		System.out.println(eight+pi); //mix byte and float
		System.out.println("'byte 8' + 'float 3.14' is calculated correctly as the output is taken to be a float.");

		// Investigating a non-initialised variable
		// Commented out as it prevents code from running
		//int j=1;
		//int i;
		//int = i+1;





		//Investigating double to int casts
		double a = 4.99;
		System.out.println(a); 
		a = (int) a ;
		System.out.println(a); 



		System.out.println("As a double, a is printed as 4.99.\nAs an int, a is printed as 4.0.\nIt prints out 4.0 as java will always round down when rounding to an integer, and since a is now classed as an integer, it will round down to an integer, which is 4.0.");





	}
}
