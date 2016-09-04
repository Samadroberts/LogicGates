package gui.gates;

import logic.gates.XNOR;

import static gui.gates.GateType.XNOR;

/**
 * Created by Sam Roberts on 8/26/2016.
 */
public class XnorGate extends abstractGate {
	private static final String PATH = "/fxml/gates/XNOR.fxml";
	private static final GateType GATE_TYPE = XNOR;

	public XnorGate() {
		super(PATH,GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new XNOR();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
