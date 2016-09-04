package gui.gates.outputs;

import exceptions.NoValidInputException;
import gui.gates.GateType;
import gui.gates.abstractGate;
import javafx.scene.image.Image;
import logic.outputs.LightBulbOutput;

import static gui.gates.GateType.LIGHT_BULB;

/**
 * Created by Sam Roberts on 8/24/2016.
 */
public class LightBulb extends abstractGate {
	private static final String PATH = "/fxml/gates/LIGHTBULB.fxml";
	private static final GateType GATE_TYPE = LIGHT_BULB;

	public LightBulb() {
		super(PATH,GATE_TYPE);
	}

	@Override
	public void initLogicGate() {
		logicGate = new LightBulbOutput();
	}

	@Override
	public void refreshGate() {
		try {
			Image image;
			if(getLogicGate().computeOutput()) {
				image = new Image(getClass().getResourceAsStream("/images/gates/LIGHT_ON.png"));
				imageView.setImage(image);
			} else {
				image = new Image(getClass().getResourceAsStream("/images/gates/LIGHT_OFF.png"));
				imageView.setImage(image);
			}
		} catch (NoValidInputException e) {
			e.printStackTrace();
		}
	}

	@Override
	public GateType getGateType() {
		return GATE_TYPE;
	}
}
