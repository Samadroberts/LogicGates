import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import logic.Constants.HighConstantGate;
import logic.Constants.LowConstantGate;
import logic.gates.XOR;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class XORTest {
	private HighConstantGate one;
	private LowConstantGate zero;
	private XOR xor;

	@Before
	public void init() {
		one = new HighConstantGate();
		zero = new LowConstantGate();
		xor = new XOR();

	}

	@Test
	public void testOneOne() {
		try {
			xor.addInput(one);
			xor.addInput(one);
			Assert.assertFalse(xor.computeOutput());
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testOneZero() {
		try {
			xor.addInput(one);
			xor.addInput(zero);
			Assert.assertTrue(xor.computeOutput());
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testZeroZero() {
		try {
			xor.addInput(zero);
			xor.addInput(zero);
			Assert.assertFalse(xor.computeOutput());
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testOddNumberOfOnes() {
		try {
			xor.addInput(one);
			xor.addInput(one);
			xor.addInput(one);
			xor.addInput(zero);
			xor.addInput(zero);
			xor.addInput(zero);
			xor.addInput(zero);
			Assert.assertTrue(xor.computeOutput());
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testEvenNumberofOnes() {
		try {
			xor.addInput(one);
			xor.addInput(one);
			xor.addInput(one);
			xor.addInput(one);
			xor.addInput(zero);
			xor.addInput(zero);
			xor.addInput(zero);
			Assert.assertFalse(xor.computeOutput());
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		} catch (NoValidInputException e) {
			fail();
			e.printStackTrace();
		}
	}
	@Test
	public void testNoInputs() {
		try {
			xor.computeOutput();
			fail("Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}


}
