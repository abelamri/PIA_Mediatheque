import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * 
 */
public class Livre {
	static ArrayList<Livre> listeLivres = new ArrayList<>();
	public Integer idLivre;

	/**
	 * Default constructor
	 */
	public Livre() {
	}
	
	public Livre(String id) {
		super();
		this.idLivre = Integer.valueOf(id);
	}

	
	static void init() throws SQLException, NumberFormatException, ParseException {
		String query = "SELECT idLivre FROM livre";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			listeLivres.add(new Livre(Connect.result.getObject(1).toString()));
		}
	}


	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getEcrivains() throws SQLException {
		ArrayList<Integer> ecrivains = new ArrayList<>();
		String query = "SELECT idEcrivain FROM ecrire WHERE idLivre = '" + idLivre + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			ecrivains.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return ecrivains;
	}

}