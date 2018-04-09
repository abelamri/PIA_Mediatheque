package Application.Java;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 */
public class Adherent {
	static ArrayList<Adherent> listeAdherents = new ArrayList<>();
	public Integer idAdherent;
	public boolean actif;
	public Integer nbRetard;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Default constructor
	 */
	public Adherent() {
	}

	public Adherent(String id, String actif, String nbRetard) {
		super();
		this.idAdherent = Integer.valueOf(id);
		this.actif = (actif.equals("false") ? false : true);
		this.nbRetard = Integer.valueOf(nbRetard);
	}

	public static Adherent getAdherent(Integer id) {
		for (Adherent adherent : listeAdherents) {
			if (adherent.idAdherent == id)
				return adherent;
		}
		return null;
	}

	static void init() throws SQLException, NumberFormatException, ParseException {
		String query = "SELECT idAdherent, Actif, nbRetard FROM adherent";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			listeAdherents.add(new Adherent(Connect.result.getObject(1).toString(),
					Connect.result.getObject(2).toString(), Connect.result.getObject(3).toString()));
		}
	}

	/**
	 * @param idProduit
	 * @throws SQLException
	 */
	public int emprunter(Integer idProduit) throws SQLException {
		Produit p = Produit.getProduit(idProduit);
		Integer dispo = p.getExemplaireDispo();
		if (dispo == -1)
			return -1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar dateLimite = Calendar.getInstance();
		dateLimite.add(Calendar.MONTH, 1);
		String query = "INSERT INTO emprunter VALUES ('" + dateFormat.format(date) + "', '"
				+ dateFormat.format(dateLimite.getTime()) + "', NULL, '" + idAdherent + "', '" + dispo.toString()
				+ "')";
		Connect.state.executeUpdate(query);
		return 0;
	}

	/**
	 * @param ...
	 * @throws SQLException
	 */
	public static List<Integer> rechercher(String recherche) throws SQLException {
		ArrayList<Integer> res = new ArrayList<>();
		String query = "SELECT idProduit FROM produit WHERE Titre LIKE '%" + recherche + "%';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			res.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}
		return res;
	}

	/**
	 * @param ...
	 * @throws SQLException
	 */
	public static List<Integer> rechercherGenre(String recherche) throws SQLException {
		ArrayList<Integer> res = new ArrayList<>();
		String query = "SELECT p.idProduit FROM produit p JOIN estdegenre e ON p.idProduit = e.idProduit "
				+ "JOIN genre g ON e.idGenre = g.idGenre " + "WHERE g.type LIKE '%" + recherche + "%';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			res.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}
		return res;
	}

	/**
	 * @param ...
	 * @throws SQLException
	 */
	public static List<Integer> rechercherAuteur(String recherche) throws SQLException {
		ArrayList<Integer> res = new ArrayList<>();
		String query = "SELECT p.idProduit FROM produit p LEFT JOIN ecrirescenario es ON p.idProduit = es.idProduit "
				+ "LEFT JOIN scenariste s ON es.idScenariste = s.idScenariste "
				+ "LEFT JOIN creer c ON p.idProduit = c.idProduit "
				+ "LEFT JOIN ecrivain ec ON c.idEcrivain = ec.idEcrivain "
				+ "LEFT JOIN ecrire e ON p.idProduit = e.idProduit " + "LEFT JOIN auteur a ON e.idAuteur = a.idAuteur "
				+ "WHERE (a.Nom LIKE '%" + recherche + "%') " + "OR (s.Nom LIKE '%" + recherche + "%') "
				+ "OR (ec.Nom LIKE '%" + recherche + "%');";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			res.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}
		return res;
	}

	/**
	 * @param idProduit
	 * @throws SQLException
	 */
	public void reserver(Integer idProduit) throws SQLException {
		Date date = new Date();
		String query = "INSERT INTO reserver (idAdherent, idProduit, dateReservation) VALUES ('" + idAdherent + "', '"
				+ idProduit + "', '" + dateFormat.format(date) + "');";
		Connect.state.executeUpdate(query);
	}

	public List<Emprunt> emprunts() throws SQLException, ParseException {
		ArrayList<Emprunt> res = new ArrayList<>();
		String query = "SELECT dateEmprunt, dateLimite, dateRetour, idAdherent, idExemplaire FROM emprunter WHERE idAdherent = "
				+ idAdherent;
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			String str1 = Connect.result.getObject(1).toString();
			String str2 = Connect.result.getObject(2).toString();
			String str3;
			if (Connect.result.getObject(3) == null)
				str3 = "NULL";
			else
				str3 = Connect.result.getObject(3).toString();
			String str4 = Connect.result.getObject(4).toString();
			String str5 = Connect.result.getObject(5).toString();
			res.add(new Emprunt(str1, str2, str3, str4, str5));
		}
		return res;
	}

	public String getPrenom() throws SQLException {
		String query = "SELECT prenom FROM adherent WHERE idAdherent = '" + idAdherent + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		if (Connect.result.next()) {
			return Connect.result.getObject(1).toString();
		} else
			return null;
	}

	public String getNom() throws SQLException {
		String query = "SELECT nom FROM adherent WHERE idAdherent = '" + idAdherent + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		if (Connect.result.next()) {
			return Connect.result.getObject(1).toString();
		} else
			return null;
	}

	public String getAdresse() throws SQLException {
		String query = "SELECT adresse FROM adherent WHERE idAdherent = '" + idAdherent + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		if (Connect.result.next()) {
			return Connect.result.getObject(1).toString();
		} else
			return null;
	}

	public String getMail() throws SQLException {
		String query = "SELECT eMail FROM adherent WHERE idAdherent = '" + idAdherent + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		if (Connect.result.next()) {
			return Connect.result.getObject(1).toString();
		} else
			return null;
	}
	
	public void rendre(Emprunt emp) throws SQLException {
		Date date = new Date();
		String query = "UPDATE emprunter SET dateRetour = '" + dateFormat.format(date) + "' WHERE idExemplaire = " + emp.idExemplaire;
		Connect.state.executeUpdate(query);	
		if(emp.retard()) {
			nbRetard++;
			query = "UPDATE adherent SET nbRetard = '" + nbRetard + "' WHERE idAdherent = " + emp.idAdherent;
		}
		emp.dateRetour = date;
	}

	public int prolonger(Emprunt emp) throws SQLException {
		if(nbRetard >= 5) {
			return -1;
		}
		Calendar dateLimite = Calendar.getInstance();
		dateLimite.setTime(emp.dateLimite);
		dateLimite.add(Calendar.WEEK_OF_YEAR, 1);
		emp.dateLimite = dateLimite.getTime();
		String query = "UPDATE emprunter SET dateLimite = '" + dateFormat.format(emp.dateLimite) + "' WHERE idExemplaire = " + emp.idExemplaire;
		Connect.state.executeUpdate(query);		
		return 0;
	}
	public int desactiver() throws SQLException, ParseException {
		List<Emprunt> emprunts = emprunts();
		if(!emprunts.isEmpty()) {
			String query = "SELECT * FROM emprunter WHERE idAdherent = '" + idAdherent + "' AND dateRetour IS NULL;";
			Connect.result = Connect.state.executeQuery(query);
			if (Connect.result.next())
				return -1;
		}
		listeAdherents.remove(this);
		String query = "UPDATE adherent SET actif = 0 WHERE idAdherent = " + idAdherent + ";";
		actif = false;
		Connect.state.executeUpdate(query);
		return 0;
	}
	
	public void setAdresse(String adresse) throws SQLException {
		String query = "UPDATE adherent SET adresse = '" + adresse + "' WHERE idAdherent = "+ idAdherent + ";";
		Connect.state.executeUpdate(query);		
	}	
	public void setMail(String mail) throws SQLException {
		String query = "UPDATE adherent SET eMail = '" + mail + "' WHERE idAdherent = "+ idAdherent + ";";
		Connect.state.executeUpdate(query);		
	}
	
	public void setPassword(String password) throws SQLException {
		String query = "UPDATE adherent SET MotDePasse = '" + password + "' WHERE idAdherent = "+ idAdherent + ";";
		Connect.state.executeUpdate(query);		
	}

}