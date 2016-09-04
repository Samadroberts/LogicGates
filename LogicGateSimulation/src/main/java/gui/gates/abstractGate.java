package gui.gates;

import gui.controllers.abstractController;
import gui.nodes.Connection;
import gui.nodes.InputNode;
import gui.nodes.abstractNode;
import gui.nodes.OutputNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import logic.gates.LogicGate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public abstract class abstractGate extends AnchorPane {
	private UUID uuid;
	protected LogicGate logicGate;
	private Connection connection;



	@FXML
	protected ImageView imageView;

	private List<InputNode> inputNodes;

	@FXML
	private OutputNode outputNode;

	public abstractGate(String path, GateType gateType) {
		super();
		this.backgroundProperty().set(Background.EMPTY);
		uuid = UUID.randomUUID();
		inputNodes = new ArrayList<InputNode>();
		initLogicGate();
		loadGate(path);
	}

	public void loadGate(String path) {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource(path)
		);
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(new abstractController());

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void relocateToPoint (Point2D p) {

		Point2D localCoords = getParent().sceneToLocal(p);



		relocate (
				(int) (localCoords.getX() -
						(getBoundsInLocal().getWidth() / 2)),
				(int) (localCoords.getY() -
						(getBoundsInLocal().getHeight() / 2))
		);
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

	public void addInputs(InputNode... inputNodes) {
		for(InputNode inputNode: inputNodes) {
			addInput(inputNode);
		}
	}

	public void setAllConnectionsVisible(boolean visible) {
		for(abstractNode node : getAllNodes()) {
			if(node.hasConnection()) {
				node.setConnectionVisisble(visible);
			}
		}
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public abstract void refreshGate();

	public abstract GateType getGateType();


	@FXML
	public OutputNode getOutputNode() {
		return outputNode;
	}

	@FXML
	public void setOutputNode(OutputNode outputNode) {
		this.outputNode = outputNode;
		outputNode.setLogicGate(logicGate);
	}

	public List<abstractNode> getAllNodes() {
		List<abstractNode> abstractNodes = new ArrayList<abstractNode>();
		if(!getInputNodes().isEmpty()) {
			abstractNodes.addAll(getInputNodes());
		}
		if(outputNode != null) {
			abstractNodes.add(outputNode);
		}
		return abstractNodes;
	}

	public LogicGate getLogicGate() {
		return logicGate;
	}

	public List<InputNode> getInputNodes() {
		return inputNodes;
	}

	public void updateNodes() {
		for(abstractNode node : getAllNodes()) {
			node.updateLocalCoordinates();
		}
	}
}
