package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Sam Roberts on 8/15/2016.
 */
public class application extends Application {
	private Scene scene;
	private static AnchorPane root;
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new AnchorPane();
		Parent or = new FXMLLoader().load(getClass().getResource("/fxml/OR.fxml"));
		Parent nor = new FXMLLoader().load(getClass().getResource("/fxml/NOR.fxml"));
		Parent and = new FXMLLoader().load(getClass().getResource("/fxml/AND.fxml"));
		Parent nand = new FXMLLoader().load(getClass().getResource("/fxml/NAND.fxml"));
		Parent not = new FXMLLoader().load(getClass().getResource("/fxml/NOT.fxml"));
		Parent highConstant = new FXMLLoader().load(getClass().getResource("/fxml/HIGHCONSTANT.fxml"));
		Parent lowConstant = new FXMLLoader().load(getClass().getResource("/fxml/LOWCONSTANT.fxml"));
		Parent lightBulb = new FXMLLoader().load(getClass().getResource("/fxml/LIGHTBULB.fxml"));
		HBox hbox = new HBox();
		VBox vBox = new VBox();
		vBox.setSpacing(15);
		vBox.getChildren().addAll(highConstant,lowConstant);
		VBox vBox1 = new VBox();
		vBox1.setSpacing(15);
		vBox1.getChildren().addAll(and, or);
		VBox vBox2 = new VBox();
		vBox2.setSpacing(15);
		vBox2.getChildren().addAll(nand,nor);
		hbox.setSpacing(15);
		hbox.getChildren().addAll(vBox, not, vBox1,vBox2,lightBulb);
		root.getChildren().add(hbox);
		primaryStage.setTitle("Logic Gate Simulator");
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
	}

	public static AnchorPane getRoot() {
		return root;
	}
}
