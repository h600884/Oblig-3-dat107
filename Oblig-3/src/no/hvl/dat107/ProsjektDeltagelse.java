package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "Oblig3")
public class ProsjektDeltagelse {

	@Id
	private Integer ansattid;
	private Integer prosjektid;
	private Integer timer;
	private String rolle;
	
	public ProsjektDeltagelse() {
		
	}
	
	public ProsjektDeltagelse(Integer ansattid, Integer prosjektid, Integer timer, String rolle) {
		this.ansattid = ansattid;
		this.prosjektid = prosjektid;
		this.timer = timer;
		this.rolle = rolle;
	}

	public Integer getAnsattid() {
		return ansattid;
	}

	public void setAnsattid(Integer ansattid) {
		this.ansattid = ansattid;
	}

	public Integer getProsjektid() {
		return prosjektid;
	}

	public void setProsjektid(Integer prosjektid) {
		this.prosjektid = prosjektid;
	}

	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}
	
	public String getRolle() {
		return rolle;
	}
	
	public void setRolle(String rolle) {
		this.rolle = rolle;
	}
	
	public void skrivUt() {
		System.out.println("Ansatt id: " + ansattid + ", Prosjekt id: " + prosjektid + ", Antall timer: " + timer + ", Rolle: " + rolle);
	}

	@Override
	public String toString() {
		return "Ansatt id = " + ansattid + ", Prosjekt id = " + prosjektid + ", Antall timer = " + timer + ", Rolle = " + rolle;
	}
	
	
}
