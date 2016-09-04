package gui.controllers;

import gui.gates.abstractGate;
import gui.nodes.InputNode;
import gui.nodes.OutputNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public class abstractController implements Initializable {
	@FXML
	private OutputNode outputNode;
	@FXML
	private Pane inputPane;
	@FXML
	private AnchorPane root_pane;

	@FXML
	ImageView imageView;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
	}

	public void init() {
		abstractGate abstractGate = (gui.gates.abstractGate) root_pane;
		if(outputNode!= null && root_pane != null) {
			abstractGate.setOutputNode(outputNode);
			outputNode.setAbstractGate(abstractGate);
		}
		if(inputPane != null) {
			for(Node node : inputPane.getChildren()) {
				if(node instanceof InputNode) {
					abstractGate.addInput((InputNode) node);
					((InputNode) node).setAbstractGate(abstractGate);
				}
			}
		}
		if(imageView != null && root_pane != null) {
			abstractGate.setImageView(imageView);
		}
	}
}
