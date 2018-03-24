package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;
import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/**
 * This class is a withdraw by recursion.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{
	
	/**
	 * Find and return items from a collection whose total value equals
	 * the requested amount.
	 * @param amount is the amount of money to withdraw, with currency
	 * @param items the contents that are available for possible withdraw.
	 * 			Must not be null, but may be an empty list. This list is not modified.
	 * @return value from helperWithdraw method that is list containing or null.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		/** Check currency that equally. */
		MoneyUtil.filterByCurrency(items, amount.getCurrency());
		return helperWithdraw(amount.getValue(), items);
	}
	
	/**
	 * Help method withdraw and return items from a collection whose total value equals.
	 * @param amount is the amount of money to withdraw, with currency
	 * @param items the contents that are available for possible withdraw.
	 * 			Must not be null, but may be an empty list. This list is not modified.
	 * @return if a solution is found, return a List containing references
	 * 			from the items parameter (List) whose sum equals the amount.
	 * 			if a solution is not found, return null.
	 */
	public List<Valuable> helperWithdraw(double amount, List<Valuable> items) {
		/** Base cause */
		if (amount < 0) return null;
		/** Base cause */
		if (items.isEmpty() && amount != 0) return null;
		/** Base cause */
		if (amount == 0) return new ArrayList<Valuable>();
		/** Select the  first item in the list, for possible withdraw */
		Valuable first = items.get(0);
		/** Amount minus first item in the list*/
		List<Valuable> result = helperWithdraw(amount - first.getValue(), items.subList(1, items.size()));
		/** Check result (List) is not equals null. So we add first item in the list. Return and find value of amount minus first item in the next item (List) */
		if (result != null){
			result.add(first);
			return result;
		}
		/** If result equals null or otherwise return amount and find amount in the next item (List).*/
		return helperWithdraw(amount, items.subList(1, items.size()));
	}	
}
