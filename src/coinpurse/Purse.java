package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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
	private List<Valuable> money = new ArrayList<Valuable>();
	private Comparator<Valuable> comp = new ValueComparator();
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    		this.capacity = capacity;
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
    			Collections.sort(money, new ValueComparator());
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
    		List<Valuable> templist = new ArrayList<>();
    		Collections.sort( money, comp);
    		Collections.reverse( money );
        if (amount < 0) return null;
		for (Valuable value : money) {
			if (amount >= value.getValue()){
				amount -= value.getValue();
				templist.add(value);
			}
		}
		if (amount != 0) return null;
		for (Valuable valueToWithdraw : templist) {
			money.remove(valueToWithdraw);
		}
		if (getBalance() < amount) return null;
		Valuable [] array = new Valuable[templist.size()];
		templist.toArray(array);
        return array; 
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
		List<Valuable> templist = new ArrayList<>();
		Collections.sort( money, comp);
		Collections.reverse( money );
		double amount1 = amount.getValue();
		if (amount1 < 0) return null;
		for (Valuable value : money) {
			if (amount1 >= value.getValue() && value.getCurrency().equalsIgnoreCase(amount.getCurrency())){
				amount1-= value.getValue();
				templist.add(value);
			}
		}
		if (amount1!= 0) return null;
		for (Valuable valueToWithdraw : templist) {
			money.remove(valueToWithdraw);
		}
		if (getBalance() < amount1) return null;
		Valuable [] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array; 
    }
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    		return count() + " money with value " + getBalance();
    }
    
//    public static void main(String[] args) {
//		Purse p1 = new Purse(5);
//		System.out.println(p1.insert(new BankNote(30,"B")));
//		System.out.println(p1.insert(new BankNote(50,"B")));
//		System.out.println(p1.insert(new BankNote(20,"B")));
//		System.out.println(p1.insert(new BankNote(100,"B")));
//		
//		System.out.println(p1.withdraw(new BankNote(50,"B")));
//		System.out.println(p1.withdraw(new BankNote(30,"C")));
//		System.out.println(p1.withdraw(new BankNote(20,"B")));
//	}
}