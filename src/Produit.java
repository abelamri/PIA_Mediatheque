import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Produit {

	static ArrayList<Produit> listeProduits = new ArrayList<>();
	public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public Integer idProduit;
	public String Titre;
	public Date DatePublication;
	public String Description;


	public Produit(String idProduit, String titre, String datePublication, String description) throws ParseException {
		super();
		this.idProduit = Integer.valueOf(idProduit);
		Titre = titre;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DatePublication = df.parse(datePublication);
		Description = description;
	}

	public static Produit getProduit(Integer id) {
		for (Produit produit : listeProduits) {
			if (id.equals(produit.idProduit))
				return produit;
		}
		return null;
	}

	static void init() throws SQLException, NumberFormatException, ParseException {
		String query = "SELECT * FROM produit";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			int i = 1;
			listeProduits
					.add(new Produit(Connect.result.getObject(i++).toString(), Connect.result.getObject(i++).toString(),
							Connect.result.getObject(i++).toString(), Connect.result.getObject(i++).toString()));

		}
	}

	public Integer getExemplaireDispo() throws SQLException {
		ArrayList<Integer> exemplaires = new ArrayList<>();
		String query = "SELECT idExemplaire FROM exemplaire WHERE idProduit = '" + idProduit + "';";
		Connect.result = Connect.state.executeQuery(query);

		while (Connect.result.next()) {
			exemplaires.add(Connect.result.getInt(1));
		}
		
		for (Integer exemplaire : exemplaires) {
			query = "SELECT * FROM emprunter WHERE idExemplaire = '" + exemplaire + "';";
			Connect.result = Connect.state.executeQuery(query);
			if (!Connect.result.next())
				return exemplaire;
			query = "SELECT * FROM emprunter WHERE idExemplaire = '" + exemplaire + "' AND dateRetour IS NULL;";
			Connect.result = Connect.state.executeQuery(query);
			if (!Connect.result.next())
				return exemplaire;
		}
		return -1;
	}

	public List<Integer> getGenres() throws SQLException {
		String query = "SELECT idGenre FROM estdegenre WHERE idProduit = " + idProduit.toString();
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		ArrayList<Integer> res = new ArrayList<>();
		while (Connect.result.next()) {
			res.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}

		return res;
	}

	public String toString() {
		return idProduit + " | " + Titre + " | " + df.format(DatePublication) + " | " + Description + '\n';
	}
	
	public static Produit getProduitFromExemplaire(Integer idExemplaire) throws SQLException {
		Produit p;
		String query = "SELECT idProduit FROM exemplaire WHERE idExemplaire = " + idExemplaire;

		Connect.result = Connect.state.executeQuery(query);
		if (Connect.result.next()) {
			p = getProduit((Integer.valueOf(Connect.result.getObject(1).toString())));
		}
		else p = null;

		return p;
	}
	
	public boolean isLivre() throws SQLException {
		String query = "SELECT p.idProduit FROM produit p JOIN livre l ON p.idProduit = l.idProduit "
				+ "WHERE p.idProduit = " + idProduit + ";";
		Connect.result = Connect.state.executeQuery(query);
		return Connect.result.next();
	}
	
	public boolean isFilm() throws SQLException {
		String query = "SELECT p.idProduit FROM produit p JOIN film f ON p.idProduit = f.idProduit "
				+ "WHERE p.idProduit = " + idProduit + ";";
		Connect.result = Connect.state.executeQuery(query);
		return Connect.result.next();
	}
	
	public boolean isMusique() throws SQLException {
		String query = "SELECT p.idProduit FROM produit p JOIN musique m ON p.idProduit = m.idProduit "
				+ "WHERE p.idProduit = " + idProduit + ";";
		Connect.result = Connect.state.executeQuery(query);
		return Connect.result.next();
	}

}