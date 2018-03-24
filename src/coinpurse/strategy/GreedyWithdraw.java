package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import coinpurse.Purse;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy{
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		Comparator<Valuable> comp = new ValueComparator();
		List<Valuable> templist = new ArrayList<>();
		Collections.sort( items, comp);
		Collections.reverse(items);
		double amount1 = amount.getValue();
		if (amount1 < 0) return null;
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
