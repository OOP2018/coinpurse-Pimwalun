package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
	
	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 * @param o1 is the first comparator
	 * @param o2 is the second comparator
	 * @return -1 if o1's currency come first 
	 * 			1 if o1's currency come after
	 * 		   	0 if both of 2 have same currency
	 * 		   
	 */
	public int compare(Valuable o1, Valuable o2) {
		if (o1.getCurrency().compareToIgnoreCase(o2.getCurrency()) == 0) {
			if (o1.getValue() < o2.getValue())
				return -1;
			else if (o1.getValue() == o2.getValue())
				return 0;
			return 1;
		}	 
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}
}
