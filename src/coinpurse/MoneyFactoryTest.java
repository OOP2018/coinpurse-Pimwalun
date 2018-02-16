package coinpurse;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the MoneyFactory using JUnit. This is a JUnit 4 test suite.
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 * 
 * @author Pimwalun Witchawanitchanun
 * @version 2018.01.19
 */
public class MoneyFactoryTest {

	private static final double TOL = 1.0E-6;
	private static MoneyFactory mf = MoneyFactory.getInstance();

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/**
	 * Test method setFactory and getInstance of ThaiMoneyFactory
	 */
	@Test
	public void testSetAndGetInstanceThai() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	/**
	 * Test method setFactory and getInstance of MalayMoneyFactory
	 */
	@Test
	public void testSetAndGetInstanceMalay() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}

	/**
	 * Test method createMoney(double) in MoneyFactory
	 */
	@Test
	public void testCreateMoneyThaiDouble() {
		testSetAndGetInstanceThai();
		mf = MoneyFactory.getInstance();
		Valuable v = mf.createMoney(5);
		Valuable v1 = mf.createMoney(50);
		Valuable v2 = mf.createMoney(20);
		Valuable v3 = mf.createMoney(10);
		Valuable v4 = mf.createMoney(0.5);

		assertEquals("5.0-Baht", v.toString());
		assertEquals("50.0-Baht note [1000000]", v1.toString());
		assertEquals(20.0, v2.getValue(), TOL);
		assertEquals(10.0, v3.getValue(), TOL);
		assertEquals("Baht", v2.getCurrency());
		assertEquals("Satang", v4.getCurrency());
		assertEquals(((BankNote) v1).getSerial(), 1000000);
		assertEquals(((BankNote) v2).getSerial(), 1000001);

	}

	/**
	 * Test method createMoney(String) in MoneyFactory
	 */
	@Test
	public void testCreateMoneyThaiString() {
		testSetAndGetInstanceThai();
		mf = MoneyFactory.getInstance();
		Valuable v = mf.createMoney("1");
		Valuable v1 = mf.createMoney("10");
		Valuable v2 = mf.createMoney("20");
		Valuable v3 = mf.createMoney("50");
		Valuable v4 = mf.createMoney("0.5");

		assertEquals("1.0-Baht", v.toString());
		assertEquals("10.0-Baht", v1.toString());
		assertEquals(20.0, v2.getValue(), TOL);
		assertEquals(50.0, v3.getValue(), TOL);
		assertEquals("Baht", v2.getCurrency());
		assertEquals("Satang", v4.getCurrency());
		assertEquals(((BankNote) v2).getSerial(), 1000000);
		assertEquals(((BankNote) v3).getSerial(), 1000001);
	}

	/**
	 * Test method createMoney(double) in MoneyFactory
	 */
	@Test
	public void testCreateMoneyMalayDouble() {
		testSetAndGetInstanceMalay();
		mf = MoneyFactory.getInstance();
		Valuable v = mf.createMoney(0.05);
		Valuable v1 = mf.createMoney(50);
		Valuable v2 = mf.createMoney(20);
		Valuable v3 = mf.createMoney(0.2);
		
		assertEquals("5.0-Sen", v.toString());
		assertEquals(20.0, v2.getValue(), TOL);
		assertEquals(20.0, v3.getValue(), TOL);
		assertEquals("Sen", v.getCurrency());
		assertEquals("Ringgit", v2.getCurrency());
		assertEquals(((BankNote) v1).getSerial(), 1000000);
		assertEquals(((BankNote) v2).getSerial(), 1000001);
	}

	/**
	 * Test method createMoney(String) in MoneyFactory
	 */
	@Test
	public void testCreateMoneyMalayString() {
		testSetAndGetInstanceMalay();
		mf = MoneyFactory.getInstance();
		Valuable v = mf.createMoney("0.05");
		Valuable v1 = mf.createMoney("0.2");
		Valuable v2 = mf.createMoney("20");
		Valuable v3 = mf.createMoney("50");

		assertEquals("5.0-Sen", v.toString());
		assertEquals("20.0-Sen", v1.toString());
		assertEquals(20.0, v2.getValue(), TOL);
		assertEquals(50.0, v3.getValue(), TOL);
		assertEquals("Sen", v1.getCurrency());
		assertEquals("Ringgit", v2.getCurrency());
		assertEquals(((BankNote) v2).getSerial(), 1000000);
		assertEquals(((BankNote) v3).getSerial(), 1000001);
	}

	/**
	 * Test IllegalArgumentException if value is not valid number.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testThrowsException() {
		Valuable a = mf.createMoney("abc");
		Valuable b = mf.createMoney(-3);
		Valuable c = mf.createMoney(10000);
		assertEquals("Value is not a valid number", a.getValue());
		assertEquals("Value is not a valid number", b.getValue());
		assertEquals("Value is not a valid number", c.getValue());
	}
}