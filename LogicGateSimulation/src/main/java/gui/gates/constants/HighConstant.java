package gui.gates.constants;
import gui.gates.abstractGate;
import logic.Constants.HighConstantGate;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class HighConstant extends abstractGate {
	public HighConstant() {
		super();
	}
	@Override
	public void initLogicGate() {
		logicGate = new HighConstantGate();
	}

	@Override
	public void refreshGate() {

	}

}
