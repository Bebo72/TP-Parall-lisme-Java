package polytech.tours.di.parallel.td1.exo6;

public class MyCyclicBarrier implements CyclicBarrier {

	public MyCyclicBarrier(int parties, Runnable barrierAction) {
		//TODO TP1-EXO6: implement this constructor
	}

	@Override
	public void await() throws InterruptedException {
		// TODO TP1-EXO6: implement this method
	}

	@Override
	public int getNumberWaiting() {
		// TODO TP1-EXO6: implement this method
		return 0;
	}

	@Override
	public int getParties() {
		// TODO TP1-EXO6: implement this method
		return 0;
	}

}
