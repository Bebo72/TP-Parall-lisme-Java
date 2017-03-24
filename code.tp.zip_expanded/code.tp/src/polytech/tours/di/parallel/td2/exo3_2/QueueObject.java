package polytech.tours.di.parallel.td2.exo3_2;

public class QueueObject {
	/**
	 * Stores a signal
	 */
	private boolean isNotified = false;
	/**
	 * Checks if a signal has been sent to the calling thread. If that is the case
	 * the method completes its execution, otherwise it waits on this object. 
	 * makes the calling thread wait on this object.
	 * @throws InterruptedException
	 */
	public synchronized void doWait() throws InterruptedException {
		while(!isNotified){
			this.wait();
		}
		this.isNotified = false;
	}
	/**
	 * Sets the signal on and notifies the thread waiting on this object.
	 */
	public synchronized void doNotify() {
		this.isNotified = true;
		this.notify();
	}
	
	@Override
	public boolean equals(Object o) {
		return this == o;
	}
}