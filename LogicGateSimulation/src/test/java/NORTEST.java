import logic.Constants.HighConstantGate;
import logic.Constants.LowConstantGate;
import logic.gates.NOR;
import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class NORTEST {
	HighConstantGate one;
	LowConstantGate zero;
	@Before
	public void init() {
		one = new HighConstantGate();
		zero = new LowConstantGate();
	}
	@Test
	public void testOneOne() {
		NOR nor = new NOR();
		try {
			nor.addInput(one);
			nor.addInput(one);
			Assert.assertFalse(nor.computeOutput());
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
		NOR nor = new NOR();

		try {
			nor.addInput(one);
			nor.addInput(zero);
			Assert.assertFalse(nor.computeOutput());
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
		NOR nor = new NOR();
		try {
			nor.addInput(zero);
			nor.addInput(zero);
			Assert.assertTrue(nor.computeOutput());
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
		NOR nor = new NOR();
		try {
			for(int i = 0; i <5; i++) {
				nor.addInput(one);
			}
			Assert.assertFalse(nor.computeOutput());
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
		NOR nor = new NOR();
		try {
			nor.addInput(one);
			nor.addInput(one);
			nor.addInput(one);
			nor.addInput(zero);
			nor.addInput(zero);
			Assert.assertFalse(nor.computeOutput());
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
		NOR nor = new NOR();
		try {
			nor.computeOutput();
			fail("Should Have thrown exception");
		} catch (NoValidInputException e) {
			//e.printStackTrace();
		}
	}
}
