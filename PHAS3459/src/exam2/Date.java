package exam2;

import java.util.Scanner;

/**
 * makes an object date from which the year, month and daycan be found
 * 
 *
 */
public class Date {

	public Date() {}
	
	int year, month, day;
	
	//scan through the string, identifying year, month day
	public Date (String s) {
		Scanner sc = new Scanner(s).useDelimiter("-");
		this.year = sc.nextInt();
		this.month = sc.nextInt();
		this.day = sc.nextInt();
		sc.close();
	}
}
