package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(schema = "Oblig3")
public class Ansatt {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansattid;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansattdato;
	private String stilling;
	private Integer monedslonn;
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "avdelingsid", referencedColumnName = "avdelingsid")
	private Integer avdeling;
	
	public Ansatt() {
	}
	
	public Ansatt (Integer ansattid, String brukernavn, String fornavn, String etternavn,
			LocalDate ansattdato, String stilling, Integer monedslonn, Integer avdeling) {
		this.ansattid = ansattid;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansattdato = ansattdato;
		this.stilling = stilling;
		this.monedslonn = monedslonn;
		this.avdeling = avdeling;
	}

	public Integer getAnsattid() {
		return ansattid;
	}

	public void setAnsattid(Integer ansattid) {
		this.ansattid = ansattid;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsattdato() {
		return ansattdato;
	}

	public void setAnsattdato(LocalDate ansattdato) {
		this.ansattdato = ansattdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	
	public Integer getMonedslonn() {
		return monedslonn;
	}

	public void setMonedslonn(Integer monedslonn) {
		this.monedslonn = monedslonn;
	}

	public Integer getAvdeling() {
		return avdeling;
	}
	
	public void setAvdeling(Integer avdeling) {
		this.avdeling = avdeling;
	}
	public void skrivUt() {
		System.out.println("AnsattId: " + ansattid + ", Brukernavn: " + brukernavn + ", Fornavn: " + fornavn + ", Etternavn: "
				+ etternavn + ", Ansattdato: " + ansattdato + ", Stilling: " + stilling + ", Månedslønn: " + monedslonn + ", Avdelings id: " + avdeling);
	}

	@Override
	public String toString() {
		return "Ansattid = " + ansattid + ", Brukernavn = " + brukernavn + ", Fornavn = " + fornavn + ", Etternavn = "
				+ etternavn + ", Ansattdato = " + ansattdato + ", Stilling = " + stilling + ", Månedslønn = " + monedslonn + ", Avdelings id = " + avdeling + "\n";
	}
	
	
}
