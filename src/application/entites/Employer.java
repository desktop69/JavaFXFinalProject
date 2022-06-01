package application.entites;

public class Employer extends Salary {
		private double HSupp ;
		private double PHSupp;

	public Employer(int numMat, String nom, String email, String category, double anneReq, double salaire,
				double hSupp, double pHSupp) {
			super(numMat, nom, email, category, anneReq, salaire);
			HSupp = hSupp;
			PHSupp = pHSupp;
		}

	public double getHSupp() {
		return HSupp;
	}
	public void setHSupp(double hSupp) {
		HSupp = hSupp;
	}
	public double getPHSupp() {
		return PHSupp;
	}
	public void setPHSupp(double pHSupp) {
		PHSupp = pHSupp;
	}
	@Override
	public String toString() {
		return "Employer [HSupp=" + HSupp + ", PHSupp=" + PHSupp + "]";
	}

		
}
