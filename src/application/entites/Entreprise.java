package application.entites;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Entreprise {
	private String nomEntreprise;
	private HashMap<Integer, Salary> salaries;
	public Entreprise(String nomEntreprise, HashMap<Integer, Salary> salaries) {
		super();
		this.nomEntreprise = nomEntreprise;
		this.salaries = salaries;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public HashMap<Integer, Salary> getSalaries() {
		return salaries;
	}
	public void setSalaries(HashMap<Integer, Salary> salaries) {
		this.salaries = salaries;
	}
	@Override
	public String toString() {
		return "Entreprise [nomEntreprise=" + nomEntreprise + ", salaries=" + salaries + "]";
	}
	
	
}
