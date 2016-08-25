package logic.outputs;

import exceptions.InvalidInputException;
import exceptions.NoValidInputException;
import logic.gates.LogicGate;

/**
 * Created by Sam Roberts on 8/24/2016.
 */
public class LightBulbOutput extends LogicGate {
	public LightBulbOutput() {
		setInputLimit(1);
	}
	@Override
	public Boolean computeOutput() throws NoValidInputException {
		if(getInputList().size() == 1) {
			return getInputList().get(0).computeOutput();
		}
		throw new NoValidInputException("There are not enough inputs for this LightBulbOutput");
	}
}
