package polytech.tours.di.parallel.td1.exo6;

/*
 * Code taken from the Java Concurrency Utilities tutorial by Jakob Jenkov.
 * Code commented by Jorge E. Mendoza for teaching purposes
 */
public class Tester {
	
	public static void main(String[] args){
		//Define an action to execute when all threads reach barrier 1
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println(Thread.currentThread().getName()+" BarrierAction 1 executed ");
		    }
		};
		//Define an action to execute when all threads reach barrier 2
		Runnable barrier2Action = new Runnable() {
		    public void run() {
		        System.out.println(Thread.currentThread().getName()+" BarrierAction 2 executed ");
		    }
		};
		//Instantiate the two barriers
		MyCyclicBarrier barrier1 = new MyCyclicBarrier(2, barrier1Action);
		MyCyclicBarrier barrier2 = new MyCyclicBarrier(2, barrier2Action);
		
		//Create the two tasks
		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
		
		//Run the threads
		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
	}
	
	//Defines the task
	static class CyclicBarrierRunnable implements Runnable{
		
		//References to the barriers
	    MyCyclicBarrier barrier1 = null;
	    MyCyclicBarrier barrier2 = null;
	    
	    //Class constructor
	    public CyclicBarrierRunnable(MyCyclicBarrier barrier1, MyCyclicBarrier barrier2) {
	        this.barrier1 = barrier1;
	        this.barrier2 = barrier2;
	    }
	    
	    //The concurrent code
	    @Override
	    public void run() {
	        try {
	        	
	            Thread.sleep(1000);
	            System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
	            this.barrier1.await();
	            //The execution passes the first barrier
	            
	            Thread.sleep(1000);
	            System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
	            this.barrier2.await();
	            //The execution passes the first barrier
	            
	            System.out.println(Thread.currentThread().getName() + " done!");

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}
