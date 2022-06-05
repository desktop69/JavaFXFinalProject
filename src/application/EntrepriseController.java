package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import application.Service.EntrepriseService;
import application.connection.connexion;
import application.entites.Employer;
import application.entites.Salary;
import application.entites.Vendeur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class EntrepriseController implements Initializable {
	@FXML
	private TextField tfnom;
	@FXML
	private TextField tfMatricule;
	@FXML
	private TextField tfMx;
	@FXML
	private TextField tfMin;
	@FXML
	private TextField tfemail;
	@FXML
	private TextField tfanne;
	@FXML
	private TextField tfhsuup_vente;
	@FXML
	private TextField tfphsupp_pourcentage;
	@FXML
	private RadioButton tfEmployer;
	@FXML
	private RadioButton tfVendeur;
	@FXML
	private TextField tfsalire;
	@FXML
	private Button addBtn;
	@FXML
	private Button ExportBtn;
	
	@FXML
	private Button MaxBtn;
	@FXML
	private Button ListByAncAscBtn;
	@FXML
	private Button RemoveBtn;
	@FXML
	private Button testForupdateBtn;
	@FXML
	private Button updateSalaryBtn;
	@FXML
	private Button listVendeurBtn;
	@FXML
	private Button switchBtn;
	@FXML
	private Button listEmployeedBtn;
	@FXML
	private TableView<Salary> table;
	@FXML
	private TableColumn<Salary, Integer> matriculeCol;
	@FXML
	private TableColumn<Salary, String> nameCol;
	@FXML
	private TableColumn<Salary, String> emailCol;
	@FXML
	private TableColumn<Salary, String> catCol;
	@FXML
	private TableColumn<Salary, Double> salaireCol;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		matriculeCol.setCellValueFactory(new PropertyValueFactory<>("numMat"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		catCol.setCellValueFactory(new PropertyValueFactory<>("Category"));
		salaireCol.setCellValueFactory(new PropertyValueFactory<>("salaire"));

		EntrepriseService ent = new EntrepriseService();
		table.getItems().addAll(ent.listerEmployee());
		table.getItems().addAll(ent.listerVendeur());
		// System.out.println(table);
		// tableView.getItems().clear();
		// tableToTextFiled();
	}

	public void addmethode() {
		// this meathod use jdbc to add an salarie and check if it an employed or a
		// vendeur
		try {
			if (tfEmployer.isSelected()) {
				Connection con = connexion.getCon();
				System.out.println(connexion.getCon() + "  for add methode :)");
				PreparedStatement ps;
				PreparedStatement ps2;
				ps = con.prepareStatement(
						"INSERT INTO salarie ( matricule, nom, email, anneRecruit, salaire, Role ) VALUES (?,?,?,?,?,'Employer')");
				// varabiles for insert
				String newNom = tfnom.getText();
				String newemail = tfemail.getText();
				double newAnne = Double.parseDouble(tfanne.getText()); // for double cast
				double newSalary = Double.parseDouble(tfsalire.getText());
				int newMatricule = Integer.parseInt(tfMatricule.getText()); // for int cast
				Salary s = new Salary(newMatricule, newNom, newemail, "Employer", newAnne, newSalary);
				ps.setInt(1, s.getNumMat());
				ps.setString(2, s.getNom());
				ps.setString(3, s.getEmail());
				ps.setDouble(4, s.getAnneReq());
				ps.setDouble(5, s.getSalaire());
				// ps.setString(4,s.getCategory());
				ps.executeUpdate();
				System.out.println("salary effected");
				// INSERT INTO employee
				ps2 = con.prepareStatement("INSERT INTO employee(Matricule, HSupp, PHSupp) VALUES (?,?,?)");
				double newHsupp = Double.parseDouble(tfhsuup_vente.getText());
				double newPHSupp = Double.parseDouble(tfphsupp_pourcentage.getText());
				Employer e = new Employer(newMatricule, newNom, newemail, newemail, newSalary, newMatricule, newHsupp,
						newPHSupp);
				ps2.setInt(1, s.getNumMat());
				ps2.setDouble(2, e.getHSupp());
				ps2.setDouble(3, e.getPHSupp());
				ps2.executeUpdate();
				System.out.println("employer effected");
				con.close();
			} else {
				if (tfVendeur.isSelected()) {
					Connection con = connexion.getCon();
					System.out.println(connexion.getCon() + "  for add me vendeur method:)");
					PreparedStatement ps;
					PreparedStatement ps3;
					ps = con.prepareStatement(
							"INSERT INTO salarie ( matricule, nom, email, anneRecruit, salaire, Role ) VALUES (?,?,?,?,?,'Vendeur')");
					String newNom = tfnom.getText();
					String newemail = tfemail.getText();
					double newAnne = Double.parseDouble(tfanne.getText());
					double newSalary = Double.parseDouble(tfsalire.getText());
					int newMatricule = Integer.parseInt(tfMatricule.getText());
					Salary s = new Salary(newMatricule, newNom, newemail, "Vendeur", newAnne, newSalary);
					ps.setInt(1, s.getNumMat());
					ps.setString(2, s.getNom());
					ps.setString(3, s.getEmail());
					ps.setDouble(4, s.getAnneReq());
					ps.setDouble(5, s.getSalaire());
					// ps.setString(4,s.getCategory());
					ps.executeUpdate();
					System.out.println("salary effected");
					// INSERT INTO employee
					ps3 = con.prepareStatement("INSERT INTO vendeur(Matricule, Vente, Pourcentage) VALUES (?,?,?)");
					double newHsupp = Double.parseDouble(tfhsuup_vente.getText());
					double newPHSupp = Double.parseDouble(tfphsupp_pourcentage.getText());
					Vendeur v = new Vendeur(newMatricule, newNom, newemail, newemail, newSalary, newMatricule, newHsupp,
							newPHSupp);
					ps3.setInt(1, s.getNumMat());
					ps3.setDouble(2, v.getVente());
					ps3.setDouble(3, v.getPourcentage());
					ps3.executeUpdate();
					System.out.println("Vendeur effected !");
					con.close();
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void switchToVueScene(ActionEvent event) throws IOException {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("ListerSalaryByEmplyer.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}

	public void listEmploye() {

		table.getItems().clear();
		EntrepriseService Eservice = new EntrepriseService();
		table.getItems().addAll(Eservice.listerEmployee());
		// Eservice.listerEmployee();
	}

	@FXML
	public void listerEmployeeByAnc() {
		table.getItems().clear();
		EntrepriseService Eservice = new EntrepriseService();
		table.getItems().addAll(Eservice.listerEmployeeByAnciter());

	}

	@FXML
	public void ListerByMaxMin() {
		// here contenuew
		// Salary s = table.getSelectionModel().getSelectedItem();
		Double tfNewMax = Double.parseDouble(tfMx.getText());
		Double tfNewMin = Double.parseDouble(tfMin.getText());
		table.getItems().clear();
		EntrepriseService Eservice = new EntrepriseService();
		table.getItems().addAll(Eservice.listerEmployeeByMaxAndMin(tfNewMax, tfNewMin));

	}

	public void ListerVendeur() {
		table.getItems().clear();
		EntrepriseService Eservice = new EntrepriseService();
		table.getItems().addAll(Eservice.listerVendeur());

	}
	// modify method ; 50%

	@FXML
	public void updateSalaryfromTable() {

		String req = "update salarie set nom ='" + tfnom.getText() + "', email ='" + tfemail.getText() + "',salaire ='"
				+ Double.parseDouble(tfanne.getText()) + "' , anneRecruit ='" + Double.parseDouble(tfsalire.getText())
				+ "',Role ='" + "Employer" + "' where matricule = " + tfMatricule.getText();
		String req2 = "update salarie set nom ='" + tfnom.getText() + "', email ='" + tfemail.getText() + "',salaire ='"
				+ Double.parseDouble(tfanne.getText()) + "' , anneRecruit ='" + Double.parseDouble(tfsalire.getText())
				+ "',Role ='" + "Vendeur" + "' where matricule = " + tfMatricule.getText();

		try {
			if (tfEmployer.isSelected()) {
				Statement st = connexion.getCon().createStatement();
				st.executeUpdate(req);

				Salary s = new Salary(Integer.parseInt(tfMatricule.getText()), tfnom.getText(), tfemail.getText(),
						"Employer", Double.parseDouble(tfanne.getText()), Double.parseDouble(tfsalire.getText()));
				table.getItems().clear();
				table.getItems().add(s);

				EntrepriseService ent = new EntrepriseService();
				table.getItems().addAll(ent.listerEmployee());
				table.getItems().addAll(ent.listerVendeur());
			}

			else {
				if (tfVendeur.isSelected()) {
					Statement st = connexion.getCon().createStatement();
					st.executeUpdate(req2);
				}
				Salary s = new Salary(Integer.parseInt(tfMatricule.getText()), tfnom.getText(), tfemail.getText(),
						"Vendeur", Double.parseDouble(tfanne.getText()), Double.parseDouble(tfsalire.getText()));
				table.getItems().clear();
				table.getItems().add(s);

				EntrepriseService ent = new EntrepriseService();
				table.getItems().addAll(ent.listerEmployee());
				table.getItems().addAll(ent.listerVendeur());
			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("update false ");
		}

	}

	@FXML
	public void supprimerSalary() {
		// Salary id ;
		// id=getNumMat();
		Salary s = table.getSelectionModel().getSelectedItem();// make an object with the selected row
		// System.out.println(s.getNumMat());
		table.getItems().remove(table.getSelectionModel().getSelectedItem());
		EntrepriseService ent = new EntrepriseService();
		ent.deleteSalarie(s.getNumMat());
		table.getItems().remove(table.getSelectionModel().getSelectedItem());

	}

	@FXML
	public void tableToTextFiled() {
		Salary s = table.getSelectionModel().getSelectedItem();
		String tfnomTest = s.getNom();
		// System.out.println(tfnomTest);
		tfnom.setText(tfnomTest);
		tfMatricule.setText(String.valueOf(s.getNumMat()));
		tfemail.setText(s.getEmail());
		tfanne.setText(String.valueOf(s.getAnneReq()));
		String c = s.getCategory();
		if (c.equals("Employer")) {
			tfEmployer.setSelected(true);
		} else {
			tfVendeur.setSelected(true);
		}
		tfhsuup_vente.setText("0");
		tfphsupp_pourcentage.setText("0");
	}

	// export methode
	@FXML
	public void exportToFile() {
		File inputFile = new File("C:\\fichiers\\Salares.txt");
		FileReader fr;
		BufferedReader br;
		String PHSupp = "";
		try {
			tfEmployer.setSelected(false);
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			String s;
			boolean ok = false;
			while ((s = br.readLine()) != null) {
				String[] fileData = s.split(" ");
				if (fileData[0].equals("PHSupp")) {
					PHSupp = fileData[1];
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tfhsuup_vente.setText(PHSupp);
	}

}
