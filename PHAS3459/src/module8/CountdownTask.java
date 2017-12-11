package module8;

import java.util.concurrent.TimeUnit;

public class CountdownTask implements Runnable {

	//member variable number of seconds to count down
	int secs;

	/*
	 * constructor for a countdown objext
	 * @argument is the starting point of the countdown 
	 */
	public CountdownTask (int secs) {
		this.secs = secs;
	}

	/*
	 * Run method for countdown task
	 * Decrease from "secs" to 0, printing every second 
	 */
	public void run() {
		while (secs>0) {
			System.out.println("Number of seconds: "+ secs);
			secs--;
			
			//Wait for 1 second to print the new value
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				e.printStackTrace();
			} 
		}
		System.out.println("Number of seconds: 0");
		return;
	}
}