package gui.gates;

import logic.gates.XOR;

import static gui.gates.GateType.XOR;

/**
 * Created by Sam Roberts on 8/26/2016.
 */
public class XorGate extends abstractGate {
	private static final String PATH = "/fxml/gates/XOR.fxml";
	private static final GateType GATE_TYPE = XOR;

	public XorGate() {
		super(PATH, GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new XOR();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
