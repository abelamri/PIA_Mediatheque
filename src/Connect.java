import java.sql.*;
import java.text.ParseException;

public class Connect {

	static Connection conn;
	static Statement state;
	static ResultSet result;
	static ResultSetMetaData resultMeta;

	public Connect() {
	}

	public static void init() throws NumberFormatException, SQLException, ParseException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/bibliotheque";
		String user = "root";
		String passwd = "root";

		conn = DriverManager.getConnection(url, user, passwd);

		state = conn.createStatement();
		Musique.init();
		Adherent.init();
		Film.init();
		Produit.init();
		Livre.init();
	}

	public static void update() throws NumberFormatException, SQLException, ParseException {
		Musique.init();
		Adherent.init();
		Film.init();
		Produit.init();
		Livre.init();
	}
}