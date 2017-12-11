package module8;

public class ThreadsMain {



	public static void main(String[] args) {

		//initialise thread for counting down from 10
		Thread cdt = new Thread (new CountdownTask(10));

		//initialise thread for finding prime numbers
		Thread pnt = new Thread(new PrimeNumberTask());

		cdt.start();
		pnt.start();

		try {
			//when countdown finishes, interrupt prime number task
			cdt.join();
			pnt.interrupt();
		}

		catch(InterruptedException e) {}
	}
}