package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import coinpurse.Valuable;

/**
 * This class is a general withdraw.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{
	
	/**
	 * Find and return items from a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of money to withdraw, with currency
	 * @param items the contents that are available for possible withdraw.
	 * 			Must not be null, but may be an empty list. This list is not modified.
	 * @return if a solution is found, return a List containing references
	 * 			from the items parameter (List) whose sum equals the amount.
	 * 			if a solution is not found, return null.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		List<Valuable> templist = new ArrayList<>();
		Collections.sort( items);
		Collections.reverse(items);
		double amount1 = amount.getValue();
		if (amount1 <= 0) return null;
		for (Valuable value : items) {
			if (amount1 >= value.getValue() && value.getCurrency().equalsIgnoreCase(amount.getCurrency())){
				amount1-= value.getValue();
				templist.add(value);
			}
		}
		if (amount1 != 0) return null;
		return templist;
	}
}
