package application.entites;

public class Vendeur extends Salary {
	private double vente ;
	private double pourcentage ;

	
	
	
	public Vendeur(int numMat, String nom, String email, String category, double anneReq, double salaire, double vente,
			double pourcentage) {
		super(numMat, nom, email, category, anneReq, salaire);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	@Override
	public String toString() {
		return "Vendeur [vente=" + vente + ", pourcentage=" + pourcentage + "]";
	}
	public double getVente() {
		return vente;
	}
	public void setVente(double vente) {
		this.vente = vente;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}



	
}
