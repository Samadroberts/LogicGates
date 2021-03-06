import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import logic.Constants.HighConstantGate;
import logic.Constants.LowConstantGate;
import logic.gates.AND;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class ANDTest {
	HighConstantGate one;
	LowConstantGate zero;
	@Before
	public void init() {
		one = new HighConstantGate();
		zero = new LowConstantGate();
	}
	@Test
	public void testOneOne() {
		AND andGate = new AND();
		try {
			andGate.addInput(one);
			andGate.addInput(one);
			Assert.assertTrue(andGate.computeOutput());
		} catch (NoValidInputException e) {
			e.printStackTrace();
			fail();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testOneZero() {
		AND andGate = new AND();
		try {
			andGate.addInput(one);
			andGate.addInput(zero);
			Assert.assertFalse(andGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testZeroZero() {
		AND andGate = new AND();

		try {
			andGate.addInput(zero);
			andGate.addInput(zero);
			Assert.assertFalse(andGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testMultipleInputTrue() {
		AND andGate = new AND();
		try {
			for(int i = 0; i <5; i++) {
				andGate.addInput(one);
			}
			Assert.assertTrue(andGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testMultipleInputFalse() {
		AND andGate = new AND();
		try {
			andGate.addInput(one);
			andGate.addInput(one);
			andGate.addInput(one);
			andGate.addInput(zero);
			andGate.addInput(zero);
			Assert.assertFalse(andGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testNoInputs() {
		AND andGate = new AND();
		try {
			andGate.computeOutput();
			fail("Method Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
