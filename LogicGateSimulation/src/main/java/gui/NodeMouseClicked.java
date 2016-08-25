package gui;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.transform.Transform;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class NodeMouseClicked implements EventHandler<MouseEvent> {
	private abstractNode lastNodeClicked;
	public NodeMouseClicked() {
	}
	private boolean validClick(abstractNode abstractNode) {
		InputNode inputNode = null;
		OutputNode outputNode = null;
		if(abstractNode instanceof InputNode) {
			inputNode = (InputNode) abstractNode;
		} else if (abstractNode instanceof OutputNode) {
			outputNode = (OutputNode) abstractNode;
		}
		if(lastNodeClicked instanceof InputNode) {
			inputNode = (InputNode) lastNodeClicked;
		} else if (lastNodeClicked instanceof OutputNode) {
			outputNode = (OutputNode) lastNodeClicked;
		}

		if((inputNode == null) || (outputNode == null)) {
			return false;
		} else {
			return !inputNode.hasConnection() && lastNodeClicked.getAbstractGate().getUuid() !=
					abstractNode.getAbstractGate().getUuid();
		}
		/*
		return ((lastNodeClicked instanceof InputNode)
				&& (abstractNode instanceof OutputNode)
				|| (lastNodeClicked instanceof OutputNode)
				&& (abstractNode instanceof InputNode)) &&;
				*/
	}
	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() != null && (event.getSource() instanceof abstractNode)) {
			abstractNode node = (abstractNode) event.getSource();
			if(lastNodeClicked == null) {
				lastNodeClicked = node;
				return;
			} else if(validClick(node)) {
				Connection connection = new Connection();
				if(lastNodeClicked instanceof InputNode) {
					connection.setInputConnection((OutputNode) node);
					connection.setOutputConnection((InputNode) lastNodeClicked);
					//order matters here
					lastNodeClicked.setConnection(connection);
					node.setConnection(connection);
				} else {
					connection.setInputConnection((OutputNode) lastNodeClicked);
					connection.setOutputConnection((InputNode) node);
					//order matters here
					node.setConnection(connection);
					lastNodeClicked.setConnection(connection);
				}

				application.getRoot().getChildren().add(connection);
			}
			lastNodeClicked = node;
		} else {
			lastNodeClicked = null;
		}
	}

}
