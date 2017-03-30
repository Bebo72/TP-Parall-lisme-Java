package polytech.tours.di.parallel.td1.exo5;

/**
 * Implements a simple re-entrant lock
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class ReentrantLock {

  // TODO TD1-EXO5: implement this class
  private boolean isLocked = false;
  private Thread lockedBy = null;
  private int lockCount = 0;

  /**
   * Acquires the lock.
   */
  public synchronized void lock() throws InterruptedException {
    // TODO TD1-EXO3: implement this method, revise method declaration if needed

    Thread callingThread = Thread.currentThread();

    while (isLocked && callingThread != lockedBy) {
      System.out.println(Thread.currentThread().getName() + " waiting for the lock @ " + System.currentTimeMillis()); // Affichage
      // d'information
      wait(); // Il se met à attendre et il lâche sinon il va continuer, ne pas
              // oublier de mettre synchronized
    }

    isLocked = true;
    lockCount++;
    lockedBy = callingThread;

    System.out.println(Thread.currentThread().getName() + " obtained the lock @ " + System.currentTimeMillis());

  }

  /**
   * Releases the lock
   */
  public synchronized void unlock() {

    if (lockedBy == Thread.currentThread()) {
      lockCount--;
      if (lockCount == 0) {
        isLocked = false;

        System.out.println(Thread.currentThread().getName() + " obtained the lock @ " + System.currentTimeMillis());

        lockedBy = null;
        notify();
      }
    }
    // TODO TD1-EXO3: implement this method, revise method declaration if needed
  }

}
