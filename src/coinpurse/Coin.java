package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency. 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class Coin implements Valuable{
	private double value;
	private String currency;
	
	/**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currency is currency of coin.
     */
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	@Override
	/**
     * Get the value of coin. 
     * @return the value of coin.
     */
	public double getValue(){
		return this.value;
	}
	
	@Override
	/**
     * Get the currency of coin.
     * @return the currency of coin.
     */
	public String getCurrency(){
		return this.currency;
	}
	
	/**
	 * Compare coin by currency and value.
	 * @param arg is another Coin to compare to this one.
	 * @return true if currency and value is same, false otherwise.
	 */
	public boolean equals(Object arg){
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Coin other = (Coin) arg;
		if(this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue()) return true;
		return false;
	}
	
	/**
     * Compare coin by value.
     * @param valuable is Coin objects we want to compare. 
     * @return -1 if this coin has greater value.
     */
	public int compareTo(Valuable valuable){
		if (this.currency.equalsIgnoreCase(valuable.getCurrency())){
			return (int) Math.signum(this.value - valuable.getValue());
		}
		if (this.currency == null && valuable.getCurrency() == null){
			return (int) Math.signum(this.value - valuable.getValue());
		}
		return -1;
	}
	
	/** 
     * toString returns a string description of coin contents.
     * @return whatever is a useful description.
     */
	@Override
	public String toString(){
		return this.value + "-" + this.currency;
	}
}
