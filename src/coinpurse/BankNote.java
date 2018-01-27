package coinpurse;

/**
 * A banknote monetary value and currency
 * @author Pimwalun Witchawanitchanun
 *
 */
public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	private double value;
	private String currency;
	
	/**
	 * A banknote with given value and currency.
	 * @param value is value of banknote.
	 * @param currency is currency of banknote.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
	}

	/**
     * Get the value of banknote. 
     * @return the value of banknote.
     */
	@Override
	public double getValue() {
		return this.value;
	}
	
	/**
     * Get the currency of banknote. 
     * @return the currency of banknote.
     */
	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Get the serial of banknote.
	 * @return the serial of banknote.
	 */
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	/**
	 * Compare banknote by currency and value.
	 * @param arg is another BankNote to compare to this one.
	 * @return true if currency and value is same, false otherwise.
	 */
	public boolean equals(Object arg){
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		BankNote other = (BankNote) arg;
		if(this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue()) return true;
		return false;
	}
	
	/** 
     * Get a string representation of BankNote.
     * @return string representation of BankNote.
     */
	@Override
	public String toString(){
		return this.value + "-" + this.currency + " note [" + this.serialNumber + "]";
	}
}
