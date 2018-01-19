package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Pimwalun Witchawanitchanun
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Coin> money;
	
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<Coin>();
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0;
    	for (Coin coin : money){
    		sum += coin.getValue();
    	}
    	return sum;  
	}

    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return money.size() >= capacity;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.
    	if (coin.getValue() <= 0) return false;
    	if (money.size() != capacity){
    		return money.add(coin);
    	}
        return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	List<Coin> templist = new ArrayList<Coin>();
    	Coin [] array = new Coin[ templist.size() ];
    	Collections.sort( money );
    	Collections.reverse( money );
        if (amount < 0) return null;
        if (getBalance() < amount) return null;
        if (amount == 0) templist.toArray(array);
		for (Coin coin : money) {
			if (amount >= coin.getValue()){
				amount -= coin.getValue();
				templist.add(coin);
			}
		}
		for (Coin coin : templist) {
			money.remove(coin);
		}
        if (amount != 0) return null;
        array = new Coin[templist.size()];
        return array;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return count() + " coins with value " + getBalance();
    }

}