package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 * Created by Sam Roberts on 8/18/2016.
 */
public class nodeController {
	@FXML
	private Boolean input;

	@FXML protected void mouseclickedEventInput(MouseEvent event) {
		if(input != null) {
			input = !input;
		} else {
			input = true;
		}
		System.out.println(input);
	}
}
