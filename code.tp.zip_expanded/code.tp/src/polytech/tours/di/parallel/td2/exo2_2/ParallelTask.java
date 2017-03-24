package polytech.tours.di.parallel.td2.exo2_2;

import java.util.concurrent.locks.ReentrantLock;

// TODO EXO 2.2: refactor this class

/**
 * Implements a parallel task that needs two locks to execute
 * 
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
class ParallelTask implements Runnable {
  /**
   * A reference to the first lock (resource)
   */
  private ReentrantLock lock1;
  /**
   * A reference to the second lock (resource)
   */
  private ReentrantLock lock2;

  /**
   * Constructs a new instance of the class
   * 
   * @param lock1
   *          a reference to the first lock
   * @param lock2
   *          a reference to the second lock
   */
  public ParallelTask(ReentrantLock lock1, ReentrantLock lock2) {
    this.lock1 = lock1;
    this.lock2 = lock2;
  }

  /**
   * The code of the parallel task
   */
  @Override
  public void run() {
    String callingThread = Thread.currentThread().getName();
    System.out.println(callingThread + " acquiring " + lock1);
    lock1.lock();
    try {
      System.out.println(callingThread + " acquired lock " + lock1);
      work();
      System.out.println(callingThread + " acquiring lock " + lock2);
      lock1.lock();
      try {
        System.out.println(callingThread + " acquired lock " + lock2);
        work();
      } finally {
        lock2.unlock();
      }
      System.out.println(callingThread + " released lock " + lock2);
    } finally {
      lock2.unlock();
    }
    System.out.println(callingThread + " released lock " + lock1);
    System.out.println(callingThread + " finished execution.");
  }

  /**
   * Simulates an expensive computation
   */
  private void work() {
    try {
      Thread.sleep(30000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
