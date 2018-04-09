package Application.Java;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * 
 */
public class Musique extends Exemplaire {
	static ArrayList<Musique> listeMusiques = new ArrayList<>();

	/**
	 * Default constructor
	 */
	public Musique() {
	}

	/**
	 * 
	 */
	public Integer idMusique;
	
	public Musique(String id) {
		super();
		this.idMusique = Integer.valueOf(id);
	}

	
	static void init() throws SQLException, NumberFormatException, ParseException {
		String query = "SELECT idMusique FROM musique";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			listeMusiques.add(new Musique(Connect.result.getObject(1).toString()));
		}
	}





	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getInterpretes() throws SQLException {
		ArrayList<Integer> interpretes = new ArrayList<>();
		String query = "SELECT idInterprete FROM interpreter WHERE idMusique = '" + idMusique + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			interpretes.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return interpretes;
	}

	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getCompositeurs() throws SQLException {
		ArrayList<Integer> compositeurs = new ArrayList<>();
		String query = "SELECT idCompositeur FROM composer WHERE idMusique = '" + idMusique + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			compositeurs.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return compositeurs;
	}

	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getAuteurs() throws SQLException {
		ArrayList<Integer> auteurs = new ArrayList<>();
		String query = "SELECT idAuteur FROM interpreter WHERE idMusique = '" + idMusique + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			auteurs.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return auteurs;
	}

}