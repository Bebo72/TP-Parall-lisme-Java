package polytech.tours.di.parallel.td1.exo4;

public class Tester {

  public static void main(String[] args) {
    (new Thread(new ReentrantTask())).start();
  }
}
