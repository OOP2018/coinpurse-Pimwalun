package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import coinpurse.Coin;
import coinpurse.MoneyFactory;
import coinpurse.Valuable;

/**
 * Test the WithdrawStrategy using JUnit. This is a JUnit 4 test suite.
 * @author Pimwalun Witchawanitchanun
 *
 */
public class WithdrawTest {
	private WithdrawStrategy strategy;
	private static MoneyFactory mf = MoneyFactory.getInstance();
	private List<Valuable> money = new ArrayList<>();
	private List<Valuable> money1 = new ArrayList<>();
	
	@Before
	public void setUp() {
		strategy = new RecursiveWithdraw();
	}

	@Test
	public void testEasyWithdraw() {
		Valuable coin = mf.createMoney(5.0);
		Valuable coin1 = mf.createMoney(10);
		money.add(coin);
		money1.add(coin);
		assertEquals(strategy.withdraw(coin, money), money1);
		assertNotEquals(strategy.withdraw(coin1, money), money1);
	}
	
	@Test 
	public void testEmptyWithdraw() {
		Valuable coin = mf.createMoney(5);
		assertNull(strategy.withdraw(coin, money));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeWithdraw() {
		Valuable coin = mf.createMoney(-5);
		assertNull(strategy.withdraw(coin, money));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testZeroWithdraw() {
		Valuable coin = mf.createMoney(0);
		money.add(coin);
		assertNull(strategy.withdraw(coin, money));
	}
	
	@Test 
	public void testInvaildWithDraw() {
		Valuable coin = mf.createMoney(10);
		Valuable bn = mf.createMoney(20);
		money.add(coin);
		assertNull(strategy.withdraw(bn, money));
	}
	
	
	@Test
	public void testDiffCurrency() {
		Valuable cointh = new Coin(5.0, "Baht");
		Valuable coinMa = new Coin(5.0, "Ringgit");
		money.add(cointh);
		money1.add(coinMa);
		assertNotEquals(strategy.withdraw(new Coin(5.0, "Baht"), money), money1);
		assertNotEquals(strategy.withdraw(new Coin(10.0, "Baht"), money), money1);
	}
}
