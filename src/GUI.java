import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class GUI {

	private static final int AUTEUR = 0;
	private static final int NOM = 1;
	private static final int GENRE = 2;

	public static final int connected = 1;
	public static final int loginScreen = 2;
	public static final int signIn = 3;
	public static final int profile = 4;

	public int state = loginScreen;
	private JFrame frame;
	private SpringLayout springLayout;
	private Produit selectedProduct;
	private Adherent currentUser;
	private Emprunt selectedEmprunt;

	/*** Elements login ***/
	private ArrayList<Object> loginList = new ArrayList<>();
	private JTextField tfUsername_login;
	private JTextField tfPassword_login;
	private JLabel lblTitre_login;
	private JLabel lblConnexion_login;
	private JLabel lblCreerCompte_login;
	private JLabel lblNomDutilisateur_login;
	private JLabel lblMotDePasse_login;
	private JButton btnConnect_login;

	/*** Elements signin ***/
	private ArrayList<Object> signinList = new ArrayList<>();
	private JTextField tfUsername_signin;
	private JTextField tfPassword_signin;
	private JTextField tfPasswordBis_signin;
	private JTextField tfAddress_signin;
	private JTextField tfFirstName_signin;
	private JTextField tfLastName_signin;
	private JComboBox<Integer> tfDateDay_signin;
	private JComboBox<Integer> tfDateMonth_signin;
	private JComboBox<Integer> tfDateYear_signin;
	private JLabel lblTitre_signin;
	private JLabel lblMail_signin;
	private JLabel lblMotDePasse_signin;
	private JLabel lblMotDePasseBis_signin;
	private JLabel lblRetour_signin;
	private JLabel lblAddress_signin;
	private JLabel lblFirstName_signin;
	private JLabel lblLastName_signin;
	private JLabel lblDate_signin;
	private JButton btnCreate_signin;

	/*** Elements connected ***/
	private ArrayList<Object> connectedList = new ArrayList<>();
	private JTextField tfRecherche_connect;
	private JButton btnRechercher_connect;
	private JScrollPane scrollPane_connect;
	private JPanel listPanel_connect;
	private JButton btnReserver_connect;
	private JButton btnEmprunter_connect;
	private JLabel lblBienvenue_connect;
	private JRadioButton rdbtnNom_connect;
	private JRadioButton rdbtnGenre_connect;
	private JRadioButton rdbtnAuteur_connect;
	private JCheckBox chckbxFilm_connect;
	private JCheckBox chckbxLivre_connect;
	private JCheckBox chckbxMusique_connect;
	private JLabel lblRechercheParCritres_connect;
	private JCheckBox chckbxDispo_connect;
	private ButtonGroup btnGrp_connect;
	private JButton btnMonCompte_connect;
	private JButton btnSeDconnecter_connect;
	private JSeparator separator_connect;

	/*** Elements profile ***/
	private ArrayList<Object> profileList = new ArrayList<>();
	private JLabel lblEmprunts_prof;
	private JScrollPane scrollPane_prof;
	private JPanel listPanel_prof;
	private JLabel txtNom_prof;
	private JLabel txtPrnom_prof;
	private JTextField tfAdr_prof;
	private JTextField tfMdp_prof;
	private JTextField tfMdpBis_prof;
	private JLabel lblEmail_prof;
	private JTextField tfMail_prof;
	private JButton btnDesactiver_prof;
	private JButton btnRetour_prof;
	private JLabel lblMesInformations_prof;
	private JLabel lblAdresse_prof;
	private JLabel lblMotDePasse_prof;
	private JLabel lblConfirmation;
	private JButton btnProlonger_prof;
	private JButton btnRendre_prof;
	private JButton btnChkAdr_prof;
	private JButton btnChkMail_prof;
	private JButton btnChkMdp_prof;
	private JButton btnSeDconnecter_prof;
	private JLabel lblNom_prof;
	private JLabel lblPrnom_prof;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initLogin(JFrame frame, SpringLayout springLayout) {
		lblTitre_login = new JLabel("MEDIATHEQUA");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitre_login, (int) (frame.getHeight() * 0.1),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitre_login, 0, SpringLayout.HORIZONTAL_CENTER,
				frame.getContentPane());
		lblTitre_login.setFont(new Font("Tahoma", Font.PLAIN, 60));
		frame.getContentPane().add(lblTitre_login);

		lblConnexion_login = new JLabel("Connexion");
		springLayout.putConstraint(SpringLayout.NORTH, lblConnexion_login, (int) (frame.getHeight() * 0.22),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblConnexion_login, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		lblConnexion_login.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblConnexion_login);

		lblNomDutilisateur_login = new JLabel("Nom d'utilisateur : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomDutilisateur_login, (int) (frame.getHeight() * 0.3),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNomDutilisateur_login, (int) (frame.getWidth() * 0.45),
				SpringLayout.WEST, frame.getContentPane());
		lblNomDutilisateur_login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblNomDutilisateur_login);
		lblNomDutilisateur_login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connect();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});

		lblMotDePasse_login = new JLabel("Mot de passe : ");
		lblMotDePasse_login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasse_login, 6, SpringLayout.SOUTH,
				lblNomDutilisateur_login);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasse_login, 0, SpringLayout.EAST,
				lblNomDutilisateur_login);
		frame.getContentPane().add(lblMotDePasse_login);

		tfUsername_login = new JTextField();
		tfUsername_login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfUsername_login, 0, SpringLayout.NORTH,
				lblNomDutilisateur_login);
		springLayout.putConstraint(SpringLayout.WEST, tfUsername_login, 5, SpringLayout.EAST, lblNomDutilisateur_login);
		springLayout.putConstraint(SpringLayout.SOUTH, tfUsername_login, 0, SpringLayout.SOUTH,
				lblNomDutilisateur_login);
		springLayout.putConstraint(SpringLayout.EAST, tfUsername_login, 340, SpringLayout.EAST,
				lblNomDutilisateur_login);
		frame.getContentPane().add(tfUsername_login);
		tfUsername_login.setColumns(10);

		tfPassword_login = new JPasswordField();
		tfPassword_login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connect();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});
		tfPassword_login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfPassword_login, 0, SpringLayout.NORTH, lblMotDePasse_login);
		springLayout.putConstraint(SpringLayout.WEST, tfPassword_login, 5, SpringLayout.EAST, lblMotDePasse_login);
		springLayout.putConstraint(SpringLayout.SOUTH, tfPassword_login, 0, SpringLayout.SOUTH, lblMotDePasse_login);
		springLayout.putConstraint(SpringLayout.EAST, tfPassword_login, 340, SpringLayout.EAST, lblMotDePasse_login);
		tfPassword_login.setColumns(10);
		frame.getContentPane().add(tfPassword_login);

		btnConnect_login = new JButton("Se connecter");
		btnConnect_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					connect();
				} catch (NumberFormatException | ParseException | SQLException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		btnConnect_login.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connect();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnConnect_login, 340, SpringLayout.WEST,
				lblNomDutilisateur_login);
		btnConnect_login.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnConnect_login, 6, SpringLayout.SOUTH, tfPassword_login);
		springLayout.putConstraint(SpringLayout.SOUTH, btnConnect_login, 37, SpringLayout.SOUTH, tfPassword_login);
		springLayout.putConstraint(SpringLayout.EAST, btnConnect_login, 0, SpringLayout.EAST, tfUsername_login);
		frame.getContentPane().add(btnConnect_login);

		lblCreerCompte_login = new JLabel("Vous n'avez de compte ? Cr\u00E9ez-en un ici !");
		lblCreerCompte_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				state = signIn;
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du changement d'écran.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		lblCreerCompte_login.setForeground(Color.BLUE);
		lblCreerCompte_login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblCreerCompte_login, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblCreerCompte_login, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		frame.getContentPane().add(lblCreerCompte_login);

		loginList.add(tfUsername_login);
		loginList.add(tfPassword_login);
		loginList.add(lblTitre_login);
		loginList.add(lblConnexion_login);
		loginList.add(lblCreerCompte_login);
		loginList.add(lblNomDutilisateur_login);
		loginList.add(lblMotDePasse_login);
		loginList.add(btnConnect_login);

	}

	public void initSingIn(JFrame frame, SpringLayout springLayout) {
		lblTitre_signin = new JLabel("CREATION DE COMPTE");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitre_signin, (int) (frame.getHeight() * 0.22),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitre_signin, 0, SpringLayout.HORIZONTAL_CENTER,
				frame.getContentPane());
		lblTitre_signin.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblTitre_signin);

		lblMail_signin = new JLabel("Adresse mail : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMail_signin, (int) (frame.getHeight() * 0.3),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblMail_signin, (int) (frame.getWidth() * 0.45),
				SpringLayout.WEST, frame.getContentPane());
		lblMail_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblMail_signin);

		lblFirstName_signin = new JLabel("Prénom : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName_signin, 6, SpringLayout.SOUTH, lblMail_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName_signin, 0, SpringLayout.EAST, lblMail_signin);
		lblFirstName_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblFirstName_signin);

		lblLastName_signin = new JLabel("Nom : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName_signin, 6, SpringLayout.SOUTH, lblFirstName_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblLastName_signin, 0, SpringLayout.EAST, lblFirstName_signin);
		lblLastName_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblLastName_signin);

		lblAddress_signin = new JLabel("Adresse : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblAddress_signin, 6, SpringLayout.SOUTH, lblLastName_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblAddress_signin, 0, SpringLayout.EAST, lblLastName_signin);
		lblAddress_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblAddress_signin);

		lblDate_signin = new JLabel("Date de naissance : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblDate_signin, 6, SpringLayout.SOUTH, lblAddress_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblDate_signin, 0, SpringLayout.EAST, lblAddress_signin);
		lblDate_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblDate_signin);

		lblMotDePasse_signin = new JLabel("Mot de passe : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasse_signin, 6, SpringLayout.SOUTH, lblDate_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasse_signin, 0, SpringLayout.EAST, lblDate_signin);
		lblMotDePasse_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblMotDePasse_signin);

		lblMotDePasseBis_signin = new JLabel("Répétez votre mot de passe : ");
		lblMotDePasseBis_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasseBis_signin, 6, SpringLayout.SOUTH,
				lblMotDePasse_signin);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasseBis_signin, 0, SpringLayout.EAST,
				lblMotDePasse_signin);
		frame.getContentPane().add(lblMotDePasseBis_signin);

		tfUsername_signin = new JTextField();
		tfUsername_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfUsername_signin, 0, SpringLayout.NORTH, lblMail_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfUsername_signin, 5, SpringLayout.EAST, lblMail_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfUsername_signin, 0, SpringLayout.SOUTH, lblMail_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfUsername_signin, 340, SpringLayout.EAST, lblMail_signin);
		frame.getContentPane().add(tfUsername_signin);
		tfUsername_signin.setColumns(10);

		tfFirstName_signin = new JTextField();
		tfFirstName_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfFirstName_signin, 0, SpringLayout.NORTH, lblFirstName_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfFirstName_signin, 5, SpringLayout.EAST, lblFirstName_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfFirstName_signin, 0, SpringLayout.SOUTH, lblFirstName_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfFirstName_signin, 340, SpringLayout.EAST, lblFirstName_signin);
		tfFirstName_signin.setColumns(10);
		frame.getContentPane().add(tfFirstName_signin);

		tfLastName_signin = new JTextField();
		tfLastName_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfLastName_signin, 0, SpringLayout.NORTH, lblLastName_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfLastName_signin, 5, SpringLayout.EAST, lblLastName_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfLastName_signin, 0, SpringLayout.SOUTH, lblLastName_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfLastName_signin, 340, SpringLayout.EAST, lblLastName_signin);
		tfLastName_signin.setColumns(10);
		frame.getContentPane().add(tfLastName_signin);

		tfAddress_signin = new JTextField();
		tfAddress_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfAddress_signin, 0, SpringLayout.NORTH, lblAddress_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfAddress_signin, 5, SpringLayout.EAST, lblAddress_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfAddress_signin, 0, SpringLayout.SOUTH, lblAddress_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfAddress_signin, 340, SpringLayout.EAST, lblAddress_signin);
		tfAddress_signin.setColumns(10);
		frame.getContentPane().add(tfAddress_signin);

		tfDateDay_signin = new JComboBox<Integer>();
		tfDateDay_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateDay_signin, 0, SpringLayout.NORTH, lblDate_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfDateDay_signin, 6, SpringLayout.EAST, lblDate_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateDay_signin, 0, SpringLayout.SOUTH, lblDate_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfDateDay_signin, 85, SpringLayout.EAST, lblDate_signin);
		frame.getContentPane().add(tfDateDay_signin);
		for (int i = 1; i <= 31; i++)
			tfDateDay_signin.addItem(i);

		tfDateMonth_signin = new JComboBox<Integer>();
		tfDateMonth_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateMonth_signin, 0, SpringLayout.NORTH, tfDateDay_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfDateMonth_signin, 6, SpringLayout.EAST, tfDateDay_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateMonth_signin, 0, SpringLayout.SOUTH, tfDateDay_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfDateMonth_signin, 85, SpringLayout.EAST, tfDateDay_signin);
		frame.getContentPane().add(tfDateMonth_signin);
		for (int i = 1; i <= 12; i++)
			tfDateMonth_signin.addItem(i);

		tfDateYear_signin = new JComboBox<Integer>();
		tfDateYear_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateYear_signin, 0, SpringLayout.NORTH, tfDateMonth_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfDateYear_signin, 6, SpringLayout.EAST, tfDateMonth_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateYear_signin, 0, SpringLayout.SOUTH, tfDateMonth_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfDateYear_signin, 170, SpringLayout.EAST, tfDateMonth_signin);
		frame.getContentPane().add(tfDateYear_signin);
		for (int i = 1920; i <= 2017; i++)
			tfDateYear_signin.addItem(i);

		tfPassword_signin = new JPasswordField();
		tfPassword_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfPassword_signin, 0, SpringLayout.NORTH, lblMotDePasse_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfPassword_signin, 5, SpringLayout.EAST, lblMotDePasse_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfPassword_signin, 0, SpringLayout.SOUTH, lblMotDePasse_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfPassword_signin, 340, SpringLayout.EAST, lblMotDePasse_signin);
		tfPassword_signin.setColumns(10);
		frame.getContentPane().add(tfPassword_signin);

		tfPasswordBis_signin = new JPasswordField();
		tfPasswordBis_signin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						createUser();
					} catch (NumberFormatException | ParseException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
						frame.dispose();
					}
				}
			}
		});
		tfPasswordBis_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfPasswordBis_signin, 0, SpringLayout.NORTH,
				lblMotDePasseBis_signin);
		springLayout.putConstraint(SpringLayout.WEST, tfPasswordBis_signin, 5, SpringLayout.EAST,
				lblMotDePasseBis_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, tfPasswordBis_signin, 0, SpringLayout.SOUTH,
				lblMotDePasseBis_signin);
		springLayout.putConstraint(SpringLayout.EAST, tfPasswordBis_signin, 340, SpringLayout.EAST,
				lblMotDePasseBis_signin);
		tfPasswordBis_signin.setColumns(10);
		frame.getContentPane().add(tfPasswordBis_signin);

		btnCreate_signin = new JButton("Créer");
		btnCreate_signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					createUser();
				} catch (NumberFormatException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCreate_signin, 340, SpringLayout.WEST, lblMail_signin);
		btnCreate_signin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnCreate_signin, 6, SpringLayout.SOUTH, tfPasswordBis_signin);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreate_signin, 37, SpringLayout.SOUTH, tfPasswordBis_signin);
		springLayout.putConstraint(SpringLayout.EAST, btnCreate_signin, 0, SpringLayout.EAST, tfUsername_signin);
		frame.getContentPane().add(btnCreate_signin);

		lblRetour_signin = new JLabel("Retour");
		lblRetour_signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				state = loginScreen;
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du retour à l'écran de connexion.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		lblRetour_signin.setForeground(Color.BLUE);
		lblRetour_signin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblRetour_signin, 0, SpringLayout.HORIZONTAL_CENTER,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblRetour_signin, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		frame.getContentPane().add(lblRetour_signin);

		signinList.add(tfUsername_signin);
		signinList.add(tfPassword_signin);
		signinList.add(tfPasswordBis_signin);
		signinList.add(tfAddress_signin);
		signinList.add(tfFirstName_signin);
		signinList.add(tfLastName_signin);
		signinList.add(tfDateDay_signin);
		signinList.add(tfDateMonth_signin);
		signinList.add(tfDateYear_signin);
		signinList.add(lblTitre_signin);
		signinList.add(lblMail_signin);
		signinList.add(lblMotDePasse_signin);
		signinList.add(lblMotDePasseBis_signin);
		signinList.add(lblRetour_signin);
		signinList.add(lblAddress_signin);
		signinList.add(lblFirstName_signin);
		signinList.add(lblLastName_signin);
		signinList.add(lblDate_signin);
		signinList.add(btnCreate_signin);

	}

	public void initConnected(JFrame frame, SpringLayout springLayout) throws SQLException {
		tfRecherche_connect = new JTextField();
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tfRecherche_connect, -13,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, tfRecherche_connect, 10, SpringLayout.NORTH,
				frame.getContentPane());
		frame.getContentPane().add(tfRecherche_connect);
		tfRecherche_connect.setColumns(40);
		tfRecherche_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tfRecherche_connect.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						if (rdbtnAuteur_connect.isSelected())
							search(AUTEUR);
						else if (rdbtnGenre_connect.isSelected())
							search(GENRE);
						else if (rdbtnNom_connect.isSelected())
							search(NOM);
						else
							search(NOM);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la recherche.");
						e1.printStackTrace();
					}
				}
			}
		});

		lblBienvenue_connect = new JLabel("");
		lblBienvenue_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblBienvenue_connect, 0, SpringLayout.NORTH,
				tfRecherche_connect);
		springLayout.putConstraint(SpringLayout.WEST, lblBienvenue_connect, 10, SpringLayout.WEST,
				frame.getContentPane());
		frame.getContentPane().add(lblBienvenue_connect);

		btnRechercher_connect = new JButton("Rechercher");
		springLayout.putConstraint(SpringLayout.WEST, btnRechercher_connect, 6, SpringLayout.EAST, tfRecherche_connect);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRechercher_connect, 0, SpringLayout.SOUTH,
				tfRecherche_connect);
		springLayout.putConstraint(SpringLayout.NORTH, btnRechercher_connect, 0, SpringLayout.NORTH,
				tfRecherche_connect);
		frame.getContentPane().add(btnRechercher_connect);
		btnRechercher_connect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (rdbtnAuteur_connect.isSelected())
						search(AUTEUR);
					else if (rdbtnGenre_connect.isSelected())
						search(GENRE);
					else if (rdbtnNom_connect.isSelected())
						search(NOM);
					else
						search(NOM);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la recherche.");
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_connect.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connect();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});

		scrollPane_connect = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_connect, 10, SpringLayout.SOUTH, tfRecherche_connect);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_connect, 0, SpringLayout.WEST, tfRecherche_connect);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_connect, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_connect, 0, SpringLayout.EAST, btnRechercher_connect);

		listPanel_connect = new JPanel();
		listPanel_connect.setLayout(new GridLayout(60, 1));
		listPanel_connect.setMinimumSize(new Dimension(scrollPane_connect.getWidth(), 2400));
		listPanel_connect.setPreferredSize(new Dimension(scrollPane_connect.getWidth(), 2400));
		listPanel_connect.setMaximumSize(new Dimension(scrollPane_connect.getWidth(), 2400));
		scrollPane_connect.setViewportView(listPanel_connect);
		frame.getContentPane().add(scrollPane_connect);

		btnReserver_connect = new JButton("R\u00E9server");
		btnReserver_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnReserver_connect, -50, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnReserver_connect, 10, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnReserver_connect, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnReserver_connect, -10, SpringLayout.WEST, scrollPane_connect);
		btnReserver_connect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					currentUser.reserver(selectedProduct.idProduit);
					JOptionPane.showMessageDialog(frame, "Réservation réussie.");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la réservation.");
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnReserver_connect);

		btnEmprunter_connect = new JButton("Emprunter");
		springLayout.putConstraint(SpringLayout.WEST, btnEmprunter_connect, 10, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnEmprunter_connect, -6, SpringLayout.NORTH,
				btnReserver_connect);
		springLayout.putConstraint(SpringLayout.EAST, btnEmprunter_connect, 0, SpringLayout.EAST, btnReserver_connect);
		btnEmprunter_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEmprunter_connect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedProduct == null) {
					JOptionPane.showMessageDialog(frame, "Aucun produit sélectionné.");
					return;
				}
				try {
					int r = currentUser.emprunter(selectedProduct.idProduit);
					if (r == -1) {
						JOptionPane.showMessageDialog(frame,
								"Le produit n'est pas disponible, vous pouvez le réserver en cliquant sur le bouton Réserver.");
					} else {
						JOptionPane.showMessageDialog(frame, "Emprunt réussi.");
						if (rdbtnAuteur_connect.isSelected())
							search(AUTEUR);
						else if (rdbtnGenre_connect.isSelected())
							search(GENRE);
						else if (rdbtnNom_connect.isSelected())
							search(NOM);
						else
							search(NOM);
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'emprunt.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnEmprunter_connect);

		rdbtnNom_connect = new JRadioButton("Nom");
		rdbtnNom_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNom_connect, 6, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNom_connect, -6, SpringLayout.WEST, scrollPane_connect);
		frame.getContentPane().add(rdbtnNom_connect);

		rdbtnGenre_connect = new JRadioButton("Genre");
		rdbtnGenre_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnGenre_connect, 1, SpringLayout.SOUTH, rdbtnNom_connect);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnGenre_connect, 6, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rdbtnGenre_connect, -8, SpringLayout.WEST, scrollPane_connect);
		frame.getContentPane().add(rdbtnGenre_connect);

		rdbtnAuteur_connect = new JRadioButton("Auteur");
		rdbtnAuteur_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnAuteur_connect, 0, SpringLayout.SOUTH, rdbtnGenre_connect);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnAuteur_connect, 6, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, rdbtnAuteur_connect, -6, SpringLayout.WEST, scrollPane_connect);
		frame.getContentPane().add(rdbtnAuteur_connect);

		separator_connect = new JSeparator();
		springLayout.putConstraint(SpringLayout.NORTH, separator_connect, 5, SpringLayout.SOUTH, rdbtnAuteur_connect);
		springLayout.putConstraint(SpringLayout.WEST, separator_connect, 0, SpringLayout.WEST, rdbtnAuteur_connect);
		springLayout.putConstraint(SpringLayout.EAST, separator_connect, -5, SpringLayout.WEST, scrollPane_connect);
		frame.getContentPane().add(separator_connect);

		chckbxDispo_connect = new JCheckBox("Afficher uniquement les produits disponibles");
		springLayout.putConstraint(SpringLayout.NORTH, chckbxDispo_connect, 6, SpringLayout.SOUTH, separator_connect);
		springLayout.putConstraint(SpringLayout.WEST, chckbxDispo_connect, 0, SpringLayout.WEST, separator_connect);
		chckbxDispo_connect.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(chckbxDispo_connect);

		chckbxFilm_connect = new JCheckBox("Film");
		chckbxFilm_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, chckbxFilm_connect, 5, SpringLayout.SOUTH, chckbxDispo_connect);
		springLayout.putConstraint(SpringLayout.WEST, chckbxFilm_connect, 0, SpringLayout.WEST, chckbxDispo_connect);
		frame.getContentPane().add(chckbxFilm_connect);

		chckbxLivre_connect = new JCheckBox("Livre");
		chckbxLivre_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, chckbxLivre_connect, 5, SpringLayout.SOUTH, chckbxFilm_connect);
		springLayout.putConstraint(SpringLayout.WEST, chckbxLivre_connect, 0, SpringLayout.WEST, chckbxFilm_connect);
		frame.getContentPane().add(chckbxLivre_connect);

		chckbxMusique_connect = new JCheckBox("Musique");
		chckbxMusique_connect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, chckbxMusique_connect, 5, SpringLayout.SOUTH,
				chckbxLivre_connect);
		springLayout.putConstraint(SpringLayout.WEST, chckbxMusique_connect, 0, SpringLayout.WEST, chckbxLivre_connect);
		frame.getContentPane().add(chckbxMusique_connect);

		lblRechercheParCritres_connect = new JLabel("Recherche par crit\u00E8res :");
		springLayout.putConstraint(SpringLayout.NORTH, lblRechercheParCritres_connect, 20, SpringLayout.NORTH,
				scrollPane_connect);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNom_connect, 6, SpringLayout.SOUTH,
				lblRechercheParCritres_connect);
		lblRechercheParCritres_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.WEST, lblRechercheParCritres_connect, 10, SpringLayout.WEST,
				frame.getContentPane());
		frame.getContentPane().add(lblRechercheParCritres_connect);
		btnGrp_connect = new ButtonGroup();
		btnGrp_connect.add(rdbtnAuteur_connect);
		btnGrp_connect.add(rdbtnGenre_connect);
		btnGrp_connect.add(rdbtnNom_connect);

		btnMonCompte_connect = new JButton("Mon compte");
		springLayout.putConstraint(SpringLayout.NORTH, btnMonCompte_connect, 0, SpringLayout.NORTH,
				btnRechercher_connect);
		springLayout.putConstraint(SpringLayout.WEST, btnMonCompte_connect, 15, SpringLayout.EAST,
				btnRechercher_connect);
		springLayout.putConstraint(SpringLayout.SOUTH, btnMonCompte_connect, 0, SpringLayout.SOUTH,
				btnRechercher_connect);
		springLayout.putConstraint(SpringLayout.EAST, btnMonCompte_connect, -10, SpringLayout.EAST,
				frame.getContentPane());
		btnMonCompte_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state = profile;
				try {
					emprunts();
					txtNom_prof.setText(currentUser.getNom());
					txtPrnom_prof.setText(currentUser.getPrenom());
					tfAdr_prof.setText(currentUser.getAdresse());
					tfMail_prof.setText(currentUser.getMail());
				} catch (ParseException | SQLException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'affichage du profil.");
					e.printStackTrace();
				}
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'accès au profil.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		btnMonCompte_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(btnMonCompte_connect);

		btnSeDconnecter_connect = new JButton("Se d\u00E9connecter");
		springLayout.putConstraint(SpringLayout.NORTH, btnSeDconnecter_connect, 6, SpringLayout.SOUTH,
				btnMonCompte_connect);
		springLayout.putConstraint(SpringLayout.WEST, btnSeDconnecter_connect, 0, SpringLayout.WEST,
				btnMonCompte_connect);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSeDconnecter_connect, 90, SpringLayout.NORTH,
				frame.getContentPane());
		btnSeDconnecter_connect.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSeDconnecter_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state = loginScreen;
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la déconnexion.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnSeDconnecter_connect, -10, SpringLayout.EAST,
				frame.getContentPane());
		frame.getContentPane().add(btnSeDconnecter_connect);

		connectedList.add(tfRecherche_connect);
		connectedList.add(lblBienvenue_connect);
		connectedList.add(btnRechercher_connect);
		connectedList.add(listPanel_connect);
		connectedList.add(scrollPane_connect);
		connectedList.add(btnReserver_connect);
		connectedList.add(btnEmprunter_connect);
		connectedList.add(rdbtnNom_connect);
		connectedList.add(rdbtnGenre_connect);
		connectedList.add(rdbtnAuteur_connect);
		connectedList.add(lblRechercheParCritres_connect);
		connectedList.add(chckbxDispo_connect);
		connectedList.add(btnMonCompte_connect);
		connectedList.add(btnSeDconnecter_connect);
		connectedList.add(chckbxFilm_connect);
		connectedList.add(chckbxLivre_connect);
		connectedList.add(chckbxMusique_connect);
		connectedList.add(separator_connect);

	}

	public void initProfile(JFrame frame, SpringLayout springLayout) throws SQLException, ParseException {
		lblEmprunts_prof = new JLabel("Mes emprunts");
		springLayout.putConstraint(SpringLayout.WEST, lblEmprunts_prof, 850, SpringLayout.WEST, frame.getContentPane());
		lblEmprunts_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblEmprunts_prof, 10, SpringLayout.NORTH,
				frame.getContentPane());
		frame.getContentPane().add(lblEmprunts_prof);

		scrollPane_prof = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_prof, 10, SpringLayout.SOUTH, lblEmprunts_prof);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_prof, 400, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_prof, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_prof, -10, SpringLayout.EAST, frame.getContentPane());

		listPanel_prof = new JPanel();
		listPanel_prof.setLayout(new GridLayout(100, 1));
		listPanel_prof.setMinimumSize(new Dimension(scrollPane_prof.getWidth(), 4000));
		listPanel_prof.setPreferredSize(new Dimension(scrollPane_prof.getWidth(), 4000));
		listPanel_prof.setMaximumSize(new Dimension(scrollPane_prof.getWidth(), 4000));
		scrollPane_prof.setViewportView(listPanel_prof);
		frame.getContentPane().add(scrollPane_prof);

		btnRetour_prof = new JButton("Retour");
		btnRetour_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnRetour_prof, 0, SpringLayout.NORTH, lblEmprunts_prof);
		springLayout.putConstraint(SpringLayout.WEST, btnRetour_prof, 10, SpringLayout.WEST, frame.getContentPane());
		btnRetour_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				state = connected;
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du retour à l'écran de connexion.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnRetour_prof);

		lblMesInformations_prof = new JLabel("Mes informations :");
		springLayout.putConstraint(SpringLayout.NORTH, lblMesInformations_prof, 25, SpringLayout.SOUTH, btnRetour_prof);
		lblMesInformations_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.WEST, lblMesInformations_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblMesInformations_prof);

		lblNom_prof = new JLabel("Nom :");
		lblNom_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblNom_prof, 6, SpringLayout.SOUTH, lblMesInformations_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblNom_prof, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNom_prof);

		txtNom_prof = new JLabel();
		txtNom_prof.setForeground(Color.DARK_GRAY);
		txtNom_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, txtNom_prof, 6, SpringLayout.SOUTH, lblNom_prof);
		springLayout.putConstraint(SpringLayout.WEST, txtNom_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(txtNom_prof);

		lblPrnom_prof = new JLabel("Pr\u00E9nom :");
		lblPrnom_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblPrnom_prof, 6, SpringLayout.SOUTH, txtNom_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblPrnom_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblPrnom_prof);

		txtPrnom_prof = new JLabel();
		txtPrnom_prof.setForeground(Color.DARK_GRAY);
		txtPrnom_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, txtPrnom_prof, 6, SpringLayout.SOUTH, lblPrnom_prof);
		springLayout.putConstraint(SpringLayout.WEST, txtPrnom_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(txtPrnom_prof);

		lblAdresse_prof = new JLabel("Adresse :");
		lblAdresse_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblAdresse_prof, 6, SpringLayout.SOUTH, txtPrnom_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblAdresse_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblAdresse_prof);

		tfAdr_prof = new JTextField();
		tfAdr_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, tfAdr_prof, 6, SpringLayout.SOUTH, lblAdresse_prof);
		springLayout.putConstraint(SpringLayout.WEST, tfAdr_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(tfAdr_prof);
		tfAdr_prof.setColumns(10);

		lblMotDePasse_prof = new JLabel("Mot de passe :");
		lblMotDePasse_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasse_prof, 6, SpringLayout.SOUTH, tfAdr_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblMotDePasse_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblMotDePasse_prof);

		tfMdp_prof = new JPasswordField();
		tfMdp_prof.setColumns(10);
		tfMdp_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, tfMdp_prof, 6, SpringLayout.SOUTH, lblMotDePasse_prof);
		springLayout.putConstraint(SpringLayout.WEST, tfMdp_prof, 0, SpringLayout.WEST, lblMotDePasse_prof);
		frame.getContentPane().add(tfMdp_prof);

		lblConfirmation = new JLabel("Confirmation : ");
		lblConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblConfirmation, 6, SpringLayout.SOUTH, tfMdp_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblConfirmation, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblConfirmation);

		tfMdpBis_prof = new JPasswordField();
		tfMdpBis_prof.setColumns(10);
		tfMdpBis_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, tfMdpBis_prof, 6, SpringLayout.SOUTH, lblConfirmation);
		springLayout.putConstraint(SpringLayout.WEST, tfMdpBis_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(tfMdpBis_prof);

		lblEmail_prof = new JLabel("E-mail : ");
		lblEmail_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblEmail_prof, 6, SpringLayout.SOUTH, tfMdpBis_prof);
		springLayout.putConstraint(SpringLayout.WEST, lblEmail_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(lblEmail_prof);

		tfMail_prof = new JTextField();
		tfMail_prof.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, tfMail_prof, 6, SpringLayout.SOUTH, lblEmail_prof);
		springLayout.putConstraint(SpringLayout.WEST, tfMail_prof, 0, SpringLayout.WEST, btnRetour_prof);
		frame.getContentPane().add(tfMail_prof);
		tfMail_prof.setColumns(10);

		btnDesactiver_prof = new JButton("Désactiver votre compte");
		btnDesactiver_prof.setBackground(Color.RED);
		btnDesactiver_prof.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDesactiver_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frameCheck = new JFrame();
				frameCheck.setBounds(700, 400, 450, 200);
				frameCheck.setTitle("Confirmation de désactivation");
				JPanel contentPane = new JPanel();
				SpringLayout sl_contentPane = new SpringLayout();
				contentPane.setLayout(sl_contentPane);
				frameCheck.setContentPane(contentPane);

				JLabel lbltesvousSrsureDe = new JLabel(
						"\u00CAtes-vous s\u00FBr/sure de vouloir désactiver votre compte ?", SwingConstants.CENTER);
				lbltesvousSrsureDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
				sl_contentPane.putConstraint(SpringLayout.NORTH, lbltesvousSrsureDe, 40, SpringLayout.NORTH,
						contentPane);
				sl_contentPane.putConstraint(SpringLayout.HORIZONTAL_CENTER, lbltesvousSrsureDe, 0,
						SpringLayout.HORIZONTAL_CENTER, contentPane);
				contentPane.add(lbltesvousSrsureDe);

				JButton btnNon = new JButton("Non");
				btnNon.setFont(new Font("Tahoma", Font.PLAIN, 25));
				sl_contentPane.putConstraint(SpringLayout.NORTH, btnNon, -83, SpringLayout.SOUTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.WEST, btnNon, 0, SpringLayout.WEST, lbltesvousSrsureDe);
				sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNon, -10, SpringLayout.SOUTH, contentPane);
				contentPane.add(btnNon);
				btnNon.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frameCheck.dispose();
					}
				});

				JButton btnOui = new JButton("Oui");
				sl_contentPane.putConstraint(SpringLayout.EAST, btnNon, -6, SpringLayout.WEST, btnOui);
				sl_contentPane.putConstraint(SpringLayout.SOUTH, btnOui, -10, SpringLayout.SOUTH, contentPane);
				sl_contentPane.putConstraint(SpringLayout.EAST, btnOui, 0, SpringLayout.EAST, lbltesvousSrsureDe);
				contentPane.add(btnOui);
				btnOui.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							int r = currentUser.desactiver();
							if (r == -1) {
								JOptionPane.showMessageDialog(frame, "Vous avez des emprunts en cours.");
								frameCheck.dispose();
								return;
							}
							state = loginScreen;
							frameCheck.dispose();
							display();
						} catch (SQLException | ParseException e1) {
							JOptionPane.showMessageDialog(frame, "Erreur critique lors de la désactivation du compte.");
							frame.dispose();
							e1.printStackTrace();
						}
					}
				});

				frameCheck.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnDesactiver_prof, 0, SpringLayout.WEST, btnRetour_prof);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDesactiver_prof, 0, SpringLayout.SOUTH, scrollPane_prof);
		frame.getContentPane().add(btnDesactiver_prof);

		btnProlonger_prof = new JButton("Prolonger");
		btnProlonger_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.SOUTH, btnProlonger_prof, 0, SpringLayout.SOUTH, scrollPane_prof);
		springLayout.putConstraint(SpringLayout.EAST, btnProlonger_prof, -6, SpringLayout.WEST, scrollPane_prof);
		frame.getContentPane().add(btnProlonger_prof);
		btnProlonger_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ev) {
				try {
					prolonger();
					JOptionPane.showMessageDialog(frame, "Emprunt prolongé avec succès.");
				} catch (SQLException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la prolongation.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});

		btnRendre_prof = new JButton("Rendre");
		springLayout.putConstraint(SpringLayout.WEST, btnRendre_prof, 0, SpringLayout.WEST, btnProlonger_prof);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRendre_prof, -6, SpringLayout.NORTH, btnProlonger_prof);
		springLayout.putConstraint(SpringLayout.EAST, btnRendre_prof, -6, SpringLayout.WEST, scrollPane_prof);
		btnRendre_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(btnRendre_prof);
		btnRendre_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ev) {
				try {
					rendre();
					JOptionPane.showMessageDialog(frame, "Produit rendu avec succès.");
				} catch (SQLException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du retour du produit.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});

		btnChkAdr_prof = new JButton("\u2713");
		springLayout.putConstraint(SpringLayout.NORTH, btnChkAdr_prof, 0, SpringLayout.NORTH, tfAdr_prof);
		springLayout.putConstraint(SpringLayout.WEST, btnChkAdr_prof, 6, SpringLayout.EAST, tfAdr_prof);
		springLayout.putConstraint(SpringLayout.SOUTH, btnChkAdr_prof, 0, SpringLayout.SOUTH, tfAdr_prof);
		springLayout.putConstraint(SpringLayout.EAST, btnChkAdr_prof, 77, SpringLayout.EAST, tfAdr_prof);
		frame.getContentPane().add(btnChkAdr_prof);
		btnChkAdr_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					currentUser.setAdresse(tfAdr_prof.getText());
					JOptionPane.showMessageDialog(frame, "Adresse modifiée avec succès.");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la modification de l'adresse.");
					e1.printStackTrace();
				}
			}
		});

		btnChkMail_prof = new JButton("\u2713");
		springLayout.putConstraint(SpringLayout.NORTH, btnChkMail_prof, 0, SpringLayout.NORTH, tfMail_prof);
		springLayout.putConstraint(SpringLayout.WEST, btnChkMail_prof, 6, SpringLayout.EAST, tfMail_prof);
		springLayout.putConstraint(SpringLayout.SOUTH, btnChkMail_prof, 0, SpringLayout.SOUTH, tfMail_prof);
		springLayout.putConstraint(SpringLayout.EAST, btnChkMail_prof, 77, SpringLayout.EAST, tfMail_prof);
		frame.getContentPane().add(btnChkMail_prof);
		btnChkMail_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Pattern r = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
				Matcher m = r.matcher(tfMail_prof.getText());
				if (!m.find()) {
					JOptionPane.showMessageDialog(frame, "Adresse mail au format incorrect.");
					try {
						tfMail_prof.setText(currentUser.getMail());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame,
								"Erreur critique lors de la modification de l'adresse mail.");
						e1.printStackTrace();
					}
				} else {
					try {
						currentUser.setMail(tfMail_prof.getText());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame,
								"Erreur critique lors de la modification de l'adresse mail.");
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(frame, "Adresse mail modifiée avec succès.");
				}
			}
		});

		btnChkMdp_prof = new JButton("\u2713");
		springLayout.putConstraint(SpringLayout.NORTH, btnChkMdp_prof, 0, SpringLayout.NORTH, tfMdpBis_prof);
		springLayout.putConstraint(SpringLayout.WEST, btnChkMdp_prof, 6, SpringLayout.EAST, tfMdpBis_prof);
		springLayout.putConstraint(SpringLayout.SOUTH, btnChkMdp_prof, 0, SpringLayout.SOUTH, tfMdpBis_prof);
		springLayout.putConstraint(SpringLayout.EAST, btnChkMdp_prof, 77, SpringLayout.EAST, tfMdpBis_prof);
		frame.getContentPane().add(btnChkMdp_prof);
		btnChkMdp_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!tfMdp_prof.getText().equals(tfMdpBis_prof.getText())) {
					JOptionPane.showMessageDialog(frame, "Les mots de passe sont différents.");
					tfMdp_prof.setText("");
					tfMdpBis_prof.setText("");
				} else {
					try {
						currentUser.setPassword(tfMdp_prof.getText());
						JOptionPane.showMessageDialog(frame, "Mot de passe modifié avec succès.");
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame,
								"Erreur critique lors de la modification du mot de passe.");
						e1.printStackTrace();
					}
				}
			}
		});

		btnSeDconnecter_prof = new JButton("Se d\u00E9connecter");
		btnSeDconnecter_prof.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnSeDconnecter_prof, 0, SpringLayout.NORTH, lblEmprunts_prof);
		springLayout.putConstraint(SpringLayout.WEST, btnSeDconnecter_prof, 6, SpringLayout.EAST, btnRetour_prof);
		btnSeDconnecter_prof.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				state = loginScreen;
				try {
					display();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la désactivation du compte.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnSeDconnecter_prof);

		profileList.add(lblEmprunts_prof);
		profileList.add(scrollPane_prof);
		profileList.add(listPanel_prof);
		profileList.add(txtNom_prof);
		profileList.add(txtPrnom_prof);
		profileList.add(tfAdr_prof);
		profileList.add(tfMdp_prof);
		profileList.add(tfMdpBis_prof);
		profileList.add(lblEmail_prof);
		profileList.add(tfMail_prof);
		profileList.add(btnDesactiver_prof);
		profileList.add(btnRetour_prof);
		profileList.add(lblMesInformations_prof);
		profileList.add(lblAdresse_prof);
		profileList.add(lblMotDePasse_prof);
		profileList.add(lblConfirmation);
		profileList.add(btnProlonger_prof);
		profileList.add(btnRendre_prof);
		profileList.add(btnChkAdr_prof);
		profileList.add(btnChkMail_prof);
		profileList.add(btnChkMdp_prof);
		profileList.add(btnSeDconnecter_prof);
		profileList.add(lblNom_prof);
		profileList.add(lblPrnom_prof);

	}

	public void display() throws NumberFormatException, SQLException, ParseException {
		Connect.update();
		/**** LOGIN ****/
		boolean log = (state == loginScreen);
		for (Object item : loginList) {
			((JComponent) item).setVisible(log);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** SIGN IN ***/
		boolean sign = (state == signIn);
		for (Object item : signinList) {
			((JComponent) item).setVisible(sign);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** CONNECTED ****/
		boolean conn = (state == connected);
		for (Object item : connectedList) {
			((JComponent) item).setVisible(conn);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** PROFILE ****/
		boolean prof = (state == profile);
		for (Object item : profileList) {
			((JComponent) item).setVisible(prof);
		}
	}

	public void createUser() throws NumberFormatException, ParseException {
		Pattern r = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = r.matcher(tfUsername_signin.getText());
		if (!m.find()) {
			JOptionPane.showMessageDialog(frame, "Adresse mail au format incorrect.");
			tfPassword_signin.setText("");
			tfPasswordBis_signin.setText("");
		} else {
			if (!tfPassword_signin.getText().equals(tfPasswordBis_signin.getText())) {
				JOptionPane.showMessageDialog(frame, "Les mots de passe sont différents.");
				tfPassword_signin.setText("");
				tfPasswordBis_signin.setText("");
			}
			String query = "SELECT eMail FROM adherent WHERE eMail = '" + tfUsername_signin.getText() + "';";
			try {
				Connect.result = Connect.state.executeQuery(query);
				if (Connect.result.next()) {
					JOptionPane.showMessageDialog(frame, "Adresse déjà utilisée.");
					tfUsername_signin.setText("");
					tfPassword_signin.setText("");
					tfPasswordBis_signin.setText("");
				} else {
					query = "INSERT INTO adherent (eMail, Nom, Prenom, Adresse, DateNaissance, MotDePasse, Actif, nbRetard) VALUES ('"
							+ tfUsername_signin.getText() + "', '" + tfLastName_signin.getText() + "', '"
							+ tfFirstName_signin.getText() + "', '" + tfAddress_signin.getText() + "', '"
							+ tfDateYear_signin.getSelectedItem().toString() + "-"
							+ tfDateMonth_signin.getSelectedItem().toString() + "-"
							+ tfDateDay_signin.getSelectedItem().toString() + "', '" + tfPassword_signin.getText()
							+ "', '1', '0');";
					Connect.state.executeUpdate(query);
					JOptionPane.showMessageDialog(frame, "Inscription réussie.");
					Adherent.init();
					state = loginScreen;
					display();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
				frame.dispose();
				e.printStackTrace();
			}
		}
	}

	public void connect() throws NumberFormatException, ParseException, SQLException {
		String query = "SELECT idAdherent FROM adherent WHERE eMail = '" + tfUsername_login.getText()
				+ "' AND MotDePasse = '" + tfPassword_login.getText() + "';";
		try {
			Connect.result = Connect.state.executeQuery(query);
			if (!Connect.result.next()) {
				JOptionPane.showMessageDialog(frame, "Erreur d'identification.");
				tfUsername_login.setText("");
			} else {
				JOptionPane.showMessageDialog(frame, "Identification réussie.");
				state = connected;
				currentUser = Adherent.getAdherent(Integer.valueOf(Connect.result.getObject(1).toString()));
				if (!currentUser.actif) {
					String update = "UPDATE adherent SET actif = 1 WHERE idAdherent = " + currentUser.idAdherent + ";";
					Connect.state.executeUpdate(update);
					currentUser.actif = true;
					JOptionPane.showMessageDialog(frame, "Votre compte a été réactivé !");
				}
				lblBienvenue_connect.setText("Bienvenue " + currentUser.getPrenom() + " !");
				List<Emprunt> emprunts = currentUser.emprunts();
				int flag = 0;
				for (Emprunt e : emprunts) {
					if (e.retard())
						flag = 2;
					else if (e.limite() && flag != 2)
						flag = 1;
				}
				switch (flag) {
				case 2:
					JOptionPane.showMessageDialog(frame, "Attention ! Vous avez au moins 1 produit à rendre !");
				case 1:
					JOptionPane.showMessageDialog(frame,
							"Attention ! Vous avez au moins 1 produit à rendre aujourd'hui !");
				default:
				}
				display();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connection de l'utilisateur.");
			frame.dispose();
			e.printStackTrace();
		}
	}

	public void search(int param) throws SQLException {
		listPanel_connect.removeAll();
		List<Integer> recherche;
		switch (param) {
		case NOM:
			recherche = Adherent.rechercher(tfRecherche_connect.getText());
			break;
		case AUTEUR:
			recherche = Adherent.rechercherAuteur(tfRecherche_connect.getText());
			break;
		case GENRE:
			recherche = Adherent.rechercherGenre(tfRecherche_connect.getText());
			break;
		default:
			recherche = Adherent.rechercher(tfRecherche_connect.getText());
		}
		List<Produit> prod = new ArrayList<>();
		List<JButton> boutons = new ArrayList<>();
		for (Integer res : recherche) {
			Produit p = Produit.getProduit(res);
			boolean add = true;
			if (chckbxFilm_connect.isSelected() && !p.isFilm())
				add = false;
			if (chckbxLivre_connect.isSelected() && !p.isLivre())
				add = false;
			if (chckbxMusique_connect.isSelected() && !p.isMusique())
				add = false;
			if (chckbxFilm_connect.isSelected() && p.isFilm())
				add = true;
			if (chckbxLivre_connect.isSelected() && p.isLivre())
				add = true;
			if (chckbxMusique_connect.isSelected() && p.isMusique())
				add = true;
			if (chckbxDispo_connect.isSelected() && p.getExemplaireDispo() == -1)
				add = false;
			if (add)
				prod.add(p);
			boutons.add(new JButton());
		}
		for (JButton bouton : boutons) {
			bouton.setFont(new Font("Tahoma", Font.PLAIN, 25));
			bouton.setVisible(false);
			bouton.setBackground(Color.lightGray);
		}
		int i = 0;
		for (Produit produit : prod) {
			JButton b = boutons.get(i);
			b.setText(produit.idProduit + "    " + produit.Titre);
			b.setVisible(true);
			b.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectedProduct = produit;
					for (JButton bouton : boutons) {
						bouton.setBackground(Color.lightGray);
					}
					b.setBackground(Color.green);
				}
			});
			b.setToolTipText(produit.Description);
			b.setMinimumSize(new Dimension(scrollPane_connect.getWidth(), 40));
			b.setPreferredSize(new Dimension(scrollPane_connect.getWidth(), 40));
			b.setMaximumSize(new Dimension(scrollPane_connect.getWidth(), 40));
			listPanel_connect.add(b);
			i++;
		}
		if (recherche.isEmpty())
			listPanel_connect.add(new JLabel("Pas de résultat trouvé."));
		listPanel_connect.revalidate();
		listPanel_connect.repaint();
	}

	public void emprunts() throws SQLException, ParseException {
		listPanel_prof.removeAll();
		List<JButton> boutons = new ArrayList<>();
		List<Emprunt> emprunts = currentUser.emprunts();
		for (Emprunt e : emprunts) {
			JButton b = new JButton(e.toString());
			b.setBorder(new LineBorder(Color.GRAY, 2));
			boutons.add(b);
			b.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent ev) {
					for (JButton b : boutons) {
						b.setBorder(new LineBorder(Color.GRAY, 2));
					}
					selectedEmprunt = e;
					b.setBorder(new LineBorder(Color.WHITE, 3));
				}
			});
			b.setFont(new Font("Tahoma", Font.PLAIN, 15));
			b.setVisible(true);
			if (e.retard())
				b.setBackground(Color.RED);
			else if (e.limite())
				b.setBackground(Color.ORANGE);
			else if (e.retoune())
				b.setBackground(Color.GRAY);
			else if (e.enCours())
				b.setBackground(Color.GREEN);
			b.setMinimumSize(new Dimension(scrollPane_prof.getWidth(), 40));
			b.setPreferredSize(new Dimension(scrollPane_prof.getWidth(), 40));
			b.setMaximumSize(new Dimension(scrollPane_prof.getWidth(), 40));
			listPanel_prof.add(b);
		}

		listPanel_prof.revalidate();
		listPanel_prof.repaint();
	}

	public void rendre() throws SQLException, ParseException {
		currentUser.rendre(selectedEmprunt);
		emprunts();
	}

	public void prolonger() throws SQLException, ParseException {
		int r = currentUser.prolonger(selectedEmprunt);
		if (r == -1)
			JOptionPane.showMessageDialog(frame, "Vous avez trop de retards pour pouvoir prolonger.");
		emprunts();
	}

	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 */
	public GUI() throws NumberFormatException, SQLException, ParseException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 * @throws SQLException
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws NumberFormatException, SQLException, ParseException, ClassNotFoundException {
		Connect.init();
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 900);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		initLogin(frame, springLayout);
		initSingIn(frame, springLayout);
		initConnected(frame, springLayout);
		initProfile(frame, springLayout);

		display();

	}
}
