import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import logic.Constants.HighConstantGate;
import logic.Constants.LowConstantGate;
import logic.gates.OR;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class ORTest {
	HighConstantGate one;
	LowConstantGate zero;
	@Before
	public void init() {
		one = new HighConstantGate();
		zero = new LowConstantGate();
	}
	@Test
	public void testOneOne() {
		OR orGate = new OR();
		try {
			orGate.addInput(one);
			orGate.addInput(one);
			Assert.assertTrue(orGate.computeOutput());
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		} catch (InvalidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testOneZero() {
		OR orGate = new OR();

		try {
			orGate.addInput(one);
			orGate.addInput(zero);
			Assert.assertTrue(orGate.computeOutput());
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
		OR orGate = new OR();
		try {
			orGate.addInput(zero);
			orGate.addInput(zero);
			Assert.assertFalse(orGate.computeOutput());
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
		OR orGate = new OR();
		try {
			for(int i = 0; i <5; i++) {
				orGate.addInput(one);
			}
			Assert.assertTrue(orGate.computeOutput());
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
		OR orGate = new OR();
		try {
			orGate.addInput(one);
			orGate.addInput(one);
			orGate.addInput(one);
			orGate.addInput(zero);
			orGate.addInput(zero);
			Assert.assertTrue(orGate.computeOutput());
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
		OR orGate = new OR();
		try {
			orGate.computeOutput();
			fail("Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
