package gui.gates.outputs;

import exceptions.NoValidInputException;
import gui.gates.abstractGate;
import javafx.scene.image.Image;
import logic.outputs.LightBulbOutput;
import org.omg.CORBA.IMP_LIMIT;

/**
 * Created by Sam Roberts on 8/24/2016.
 */
public class LightBulb extends abstractGate {
	@Override
	public void initLogicGate() {
		logicGate = new LightBulbOutput();
	}

	@Override
	public void refreshGate() {
		try {
			Image image;
			if(getLogicGate().computeOutput()) {
				image = new Image(getClass().getResourceAsStream("/LIGHT_ON.png"));
				imageView.setImage(image);
			} else {
				image = new Image(getClass().getResourceAsStream("/LIGHT_OFF.png"));
				imageView.setImage(image);
			}
		} catch (NoValidInputException e) {
			e.printStackTrace();
		}
	}
}
