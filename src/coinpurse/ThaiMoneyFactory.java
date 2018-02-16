package coinpurse;

/**
 * This class create coin and banknote of Thailand.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	private static final String DEFAULT_CURRENCY = "Baht";
	private static final String DIME_CURRENCY = "Satang";
	public long nextSerialNumber = 1000000;
	private double[] thaiMoney = { 0.25, 0.5, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	/**
	 * Create coin and banknote of Thailand.
	 * @param value is coin and banknote to insert
	 * @return valuable of coin and banknote.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable = null;
		for (double m : thaiMoney) {
			if (value == m) {
				if (value >= 20) {
					valuable = new BankNote(value, DEFAULT_CURRENCY, nextSerialNumber++);
				} else if (value >= 1 && value < 20) {
					valuable = new Coin(value, DEFAULT_CURRENCY);
				} else if (value < 1) {
					valuable = new Coin(value * 100, DIME_CURRENCY);
				} 
			}
		}
		return valuable;
	}
}
