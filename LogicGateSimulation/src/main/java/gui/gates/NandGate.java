package gui.gates;

import logic.gates.NAND;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NandGate extends abstractGate {
	@Override
	public void initLogicGate() {
		logicGate = new NAND();
	}

	@Override
	public void refreshGate() {

	}
}
