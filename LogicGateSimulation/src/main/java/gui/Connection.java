package gui;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;
import logic.gates.LogicGate;
import exceptions.NoValidInputException;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by Sam Roberts on 8/24/2016.
 */
public class Connection extends Line {
	private InputNode OutputConnection; //input node it is connected to
	private OutputNode InputConnection; //output node connected to

	public Connection() {
	}

	public void setOutputConnection(InputNode inputNode) {
		Point2D point2D = findMidPoint(inputNode.localToScene(inputNode.getBoundsInLocal()));
		setEndX(point2D.getX());
		setEndY(point2D.getY());
		OutputConnection = inputNode;
	}

	public void setInputConnection(OutputNode outputNode) {
		Point2D point2D = findMidPoint(outputNode.localToScene(outputNode.getBoundsInLocal()));
		setStartX(point2D.getX());
		setStartY(point2D.getY());
		InputConnection = outputNode;
	}

	public void refresh() {
		OutputConnection.getAbstractGate().refreshGate();
		OutputNode outputNode = OutputConnection.getAbstractGate().getOutputNode();
		if(outputNode != null) {
			for (Connection connection : outputNode.getConnectionList()) {
				connection.refresh();
			}
		}
		if(getSignal()) {
			setStroke(Color.GREEN);
		} else {
			setStroke(Color.RED);
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
