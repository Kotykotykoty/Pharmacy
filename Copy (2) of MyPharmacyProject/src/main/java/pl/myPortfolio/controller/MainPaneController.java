package pl.myPortfolio.controller;

import java.io.File;
import java.net.URL;

import java.util.Comparator;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import pl.myPortfolio.medicaments.Medicaments;

import pl.myPortfolio.model.MedicamentsJAXB;

public class MainPaneController implements Initializable {
	@FXML
	AppPaneController appPaneController;
	@FXML
	MenuPaneController menuPaneController;
	@FXML
	TablePaneController tablePaneController;

	private Medicaments med;

	ObservableList<Medicaments> lista = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		add();
		saveToFile();

	}

	public void createPerson() {
		TableView<Medicaments> tv = tablePaneController.getTableView();
		TextArea console = appPaneController.getConsoleTextFild();
		CheckBox avail = appPaneController.getAvailabilityBox();
		CheckBox pres = appPaneController.getPrescriptionBox();
		String tm = appPaneController.getTademarkTable().getText();
		String prod = appPaneController.getProducerTable().getText();
		String prize = appPaneController.getPrizeTable().getText();

		boolean isDouble = isStringDouble(prize);
		boolean isSelect = avail.isSelected();
		boolean isSelect2 = pres.isSelected();

		String av = isAvailabilityChecked(isSelect);
		String pr = isPrescriptionChecked(isSelect2);

		if (tm != null && prod != null && isDouble != false) {
			setMed(new Medicaments(tm, prod, prize, av, pr));

			lista.add(med);
			console.setText("Pomyœlnie dodano lek");

			tv.setItems(lista);
		} else {
			console.setText("Podano z³e wartosci! ");

		}
		appPaneController.getTademarkTable().clear();
		appPaneController.getProducerTable().clear();
		appPaneController.getPrizeTable().clear();
		pres.setSelected(false);
		avail.setSelected(false);

	}

	public void add() {
		TextArea console = appPaneController.getConsoleTextFild();
		Button add = appPaneController.getAddButton();
		Button delete = appPaneController.getDeleteButton();
		Button edit = appPaneController.getEditButton();
		Button sort = appPaneController.getSortButton();
		TableView<Medicaments> tv = tablePaneController.getTableView();
		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				console.clear();
				createPerson();

			}
		});

		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				console.clear();
				if (tv.getSelectionModel().getSelectedItem() != null) {
					lista.remove(tv.getSelectionModel().getSelectedItem());

					console.setText("Pomyslnie usunieto");
				} else {
					console.setText("Nie wybrano elementu");
				}
			}
		});

		edit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (tv.getSelectionModel().getSelectedItem() != null) {

					console.clear();
					int a = tv.getSelectionModel().getSelectedIndex();
					lista.get(a);
					appPaneController.setParameters(getMed());

					lista.remove(tv.getSelectionModel().getSelectedItem());
					tv.getSelectionModel().clearSelection();
				}

				else {
					console.setText("Nie wybrano elementu");
				}

			}
		});

		sort.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				sort(lista);
				tv.setItems(lista);

			}
		});
	}

	public void sort(ObservableList<Medicaments> list) {
		FXCollections.sort(list, new Comparator<Medicaments>() {

			@Override
			public int compare(Medicaments o1, Medicaments o2) {
				// TODO Auto-generated method stub
				return o1.getTradeMark().compareToIgnoreCase(o2.getTradeMark());
			}
		});

	}

	public void saveToFile() {
		MenuItem save = menuPaneController.getSaveItem();
		MenuItem open = menuPaneController.getOpenItem();
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				File file = menuPaneController.saveFile();
				savePersonDataToFile(file);

			}
		});
		open.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				File file = menuPaneController.openFile();
				openMedicamentsFromFile(file);

			}
		});
	}

	public void savePersonDataToFile(File file) {

		try {
			JAXBContext context = JAXBContext.newInstance(MedicamentsJAXB.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			MedicamentsJAXB wrapper = new MedicamentsJAXB();
			wrapper.setMedicaments(lista);

			m.marshal(wrapper, file);

		} catch (Exception e) {

		}

	}

	public void openMedicamentsFromFile(File file) {
		TableView<Medicaments> tv = tablePaneController.getTableView();
		try {
			JAXBContext context = JAXBContext.newInstance(MedicamentsJAXB.class);
			Unmarshaller um = context.createUnmarshaller();

			MedicamentsJAXB wrapper = (MedicamentsJAXB) um.unmarshal(file);

			lista.addAll(wrapper.getMedicaments());

		} catch (Exception e) {
			e.printStackTrace();
		}

		tv.setItems(lista);
	}

	public boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public String isAvailabilityChecked(boolean tmp) {
		if (tmp == true) {
			return "Dostepny";
		} else {
			return "Niedostepny";

		}
	}

	public String isPrescriptionChecked(boolean tmp) {
		if (tmp == true) {
			return "Wymagana";
		} else {
			return "Niewymagana";

		}
	}

	public Medicaments getMed() {
		return med;
	}

	public void setMed(Medicaments med) {
		this.med = med;
	}

}