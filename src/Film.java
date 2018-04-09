import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * 
 */
public class Film extends Exemplaire {
	static ArrayList<Film> listeFilms = new ArrayList<>();
	public Integer idFilm;
	public Integer idProduction;

	/**
	 * Default constructor
	 */
	public Film() {
	}
	
	public Film(String idFilm, String idProduction) {
		super();
		this.idFilm = Integer.valueOf(idFilm);
		this.idProduction = Integer.valueOf(idProduction);
	}

	
	static void init() throws SQLException, NumberFormatException, ParseException {
		String query = "SELECT idFilm, idProd FROM film";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();

		while (Connect.result.next()) {
			listeFilms.add(new Film(Connect.result.getObject(1).toString(), Connect.result.getObject(2).toString()));
		}
	}
	
	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getRealisateurs() throws SQLException {
		ArrayList<Integer> realisateurs = new ArrayList<>();
		String query = "SELECT idRealisateur FROM realiser WHERE idFilm = '" + idFilm + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			realisateurs.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return realisateurs;
	}
	
	/**
	 * @return
	 * @throws SQLException 
	 */
	public List<Integer> getScenaristes() throws SQLException {
		ArrayList<Integer> scenaristes = new ArrayList<>();
		String query = "SELECT idScenariste FROM ecrirescenario WHERE idFilm = '" + idFilm + "';";
		Connect.result = Connect.state.executeQuery(query);
		Connect.resultMeta = Connect.result.getMetaData();
		while (Connect.result.next()) {
			scenaristes.add(Integer.valueOf(Connect.result.getObject(1).toString()));
		}		
		return scenaristes;
	}

}