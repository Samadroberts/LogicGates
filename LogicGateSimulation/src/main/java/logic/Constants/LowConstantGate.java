package logic.Constants;

import logic.gates.LogicGate;

/**
 * Created by Sam Roberts on 8/11/2016.
 */
public class LowConstantGate extends LogicGate {
	@Override
	public void addInput(LogicGate logicGate) {return;}

	@Override
	public Boolean computeOutput() {
		return false;
	}
}
