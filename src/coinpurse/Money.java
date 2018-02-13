package coinpurse;

/**
 * This class to provide the value, currency, getValue, and getCurrency for subclasses.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class Money implements Valuable{

	protected double value;
	protected String currency;

	/**
     * A money with given value and currency.
     * @param value is value of money.
     * @param currency is currency of money.
     */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
     * Get the value of money. 
     * @return the value of money.
     */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of money.
	 * @return the currency of money.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
     * Compare money by currency and value.
     * @param o is Valuable objects we want to compare. 
     * @return 1 if this currency and value has greater Valuable.
	 * 		  -1 if this currency and value has less than Valuable.
	 * 		   	0 if both of 2 have same currency and value.
     */
	@Override
	public int compareTo(Valuable o) {
		if(this.getCurrency().compareToIgnoreCase(o.getCurrency()) == 0) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return this.getCurrency().compareToIgnoreCase(o.getCurrency());
	}
	
	/**
	 * Compare money by currency and value.
	 * @param arg is another Money to compare to this one.
	 * @return true if currency and value is same, false otherwise.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Money money = (Money) obj;
		if(this.currency.equalsIgnoreCase(money.currency) && this.value == money.value) return true;
		return false;
	}
}