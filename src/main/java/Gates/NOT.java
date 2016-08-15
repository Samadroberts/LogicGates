package main.java.Gates;

import main.java.exceptions.NoValidInputException;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class NOT extends LogicGate {
	public NOT() {
		super();
		setInputLimit(1);
	}
	@Override
	public Boolean computeOutput() throws NoValidInputException{
		if(!getInputList().isEmpty()) {
			try {
				return !(getInputList().get(0).computeOutput());
			} catch (NoValidInputException e) {
				throw e;
			}
		} else {
			throw new NoValidInputException("NOT gate has no input!");
		}
	}
}
