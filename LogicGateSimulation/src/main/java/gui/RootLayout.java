package gui;

import gui.dragAndDrop.DragDropContainer;
import gui.gates.AndGate;
import gui.gates.GateType;
import gui.gates.NandGate;
import gui.gates.NorGate;
import gui.gates.NotGate;
import gui.gates.OrGate;
import gui.gates.XnorGate;
import gui.gates.XorGate;
import gui.gates.abstractGate;
import gui.gates.constants.HighConstant;
import gui.gates.constants.LowConstant;
import gui.gates.outputs.LightBulb;
import gui.nodes.abstractNode;
import gui.nodes.nodeListeners.rightPaneMouseMotionListener;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sam Roberts on 8/29/2016.
 */
public class RootLayout extends AnchorPane {
	@FXML
	SplitPane base_pane;
	@FXML
	AnchorPane right_pane;
	@FXML
	VBox left_pane;

	private EventHandler mIconDragOverRoot=null;
	private EventHandler mIconDragDropped=null;
	private EventHandler mIconDragOverRightPane=null;

	private rightPaneMouseMotionListener rightPaneMouseMotionListener = new rightPaneMouseMotionListener();;

	private EventHandler ConnectionDragAndDrop = null;

	private abstractGate dragAndDropOver = null;


	public RootLayout() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/fxml/RootLayout.fxml")
		);
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	@FXML
	public void initialize() {

		dragAndDropOver = new AndGate();
		dragAndDropOver.setVisible(false);
		//dragAndDropOver.setOpacity(0.65);
		//getChildren().add(dragAndDropOver);
		for(abstractGate abstractGate: getGates()) {
			addDragDetection(abstractGate);
			left_pane.getChildren().add(abstractGate);
		}
		buildDragHandlers();
	}

	private void buildDragHandlers() {
		mIconDragOverRoot = new EventHandler <DragEvent>() {

			@Override
			public void handle(DragEvent event) {

				Point2D p = right_pane.sceneToLocal(event.getSceneX(), event.getSceneY());

				if (!right_pane.boundsInLocalProperty().get().contains(p)) {
					dragAndDropOver.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
					return;
				}

				event.consume();
			}
		};

		mIconDragOverRightPane = new EventHandler <DragEvent> () {

			@Override
			public void handle(DragEvent event) {

				event.acceptTransferModes(TransferMode.ANY);


				dragAndDropOver.relocateToPoint(
						new Point2D(event.getSceneX(), event.getSceneY())
				);
				event.consume();
			}
		};

		mIconDragDropped = new EventHandler <DragEvent> () {

			@Override
			public void handle(DragEvent event) {

				DragDropContainer container =
						(DragDropContainer) event.getDragboard().getContent(DragDropContainer.Node);

				container.addData("scene_coords",
						String.valueOf(new Point2D(event.getSceneX(), event.getSceneY())));


				ClipboardContent content = new ClipboardContent();
				content.put(DragDropContainer.Node, container);

				event.getDragboard().setContent(content);
				event.setDropCompleted(true);
			}
		};

		this.setOnDragDone (new EventHandler <DragEvent> (){

			@Override
			public void handle (DragEvent event) {

				right_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRightPane);
				right_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mIconDragDropped);
				base_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRoot);
				dragAndDropOver.setVisible(false);
				DragDropContainer container =
						(DragDropContainer) event.getDragboard().getContent(DragDropContainer.Node);

				if (container != null) {
					if (container.getValue("scene_coords") != null) {
						abstractGate abstractGate;
						if(container.getValue("id") == null) {
							abstractGate = GateType.getGate(GateType.valueOf(container.getValue("type")));
							right_pane.getChildren().add(abstractGate);
							initNewGate(abstractGate);
							right_pane.setOnMouseMoved(rightPaneMouseMotionListener);
							Point2D cursorPoint = getPoint2DFromString(container.getValue("scene_coords"));
							abstractGate.relocateToPoint(
									new Point2D(cursorPoint.getX(), cursorPoint.getY())
							);
						} else {
							abstractGate = getGateFromId(right_pane,container.getValue("id"));
							if(abstractGate != null) {
								Point2D cursorPoint = getPoint2DFromString(container.getValue("scene_coords"));
								abstractGate.relocateToPoint(
										new Point2D(cursorPoint.getX(), cursorPoint.getY())
								);
								abstractGate.updateNodes();
								abstractGate.setVisible(true);
								abstractGate.setAllConnectionsVisible(true);
							}

						}
					}
				}
				event.consume();
			}
		});

	}

	private void initNewGate(abstractGate abstractGate) {
		for(abstractNode node : abstractGate.getAllNodes()) {
			//node.setOnMouseEntered(new nodeMouseEnteredEventHandler(node));
			//node.setOnMouseExited(new nodeMouseExitedEventHandler(node));
			node.setMouseMotionListener(rightPaneMouseMotionListener);
			node.initOnclick(right_pane);
			//node.setOnMouseClicked(new nodeMouseClickedEventHandler(right_pane));
			//addDragDetectionForConnection(node);
		}
		addDragDetectionRightPane(abstractGate);
	}
	private Point2D getPoint2DFromString(String str) {
		Pattern p = Pattern.compile("(\\d+(?:\\.\\d+))");
		Matcher m = p.matcher(str);
		return new Point2D((m.find()) ? Double.parseDouble(m.group(1)) : 0.0, (m.find()) ? Double.parseDouble(m.group(1)) : 0.0);
	}

	private abstractGate getGateFromId(Parent parent, String id) {
		UUID uuid = UUID.fromString(id);
		for(Node node: parent.getChildrenUnmodifiable()) {
			if(node instanceof abstractGate) {
				abstractGate abstractGate = (abstractGate) node;
				if(abstractGate.getUuid().equals(uuid)) {
					return abstractGate;
				}
			}
		}
		return null;

	}

	private void addDragDetection(final abstractGate abstractGate) {
		abstractGate.setOnDragDetected (new EventHandler <MouseEvent> () {

			@Override
			public void handle(MouseEvent event) {

				// set the other drag event handles on their respective objects
				base_pane.setOnDragOver(mIconDragOverRoot);
				right_pane.setOnDragOver(mIconDragOverRightPane);
				right_pane.setOnDragDropped(mIconDragDropped);

				// get a reference to the clicked DragIcon object
				abstractGate icn = (abstractGate) event.getSource();

				//begin drag ops
				dragAndDropOver = GateType.getGate(icn.getGateType());
				getChildren().add(dragAndDropOver);
				dragAndDropOver.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));

				ClipboardContent content = new ClipboardContent();
				DragDropContainer container = new DragDropContainer();

				container.addData ("type", dragAndDropOver.getGateType().getType());
				content.put(DragDropContainer.Node, container);

				dragAndDropOver.startDragAndDrop (TransferMode.ANY).setContent(content);
				dragAndDropOver.setVisible(true);
				dragAndDropOver.setMouseTransparent(true);
				event.consume();
			}
		});
	}

	private void addDragDetectionRightPane(final abstractGate abstractGate) {
		abstractGate.setOnDragDetected (new EventHandler <MouseEvent> () {

			@Override
			public void handle(MouseEvent event) {
				// set the other drag event handles on their respective objects
				if(!(event.getTarget() instanceof abstractNode)) {
					base_pane.setOnDragOver(mIconDragOverRoot);
					right_pane.setOnDragOver(mIconDragOverRightPane);
					right_pane.setOnDragDropped(mIconDragDropped);

					// get a reference to the clicked DragIcon object
					abstractGate icn = (abstractGate) event.getSource();
					icn.setVisible(false);
					icn.setAllConnectionsVisible(false);

					//begin drag ops
					dragAndDropOver = GateType.getGate(icn.getGateType());
					getChildren().add(dragAndDropOver);
					dragAndDropOver.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));

					ClipboardContent content = new ClipboardContent();
					DragDropContainer container = new DragDropContainer();

					container.addData("type", dragAndDropOver.getGateType().getType());
					container.addData("id", abstractGate.getUuid().toString());
					content.put(DragDropContainer.Node, container);

					dragAndDropOver.startDragAndDrop(TransferMode.ANY).setContent(content);
					dragAndDropOver.setVisible(true);
					dragAndDropOver.setMouseTransparent(true);
				}
				event.consume();
			}
		});
	}

	private List<abstractGate> getGates() {
		List<abstractGate> abstractGates = new ArrayList<abstractGate>();
		abstractGates.add(new AndGate());
		abstractGates.add(new OrGate());
		abstractGates.add(new NotGate());
		abstractGates.add(new NandGate());
		abstractGates.add(new NorGate());
		abstractGates.add(new XorGate());
		abstractGates.add(new XnorGate());
		abstractGates.add(new HighConstant());
		abstractGates.add(new LowConstant());
		abstractGates.add(new LightBulb());

		return abstractGates;
	}
}
