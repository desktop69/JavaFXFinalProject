package application.entites;

public class Salary {
	private int numMat;
	private String nom;
	private String email;
	private String Category;
	private double AnneReq;
	private double salaire ;

	


	public Salary(int numMat, String nom, String email, String category, double anneReq, double salaire) {
		super();
		this.numMat = numMat;
		this.nom = nom;
		this.email = email;
		Category = category;
		AnneReq = anneReq;
		this.salaire = salaire;
	}
	public int getNumMat() {
		return numMat;
	}
	public void setNumMat(int numMat) {
		this.numMat = numMat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAnneReq() {
		return AnneReq;
	}
	public void setAnneReq(double anneReq) {
		AnneReq = anneReq;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String cat) {
		Category = cat;
	}
	@Override
	public String toString() {
		return "Salary [numMat=" + numMat + ", nom=" + nom + ", email=" + email + ", Category=" + Category
				+ ", AnneReq=" + AnneReq + ", salaire=" + salaire + "]";
	}


}
