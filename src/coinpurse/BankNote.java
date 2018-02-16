package coinpurse;

/**
 * A banknote monetary value and currency
 * @author Pimwalun Witchawanitchanun
 */
public class BankNote extends Money {
	private long serialNumber;
	/**
	 * A banknote with given value and currency.
	 * @param value is value of banknote.
	 * @param currency is currency of banknote.
	 */
	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	/**
	 * Get the serial of banknote.
	 * @return the serial of banknote.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/** 
     * Get a string representation of BankNote.
     * @return string representation of BankNote.
     */
	@Override
	public String toString(){
		return getValue() + "-" + getCurrency() + " note [" + getSerial() + "]";
	}
}
