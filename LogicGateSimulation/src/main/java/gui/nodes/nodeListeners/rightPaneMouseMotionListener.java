package gui.nodes.nodeListeners;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.DoublePropertyBase;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Sam Roberts on 9/2/2016.
 */
public class rightPaneMouseMotionListener implements EventHandler<MouseEvent> {
	private DoubleProperty sceneX = null;
	private DoubleProperty sceneY = null;

	@Override
	public void handle(MouseEvent event) {
		setSceneX(event.getX());
		setSceneY(event.getY());
	}


	public final DoubleProperty getSceneX() {
		if(sceneX == null) {
			sceneX = new DoublePropertyBase() {
				@Override
				public Object getBean() {
					return rightPaneMouseMotionListener.this;
				}

				@Override
				public String getName() {
					return "sceneX";
				}
			};
		}
		return sceneX;
	}

	public final DoubleProperty getSceneY() {
		if(sceneY == null) {
			sceneY = new DoublePropertyBase() {
				@Override
				public Object getBean() {
					return rightPaneMouseMotionListener.this;
				}

				@Override
				public String getName() {
					return "sceneY";
				}
			};
		}
		return sceneY;
	}


	public final void setSceneX(double value) {
		if (sceneX != null || value != 0.0) {
			getSceneX().set(value);
		}
	}

	public final void setSceneY(double value) {
		if (sceneY != null || value != 0.0) {
			getSceneY().set(value);
		}
	}
}
