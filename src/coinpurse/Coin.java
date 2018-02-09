package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency. 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class Coin extends Money {
	
	/**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currency is currency of coin.
     */
	public Coin(double value, String currency){
		super(value, currency);
	}
	
	/** 
     * toString returns a string description of coin contents.
     * @return whatever is a useful description.
     */
	@Override
	public String toString(){
		return getValue() + "-" + getCurrency();
	}
}
