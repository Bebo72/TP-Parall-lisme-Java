package polytech.tours.di.parallel.td1.exo3;

public class ParallelCounting implements Runnable {
	
	//Number of iterations
	private int n;
	//A reference to the counter
	private Counter c;
	//True is the task adds to the counter, false if it subtracts from the counter
	private boolean additive;
	//Constructor
	public ParallelCounting(int n, Counter c, boolean additive){
		this.n=n;
		this.c=c;
		this.additive=additive;
	}
	//The code to execute in parallel
	@Override
	public void run() {
		for(int i=1;i<=n;i++)
			if(this.additive) //if the task is additive add one, else subtract one
				c.inc();
			else
				c.dec();
		System.out.println(Thread.currentThread().getName()+(this.additive?"(+)":"(-)")+"\t"+c.getCount());
	}
}
