package gui.gates;

import logic.gates.NAND;

import static gui.gates.GateType.NAND;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class NandGate extends abstractGate {
	private static final String PATH = "/fxml/gates/NAND.fxml";
	private static final GateType GATE_TYPE = NAND;

	public NandGate() {
		super(PATH,GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new NAND();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
