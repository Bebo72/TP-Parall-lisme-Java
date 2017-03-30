package polytech.tours.di.parallel.td2.exo2_1;

import java.util.concurrent.locks.ReentrantLock;

// TODO EXO 2.1: refactor this class

/**
 * Runs parallel tasks
 * 
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Tester {

  /**
   * Runs the test
   * 
   * @param args
   *          no arguments expected
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {

    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    ReentrantLock lock3 = new ReentrantLock();

    Thread t1 = new Thread(new ParallelTask(lock1, lock2), "t1");
    Thread t2 = new Thread(new ParallelTask(lock1, lock2), "t2");
    Thread t3 = new Thread(new ParallelTask(lock1, lock2), "t3");

    t1.start();
    Thread.sleep(5000);
    t2.start();
    Thread.sleep(5000);
    t3.start();

  }
}
