package gui.nodes;

import exceptions.NoValidInputException;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.StrokeLineCap;
import logic.gates.LogicGate;

/**
 * Created by Sam Roberts on 8/24/2016.
 */
public class Connection extends CubicCurve {
	private InputNode OutputConnection; //input node it is connected to
	private OutputNode InputConnection; //output node connected to

	private SimpleDoubleProperty doublePropertyX;
	private SimpleDoubleProperty getDoublePropertyY;
	public Connection() {
		setStroke(Color.DODGERBLUE);
		setStrokeWidth(4);
		setStrokeLineCap(StrokeLineCap.ROUND);
		setFill(Color.TRANSPARENT);
		setMouseTransparent(true);
	}

	public void addConnection(abstractNode node) {
		if(node instanceof InputNode) {
			OutputConnection = (InputNode) node;
		} else {
			InputConnection = (OutputNode) node;
		}
	}

	public void refresh() {
		//TODO add support for race conditions for circuits
		if(OutputConnection != null && InputConnection != null) {
			OutputConnection.getAbstractGate().refreshGate();
			OutputNode outputNode = OutputConnection.getAbstractGate().getOutputNode();
			if (outputNode != null) {
				for (Connection connection : outputNode.getConnectionList()) {
					connection.refresh();
				}
			}
			if (getSignal()) {
				setStroke(Color.GREEN);
			} else {
				setStroke(Color.RED);
			}
		}
	}

	public Boolean getSignal() {
		try {
			return InputConnection.getLogicGate().computeOutput();
		} catch (NoValidInputException e) {
			e.printStackTrace();
		}
		return false;
	}

	public InputNode getOutputConnection() {
		return OutputConnection;
	}

	public OutputNode getInputConnection() {
		return InputConnection;
	}

	public LogicGate getInputLogicGate() {
		return InputConnection.getLogicGate();
	}

	private Point2D findMidPoint(Bounds bounds) {
		return new Point2D((bounds.getMinX() + bounds.getMaxX())/2,
				(bounds.getMaxY() + bounds.getMinY())/2);
	}
}
