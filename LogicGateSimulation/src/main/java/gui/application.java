package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Sam Roberts on 8/15/2016.
 */
public class application extends Application {
	private AnchorPane root;

	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new RootLayout();
		primaryStage.setTitle("Logic Gate Simulator");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
