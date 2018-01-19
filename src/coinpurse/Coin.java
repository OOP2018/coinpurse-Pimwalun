package coinpurse;

import java.util.ArrayList;
import java.util.List;


/**
 * Coin represents coinage (money) with a fixed value and currency. 
 * @author Pimwalun Witchawanitchanun
 *
 */
public class Coin implements Comparable<Coin>{
	private double value;
	private String currency;
	
	/**
     * A coin with given value and currency.
     * @param value is value of coin.
     * @param currency is currency of coin.
     */
	public Coin(double value, String currency){
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue(){
		return this.value;
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public boolean equals(Object arg){
		if(arg == null) return false;
		if(arg.getClass() != this.getClass()) return false;
		Coin other = (Coin) arg;
		if(this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue()) return true;
		return false;
	}
	
	@Override
	public int compareTo(Coin coin){
		if (this.currency.equals(coin.getCurrency())){
			if (this.value > coin.getValue())
				return 1;
			if (this.value < coin.getValue())
				return -1;
			if (this.value == coin.getValue())
				return 0;
		}
		return this.currency.compareTo(coin.getCurrency());
	}
	
	@Override
	public String toString(){
		return this.value + "-" + this.currency;
	}
	
	public static void printCoin(List<Coin> coins){
		for (Coin coin : coins){
			System.out.println(coin.getValue()+"-"+coin.getCurrency());
		}
	}
	
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
    	coins.add(new Coin(10.0, "Bath"));
    	coins.add(new Coin(0.5, "Bath"));
    	coins.add(new Coin(2.0, "Bath"));
    	coins.add(new Coin(1.0, "Bath"));
    	printCoin(coins);
    	java.util.Collections.sort(coins);
    	printCoin(coins);
	}

}
