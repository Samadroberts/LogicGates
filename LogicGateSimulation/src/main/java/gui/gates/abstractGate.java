package gui.gates;

import gui.Connection;
import javafx.scene.image.ImageView;
import logic.gates.LogicGate;
import gui.InputNode;
import gui.OutputNode;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public abstract class abstractGate extends Pane {
	private UUID uuid;
	protected LogicGate logicGate;
	private Connection connection;

	protected ImageView imageView;

	private List<InputNode> inputNodes;

	private OutputNode outputNode;

	public abstractGate() {
		super();
		uuid = UUID.randomUUID();
		inputNodes = new ArrayList<InputNode>();
		initLogicGate();
	}

	public UUID getUuid() {
		return uuid;
	}

	public abstract void initLogicGate();

	public void addInput(InputNode inputNode) {
		if(inputNode != null) {
			inputNodes.add(inputNode);
		}
	}

	public void addInputs(InputNode ... inputNodes) {
		for(InputNode inputNode: inputNodes) {
			addInput(inputNode);
		}
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public abstract void refreshGate();

	/*
	public boolean connectToInput(OutputNode outputNode) {
		if(inputNodes.isEmpty()) {
			return false;
		} else {
			for(InputNode inputNode: inputNodes) {
				if(!inputNode.hasConnection()) {
					try {
						inputNode.setConnection(outputNode);
						logicGate.addInput(inputNode.getLogicGate());
					} catch (InvalidInputException e) {
						e.printStackTrace();
						return false;
					}
					return true;
				}
			}
			return false;
		}
	}
	*/


	@FXML
	public OutputNode getOutputNode() {
		return outputNode;
	}

	@FXML
	public void setOutputNode(OutputNode outputNode) {
		this.outputNode = outputNode;
		outputNode.setLogicGate(logicGate);
	}

	public LogicGate getLogicGate() {
		return logicGate;
	}

	public List<InputNode> getInputNodes() {
		return inputNodes;
	}
}
