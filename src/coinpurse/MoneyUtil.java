package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is to sort and compare coins currency.
 * @author Pimwalun Witchawanitchanun
 */
public class MoneyUtil {
	
	/**
	 * Method that examines all the money in a List and returns
	 * only the money that have a currency that matches the parameter value.
	 * @param money is a List of Valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from value list that have the requested currency.  
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<? extends E> money, String currency) {
		List<E> sameCurrency = new ArrayList<E>();
		for (E value : money) {
			if (value.getCurrency().equals(currency)) {
				sameCurrency.add(value);
			}
		}
		return sameCurrency;
	}

	/**
	 * Method to sort a list of money by currency.
	 * On return, the list (money) will be ordered by currency.
	 * @param money is a List of Coin objects we want to sort. 
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money,new ValueComparator());
	}
	
	/**
	 * Method to print the money
	 * @param money is a List of Valuable objects we want to print.
	 */
	public static void printMoney(List<? extends Valuable> money){
		for (Valuable value : money){
			System.out.println(value.getValue()+"-"+value.getCurrency());
		}
	}
	
	/**
	 * Return the larger argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E...args) {
		E max;
		try {
			max = args[0];
			for (E aE : args) {
				if( aE.compareTo(max) > 0 ) 
					max = aE;
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}
		return max;
	}
	
	/**
	 * Test compareTo method
	 * @param args not used
	 */
	public static void main(String[] args) {
		Money m1 = new BankNote(100, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new Coin(10, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		System.out.println(max);
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD"));
		list.add(new BankNote(500, "Baht"));
		MoneyUtil.sortMoney(list);
		printMoney(list);
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		printMoney(result);
	}
}
