package gui.gates;

import logic.gates.AND;

import static gui.gates.GateType.AND;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class AndGate extends abstractGate {
	private static final String PATH = "/fxml/gates/AND.fxml";
	private static final GateType GATE_TYPE = AND;

	public AndGate() {
		super(PATH,GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new AND();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}

}
