package main.java.Gates;

import main.java.exceptions.NoValidInputException;

/**
 * Created by Sam Roberts on 8/11/2016.
 */
public class AND extends LogicGate {

	public AND() {
	}


	@Override
	public Boolean computeOutput() throws NoValidInputException {
		if(getInputList().size() > 1) {
			Boolean ret = getInputList().get(0).computeOutput();
			for (int i = 1; i < getInputList().size(); i++) {
				ret = ret && getInputList().get(i).computeOutput();
			}
			return ret;
		} else {
			throw new NoValidInputException("There are not enough inputs for this AND gate");
		}
	}
}
