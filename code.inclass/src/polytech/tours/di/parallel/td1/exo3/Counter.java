package polytech.tours.di.parallel.td1.exo3;

/**
 * Implements a simple counter
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Counter {

  // TODO TD1-EXO2: refactor this class

  /**
   * The count
   */
  private int count = 0;

  private Lock lock = new Lock();

  /**
   * Decrements the counter
   */
  public void dec() {
    try {
      lock.lock();
      count--;
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock(); // Même en cas de problème il va delock
    }
  }

  /**
   *
   * @return the count
   */
  public int getCount() {
    return this.count;
  }

  /**
   * Increments the counter
   */
  public void inc() {
    try {
      lock.lock();
      count++;
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock(); // Même en cas de problème il va delock
    }
  }
}
