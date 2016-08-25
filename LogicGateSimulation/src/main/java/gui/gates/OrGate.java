package gui.gates;

import logic.gates.OR;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class OrGate extends abstractGate {
	@Override
	public void initLogicGate() {
		logicGate = new OR();
	}

	@Override
	public void refreshGate() {

	}
}
