package exam2;

import java.util.Scanner;

/**
 * makes an object time from which the hour and minute can be found
 * 
 *
 */
public class Time {

	
	public Time() {}
	
	int hour, min;
	
	//scan through the string, finding hour and min
	public Time (String s) {
		Scanner sc = new Scanner(s).useDelimiter(":");
		this.hour = sc.nextInt();
		this.min = sc.nextInt();
		sc.close();
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public String toString() {
		return (this.hour +":" + this.min);
	}
}
