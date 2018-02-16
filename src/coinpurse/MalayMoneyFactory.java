package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	private static final String DEFAULT_CURRENCY = "Ringgit";
	private static final String DIME_CURRENCY = "Sen";
	protected long nextSerialNumber = 1000000;
	private double[] malayMoney = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };

	@Override
	public Valuable createMoney(double value) {
		Valuable valuable = null;
		for (double m : malayMoney) {
			if (value == m) {
				if (m >= 1) {
					valuable = new BankNote(m, DEFAULT_CURRENCY, nextSerialNumber++);
				} else if (m < 1) {
					valuable = new Coin(m * 100, DIME_CURRENCY);
				} else {
					throw new IllegalArgumentException();
				}
			}

		}
		return valuable;
	}

	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(0.5);
		System.out.println(m.toString());
		Valuable m3 = factory.createMoney(50);
		System.out.println(m3.toString());
		Valuable m4 = factory.createMoney(20);
		System.out.println(m4.toString());
	}

}
