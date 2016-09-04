package gui.gates;

import logic.gates.NOR;

import static gui.gates.GateType.NOR;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NorGate extends abstractGate {
	private static final String PATH = "/fxml/gates/NOR.fxml";
	private static final GateType GATE_TYPE = NOR;

	public NorGate() {
		super(PATH,GATE_TYPE);
	}


	@Override
	public void initLogicGate() {
		logicGate = new NOR();
	}

	@Override
	public void refreshGate() {

	}
	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
