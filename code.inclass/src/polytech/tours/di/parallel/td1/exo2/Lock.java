package polytech.tours.di.parallel.td1.exo2;

/**
 * Implements a lock
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 *
 */
public class Lock {

  // TODO TD1-EXO3: implement this class
  private boolean isLocked = false;

  /**
   * Acquires the lock.
   */
  public synchronized void lock() throws InterruptedException {
    // TODO TD1-EXO3: implement this method, revise method declaration if needed
    while (isLocked) {
      System.out.println(Thread.currentThread().getName() + " waiting for the lock @ " + System.currentTimeMillis()); // Affichage
      // d'information
      wait(); // Il se met à attendre et il lâche sinon il va continuer, ne pas
              // oublier de mettre synchronized
    }

    isLocked = true;

    System.out.println(Thread.currentThread().getName() + " obtained the lock @ " + System.currentTimeMillis());

  }

  /**
   * Releases the lock
   */
  public synchronized void unlock() {
    isLocked = false;

    System.out.println(Thread.currentThread().getName() + " obtained the lock @ " + System.currentTimeMillis());

    notify();
    // TODO TD1-EXO3: implement this method, revise method declaration if needed
  }

}
