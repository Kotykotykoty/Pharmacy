package pl.myPortfolio.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pl.myPortfolio.medicaments.Medicaments;

@XmlRootElement(name = "medicaments")
public class MedicamentsJAXB {

	private List<Medicaments> medicaments;

	@XmlElement(name = "medicament")
	public List<Medicaments> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(List<Medicaments> medicaments) {
		this.medicaments = medicaments;
	}

	public Medicaments get(int i) {
		return medicaments.get(i);

	}

}
