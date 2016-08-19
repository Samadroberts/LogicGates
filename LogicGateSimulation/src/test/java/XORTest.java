import Gates.Constants.HighConstant;
import Gates.Constants.LowConstant;
import Gates.XOR;
import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.fail;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class XORTest {
	private HighConstant one;
	private LowConstant zero;
	private XOR xor;

	@Before
	public void init() {
		one = new HighConstant();
		zero = new LowConstant();
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
