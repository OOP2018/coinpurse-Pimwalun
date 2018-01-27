package coinpurse;

/**
* An interface for objects having a monetary value and currency.
* @author Pimwalun Witchawanitchanun
*/
public interface Valuable {
	
	/**
	 * Get the monetary value of this object, in its own currency.
	 * @return the value of this object
	 */
	public double getValue();
	
	/**
	 * Get the currency of item.
	 * @return the currency of item
	 */
	public String getCurrency();
}
