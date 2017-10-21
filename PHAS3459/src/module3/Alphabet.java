package module3;
import java.util.Random;
import java.lang.StringBuilder;
import java.lang.Character;

public class Alphabet {

	//find a random charactor
	static char randomCharacter() {
		Random rnd = new Random();
		//find random integer between 0 and 128
		int v = rnd.nextInt(128);
		//convert int to ascii char
		char b = (char)v;
		return (b);
	}

	public static void main(String[] args) {

		// initialise stringbuidler
		StringBuilder sb = new StringBuilder();
		//sum of numbers, number of exceptions and numbers in sb all start at 0
		int sum = 0;
		int ex =0;
		int tot = 0;
		
		// 250 random characters
		for (int i =1; i <= 250; i++) {
			char c = randomCharacter();
			String s = Character.toString(c);
			
			//if character is letter or digit, append to sb
			if (Character.isLetterOrDigit(c)){
				sb.append(c);
				tot++;
				try {
					//if char generated is a number, add it to a total
					sum += Integer.parseInt(s);
				}
				catch (Exception e) {
					//sum number of exceptions
					ex++;
				}


			}
		}
		
		
		System.out.println("StringBuilder of all digits and numbers: " + sb);
		System.out.println();
		System.out.println("The total number of characters in the StringBuilder is: "+ tot);
		System.out.println();
		System.out.println("The sum of the numbers in the StringBuilder is: " + sum);
		System.out.println();
		System.out.println("Number of thrown excpetions: " + ex);


	}
}
