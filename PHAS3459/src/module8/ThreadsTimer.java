package module8;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//number of points to find pi 
		long nPoints = 10000000L;

		//check starting time of one thread method
		long oneThreadStartTime = System.currentTimeMillis();

		//Create MCPCT object for nPoints
		MonteCarloPiCalculatorTask taskone = new MonteCarloPiCalculatorTask(nPoints);

		//find pi using one thread
		double pione = taskone.call();

		//print out this value of pi
		System.out.println("pi using one thread: "+pione);

		//find the ending time of this method, find the time elapsed and print out
		long oneThreadFinishTime = System.currentTimeMillis();
		long oneThreadTimeTaken = oneThreadFinishTime - oneThreadStartTime;
		System.out.println("Time taken for the single thread = " + oneThreadTimeTaken + " milliseconds");

		System.out.println();

		//starting time of four thread method
		long fourThreadStartTime = System.currentTimeMillis();
		int nThreads = 4;

		//create pool of nThreads (4)
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);

		//use Future to represent results of each parallel calculation
		List<Future<Double>> futures = new ArrayList<Future<Double>>();

		//loop through the threads
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;

		//loop through threads
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result = futures.get(iThread).get();
			sum += result;
		}
		threadPool.shutdown();

		//find the final value of pi
		double pifour = sum/nThreads;
		System.out.println("pi using four threads: "+ pifour);


		//find ending time of this method
		long fourThreadFinishTime = System.currentTimeMillis();

		//find and print time elapsed
		long fourThreadTimeTaken = fourThreadFinishTime - fourThreadStartTime;
		System.out.println("Time taken for four threads = " + fourThreadTimeTaken + " milliseconds");


		//Comparison and discussion of the two methods
		double timeComp = ( (double)oneThreadTimeTaken / (double) fourThreadTimeTaken);

		System.out.println();
		System.out.printf("The single thread took around "+ String.format("%.3f", timeComp)+ " times longer than the four threads.\nThis is expected as the four threads method has four threads working through the task at the same time. It is not as high as four times as quick because\nusing four threads requires more processing power so the individual threads cannot work as fast as a single thread.\nTo 10 dp, the expected value is 3.1415926535, no method is consistently more accurate than the other as they are both doing the same process, except the four threads is splitting\nthe task into four and doing it at the same time.");
	}

} 