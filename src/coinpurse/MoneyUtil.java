package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is to sort and compare coins currency.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class MoneyUtil {
	
	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param money is a List of Valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from value list that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> sameCurrency = new ArrayList<Valuable>();
		for (Valuable value : money) {
			if (value.getCurrency().equals(currency)) {
				sameCurrency.add(value);
			}
		}
		return sameCurrency;
	}

	/**
	 * Method to sort a list of coin by currency.
	 * On return, the list (coin) will be ordered by currency.
	 * @param values is a List of Coin objects we want to sort. 
	 */
	public static void sortCoins(List<Valuable> values) {
		Collections.sort(values,new ValueComparator());
	}
	
	/**
	 * Method to print the coin
	 * @param values is a List of Valuable objects we want to print.
	 */
	public static void printCoin(List<Valuable> values){
		for (Valuable value : values){
			System.out.println(value.getValue()+"-"+value.getCurrency());
		}
	}
	
	/**
	 * Test compareTo method
	 * @param args not used
	 */
	public static void main(String[] args) {
		List<Valuable> values = new ArrayList<Valuable>();
    		values.add(new Coin(10.0, "Baht"));
    		values.add(new Coin(0.5, "Baht"));
    		values.add(new Coin(2.0, "Baht"));
    		values.add(new Coin(10.0, "Dollar"));
    		values.add(new Coin(1.0, "Baht"));
    		values.add(new Coin(1.0, "Dollar"));
    		values.add(new Coin(2.0, "ht"));
    		values.add(new BankNote(1000.0, "Baht"));
    		values.add(new BankNote(50.0, "Baht"));
    		values.add(new BankNote(100.0, "Baht"));
    		values.add(new BankNote(20.0, "ht"));
    		printCoin(values);
    		Collections.sort(values);
    		System.out.println("==========================");
    		printCoin(values);
    		System.out.println("==========================");
    		System.out.println(filterByCurrency(values, "Baht"));
	}
}
