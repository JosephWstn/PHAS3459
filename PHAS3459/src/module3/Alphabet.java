package module3;
import java.util.Random;
import java.lang.StringBuilder;
import java.lang.Character;

public class Alphabet {

	static char randomCharacter() {
		Random rnd = new Random();
		int v = rnd.nextInt(128);
		char b = (char)v;
		return (b);
	}

	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder();
		int sum = 0;
		for (int i =1; i <= 250; i++) {
			char c = randomCharacter();
			if ((Character.isAlphabetic(c)) || (Character.isDigit(c))){
				s.append(c);
				int num = Integer.parseInt(s.toString());
				sum += num;
				
			}
		}
		System.out.println(sum);
	}
	

}
