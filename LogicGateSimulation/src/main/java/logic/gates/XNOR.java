package logic.gates;

import exceptions.NoValidInputException;

/**
 * Created by Sam Roberts on 8/13/2016.
 */
public class XNOR extends LogicGate{
	@Override
	public Boolean computeOutput() throws NoValidInputException {
		if(getInputList().size() > 1) {
			long numTrue = 0;
			for (LogicGate logicGate: getInputList()) {
				if(logicGate.computeOutput()) {
					numTrue++;
				}
			}
			return numTrue%2 == 0;
		} else {
			throw new NoValidInputException("There are not enough inputs for this XNOR gate");
		}
	}
}
