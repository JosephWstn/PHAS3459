package module1;

public class AlgorithmControl {

	// Print out integers one to ten
	static void loop() {

		for (int i =1; i<=10; i++) { 
			System.out.println(i);
		}
	}

	// Print out integers from 5 to -12.
	static void decrement() {
		int x=5; 
		while (x>= -12) { 
			System.out.println(x);
			x--; 
		}
	}

	// Add 0.2 to 2.4 until it equals 8.8
	static void increment() {

		for (double i =2.4; i<=8.8; i=i+0.2) { 
			System.out.format("%.1f %n ",i); //%.1f: to 1 decimal place. %n: print on a new line
		}
	}

	// Timer for "maxTime" milliseconds,number of loops printed every "loopSteps" loops 
	static int timer (long maxTime, int loopSteps) {
		long TStart = System.currentTimeMillis(); 
		long TEnd = TStart + maxTime; 
		int t=0;
		while (System.currentTimeMillis() <= TEnd) {
			t++; 
			if (t % loopSteps == 0) { 
				System.out.println("Number of loops: "+t);
			}
		}
		System.out.println("Total number of loops: "+t); 
		return t;
	}



	// compare number of loops for timer that prints loop count every 40k loops vs 1k loops
	static void loopcomp () {
		int t40k= timer(8000,40000); 
		int t1k= timer(8000,1000); 
		System.out.println("Total number of loops for printing every 40k loops = " + t40k);
		System.out.println("Total number of loops for printing every 1k loops = "+ t1k);
	}





	public static void main(String[] args) {
		loop();
		decrement();
		increment();
		loopcomp();
	}
}


/*
For an 8 second timer printing out the number of loops every 1000 loops (ie timer(8000,1000) ), total loops is around 765534000
For an 8 second timer printing out the number of loops every 40,000 loops (ie timer(8000,40000), total number of loops is around 1001111578
These values change by a little bit every time the code is ran, the run that prints every 40,000 loops is always greater.
This difference is because when the "if" statement is satisfied, more time passes before the "while" statement is run again because the
"if" statement take a finite amount of time to execute.
When it prints for every 1000 loops, the "if" statement is satisfied much more often, so this longer and slower execution of the loop occurs
more often, so it doesn't have the time to complete as many loops in 8 seconds. This is why the number of loops it had time to complete is
much greater for the loop that printed every 40,000 loops, it can process more loops per second.
 */
