package polytech.tours.di.parallel.td3.pi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Implements the "master tasks"
 *
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class PICalculator {

  public double computePI(long N, int nbThreads, int T) {
    // instantiate an executor
    ExecutorService executor = Executors.newFixedThreadPool(nbThreads);

    // build tasks
    List<Callable<Long>> tasks = new ArrayList<>();
    List<Future<Long>> results;

    for (int t = 1; t <= T; t++) {
      tasks.add(new PIComputation(N / T, 1));
    }

    // Execute tasks
    try {
      results = executor.invokeAll(tasks);
      executor.shutdown();
    } catch (InterruptedException e) {
      return Double.NaN;
    }

    // compute PI
    try {
      long counter = 0;
      for (Future<Long> r : results) {
        counter = counter + r.get();
      }
      return 4d * ((double) counter / N);
    } catch (InterruptedException | ExecutionException e) {
      return Double.NaN;
    }
  }
}
