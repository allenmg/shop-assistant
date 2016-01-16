package io.purpleblock.shopassistant.gui;

import io.purpleblock.shopassistant.persistence.EntityManagerFactoryProvider;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ApplicationMain extends Application {

	private static SplashScreen splash;
	
	public static void main(String[] args) {
		splash = new SplashScreen();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = GuiceFXMLLoader.load(getClass().getResource("shop_assistant.fxml"));
		
		assert(null != root);

		Scene scene = new Scene(root, 640, 480);

		primaryStage.setTitle("Shop Assistant");
		primaryStage.setScene(scene);
		Image icon = new Image(getClass().getResourceAsStream("157-wrench-icon.png"));
		primaryStage.getIcons().add(icon);
		
		EntityManagerFactoryProvider.getFactory();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
			@Override
			public void handle(WindowEvent event) {
				EntityManagerFactoryProvider.closeFactory();
			}
		});
		splash.dispose();
		primaryStage.show();
	}

}
