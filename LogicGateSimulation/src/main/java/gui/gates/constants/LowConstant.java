package gui.gates.constants;

import gui.gates.abstractGate;
import logic.Constants.HighConstantGate;
import logic.Constants.LowConstantGate;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class LowConstant extends abstractGate {

	@Override
	public void initLogicGate() {
		logicGate = new LowConstantGate();
	}

	@Override
	public void refreshGate() {

	}
}
