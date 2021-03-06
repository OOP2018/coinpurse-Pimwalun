package coinpurse;

import java.util.ArrayList;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

import java.util.Collections;
import java.util.Comparator;

// You will use Collections.sort() to sort the coins

/**
 *  A purse contains money.
 *  You can insert money, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Pimwalun Witchawanitchanun
 */
public class Purse {
    /** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
	private Comparator<Valuable> comp = new ValueComparator();
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    private static final String CURRENCY = "Baht";
    /** The strategy for withdrawing items */
    private WithdrawStrategy strategy;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    		this.capacity = capacity;
    		strategy = new GreedyWithdraw();
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
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
    		for (Valuable value : money){
    			sum += value.getValue();
    		}
    		return sum;  
	}

    /**
     * Return the capacity of the purse.
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
     * Insert a money into the purse.
     * The money is only inserted if the purse has space for it
     * and the money has positive value.  No worthless coins!
     * @param value is a Valuable object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.
    		if (value.getValue() <= 0) return false;
    		else if (!isFull()){
    			this.money.add(value);
    			Collections.sort(money, comp);
    			return true;
    		}
    		return false;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of money withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
    		return withdraw(new Money(amount, CURRENCY));
	}
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of money withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Valuable objects for money withdrawn and same currency, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( Valuable amount ) {
    		if (this.getBalance() < 0) return null;
    		if (amount.getValue() < 0) return null;
    		if (amount.getValue() > this.getBalance()) return null;
    		List<Valuable> templist = strategy.withdraw(amount, money);
		if (templist == null) return null;
		for (Valuable valueToWithdraw : templist) {
			money.remove(valueToWithdraw);
		}
		Valuable [] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;
		
//    	Collections.sort( money, comp);
//    	Collections.reverse( money );
//		double amount1 = amount.getValue();
//		if (amount1 < 0) return null;
//		for (Valuable value : money) {
//			if (amount1 >= value.getValue() && value.getCurrency().equalsIgnoreCase(amount.getCurrency())){
//				amount1-= value.getValue();
//				templist.add(value);
//			}
//		}
//		if (amount1!= 0) return null;
//		for (Valuable valueToWithdraw : templist) {
//			money.remove(valueToWithdraw);
//		}
//		if (getBalance() < amount.getValue()) return null;
//		Valuable [] array = new Valuable[templist.size()];
//		templist.toArray(array);
//		return array;
		
    }
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    		return count() + " money with value " + getBalance();
    }
    
    /**
     * Set strategy to another object that come from implements WithdrawStrategy.
     * @param strategy is another object that come from implements WithdrawStrategy.
     */
    public void setWithDrawStrategy(WithdrawStrategy strategy){
    		this.strategy = strategy;
    }
    
    public static void main(String[] args) {
//		Purse p1 = new Purse(5);
//		System.out.println(p1.insert(new BankNote(30,"B")));
//		System.out.println(p1.insert(new BankNote(50,"B")));
//		System.out.println(p1.insert(new BankNote(20,"B")));
//		System.out.println(p1.insert(new BankNote(100,"B")));
//		
//		System.out.println(p1.withdraw(new BankNote(50,"B")));
//		System.out.println(p1.withdraw(new BankNote(30,"C")));
//		System.out.println(p1.withdraw(new BankNote(20,"B")));
    	
    		Purse purse = new Purse(10);
    		double[] values = { 1, 20, 0.5, 10 }; // values of coins we will insert

    		for (double value : values) {
    			Valuable coin = new Money(value, "Bath");
    			purse.insert(coin);
    			Valuable[] result = purse.withdraw(value);
    			System.out.println(result != null);
    		}
	}
}