package application.Service;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import application.entites.Entreprise;
import application.entites.Salary;
import application.connection.*;

public class EntrepriseService implements IDO<Entreprise> {

	public EntrepriseService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Salary> listerEmployee() {
		List<Salary> emp = new ArrayList<>();
		try {
			String req = "SELECT s.matricule, nom, email, role, anneRecruit, (salaire + HSupp * PHSupp) as salaireTot from salarie s, employee e where s.matricule = e.Matricule and s.Role =\"Employer\"; ";
			// System.out.println(req);
			Statement stmt = connexion.getCon().createStatement();
			// System.out.println("connection suucsed liest employer :)");
			ResultSet res = stmt.executeQuery(req);
			// System.out.println(res);
			while (res.next()) {
				emp.add(new Salary(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getDouble(5), res.getDouble(6)));
			}
			System.out.println(emp.toString());
			return emp;
		} catch (SQLException ex) {
			System.out.println("go to service methode listerEmployer list " + ex);
			return null;
		}
	}

	@Override
	public List<Salary> listerVendeur() {
		List<Salary> vList = new ArrayList<>();
		try {
			String req = "SELECT s.matricule, nom, email, anneRecruit, (salaire + vente * pourcentage) as salaireTot, role from salarie s, vendeur v where s.matricule = v.Matricule and s.Role =\"Vendeur\" ;";
			Statement stm = connexion.getCon().createStatement();
			ResultSet res = stm.executeQuery(req);
			while (res.next()) {
				vList.add(new Salary(res.getInt(1), res.getString(2), res.getString(3), res.getString(6),
						res.getDouble(4), res.getDouble(5)));
			}
			return vList;
		} catch (SQLException ex) {
			System.out.println("go to list vendeur methode service " + ex);
		}
		return null;
	}

	@Override
	public boolean deleteSalarie(int Id) {	
		try {
			String req = "Delete from salarie where matricule =" + Id;
			Statement stmt = connexion.getCon().createStatement();
			if (stmt.executeUpdate(req) == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("SQL EXCEPTION");
		}	
		return false;
	}

	@Override
	public List<Salary> listerVendeurEmployedById(int id) {
		List<Salary> emp = new ArrayList<>();
		return null ;
	}

	@Override
	public List<Salary> listerEmployeeByAnciter() {
		List<Salary> emp = new ArrayList<>();
		try {
			String req = "SELECT s.matricule, nom, email, role, anneRecruit, salaire from salarie s, employee e where s.matricule = e.Matricule ORDER BY anneRecruit; ";
			// System.out.println(req);
			Statement stmt = connexion.getCon().createStatement();
			// System.out.println("connection suucsed liest employer :)");
			ResultSet res = stmt.executeQuery(req);
			 System.out.println(res);
			while (res.next()) {
				emp.add(new Salary(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getDouble(5), res.getDouble(6)));
			}
			//System.out.println(emp.toString());
			return emp;
		} catch (SQLException ex) {
			System.out.println("go to service methode listerEmployer par anciter DesAsc  " + ex);
			return null;
		}
	}

	@Override
	public List<Salary> listerEmployeeByMaxAndMin(Double max,Double min) {
		List<Salary> emp = new ArrayList<>();
		
		try {
			String req = "SELECT s.matricule, nom, email, role, anneRecruit, (salaire + HSupp * PHSupp) as salaireTot"
					+ " from salarie s, employee e "
					+ "where s.matricule = e.Matricule and ((salaire<"+max+ ") and (salaire > "+min+")); ";
			// System.out.println(req);
			Statement stmt = connexion.getCon().createStatement();
			// System.out.println("connection suucsed liest employer :)");
			ResultSet res = stmt.executeQuery(req);
			// System.out.println(res);
			while (res.next()) {
				emp.add(new Salary(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),
						res.getDouble(5), res.getDouble(6)));
			}
			System.out.println(emp.toString());
			return emp;
		} catch (SQLException ex) {
			System.out.println("go to service methode listerEmployer list " + ex);
			return null;
		}
	}

}
