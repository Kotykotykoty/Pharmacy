package pl.myPortfolio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.myPortfolio.medicaments.Medicaments;

public class AppPaneController implements Initializable {
	@FXML
	private TextField producerTable;

	@FXML
	private Button deleteButton;

	@FXML
	private TextArea consoleTextFild;

	@FXML
	private CheckBox availabilityBox;

	@FXML
	private Button editButton;

	@FXML
	private TextField prizeTable;

	@FXML
	private Button sortButton;

	@FXML
	private Button addButton;

	@FXML
	private CheckBox prescriptionBox;

	@FXML
	private TextField tademarkTable;

	public TextField getProducerTable() {
		return producerTable;
	}

	public void setProducerTable(TextField producerTable) {
		this.producerTable = producerTable;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(Button deleteButton) {
		this.deleteButton = deleteButton;
	}

	public TextArea getConsoleTextFild() {
		return consoleTextFild;
	}

	public void setConsoleTextFild(TextArea descriptionTextFild) {
		this.consoleTextFild = descriptionTextFild;
	}

	public CheckBox getAvailabilityBox() {
		return availabilityBox;
	}

	public void setAvailabilityBox(CheckBox availabilityBox) {
		this.availabilityBox = availabilityBox;
	}

	public Button getEditButton() {
		return editButton;
	}

	public void setEditButton(Button editButton) {
		this.editButton = editButton;
	}

	public TextField getPrizeTable() {
		return prizeTable;
	}

	public void setPrizeTable(TextField prizeTable) {
		this.prizeTable = prizeTable;
	}

	public Button getSortButton() {
		return sortButton;
	}

	public void setSortButton(Button sortButton) {
		this.sortButton = sortButton;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}

	public CheckBox getPrescriptionBox() {
		return prescriptionBox;
	}

	public void setPrescriptionBox(CheckBox prescriptionBox) {
		this.prescriptionBox = prescriptionBox;
	}

	public TextField getTademarkTable() {
		return tademarkTable;
	}

	public void setTademarkTable(TextField tademarkTable) {
		this.tademarkTable = tademarkTable;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void setParameters(Medicaments med) {
		getTademarkTable().setText(med.getTradeMark());
		getProducerTable().setText(med.getProducer());
		getPrizeTable().setText(med.getPrize());

	}
}
