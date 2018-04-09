import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 */
public class Emprunt {

	public Date dateEmprunt;
	public Date dateLimite;
	public Date dateRetour;
	public Integer idAdherent;
	public Integer idExemplaire;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Default constructor
	 */
	public Emprunt() {
	}

	public Emprunt(String dateEmprunt, String dateLimite, String dateRetour, String idAdherent, String idExemplaire)
			throws ParseException {
		super();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		this.dateEmprunt = df.parse(dateEmprunt);
		this.dateLimite = df.parse(dateLimite);
		if(dateRetour.equals("NULL")) this.dateRetour = null;
		else this.dateRetour = df.parse(dateRetour);
		this.idAdherent = Integer.valueOf(idAdherent);
		this.idExemplaire = Integer.valueOf(idExemplaire);
	}
	
	public boolean retard() {
		Date date = new Date();
		return (date.after(dateLimite) && dateRetour == null);
	}
	
	public boolean limite() {
		Date date = new Date();
		return (date.equals(dateLimite) && dateRetour == null);
	}
	
	public boolean enCours() {
		Date date = new Date();
		return (date.before(dateLimite) && dateRetour == null);
	}
	
	public boolean retoune() {
		return (dateRetour != null);
	}

	public String toString() {
		String query = "SELECT idProduit FROM exemplaire WHERE idExemplaire = " + idExemplaire + ";";
		Produit p;
		try {
			Connect.result = Connect.state.executeQuery(query);
			Connect.resultMeta = Connect.result.getMetaData();
			if (Connect.result.next())
				p = Produit.getProduit(Integer.valueOf(Connect.result.getObject(1).toString()));
			else return "null";
			String mes = "";
			if(retard()) mes = "Date limite dépassée !";
			else if(limite()) mes = "Date limite atteinte !";
			String res = p.Titre;
			String res2 = "   Emprunté le : " + dateFormat.format(dateEmprunt) + "  Date Limite : " + dateFormat.format(dateLimite) + "  ";
			if (dateRetour == null) res2 += mes + " ";
			else res2 += "Rendu le : " + dateFormat.format(dateRetour) + " " + mes;
			res += res2;
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "null";
	}

}