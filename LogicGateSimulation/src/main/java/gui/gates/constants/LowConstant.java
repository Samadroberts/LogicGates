package gui.gates.constants;

import gui.gates.GateType;
import gui.gates.abstractGate;
import logic.Constants.LowConstantGate;

import static gui.gates.GateType.LOW_CONSTANT;

/**
 * Created by Sam Roberts on 8/25/2016.
 */
public class LowConstant extends abstractGate {
	private static final String PATH = "/fxml/gates/LOWCONSTANT.fxml";
	private static final GateType GATE_TYPE = LOW_CONSTANT;

	public LowConstant() {
		super(PATH, GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new LowConstantGate();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
