package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "Oblig3")
public class Prosjekt {

	@Id
	private Integer prosjektid;
	private String prosjektnavn;
	private String beskrivelse;
	
	public Prosjekt() {
		
	}
	
	public Prosjekt(Integer prosjektid, String prosjektnavn, String beskrivelse) {
		this.prosjektid = prosjektid;
		this.prosjektnavn = prosjektnavn;
		this.beskrivelse = beskrivelse;
	}

	public Integer getProsjektid() {
		return prosjektid;
	}

	public void setProsjektid(Integer prosjektid) {
		this.prosjektid = prosjektid;
	}

	public String getProsjektnavn() {
		return prosjektnavn;
	}

	public void setProsjektnavn(String prosjektnavn) {
		this.prosjektnavn = prosjektnavn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	public void skrivUt() {
		System.out.println("Prosjekt id: " + prosjektid + ", Prosjekt navn: " + prosjektnavn + ", Prosjekt beskrivelse: " + beskrivelse);
	}

	@Override
	public String toString() {
		return "Prosjekt id = " + prosjektid + ", Prosjekt navn = " + prosjektnavn + ", Beskrivelse = " + beskrivelse;
	}
	
	
}
