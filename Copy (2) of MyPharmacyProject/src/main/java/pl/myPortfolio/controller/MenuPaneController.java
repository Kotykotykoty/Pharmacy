package pl.myPortfolio.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuPaneController implements Initializable {

	public MenuItem getSaveItem() {
		return saveItem;
	}

	public void setSaveItem(MenuItem saveItem) {
		this.saveItem = saveItem;
	}

	public MenuItem getAboutItem() {
		return aboutItem;
	}

	public void setAboutItem(MenuItem aboutItem) {
		this.aboutItem = aboutItem;
	}

	public MenuItem getCloseItem() {
		return closeItem;
	}

	public void setCloseItem(MenuItem closeItem) {
		this.closeItem = closeItem;
	}

	public MenuItem getOpenItem() {
		return openItem;
	}

	public void setOpenItem(MenuItem openItem) {
		this.openItem = openItem;
	}

	@FXML
	private MenuItem saveItem;

	@FXML
	private MenuItem aboutItem;

	@FXML
	private MenuItem closeItem;

	@FXML
	private MenuItem openItem;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuConfirgure();

	}

	public void menuConfirgure() {
		aboutItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Parent parent = null;

				try {
					parent = FXMLLoader.load(getClass().getResource("/pl/myPortfolio/view/About.fxml"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Scene scene = new Scene(parent);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setTitle("About");
				stage.show();

			}
		});

		closeItem.setOnAction(x -> Platform.exit());

	}

	public File openFile() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showOpenDialog(new Stage());

		return file;

	}

	public File saveFile() {
		FileChooser fileChooser = new FileChooser();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showSaveDialog(new Stage());

		return file;

	}

}
