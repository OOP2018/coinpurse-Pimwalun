package coinpurse;

/**
* An interface for objects having a monetary value and currency.
* @author Pimwalun Witchawanitchanun
*/
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 */
	public double getValue();
	
	/**
	 * Get the currency of item.
	 */
	public String getCurrency();
}
