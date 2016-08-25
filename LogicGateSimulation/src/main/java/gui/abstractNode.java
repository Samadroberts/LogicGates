package gui;

import exceptions.InvalidInputException;
import logic.gates.LogicGate;
import gui.gates.abstractGate;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static gui.NODE_STATE.NODE_NEUTRAL;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public abstract class abstractNode extends ImageView {
	private UUID uuid;
	private abstractGate abstractGate;
	private LogicGate logicGate;
	private Image previousImage;
	private static final NodeMouseClicked nodeMouseClicked = new NodeMouseClicked();

	public abstractNode() {
		super();
		uuid = UUID.randomUUID();
		//connectionList = new ArrayList<Connection>();
		Image image = new Image(getClass().getResourceAsStream("/NODE.png"));
		setImage(image);
		setOnMouseEntered(new NodeMouseEntered(this));
		setOnMouseExited(new NodeMouseExited(this));
		setOnMouseClicked(nodeMouseClicked);
	}

	public void setAbstractGate(gui.gates.abstractGate abstractGate) {
		if(this.abstractGate == null) {
			this.abstractGate = abstractGate;
			logicGate = abstractGate.getLogicGate();
		}
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

	public abstract void setConnection(Connection connection);

	public abstract boolean hasConnection();

	/*
	public void refreshGates() {
		for(InputNode inputNode: getAbstractGate().getInputNodes()) {
			Connection connection = inputNode.getConnection();
			if(connection != null) {
				connection.refresh();
				connection.getInputConnection().refreshGates();
			}
			inputNode.getAbstractGate().refreshGate();
		}
		OutputNode outputNode = getAbstractGate().getOutputNode();
		Connection connection = outputNode.getConnection();
		if(connection != null) {
			connection.refresh();
			outputNode.getConnection()
		}

	}
	*/

	public void changeNodeImage(NODE_STATE node_state) {
		Image image;
		previousImage = getImage();
		switch (node_state) {
			case NODE:
				image = new Image(getClass().getResourceAsStream("/NODE.png"));
				break;
			case NODE_NEUTRAL:
				image = new Image(getClass().getResourceAsStream("/NODE_NEUTRAL.png"));
				break;
			case NODE_TRUE:
				image = new Image(getClass().getResourceAsStream("/NODE_TRUE.png"));
				break;
			case NODE_FALSE:
				image = new Image(getClass().getResourceAsStream("/NODE_FALSE.png"));
				break;
			default:
				image = new Image(getClass().getResourceAsStream("/NODE.png"));
		}
		this.setImage(image);
	}

	private class NodeMouseEntered implements EventHandler<MouseEvent> {
		private abstractNode abstractNode;
		public NodeMouseEntered(abstractNode abstractNode) {
			this.abstractNode = abstractNode;
		}
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof abstractNode) {
				abstractNode abstractNode = (abstractNode) event.getSource();
				if(abstractNode.equals(this.abstractNode)) {
					abstractNode.changeNodeImage(NODE_NEUTRAL);
				}
			}
		}
	}

	private class NodeMouseExited implements EventHandler<MouseEvent> {
		private abstractNode abstractNode;
		public NodeMouseExited(abstractNode abstractNode) {
			this.abstractNode = abstractNode;
		}
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof abstractNode) {
				abstractNode abstractNode = (abstractNode) event.getSource();
				if(abstractNode.equals(this.abstractNode)) {
					abstractNode.setImage(abstractNode.previousImage);
				}
			}
		}
	}
}
