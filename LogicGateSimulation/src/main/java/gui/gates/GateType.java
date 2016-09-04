package gui.gates;

import gui.gates.constants.HighConstant;
import gui.gates.constants.LowConstant;
import gui.gates.outputs.LightBulb;

/**
 * Created by Sam Roberts on 8/28/2016.
 */
public enum GateType {
	AND("AND"),
	OR("OR"),
	NOT("NOT"),
	NAND("NAND"),
	NOR("NOR"),
	XOR("XOR"),
	XNOR("XNOR"),
	HIGH_CONSTANT("HIGH_CONSTANT"),
	LOW_CONSTANT("LOW_CONSTANT"),
	LIGHT_BULB("LIGHT_BULB")
	;

	private String type;
	GateType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String valueOf(GateType gateType) {
		return gateType.type;
	}

	public static abstractGate getGate(GateType gateType) {
		switch (gateType) {
			case AND:
				return new AndGate();
			case OR:
				return new OrGate();
			case NOT:
				return new NotGate();
			case NAND:
				return new NandGate();
			case NOR:
				return new NorGate();
			case XOR:
				return new XorGate();
			case XNOR:
				return new XnorGate();
			case HIGH_CONSTANT:
				return new HighConstant();
			case LOW_CONSTANT:
				return new LowConstant();
			case LIGHT_BULB:
				return new LightBulb();
			default:
				return null;
		}

	}

	public static boolean contains(GateType value) {
		for(GateType gateType : GateType.values()) {
			if(gateType == value) {
				return true;
			}
		}
		return false;
	}
}
