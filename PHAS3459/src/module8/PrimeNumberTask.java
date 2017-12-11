package module8;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeNumberTask implements Runnable {

	//empty constructor for prime number task
	PrimeNumberTask(){}

	/*
	 * Thread runs, counting up, printing prime numbers and adding them to a list until it is interrupted and it stops
	 * 
	 */
	public void run() {
		//initialise arraylist of prime numbers
		ArrayList<Integer> list = new ArrayList<Integer>();

		//true boolean so it continues to look for prime numbers until it is stopped in the loop
		boolean again = true;

		//begin from 2 
		int current = 2;

		//loop indefinitely, finding prime numbers from 2
		while (again) {

			//set prime to true, this will turn false if it's not prime
			boolean prime = true;

			//loop from 2 to square root of current value checking if divisible
			for (int i = 2; i*i <= current; i++) {

				//if current is divisible by i - making it not prime - turn prime to false
				if (current % i == 0 ) {
					prime = false;
				}
			}

			//if boolean prime remained true
			if (prime == true) {
				//add current prime to list
				list.add(current);
			}

			//if the thread becomes interrupted, stop process and print information
			if(Thread.currentThread().isInterrupted()) { 
				System.out.println("Largest number checked is: " + current);
				System.out.println("Largest prime number found is: "+ Collections.max(list));
				System.out.println("Number of prime numbers found is: "+ list.size());
				return;
			}
			current++;
		}
		return;
	}
}