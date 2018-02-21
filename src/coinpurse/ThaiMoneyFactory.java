package coinpurse;

/**
 * This class create coin and banknote of Thailand.
 * @author Pimwalun Witchawanitchanun
 */
public class ThaiMoneyFactory extends MoneyFactory {

	private static final String DEFAULT_CURRENCY = "Baht";
	private static final String DIME_CURRENCY = "Satang";
	private long nextSerialNumber = 1000000;
	private double[] thaiMoney = { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	/**
	 * Create coin and banknote of Thailand.
	 * @param value is coin and banknote to insert
	 * @return valuable of coin and banknote.
	 */
	@Override
	public Valuable createMoney(double value) {
		for (double m : thaiMoney) {
			if (value == m) {
				if (value >= 20) {
					return new BankNote(value, DEFAULT_CURRENCY, nextSerialNumber++);
				} else if (value >= 1 && value < 20) {
					return new Coin(value, DEFAULT_CURRENCY);
				} else if (value < 1) {
					return new Coin(value * 100, DIME_CURRENCY);
				} 
			} 
		}
		throw new IllegalArgumentException("Sorry, " + value + " is not a valid amount.");
	}
	
	public static void main(String[] args) {
		MoneyFactory m = MoneyFactory.getInstance();
		Valuable v1 = m.createMoney(5);
		System.out.println(v1.toString());
		Valuable v2 = m.createMoney(20);
		System.out.println(v2.toString());
		Valuable v3 = m.createMoney(40);
		System.out.println(v3.toString());
	}
}
