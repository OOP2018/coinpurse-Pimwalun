package coinpurse;

import java.util.ResourceBundle;

public class Reader {
	public static MoneyFactory read(){
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory instance = null;
		try {
			instance = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(instance + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (instance == null)
			System.exit(1);
		return instance;
	}
}
