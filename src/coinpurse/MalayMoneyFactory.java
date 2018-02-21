package coinpurse;

/**
 * This class create coin and banknote of Malaysia.
 * @author Pimwalun Witchawanitchanun
 */
public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String DIME_CURRENCY = "Sen";
	private long nextSerialNumber = 1000000;
	private double[] malayMoney = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };

	/**
	 * Create coin and banknote of Malaysia.
	 * @param value is coin and banknote to insert
	 * @return valuable of coin and banknote.
	 */
	@Override
	public Valuable createMoney(double value) {
		for (double m : malayMoney) {
			if (value == m) {
				if (value >= 1) {
					return new BankNote(value, DEFAULT_CURRENCY, nextSerialNumber++);
				} else if (value < 1) {
					return new Coin(value * 100, DIME_CURRENCY);
				} 
			} 
		}
		throw new IllegalArgumentException("Sorry, " + value + " is not a valid amount.");
	}
	
	public static void main(String[] args) {
		
		MoneyFactory m = new MalayMoneyFactory();
		MoneyFactory.setFactory(m);
		Valuable v1 = m.createMoney(0.5);
		System.out.println(v1.toString());
		Valuable v2 = m.createMoney(20);
		System.out.println(v2.toString());
		Valuable v3 = m.createMoney(40);
		System.out.println(v3.toString());
	}
}
