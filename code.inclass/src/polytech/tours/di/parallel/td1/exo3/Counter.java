package polytech.tours.di.parallel.td1.exo3;

/**
 * Implements a simple counter
 * @author Jorge E. Mendoza (dev@jorge-mendoza.com)
 * @version %I%, %G%
 *
 */
public class Counter{
	
	//TODO TD1-EXO3: refactor this class
	
	/**
	 * The count
	 */
	private int count=0;
	/**
	 * Increments the counter
	 */
	public void inc(){
		count++;
	}
	/**
	 * Decrements the counter
	 */
	public void dec(){
		count--;
	}
	/**
	 * 
	 * @return the count
	 */
	public int getCount(){
		return this.count;
	}

}
