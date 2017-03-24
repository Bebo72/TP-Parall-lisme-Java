package polytech.tours.di.parallel.td2.exo3_1;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implements a parallel task
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
class ParallelTask implements Runnable, Comparable<ParallelTask>{
	/**
	 * The task's id
	 */
	private final int ID;
	/**
	 * A reference to a lock representing a shared resource
	 */
	private ReentrantLock lock;
	/**
	 * Keeps a counter of the number of times the task is executed
	 */
	private AtomicInteger runCount = new AtomicInteger();
	/**
	 * A reference to the object coordinating the work of the threads
	 */
	private Coordinator coordinator;
	/**
	 * Constructs a new instance of the class
	 * @param lock the reference to the lock representing the shared resource
	 * @param coordinator a reference to the object responsible for coordinating the execution of the threads
	 */
	public ParallelTask(int id,ReentrantLock lock, Coordinator coordinator){
		this.lock=lock;
		this.coordinator=coordinator;
		this.ID=id;
	}
	/**
	 * Implements the code of the task.
	 */
	public void run() {
		while (coordinator.keepRunning()){
			lock.lock();
			try {
				work();
			}
			finally{
				lock.unlock();
			}
		}
	}
	/**
	 * Does the actual work
	 */
	private void work() {
		runCount.getAndIncrement();
	}
	/**
	 * 
	 * @return the value of number of times the task has been executed
	 */
	public int getCounter(){
		return this.runCount.get();
	}
	/**
	 * 
	 * @return the ID of the task
	 */
	public int getID(){
		return this.ID;
	}
	
	@Override
	public int compareTo(ParallelTask t) {
		if(this.getCounter()<t.getCounter())return -1;
		return this.getCounter()>t.getCounter()?1:0;
	}
	
}
