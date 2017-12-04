package module8;

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
	 */
	public void run() {


		long TStart = System.currentTimeMillis(); //starting time
		long TEnd = TStart + 10000; 
		while (System.currentTimeMillis() <= TEnd) { // 
			if (System.currentTimeMillis() % 1000000 == 0) { 
				secs--;
				System.out.println("Number of seconds: "+secs);
			}
		}
		return;
	}
}
