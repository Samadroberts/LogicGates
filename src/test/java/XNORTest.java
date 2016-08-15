package test.java;

import main.java.Gates.XNOR;
import main.java.Gates.Constants.HighConstant;
import main.java.Gates.Constants.LowConstant;
import main.java.exceptions.InvalidInputException;
import main.java.exceptions.NoValidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class XNORTest {
	private HighConstant one;
	private LowConstant zero;
	private XNOR xnor;

	@Before
	public void init() {
		one = new HighConstant();
		zero = new LowConstant();
		xnor = new XNOR();

	}

	@Test
	public void testOneOne() {
		try {
			xnor.addInput(one);
			xnor.addInput(one);
			Assert.assertTrue(xnor.computeOutput());
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
			xnor.addInput(one);
			xnor.addInput(zero);
			Assert.assertFalse(xnor.computeOutput());
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
			xnor.addInput(zero);
			xnor.addInput(zero);
			Assert.assertTrue(xnor.computeOutput());
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
			xnor.addInput(one);
			xnor.addInput(one);
			xnor.addInput(one);
			xnor.addInput(zero);
			xnor.addInput(zero);
			xnor.addInput(zero);
			xnor.addInput(zero);
			Assert.assertFalse(xnor.computeOutput());
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
			xnor.addInput(one);
			xnor.addInput(one);
			xnor.addInput(one);
			xnor.addInput(one);
			xnor.addInput(zero);
			xnor.addInput(zero);
			xnor.addInput(zero);
			Assert.assertTrue(xnor.computeOutput());
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
			xnor.computeOutput();
			fail("Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
