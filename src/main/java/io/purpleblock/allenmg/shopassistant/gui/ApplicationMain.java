package io.purpleblock.allenmg.shopassistant.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("shop_assistant.fxml"));
		
		assert(null != root);

		Scene scene = new Scene(root, 640, 480);

		primaryStage.setTitle("Shop Assistant");
		primaryStage.setScene(scene);
		Image icon = new Image(getClass().getResourceAsStream("157-wrench-icon.png"));
		primaryStage.getIcons().add(icon);
		primaryStage.show();
	}

}
