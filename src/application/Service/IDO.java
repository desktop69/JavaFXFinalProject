package application.Service;

import java.util.List;

import application.entites.Salary;

public interface IDO <Entreprise> {	
	public List<Salary> listerEmployee() ;
	public List<Salary> listerVendeur() ;
	public List<Salary> listerVendeurEmployedById(int id) ;
	public boolean deleteSalarie(int empId);
	public List<Salary> listerEmployeeByAnciter() ;
	public List<Salary> listerEmployeeByMaxAndMin(Double max,Double min);
	
}
