package polytech.tours.di.parallel.td1.exo1;

/**
 * Implements a simple counter
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Counter {

  /**
   * The count
   */
  private int count = 0;

  /**
   * Decrements the counter
   */
  public synchronized void dec() {
    count--;
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
  public synchronized void inc() {
    count++;
  }

}
