package gui.gates;

import logic.gates.OR;

import static gui.gates.GateType.OR;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class OrGate extends abstractGate {
	private static final String PATH = "/fxml/gates/OR.fxml";
	private static final GateType GATE_TYPE = OR;

	public OrGate() {
		super(PATH, GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new OR();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
