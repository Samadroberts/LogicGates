package Gates.Constants;


import Gates.LogicGate;

/**
 * Created by Sam Roberts on 8/11/2016.
 */
public class HighConstant extends LogicGate {

	@Override
	public void addInput(LogicGate logicGate) {return;}

	@Override
	public Boolean computeOutput() {
		return true;
	}
}
