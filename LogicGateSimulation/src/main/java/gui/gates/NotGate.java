package gui.gates;

import logic.gates.NOT;

import static gui.gates.GateType.NOT;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NotGate extends abstractGate {
	private static final String PATH = "/fxml/gates/NOT.fxml";
	private static final GateType GATE_TYPE = NOT;

	public NotGate() {
		super(PATH,GATE_TYPE);
	}


	@Override
	public void initLogicGate() {
		logicGate = new NOT();
	}

	@Override
	public void refreshGate() {

	}
	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
