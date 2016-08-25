package gui.gates;

import logic.gates.AND;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class AndGate extends abstractGate {
	public AndGate() {
		super();
	}
	@Override
	public void initLogicGate() {
		logicGate = new AND();
	}

	@Override
	public void refreshGate() {

	}

}
