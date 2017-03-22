package polytech.tours.di.parallel.td1.exo5;

public class Tester {
	
	/**
	 * 
	 * @param args[0] the number of counter increments that each task should perform
	 */
	public static void main(String[] args){
		(new Thread(new ReentrantTask())).start();
	}
	
}
