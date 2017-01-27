package pl.myPortfolio.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.myPortfolio.medicaments.Medicaments;

public class TablePaneController implements Initializable {

	public static final String TRADEMARK_COLUMN = "Nazwa";
	public static final String PRODUCER_COLUMN = "Producent";
	public static final String PRIZE_COLUMN = "Cena";
	public static final String AVAILABILITY_COLUMN = "Dostepnosc";
	public static final String PRESCRIPTION_COLUMN = "Recepta";

	@FXML
	private TableView<Medicaments> tableView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setTable();

	}

	private void setTable() {
		TableColumn<Medicaments, String> trademarkColumn = new TableColumn<Medicaments, String>(TRADEMARK_COLUMN);
		trademarkColumn.setCellValueFactory(new PropertyValueFactory<>("tradeMark"));

		TableColumn<Medicaments, String> producerColumn = new TableColumn<Medicaments, String>(PRODUCER_COLUMN);
		producerColumn.setCellValueFactory(new PropertyValueFactory<>("producer"));

		TableColumn<Medicaments, String> prizeColumn = new TableColumn<Medicaments, String>(PRIZE_COLUMN);
		prizeColumn.setCellValueFactory(new PropertyValueFactory<>("prize"));

		TableColumn<Medicaments, String> availabilityColumn = new TableColumn<Medicaments, String>(AVAILABILITY_COLUMN);
		availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));

		TableColumn<Medicaments, String> prescriptionColumn = new TableColumn<Medicaments, String>(PRESCRIPTION_COLUMN);
		prescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("prescription"));

		getTableView().getColumns().add(trademarkColumn);
		getTableView().getColumns().add(producerColumn);
		getTableView().getColumns().add(prizeColumn);
		getTableView().getColumns().add(availabilityColumn);
		getTableView().getColumns().add(prescriptionColumn);
	}

	public TableView<Medicaments> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Medicaments> tableView) {
		this.tableView = tableView;
	}

}
