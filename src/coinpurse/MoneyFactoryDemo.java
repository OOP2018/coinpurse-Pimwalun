package coinpurse;

/**
 * This class to create a MoneyFactory and call its methods. And print results on the console. 
 * @author Pimwalun Witchawanitchanun
 */
public class MoneyFactoryDemo {
	
	/**
	 * This method it test that MoneyFactory is singleton and all the methods work as specified.
	 */
	public static void testMoneyFactory() {
		MoneyFactory f1 = MoneyFactory.getInstance();
		System.out.println("f1 is a " + f1.getClass().getName());
		MoneyFactory f2 = MoneyFactory.getInstance();
		System.out.println("f2 is a " + f2.getClass().getName());
		System.out.println("f1 == f2 (same object)?");
		System.out.println(f1 == f2);
		
		// create some money
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(0.5);
		System.out.println(m.toString());
		Valuable m3 = factory.createMoney(50);
		System.out.println(m3.toString());
		Valuable m4 = factory.createMoney(20);
		System.out.println(m4.toString());
	}
	
	public static void main(String[] args) {
		testMoneyFactory();
	}
}
