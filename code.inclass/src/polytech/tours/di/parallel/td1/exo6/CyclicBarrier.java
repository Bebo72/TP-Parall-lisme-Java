package polytech.tours.di.parallel.td1.exo6;
/**
 * A synchronization aid that allows a set of threads to all wait for
 * each other to reach a common barrier point.  CyclicBarriers are
 * useful in programs involving a fixed sized party of threads that
 * must occasionally wait for each other. The barrier is called
 * <em>cyclic</em> because it can be re-used after the waiting threads
 * are released.
 */
public interface CyclicBarrier {
	/**
	 * Waits until all {@linkplain #getParties parties} have invoked
	 * {@code await} on this barrier.
	 *
	 * <p>If the current thread is not the last to arrive then it is
	 * disabled for thread scheduling purposes and lies dormant until
	 * the barrier is tripped.
	 * 
	 * <p>If the current thread is the last thread to arrive, then the
	 * current thread runs the barrier action before allowing the other 
	 * threads to continue.
	 * */
	public abstract void await() throws InterruptedException;
	/**
	 * Returns the number of parties currently waiting at the barrier.
	 * This method is primarily useful for debugging and assertions.
	 * @return the number of parties currently blocked in {@link #await}
	 */
	public abstract int getNumberWaiting();
	/**
	 * Returns the number of parties required to trip this barrier.
	 * @return the number of parties required to trip this barrier
	 */
	public abstract int getParties();
}