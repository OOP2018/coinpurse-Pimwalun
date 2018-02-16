package coinpurse;

import java.util.ResourceBundle;

/**
 * This class use a property file(as ResourceBundle) to read file.
 * @author Pimwalun Witchawanitchanun
 */
public class Reader {
	
	/**
	 * This method use a ResourceBundle to read file.
	 * @return MoneyFactory of country in file
	 */
	public static MoneyFactory read(){
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factory + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		return factory;
	}
}
