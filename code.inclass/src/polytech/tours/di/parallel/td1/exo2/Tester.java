package polytech.tours.di.parallel.td1.exo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * Executes the experiment for exercise 0. The experiment consists on showing the effect
 * of thread overlapping. 
 *  
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Tester {

	/**
	 * Runs the experiment
	 * @param args[0] the number of iterations of the parallel counting task. Default value 1
	 * @param args[1] the number of threads to add to the pool. Default value the number of available processors.
	 */
	public static void main(String[] args){
		//set number of iterations
		int n=1;
		if(args.length>0)
			n=Integer.valueOf(args[0]);
		//set number of threads
		int p=Runtime.getRuntime().availableProcessors();
		if(args.length>1)
			p=Integer.valueOf(args[1]);
		//instantiate counter
		Counter c=new Counter();
		//instantiate executor service
		ExecutorService executor = Executors.newFixedThreadPool(p);
		//submit the parallel tasks and execute them
		for(int i=1;i<=p;i++){
			executor.submit(new ParallelCounting(n,c, true));
			executor.submit(new ParallelCounting(n,c, false));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(10,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//report final counter
		System.out.println("Counter = "+c.getCount());
	}

}
