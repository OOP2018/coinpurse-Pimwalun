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
		Valuable valuable = null;
		for (double m : malayMoney) {
			if (value == m) {
				if (m >= 1) {
					valuable = new BankNote(m, DEFAULT_CURRENCY, nextSerialNumber++);
				} else if (m < 1) {
					valuable = new Coin(m * 100, DIME_CURRENCY);
				} 
			}
		}
		return valuable;
	}
}
