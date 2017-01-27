package pl.myPortfolio.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override

	public void start(Stage primaryStage) {
		final String appName = "Pharmacy Application";
		try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/myPortfolio/view/MainPane.fxml"));

			Scene scene = new Scene(parent);

			primaryStage.setTitle(appName);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/pl/myPortfolio/res/icon.png"));
			primaryStage.setHeight(460);
			primaryStage.setWidth(720);
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}