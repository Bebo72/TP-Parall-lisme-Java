package polytech.tours.di.parallel.td1.exo6;

public class MyCyclicBarrier implements CyclicBarrier {

  private final int parties; // nombre de thread
  private int count;

  private Runnable action;

  public MyCyclicBarrier(int parties) {
    this(parties, null);
  }

  public MyCyclicBarrier(int parties, Runnable barrierAction) {
    // TODO TP1-EXO6: implement this constructor

    if (parties <= 0) {
      throw new IllegalStateException();
    }

    // Initialisations des attributs
    this.parties = parties;
    this.action = barrierAction;
    this.count = this.parties;
  }

  @Override
  public synchronized void await() throws InterruptedException {
    // TODO TP1-EXO6: implement this method
    this.count--;

    if (this.count > 0) {
      wait(); // pas le droit d'appeller wait si pas de synchro
    }

    else {
      this.count = this.parties;

      if (action != null) {
        action.run();
        notifyAll();
      }
    }
  }

  @Override
  public int getNumberWaiting() {
    // TODO TP1-EXO6: implement this method
    return this.parties - this.count;
  }

  @Override
  public int getParties() {
    // TODO TP1-EXO6: implement this method
    return this.parties;
  }

}
