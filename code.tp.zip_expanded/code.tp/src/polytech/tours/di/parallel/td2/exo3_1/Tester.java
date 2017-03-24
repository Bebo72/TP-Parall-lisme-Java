package polytech.tours.di.parallel.td2.exo3_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Runs parallel tasks
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Tester {

	/**
	 * Runs the test
	 * @param args no arguments expected
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		//Set up the share resources
		ReentrantLock lock=new ReentrantLock();
		Coordinator coordinator=new Coordinator();

		//Set up experiment parameters
		int T=100;
		int D=5_000;
		
		//Build tasks and threads
		ArrayList<ParallelTask> tasks=new ArrayList<>();
		ArrayList<Thread> threads=new ArrayList<>();
		for(int t=1;t<=T;t++){
			tasks.add(new ParallelTask(t,lock,coordinator));
			threads.add(new Thread(tasks.get(tasks.size()-1)));
		}
				
		//Launch execution
		for(int t=1;t<=T;t++){
			threads.get(t-1).start();
		}
		
		//  Make the Main Thread sleep for 5 seconds
		//  then stop all threads 
		try {
			Thread.sleep(D);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coordinator.stop();

		//Let console catch up
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Sort the list of tasks
		Collections.sort(tasks);
		for(int t=1;t<=T;t++){
			System.out.println("Task "+tasks.get(t-1).getID()+"="+tasks.get(t-1).getCounter());
		}

	}

}
