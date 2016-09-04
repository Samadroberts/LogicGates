package gui.nodes.nodeEventHandlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Sam Roberts on 8/31/2016.
 */
public class nodeMouseEnteredEventHandler implements EventHandler<MouseEvent> {
	private gui.nodes.abstractNode abstractNode;
	public nodeMouseEnteredEventHandler(gui.nodes.abstractNode abstractNode) {
		this.abstractNode = abstractNode;
	}
	@Override
	public void handle(MouseEvent event) {
	}
}