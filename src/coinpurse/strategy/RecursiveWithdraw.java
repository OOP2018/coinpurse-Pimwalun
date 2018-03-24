package coinpurse.strategy;

import java.util.List;
import coinpurse.MoneyUtil;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> items) {
		MoneyUtil.filterByCurrency(items, amount.getCurrency());
		return helperWithdraw(amount.getValue(), items);
	}
	
	public List<Valuable> helperWithdraw(double amount, List<Valuable> items) {
		if (amount <= 0) return items;
		if (items.isEmpty() && amount != 0) return null;
		Valuable frist = items.get(0);
		List<Valuable> result = helperWithdraw(amount - frist.getValue(), items.subList(1, items.size()));
		if (result != null){
			result.add(frist);
			return result;
		}
		return helperWithdraw(amount, items.subList(1, items.size()));
	}	
}
