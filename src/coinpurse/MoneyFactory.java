package coinpurse;

/**
 * This class for creating money of other countries.
 * @author Pimwalun Witchawanitchanun
 */
public abstract class MoneyFactory {
	private static MoneyFactory factory;
	
	/**
	 * Returns an object of other countries.
	 * @return get an instance of MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = Reader.read();
		}
		return factory;
	}
	
	/**
	 * create a new money object in the local currency.
	 * @param value is a new money object in the local currency.
	 * @throws IllegalArgumentException if the value is not a valid number.
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;
	
	/**
	 * It parses the String parameter as a double.
	 * @param value is coin and banknote to insert
	 * @return valuable is calls the abstract createMoney(double) method
	 * @throws IllegalArgumentException if the value is not a valid number.
	 */
	public Valuable createMoney(String value) {
		double newValues = 0.0;
		try {
			newValues = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Value is not a valid number");
		}
		return createMoney(newValues);
	}
	
	/**
	 * Set MoneyFacetory depend on purse.properties
	 */
	public static void setFactory(MoneyFactory f) {
		MoneyFactory.factory = f;		
	}
}