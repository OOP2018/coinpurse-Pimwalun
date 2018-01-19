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
	 * @param coins is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from value list that have the requested currency.  
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> sameCurrency = new ArrayList<Coin>();
		for (Coin coin : coins) {
			if (coin.getCurrency().contains(currency)) {
				sameCurrency.add(coin);
			}
		}
		return sameCurrency;
	}

	/**
	 * Method to sort a list of coin by currency.
	 * On return, the list (coin) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	/**
	 * Method to print the coin
	 * @param coins is a List of Coin objects we want to print.
	 */
	public static void printCoin(List<Coin> coins){
		for (Coin coin : coins){
			System.out.println(coin.getValue()+"-"+coin.getCurrency());
		}
	}
	
	/**
	 * Test compareTo method
	 * @param args not used
	 */
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
    	coins.add(new Coin(10.0, "Bath"));
    	coins.add(new Coin(0.5, "Bath"));
    	coins.add(new Coin(2.0, "Bath"));
    	coins.add(new Coin(10.0, "Dollar"));
    	coins.add(new Coin(1.0, "Bath"));
    	coins.add(new Coin(1.0, "Dollar"));
    	printCoin(coins);
    	java.util.Collections.sort(coins);
    	System.out.println("==========================");
    	printCoin(coins);
	}
}
