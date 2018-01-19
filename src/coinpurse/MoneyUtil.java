package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil{
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency){
		List<Coin> sameCurrency = new ArrayList<Coin>();
		for(Coin coin : coins){
			if (coin.getCurrency().contains(currency)){
				sameCurrency.add(coin);
			}
		}
		return sameCurrency;
	}
	
	public void sortCoins(List<Coin> coins){
		Collections.sort(coins);
	}
	}
