package polytech.tours.di.parallel.td1.exo4;

import polytech.tours.di.parallel.td1.exo3.Lock;

/**
 * Implements a reentrant task
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class ReentrantTask implements Runnable{
	//a reference to the lock
	Lock lock = new Lock();
	//runs the concurrent task
	public void run(){
		try {
			lock.lock();
			System.out.println("Doing the outer work");
			//Do some work here
			inner();
		} catch (InterruptedException e) {
			return;
		}finally{
			lock.unlock();
		}
	}
	//some other method provided by the class
	public void inner(){
		try {
			lock.lock();
			System.out.println("Doing the inner work");
			//Do some work here
		} catch (InterruptedException e) {
			return;
		} finally{
			lock.unlock();
		}    

	}

}
