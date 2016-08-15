package test.java;

import main.java.Gates.NAND;
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
public class NANDTest {
	HighConstant one;
	LowConstant zero;
	@Before
	public void init() {
		one = new HighConstant();
		zero = new LowConstant();
	}
	@Test
	public void testOneOne() {
		NAND nand = new NAND();
		try {
			nand.addInput(one);
			nand.addInput(one);
			Assert.assertFalse(nand.computeOutput());
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
		NAND nand = new NAND();
		try {
			nand.addInput(one);
			nand.addInput(zero);
			Assert.assertTrue(nand.computeOutput());
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
		NAND nand = new NAND();

		try {
			nand.addInput(zero);
			nand.addInput(zero);
			Assert.assertTrue(nand.computeOutput());
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
		NAND nand = new NAND();
		try {
			for(int i = 0; i <5; i++) {
				nand.addInput(one);
			}
			Assert.assertFalse(nand.computeOutput());
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
		NAND nand = new NAND();
		try {
			nand.addInput(one);
			nand.addInput(one);
			nand.addInput(one);
			nand.addInput(zero);
			nand.addInput(zero);
			Assert.assertTrue(nand.computeOutput());
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
		NAND nand = new NAND();
		try {
			nand.computeOutput();
			fail("Method Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
