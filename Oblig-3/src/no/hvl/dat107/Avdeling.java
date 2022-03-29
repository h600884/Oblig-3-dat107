package no.hvl.dat107;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "Oblig3")
public class Avdeling {

	@Id
	private Integer avdelingsid;
	private String navn;
	private Integer avdelingssjef;
	
	public Avdeling() {
		
	}
	
	public Avdeling(Integer avdelingsid, String navn, Integer avdelingssjef) {
		this.avdelingsid = avdelingsid;
		this.navn = navn;
		this.avdelingssjef = avdelingssjef;
	}

	public Integer getAvdelingsid() {
		return avdelingsid;
	}

	public void setAvdelingsid(Integer avdelingsid) {
		this.avdelingsid = avdelingsid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getAvdelingssjef() {
		return avdelingssjef;
	}

	public void setAvdelingssjef(Integer avdelingssjef) {
		this.avdelingssjef = avdelingssjef;
	}
	
	public void skrivUt() {
		System.out.println("Avdelingsid: " + avdelingsid + "Avdelings navn: " + navn + "Avdelings sjef: " + avdelingssjef);
	}

	@Override
	public String toString() {
		return "Avdelingsid = " + avdelingsid + ", Avdelings navn = " + navn + ", Avdelings sjef = " + avdelingssjef + "\n";
	}
	
	
}
