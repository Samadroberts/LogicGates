import Gates.AND;
import Gates.Constants.HighConstant;
import Gates.Constants.LowConstant;
import Gates.NOT;
import Gates.OR;
import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class NOTTest {
	HighConstant one;
	LowConstant zero;
	@Before
	public void init() {
		one = new HighConstant();
		zero = new LowConstant();
	}
	@Test
	public void testOneInput() {
		NOT notGate = new NOT();
		try {
			notGate.addInput(one);
			Assert.assertFalse(notGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}

	}
	@Test
	public void testZeroInput() {
		NOT notGate = new NOT();
		try {
			notGate.addInput(zero);
			Assert.assertTrue(notGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testANDInput() {
		AND andGate = new AND();
		NOT notGate = new NOT();
		try {
			notGate.addInput(andGate);
			andGate.addInput(one);
			andGate.addInput(one);
			Assert.assertFalse(notGate.computeOutput());
		} catch (NoValidInputException e) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testANDInputWithError() {
		AND and = new AND();
		NOT not = new NOT();
		try {
			not.addInput(and);
			and.addInput(zero);
			not.computeOutput();
			fail("Should throw an NoValidInputException");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		} catch (InvalidInputException e) {
			fail("Should not throw InvalidInputException");
			e.printStackTrace();
		}
	}
	@Test
	public void testORInputWithError() {
		OR or = new OR();
		NOT not = new NOT();
		try {
			not.addInput(or);
			or.addInput(one);
			not.computeOutput();
			fail("Should throw an Exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		} catch (InvalidInputException e) {
			fail("Should Not throw Invalid InputException");
			e.printStackTrace();
		}
	}
	@Test
	public void testNoInputs() {
		NOT notGate = new NOT();
		try {
			notGate.computeOutput();
			fail("Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
