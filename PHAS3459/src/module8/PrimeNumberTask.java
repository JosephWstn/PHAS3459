package module8;

import java.util.ArrayList;
import java.util.Collections;

public class PrimeNumberTask implements Runnable {

	//empty constructor for primeb number task
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

		//loop indefinitely 
		while (again) {

			//set prime to true, this will turn false if it's not prime
			boolean prime = true;

			//loop from 2 to square root of current value checking if divisible
			for (int i = 2; i*i <= current; i++) {

				//if current is divisible by i - making it not prime
				if (current % i == 0 ) {
					//turn prime to false
					prime = false;
				}
			}


			//if boolean prime remained true
			if (prime == true) {
				//System.out.println(current + " is prime");

				//add current prime to list
				list.add(current);
			}

			//make process stop if the thread becomes interrupted
			if(Thread.currentThread().isInterrupted()) {

				//print largest prime found, the largest integer checked and the number of primes found 
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