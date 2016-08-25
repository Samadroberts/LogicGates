package gui.controllers;

import gui.InputNode;
import gui.OutputNode;
import gui.gates.abstractGate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sam Roberts on 8/23/2016.
 */
public abstract class abstractController implements Initializable {
	@FXML
	private OutputNode outputNode;
	@FXML
	private Pane inputPane;
	@FXML
	private abstractGate abstractGate;
	@FXML
	ImageView imageView;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		init();
	}

	public void init() {
		if(outputNode!= null && abstractGate != null) {
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
		if(imageView != null && abstractGate!= null) {
			abstractGate.setImageView(imageView);
		}
	}
}
