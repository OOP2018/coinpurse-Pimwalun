package coinpurse;

public abstract class MoneyFactory {
	private static MoneyFactory factory;
	
	public static MoneyFactory getInstance() {
		if (factory == null) {
			factory = Reader.read();
		}
		return factory;
	}
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney(String value) {
		Double newValues = 0.0;
		try {
			newValues = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("Value is not a valid number");
		}
		return createMoney(newValues);
	}
	
	public static void setMoneyFactory(MoneyFactory mf) {
		MoneyFactory.factory = mf;		
	}
}
