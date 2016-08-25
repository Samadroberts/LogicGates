package gui.gates;

import logic.gates.NOT;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NotGate extends abstractGate {
	@Override
	public void initLogicGate() {
		logicGate = new NOT();
	}

	@Override
	public void refreshGate() {

	}
}
