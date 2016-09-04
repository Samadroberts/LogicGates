package gui.gates.constants;

import gui.gates.GateType;
import gui.gates.abstractGate;
import logic.Constants.HighConstantGate;

import static gui.gates.GateType.HIGH_CONSTANT;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class HighConstant extends abstractGate {
	private static final String PATH = "/fxml/gates/HIGHCONSTANT.fxml";
	private static final GateType GATE_TYPE = HIGH_CONSTANT;
	public HighConstant() {
		super(PATH, GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new HighConstantGate();
	}

	@Override
	public void refreshGate() {

	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}

}
