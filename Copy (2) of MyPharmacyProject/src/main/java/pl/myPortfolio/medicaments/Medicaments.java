package pl.myPortfolio.medicaments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicaments {
	private StringProperty tradeMark;
	private StringProperty producer;
	private StringProperty prize;
	private StringProperty availability;
	private StringProperty prescription;

	public String getTradeMark() {
		return tradeMark.get();
	}

	public void setTradeMark(String tradeMark) {
		this.tradeMark.set(tradeMark);
	}

	public StringProperty tradeMarkProperty() {
		return tradeMark;
	}

	public String getProducer() {
		return producer.get();
	}

	public void setProducer(String producer) {
		this.producer.set(producer);
	}

	public StringProperty producerProperty() {
		return producer;
	}

	public String getPrize() {
		return prize.get();
	}

	public void setPrize(String prize) {
		this.prize.set(prize);
	}

	public StringProperty prizeProperty() {
		return prize;
	}

	public String getAvailability() {
		return availability.get();
	}

	public void setAvailability(String availability) {
		this.availability.set(availability);
	}

	public StringProperty availabilityProperty() {
		return availability;
	}

	public String getPrescription() {
		return prescription.get();
	}

	public void setPrescription(String prescription) {
		this.prescription.set(prescription);
	}

	public StringProperty prescriptionProperty() {
		return prescription;
	}

	public Medicaments(String tradeMark, String producer, String prize, String availability, String prescription) {
		this.tradeMark = new SimpleStringProperty(tradeMark);
		this.producer = new SimpleStringProperty(producer);
		this.prize = new SimpleStringProperty(prize);
		this.availability = new SimpleStringProperty(availability);
		this.prescription = new SimpleStringProperty(prescription);

	}

	public Medicaments() {
		this(null, null, null, null, null);
	}

}
