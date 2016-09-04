package gui.nodes;

import gui.nodes.nodeEventHandlers.nodeMouseClickedEventHandler;
import gui.nodes.nodeListeners.rightPaneMouseMotionListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import logic.gates.LogicGate;

import java.util.UUID;

/**
 * Created by Sam Roberts on 9/2/2016.
 */
public abstract class abstractNode extends Circle {
	private UUID uuid;
	private gui.gates.abstractGate abstractGate;
	private LogicGate logicGate;
	private rightPaneMouseMotionListener mousePositionListener;
	private nodeMouseClickedEventHandler mouseClickedEventHandler;

	private DoubleProperty relativeToRightPaneX;
	private DoubleProperty relativeToRightPaneY;

	public abstractNode() {
		super(8);
		Color color = Color.BLACK;
		setFill(color.deriveColor(1, 1, 1, 0.5));
		setStroke(color);
		setStrokeWidth(2);
		setStrokeType(StrokeType.OUTSIDE);
		uuid = UUID.randomUUID();

	}
	public void setAbstractGate(gui.gates.abstractGate abstractGate) {
		if(this.abstractGate == null) {
			this.abstractGate = abstractGate;
			logicGate = abstractGate.getLogicGate();
		}
	}

	public void updateLocalCoordinates() {
		double x = getAbstractGate().getBoundsInParent().getMinX();
		x += getParent().getBoundsInParent().getMinX();
		x += getBoundsInParent().getMinX();
		x += (getRadius()*1.5);
		double y = getAbstractGate().getBoundsInParent().getMinY();
		y += getParent().getBoundsInParent().getMinY();
		y += getBoundsInParent().getMinY();
		y += (getRadius()*1.5);
		setRelativeToRightPaneX(x);
		setRelativeToRightPaneY(y);
	}

	public gui.gates.abstractGate getAbstractGate() {
		return abstractGate;
	}

	public LogicGate getLogicGate() {
		return logicGate;
	}

	public void setLogicGate(LogicGate logicGate) {
		this.logicGate = logicGate;
	}

	public UUID getUuid() {
		return uuid;
	}

	public boolean equals(abstractNode abstractNode) {
		return abstractNode.getUuid().equals(getUuid());
	}

	public abstract boolean hasConnection();

	public void setMouseMotionListener(rightPaneMouseMotionListener eventHandler) {
		mousePositionListener = eventHandler;
	}

	public void initOnclick(final AnchorPane anchorPane) {
		mouseClickedEventHandler = new nodeMouseClickedEventHandler(this,anchorPane);
		setOnMouseClicked(mouseClickedEventHandler);
	}

	public abstract Connection getConnection();

	public abstract int getMaxConnections();


	public abstract void addConnection(Connection connection);

	public DoubleProperty getMouseSceneX() {
		return mousePositionListener.getSceneX();
	}

	public abstract void initConnection();

	public DoubleProperty getMouseSceneY() {
		return mousePositionListener.getSceneY();
	}

	public DoubleProperty getRelativeToRightPaneX() {
		if(relativeToRightPaneX == null) {
			relativeToRightPaneX = new DoublePropertyBase() {
				@Override
				public Object getBean() {
					return abstractNode.this;
				}

				@Override
				public String getName() {
					return "relativeToRightPaneX";
				}
			};
		}
		return relativeToRightPaneX;
	}

	public DoubleProperty getRelativeToRightPaneY() {
		if(relativeToRightPaneY == null) {
			relativeToRightPaneY = new DoublePropertyBase() {
				@Override
				public Object getBean() {
					return abstractNode.this;
				}

				@Override
				public String getName() {
					return "relativeToRightPaneY";
				}
			};
		}
		return relativeToRightPaneY;
	}

	public void setRelativeToRightPaneX(double value) {
		if(value != 0.0) {
			getRelativeToRightPaneX().set(value);
		}
	}

	public abstract void setConnectionVisisble(boolean visible);

	public void setRelativeToRightPaneY(double value) {
		if(value != 0.0) {
			getRelativeToRightPaneY().set(value);
		}
	}
}
