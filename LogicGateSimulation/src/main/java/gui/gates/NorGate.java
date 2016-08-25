package gui.gates;

import logic.gates.NOR;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NorGate extends abstractGate {
	@Override
	public void initLogicGate() {
		logicGate = new NOR();
	}

	@Override
	public void refreshGate() {

	}
}
