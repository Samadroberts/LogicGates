package gui.nodes.nodeEventHandlers;

import gui.nodes.Connection;
import gui.nodes.InputNode;
import gui.nodes.abstractNode;
import gui.nodes.OutputNode;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class nodeMouseClickedEventHandler implements EventHandler<MouseEvent> {
	private abstractNode abstractNode;
	private Pane pane;
	private static abstractNode lastNodeClicked = null;
	public nodeMouseClickedEventHandler(abstractNode abstractNode, Pane pane) {
		this.abstractNode = abstractNode;
		this.pane = pane;
	}
	public boolean validClick() {
		if(abstractNode instanceof InputNode) {
			InputNode tempNode = (InputNode) abstractNode;
			if(tempNode.getConnection() != null) {
				return false;
			}
		}
		return ! (lastNodeClicked.getUuid().equals(abstractNode.getUuid()) ||
				lastNodeClicked.getAbstractGate().getUuid().equals(abstractNode.getAbstractGate().getUuid()) ||
				((lastNodeClicked instanceof InputNode) && (abstractNode instanceof InputNode)) ||
				((lastNodeClicked instanceof OutputNode) && (abstractNode instanceof OutputNode)));
	}
	@Override
	public void handle(MouseEvent event) {
		if(lastNodeClicked == null) {
			Connection connection = new Connection();
			abstractNode.updateLocalCoordinates();
			connection.startXProperty().bind(abstractNode.getRelativeToRightPaneX());
			connection.startYProperty().bind(abstractNode.getRelativeToRightPaneY());
			connection.controlX1Property().bind(abstractNode.getRelativeToRightPaneX());
			connection.controlY1Property().bind(abstractNode.getRelativeToRightPaneY());
			connection.addConnection(abstractNode);
			abstractNode.addConnection(connection);
			connection.endXProperty().bind(abstractNode.getMouseSceneX());
			connection.endYProperty().bind(abstractNode.getMouseSceneY());
			connection.controlX2Property().bind(abstractNode.getMouseSceneX());
			connection.controlY2Property().bind(abstractNode.getMouseSceneY());
			lastNodeClicked = abstractNode;
			pane.getChildren().add(connection);
		} else {
			if(validClick()) {
				Connection connection = lastNodeClicked.getConnection();
				connection.addConnection(abstractNode);
				abstractNode.addConnection(connection);
				connection.endYProperty().unbind();
				connection.endXProperty().unbind();
				connection.controlX2Property().unbind();
				connection.controlY2Property().unbind();
				abstractNode.updateLocalCoordinates();
				connection.endXProperty().bind(abstractNode.getRelativeToRightPaneX());
				connection.endYProperty().bind(abstractNode.getRelativeToRightPaneY());
				connection.controlX2Property().bind(abstractNode.getRelativeToRightPaneX());
				connection.controlY2Property().bind(abstractNode.getRelativeToRightPaneY());
				abstractNode.initConnection();
				lastNodeClicked.initConnection();
				lastNodeClicked = null; //sucessfull connection
			}
		}
	}

}
