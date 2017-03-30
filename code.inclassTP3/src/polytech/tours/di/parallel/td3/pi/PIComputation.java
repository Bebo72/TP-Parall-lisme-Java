package polytech.tours.di.parallel.td3.pi;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implements an estimation of PI using simulation
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class PIComputation implements Callable<Long> {

  // the number of points to generate
  private final long runs;
  // The diameter of the circle
  private final int d;
  // The X coordinate of the center of the circle
  private double ox;
  // The Y coordinate of the center of the circle
  private final double oy;
  // The number of points inside the circle
  private long counter;

  public PIComputation(long runs, int d) {
    this.runs = runs;
    this.d = d;
    this.ox = d / 2d; // on met d pour avoir un resultat double dans la division
    this.oy = d / 2d;
  }

  @Override
  public Long call() throws Exception {
    // TODO Auto-generated method stub

    for (int i = 1; i <= runs; i++) {
      double px = ThreadLocalRandom.current().nextDouble(d);
      double py = ThreadLocalRandom.current().nextDouble(d);

      if (inCircle(px, py)) {
        counter++;
      }

    }

    return counter;

  }

  public double euclidean(double px1, double py1, double px2, double py2) {
    return Math.sqrt(Math.pow(px1 - px2, 2) + Math.pow(py1 - py2, 2));
  }

  private boolean inCircle(double px, double py) {
    return euclidean(px, py, ox, oy) <= this.d / 2d;
  }
}
