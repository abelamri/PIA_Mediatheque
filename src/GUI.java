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

	public static final int connecte = 1;
	public static final int accueil = 2;
	public static final int inscription = 3;
	public static final int profil = 4;

	public int etat = accueil;
	private JFrame frame;
	private SpringLayout springLayout;
	private Produit produitCourant;
	private Adherent utilisateurCourant;
	private Emprunt empruntCourant;

	/*** Elements login ***/
	private ArrayList<Object> listAccueil = new ArrayList<>();
	private JTextField tfMail_accueil;
	private JTextField tfMotDePasse_accueil;
	private JLabel lblTitre_accueil;
	private JLabel lblConnexion_accueil;
	private JLabel lblCreerCompte_accueil;
	private JLabel lblNomDutilisateur_accueil;
	private JLabel lblMotDePasse_accueil;
	private JButton btnConnect_accueil;

	/*** Elements signin ***/
	private ArrayList<Object> signinList = new ArrayList<>();
	private JTextField tfMail_inscription;
	private JTextField tfMotDePasse_inscription;
	private JTextField tfMotDePasseBis_inscription;
	private JTextField tfAdresse_inscription;
	private JTextField tfPrenom_inscription;
	private JTextField tfNom_inscription;
	private JComboBox<Integer> tfDateJour_inscription;
	private JComboBox<Integer> tfDateMois_inscription;
	private JComboBox<Integer> tfDateAnnee_inscription;
	private JLabel lblTitre_inscription;
	private JLabel lblMail_inscription;
	private JLabel lblMotDePasse_inscription;
	private JLabel lblMotDePasseBis_inscription;
	private JLabel lblRetour_inscription;
	private JLabel lblAdresse_inscription;
	private JLabel lblPrenom_inscription;
	private JLabel lblNom_inscription;
	private JLabel lblDate_inscription;
	private JButton btnCreer_inscription;

	/*** Elements connecte ***/
	private ArrayList<Object> listConnect = new ArrayList<>();
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

	/*** Elements profil ***/
	private ArrayList<Object> listProfil = new ArrayList<>();
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
					JOptionPane.showMessageDialog(new JFrame(), "La base de données n'a pas été iniialisée.");
					e.printStackTrace();
				}
			}
		});
	}

	public void initAccueil(JFrame frame, SpringLayout springLayout) {
		lblTitre_accueil = new JLabel("MEDIATHEQUA");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitre_accueil, (int) (frame.getHeight() * 0.1),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitre_accueil, 0, SpringLayout.HORIZONTAL_CENTER,
				frame.getContentPane());
		lblTitre_accueil.setFont(new Font("Tahoma", Font.PLAIN, 60));
		frame.getContentPane().add(lblTitre_accueil);

		lblConnexion_accueil = new JLabel("Connexion");
		springLayout.putConstraint(SpringLayout.NORTH, lblConnexion_accueil, (int) (frame.getHeight() * 0.22),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblConnexion_accueil, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		lblConnexion_accueil.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblConnexion_accueil);

		lblNomDutilisateur_accueil = new JLabel("Nom d'utilisateur : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomDutilisateur_accueil, (int) (frame.getHeight() * 0.3),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNomDutilisateur_accueil, (int) (frame.getWidth() * 0.45),
				SpringLayout.WEST, frame.getContentPane());
		lblNomDutilisateur_accueil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblNomDutilisateur_accueil);
		lblNomDutilisateur_accueil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connecter();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});

		lblMotDePasse_accueil = new JLabel("Mot de passe : ");
		lblMotDePasse_accueil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasse_accueil, 6, SpringLayout.SOUTH,
				lblNomDutilisateur_accueil);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasse_accueil, 0, SpringLayout.EAST,
				lblNomDutilisateur_accueil);
		frame.getContentPane().add(lblMotDePasse_accueil);

		tfMail_accueil = new JTextField();
		tfMail_accueil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfMail_accueil, 0, SpringLayout.NORTH,
				lblNomDutilisateur_accueil);
		springLayout.putConstraint(SpringLayout.WEST, tfMail_accueil, 5, SpringLayout.EAST, lblNomDutilisateur_accueil);
		springLayout.putConstraint(SpringLayout.SOUTH, tfMail_accueil, 0, SpringLayout.SOUTH,
				lblNomDutilisateur_accueil);
		springLayout.putConstraint(SpringLayout.EAST, tfMail_accueil, 340, SpringLayout.EAST,
				lblNomDutilisateur_accueil);
		frame.getContentPane().add(tfMail_accueil);
		tfMail_accueil.setColumns(10);

		tfMotDePasse_accueil = new JPasswordField();
		tfMotDePasse_accueil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connecter();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});
		tfMotDePasse_accueil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfMotDePasse_accueil, 0, SpringLayout.NORTH,
				lblMotDePasse_accueil);
		springLayout.putConstraint(SpringLayout.WEST, tfMotDePasse_accueil, 5, SpringLayout.EAST,
				lblMotDePasse_accueil);
		springLayout.putConstraint(SpringLayout.SOUTH, tfMotDePasse_accueil, 0, SpringLayout.SOUTH,
				lblMotDePasse_accueil);
		springLayout.putConstraint(SpringLayout.EAST, tfMotDePasse_accueil, 340, SpringLayout.EAST,
				lblMotDePasse_accueil);
		tfMotDePasse_accueil.setColumns(10);
		frame.getContentPane().add(tfMotDePasse_accueil);

		btnConnect_accueil = new JButton("Se connecter");
		btnConnect_accueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					connecter();
				} catch (NumberFormatException | ParseException | SQLException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		btnConnect_accueil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						connecter();
					} catch (NumberFormatException | ParseException | SQLException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connexion.");
						frame.dispose();
						e.printStackTrace();
					}
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnConnect_accueil, 340, SpringLayout.WEST,
				lblNomDutilisateur_accueil);
		btnConnect_accueil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnConnect_accueil, 6, SpringLayout.SOUTH, tfMotDePasse_accueil);
		springLayout.putConstraint(SpringLayout.SOUTH, btnConnect_accueil, 37, SpringLayout.SOUTH,
				tfMotDePasse_accueil);
		springLayout.putConstraint(SpringLayout.EAST, btnConnect_accueil, 0, SpringLayout.EAST, tfMail_accueil);
		frame.getContentPane().add(btnConnect_accueil);

		lblCreerCompte_accueil = new JLabel("Vous n'avez de compte ? Cr\u00E9ez-en un ici !");
		lblCreerCompte_accueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				etat = inscription;
				try {
					affichage();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du changement d'écran.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		lblCreerCompte_accueil.setForeground(Color.BLUE);
		lblCreerCompte_accueil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblCreerCompte_accueil, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblCreerCompte_accueil, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		frame.getContentPane().add(lblCreerCompte_accueil);

		listAccueil.add(tfMail_accueil);
		listAccueil.add(tfMotDePasse_accueil);
		listAccueil.add(lblTitre_accueil);
		listAccueil.add(lblConnexion_accueil);
		listAccueil.add(lblCreerCompte_accueil);
		listAccueil.add(lblNomDutilisateur_accueil);
		listAccueil.add(lblMotDePasse_accueil);
		listAccueil.add(btnConnect_accueil);

	}

	public void initInscription(JFrame frame, SpringLayout springLayout) {
		lblTitre_inscription = new JLabel("CREATION DE COMPTE");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitre_inscription, (int) (frame.getHeight() * 0.22),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitre_inscription, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		lblTitre_inscription.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frame.getContentPane().add(lblTitre_inscription);

		lblMail_inscription = new JLabel("Adresse mail : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMail_inscription, (int) (frame.getHeight() * 0.3),
				SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblMail_inscription, (int) (frame.getWidth() * 0.45),
				SpringLayout.WEST, frame.getContentPane());
		lblMail_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblMail_inscription);

		lblPrenom_inscription = new JLabel("Prénom : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrenom_inscription, 6, SpringLayout.SOUTH,
				lblMail_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblPrenom_inscription, 0, SpringLayout.EAST, lblMail_inscription);
		lblPrenom_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblPrenom_inscription);

		lblNom_inscription = new JLabel("Nom : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNom_inscription, 6, SpringLayout.SOUTH,
				lblPrenom_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblNom_inscription, 0, SpringLayout.EAST, lblPrenom_inscription);
		lblNom_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblNom_inscription);

		lblAdresse_inscription = new JLabel("Adresse : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdresse_inscription, 6, SpringLayout.SOUTH,
				lblNom_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblAdresse_inscription, 0, SpringLayout.EAST, lblNom_inscription);
		lblAdresse_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblAdresse_inscription);

		lblDate_inscription = new JLabel("Date de naissance : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblDate_inscription, 6, SpringLayout.SOUTH,
				lblAdresse_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblDate_inscription, 0, SpringLayout.EAST,
				lblAdresse_inscription);
		lblDate_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblDate_inscription);

		lblMotDePasse_inscription = new JLabel("Mot de passe : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasse_inscription, 6, SpringLayout.SOUTH,
				lblDate_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasse_inscription, 0, SpringLayout.EAST,
				lblDate_inscription);
		lblMotDePasse_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblMotDePasse_inscription);

		lblMotDePasseBis_inscription = new JLabel("Répétez votre mot de passe : ");
		lblMotDePasseBis_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, lblMotDePasseBis_inscription, 6, SpringLayout.SOUTH,
				lblMotDePasse_inscription);
		springLayout.putConstraint(SpringLayout.EAST, lblMotDePasseBis_inscription, 0, SpringLayout.EAST,
				lblMotDePasse_inscription);
		frame.getContentPane().add(lblMotDePasseBis_inscription);

		tfMail_inscription = new JTextField();
		tfMail_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfMail_inscription, 0, SpringLayout.NORTH, lblMail_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfMail_inscription, 5, SpringLayout.EAST, lblMail_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfMail_inscription, 0, SpringLayout.SOUTH, lblMail_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfMail_inscription, 340, SpringLayout.EAST, lblMail_inscription);
		frame.getContentPane().add(tfMail_inscription);
		tfMail_inscription.setColumns(10);

		tfPrenom_inscription = new JTextField();
		tfPrenom_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfPrenom_inscription, 0, SpringLayout.NORTH,
				lblPrenom_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfPrenom_inscription, 5, SpringLayout.EAST,
				lblPrenom_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfPrenom_inscription, 0, SpringLayout.SOUTH,
				lblPrenom_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfPrenom_inscription, 340, SpringLayout.EAST,
				lblPrenom_inscription);
		tfPrenom_inscription.setColumns(10);
		frame.getContentPane().add(tfPrenom_inscription);

		tfNom_inscription = new JTextField();
		tfNom_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfNom_inscription, 0, SpringLayout.NORTH, lblNom_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfNom_inscription, 5, SpringLayout.EAST, lblNom_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfNom_inscription, 0, SpringLayout.SOUTH, lblNom_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfNom_inscription, 340, SpringLayout.EAST, lblNom_inscription);
		tfNom_inscription.setColumns(10);
		frame.getContentPane().add(tfNom_inscription);

		tfAdresse_inscription = new JTextField();
		tfAdresse_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfAdresse_inscription, 0, SpringLayout.NORTH,
				lblAdresse_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfAdresse_inscription, 5, SpringLayout.EAST,
				lblAdresse_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfAdresse_inscription, 0, SpringLayout.SOUTH,
				lblAdresse_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfAdresse_inscription, 340, SpringLayout.EAST,
				lblAdresse_inscription);
		tfAdresse_inscription.setColumns(10);
		frame.getContentPane().add(tfAdresse_inscription);

		tfDateJour_inscription = new JComboBox<Integer>();
		tfDateJour_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateJour_inscription, 0, SpringLayout.NORTH,
				lblDate_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfDateJour_inscription, 6, SpringLayout.EAST,
				lblDate_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateJour_inscription, 0, SpringLayout.SOUTH,
				lblDate_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfDateJour_inscription, 85, SpringLayout.EAST,
				lblDate_inscription);
		frame.getContentPane().add(tfDateJour_inscription);
		for (int i = 1; i <= 31; i++)
			tfDateJour_inscription.addItem(i);

		tfDateMois_inscription = new JComboBox<Integer>();
		tfDateMois_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateMois_inscription, 0, SpringLayout.NORTH,
				tfDateJour_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfDateMois_inscription, 6, SpringLayout.EAST,
				tfDateJour_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateMois_inscription, 0, SpringLayout.SOUTH,
				tfDateJour_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfDateMois_inscription, 85, SpringLayout.EAST,
				tfDateJour_inscription);
		frame.getContentPane().add(tfDateMois_inscription);
		for (int i = 1; i <= 12; i++)
			tfDateMois_inscription.addItem(i);

		tfDateAnnee_inscription = new JComboBox<Integer>();
		tfDateAnnee_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfDateAnnee_inscription, 0, SpringLayout.NORTH,
				tfDateMois_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfDateAnnee_inscription, 6, SpringLayout.EAST,
				tfDateMois_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfDateAnnee_inscription, 0, SpringLayout.SOUTH,
				tfDateMois_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfDateAnnee_inscription, 170, SpringLayout.EAST,
				tfDateMois_inscription);
		frame.getContentPane().add(tfDateAnnee_inscription);
		for (int i = 1920; i <= 2017; i++)
			tfDateAnnee_inscription.addItem(i);

		tfMotDePasse_inscription = new JPasswordField();
		tfMotDePasse_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfMotDePasse_inscription, 0, SpringLayout.NORTH,
				lblMotDePasse_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfMotDePasse_inscription, 5, SpringLayout.EAST,
				lblMotDePasse_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfMotDePasse_inscription, 0, SpringLayout.SOUTH,
				lblMotDePasse_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfMotDePasse_inscription, 340, SpringLayout.EAST,
				lblMotDePasse_inscription);
		tfMotDePasse_inscription.setColumns(10);
		frame.getContentPane().add(tfMotDePasse_inscription);

		tfMotDePasseBis_inscription = new JPasswordField();
		tfMotDePasseBis_inscription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						creerUtilisateur();
					} catch (NumberFormatException | ParseException e) {
						JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
						frame.dispose();
					}
				}
			}
		});
		tfMotDePasseBis_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, tfMotDePasseBis_inscription, 0, SpringLayout.NORTH,
				lblMotDePasseBis_inscription);
		springLayout.putConstraint(SpringLayout.WEST, tfMotDePasseBis_inscription, 5, SpringLayout.EAST,
				lblMotDePasseBis_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, tfMotDePasseBis_inscription, 0, SpringLayout.SOUTH,
				lblMotDePasseBis_inscription);
		springLayout.putConstraint(SpringLayout.EAST, tfMotDePasseBis_inscription, 340, SpringLayout.EAST,
				lblMotDePasseBis_inscription);
		tfMotDePasseBis_inscription.setColumns(10);
		frame.getContentPane().add(tfMotDePasseBis_inscription);

		btnCreer_inscription = new JButton("Créer");
		btnCreer_inscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					creerUtilisateur();
				} catch (NumberFormatException | ParseException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
					frame.dispose();
					e.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCreer_inscription, 340, SpringLayout.WEST,
				lblMail_inscription);
		btnCreer_inscription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		springLayout.putConstraint(SpringLayout.NORTH, btnCreer_inscription, 6, SpringLayout.SOUTH,
				tfMotDePasseBis_inscription);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreer_inscription, 37, SpringLayout.SOUTH,
				tfMotDePasseBis_inscription);
		springLayout.putConstraint(SpringLayout.EAST, btnCreer_inscription, 0, SpringLayout.EAST, tfMail_inscription);
		frame.getContentPane().add(btnCreer_inscription);

		lblRetour_inscription = new JLabel("Retour");
		lblRetour_inscription.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				etat = accueil;
				try {
					affichage();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors du retour à l'écran de connexion.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		lblRetour_inscription.setForeground(Color.BLUE);
		lblRetour_inscription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblRetour_inscription, 0,
				SpringLayout.HORIZONTAL_CENTER, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblRetour_inscription, -10, SpringLayout.SOUTH,
				frame.getContentPane());
		frame.getContentPane().add(lblRetour_inscription);

		signinList.add(tfMail_inscription);
		signinList.add(tfMotDePasse_inscription);
		signinList.add(tfMotDePasseBis_inscription);
		signinList.add(tfAdresse_inscription);
		signinList.add(tfPrenom_inscription);
		signinList.add(tfNom_inscription);
		signinList.add(tfDateJour_inscription);
		signinList.add(tfDateMois_inscription);
		signinList.add(tfDateAnnee_inscription);
		signinList.add(lblTitre_inscription);
		signinList.add(lblMail_inscription);
		signinList.add(lblMotDePasse_inscription);
		signinList.add(lblMotDePasseBis_inscription);
		signinList.add(lblRetour_inscription);
		signinList.add(lblAdresse_inscription);
		signinList.add(lblPrenom_inscription);
		signinList.add(lblNom_inscription);
		signinList.add(lblDate_inscription);
		signinList.add(btnCreer_inscription);

	}

	public void initConnecte(JFrame frame, SpringLayout springLayout) throws SQLException {
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
							rechercher(AUTEUR);
						else if (rdbtnGenre_connect.isSelected())
							rechercher(GENRE);
						else if (rdbtnNom_connect.isSelected())
							rechercher(NOM);
						else
							rechercher(NOM);
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
						rechercher(AUTEUR);
					else if (rdbtnGenre_connect.isSelected())
						rechercher(GENRE);
					else if (rdbtnNom_connect.isSelected())
						rechercher(NOM);
					else
						rechercher(NOM);
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
						connecter();
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
				if (produitCourant == null) {
					JOptionPane.showMessageDialog(frame, "Aucun produit sélectionné.");
					return;
				}
				try {
					int r = utilisateurCourant.reserver(produitCourant.idProduit);
					if (r == -1)
						JOptionPane.showMessageDialog(frame,
								"Le produit est déjà disponible, vous pouvez l'emprunter.");
					else if (r == 1)
						JOptionPane.showMessageDialog(frame, "Le produit est déjà réservé.");
					else
						JOptionPane.showMessageDialog(frame, "Réservation réussie.");
					produitCourant = null;
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
				if (produitCourant == null) {
					JOptionPane.showMessageDialog(frame, "Aucun produit sélectionné.");
					return;
				}
				try {
					int r = utilisateurCourant.emprunter(produitCourant.idProduit);
					if (r == -1) {
						JOptionPane.showMessageDialog(frame,
								"Le produit n'est pas disponible, vous pouvez le réserver en cliquant sur le bouton Réserver.");
					} else {
						JOptionPane.showMessageDialog(frame, "Emprunt réussi.");
						if (rdbtnAuteur_connect.isSelected())
							rechercher(AUTEUR);
						else if (rdbtnGenre_connect.isSelected())
							rechercher(GENRE);
						else if (rdbtnNom_connect.isSelected())
							rechercher(NOM);
						else
							rechercher(NOM);
						produitCourant = null;
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
				etat = profil;
				try {
					emprunts();
					txtNom_prof.setText(utilisateurCourant.getNom());
					txtPrnom_prof.setText(utilisateurCourant.getPrenom());
					tfAdr_prof.setText(utilisateurCourant.getAdresse());
					tfMail_prof.setText(utilisateurCourant.getMail());
				} catch (ParseException | SQLException e) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'affichage du profil.");
					e.printStackTrace();
				}
				try {
					affichage();
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
				etat = accueil;
				try {
					affichage();
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

		listConnect.add(tfRecherche_connect);
		listConnect.add(lblBienvenue_connect);
		listConnect.add(btnRechercher_connect);
		listConnect.add(listPanel_connect);
		listConnect.add(scrollPane_connect);
		listConnect.add(btnReserver_connect);
		listConnect.add(btnEmprunter_connect);
		listConnect.add(rdbtnNom_connect);
		listConnect.add(rdbtnGenre_connect);
		listConnect.add(rdbtnAuteur_connect);
		listConnect.add(lblRechercheParCritres_connect);
		listConnect.add(chckbxDispo_connect);
		listConnect.add(btnMonCompte_connect);
		listConnect.add(btnSeDconnecter_connect);
		listConnect.add(chckbxFilm_connect);
		listConnect.add(chckbxLivre_connect);
		listConnect.add(chckbxMusique_connect);
		listConnect.add(separator_connect);

	}

	public void initProfil(JFrame frame, SpringLayout springLayout) throws SQLException, ParseException {
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
				etat = connecte;
				try {
					affichage();
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
							int r = utilisateurCourant.desactiver();
							if (r == -1) {
								JOptionPane.showMessageDialog(frame, "Vous avez des emprunts en cours.");
								frameCheck.dispose();
								return;
							}
							etat = accueil;
							frameCheck.dispose();
							affichage();
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
					utilisateurCourant.setAdresse(tfAdr_prof.getText());
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
						tfMail_prof.setText(utilisateurCourant.getMail());
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frame,
								"Erreur critique lors de la modification de l'adresse mail.");
						e1.printStackTrace();
					}
				} else {
					try {
						utilisateurCourant.setMail(tfMail_prof.getText());
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
						utilisateurCourant.setMotDePasse(tfMdp_prof.getText());
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
				etat = accueil;
				try {
					affichage();
				} catch (NumberFormatException | SQLException | ParseException e1) {
					JOptionPane.showMessageDialog(frame, "Erreur critique lors de la désactivation du compte.");
					frame.dispose();
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnSeDconnecter_prof);

		listProfil.add(lblEmprunts_prof);
		listProfil.add(scrollPane_prof);
		listProfil.add(listPanel_prof);
		listProfil.add(txtNom_prof);
		listProfil.add(txtPrnom_prof);
		listProfil.add(tfAdr_prof);
		listProfil.add(tfMdp_prof);
		listProfil.add(tfMdpBis_prof);
		listProfil.add(lblEmail_prof);
		listProfil.add(tfMail_prof);
		listProfil.add(btnDesactiver_prof);
		listProfil.add(btnRetour_prof);
		listProfil.add(lblMesInformations_prof);
		listProfil.add(lblAdresse_prof);
		listProfil.add(lblMotDePasse_prof);
		listProfil.add(lblConfirmation);
		listProfil.add(btnProlonger_prof);
		listProfil.add(btnRendre_prof);
		listProfil.add(btnChkAdr_prof);
		listProfil.add(btnChkMail_prof);
		listProfil.add(btnChkMdp_prof);
		listProfil.add(btnSeDconnecter_prof);
		listProfil.add(lblNom_prof);
		listProfil.add(lblPrnom_prof);

	}

	public void affichage() throws NumberFormatException, SQLException, ParseException {
		Connect.update();
		produitCourant = null;
		/**** LOGIN ****/
		boolean log = (etat == accueil);
		for (Object item : listAccueil) {
			((JComponent) item).setVisible(log);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** SIGN IN ***/
		boolean sign = (etat == inscription);
		for (Object item : signinList) {
			((JComponent) item).setVisible(sign);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** CONNECTED ****/
		boolean conn = (etat == connecte);
		for (Object item : listConnect) {
			((JComponent) item).setVisible(conn);
			if (item.getClass().getSimpleName().equals("JTextField"))
				((JTextComponent) item).setText("");
			if (item.getClass().getSimpleName().equals("JPasswordField"))
				((JTextComponent) item).setText("");
		}

		/**** PROFILE ****/
		boolean prof = (etat == profil);
		for (Object item : listProfil) {
			((JComponent) item).setVisible(prof);
		}
	}

	public void creerUtilisateur() throws NumberFormatException, ParseException {
		Pattern r = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = r.matcher(tfMail_inscription.getText());
		if (!m.find()) {
			JOptionPane.showMessageDialog(frame, "Adresse mail au format incorrect.");
			tfMotDePasse_inscription.setText("");
			tfMotDePasseBis_inscription.setText("");
		} else {
			if (!tfMotDePasse_inscription.getText().equals(tfMotDePasseBis_inscription.getText())) {
				JOptionPane.showMessageDialog(frame, "Les mots de passe sont différents.");
				tfMotDePasse_inscription.setText("");
				tfMotDePasseBis_inscription.setText("");
			}
			String query = "SELECT eMail FROM adherent WHERE eMail = '" + tfMail_inscription.getText() + "';";
			try {
				Connect.result = Connect.state.executeQuery(query);
				if (Connect.result.next()) {
					JOptionPane.showMessageDialog(frame, "Adresse déjà utilisée.");
					tfMail_inscription.setText("");
					tfMotDePasse_inscription.setText("");
					tfMotDePasseBis_inscription.setText("");
				} else {
					if (tfDateMois_inscription.getSelectedItem().toString().equals("04")
							|| tfDateMois_inscription.getSelectedItem().toString().equals("06")
							|| tfDateMois_inscription.getSelectedItem().toString().equals("09")
							|| tfDateMois_inscription.getSelectedItem().toString().equals("11")) {
						if(tfDateJour_inscription.getSelectedItem().toString().equals("31")) {
							JOptionPane.showMessageDialog(frame, "Saisissez une date valide.");
							return;
						}
					}
					if (tfDateMois_inscription.getSelectedItem().toString().equals("02")) {
						if(tfDateJour_inscription.getSelectedItem().toString().equals("31")
								|| tfDateJour_inscription.getSelectedItem().toString().equals("30")) {
							JOptionPane.showMessageDialog(frame, "Saisissez une date valide.");
							return;
						}
					}
					query = "INSERT INTO adherent (eMail, Nom, Prenom, Adresse, DateNaissance, MotDePasse, Actif, nbRetard) VALUES ('"
							+ tfMail_inscription.getText() + "', '" + tfNom_inscription.getText() + "', '"
							+ tfPrenom_inscription.getText() + "', '" + tfAdresse_inscription.getText() + "', '"
							+ tfDateAnnee_inscription.getSelectedItem().toString() + "-"
							+ tfDateMois_inscription.getSelectedItem().toString() + "-"
							+ tfDateJour_inscription.getSelectedItem().toString() + "', '"
							+ tfMotDePasse_inscription.getText() + "', '1', '0');";
					Connect.state.executeUpdate(query);
					JOptionPane.showMessageDialog(frame, "Inscription réussie.");
					Adherent.init();
					etat = accueil;
					affichage();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(frame, "Erreur critique lors de l'inscription.");
				frame.dispose();
				e.printStackTrace();
			}
		}
	}

	public void connecter() throws NumberFormatException, ParseException, SQLException {
		String query = "SELECT idAdherent FROM adherent WHERE eMail = '" + tfMail_accueil.getText()
				+ "' AND MotDePasse = '" + tfMotDePasse_accueil.getText() + "';";
		try {
			Connect.result = Connect.state.executeQuery(query);
			if (!Connect.result.next()) {
				JOptionPane.showMessageDialog(frame, "Erreur d'identification.");
				tfMail_accueil.setText("");
			} else {
				JOptionPane.showMessageDialog(frame, "Identification réussie.");
				etat = connecte;
				utilisateurCourant = Adherent.getAdherent(Integer.valueOf(Connect.result.getObject(1).toString()));
				if (!utilisateurCourant.actif) {
					String update = "UPDATE adherent SET actif = 1 WHERE idAdherent = " + utilisateurCourant.idAdherent
							+ ";";
					Connect.state.executeUpdate(update);
					utilisateurCourant.actif = true;
					JOptionPane.showMessageDialog(frame, "Votre compte a été réactivé !");
				}
				lblBienvenue_connect.setText("Bienvenue " + utilisateurCourant.getPrenom() + " !");
				List<Emprunt> emprunts = utilisateurCourant.emprunts();
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
					break;
				case 1:
					JOptionPane.showMessageDialog(frame,
							"Attention ! Vous avez au moins 1 produit à rendre aujourd'hui !");
					break;
				default:
				}
				String mes = utilisateurCourant.hasReservation();
				if (!mes.equals("null")) {
					System.out.println(mes);
					JOptionPane.showMessageDialog(frame, mes);
				}
				affichage();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erreur critique lors de la connection de l'utilisateur.");
			frame.dispose();
			e.printStackTrace();
		}
	}

	public void rechercher(int param) throws SQLException {
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
					produitCourant = produit;
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
		List<Emprunt> emprunts = utilisateurCourant.emprunts();
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
					empruntCourant = e;
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
		if (empruntCourant == null) {
			JOptionPane.showMessageDialog(frame, "Aucun emprunt sélectionné.");
			return;
		}
		int r = utilisateurCourant.rendre(empruntCourant);
		if (r == 1)
			JOptionPane.showMessageDialog(frame, "Le produit a déjà été rendu.");
		emprunts();
		produitCourant = null;
	}

	public void prolonger() throws SQLException, ParseException {
		if (empruntCourant == null) {
			JOptionPane.showMessageDialog(frame, "Aucun emprunt sélectionné.");
			return;
		}
		int r = utilisateurCourant.prolonger(empruntCourant);
		if (r == -1)
			JOptionPane.showMessageDialog(frame, "Vous avez trop de retards pour pouvoir prolonger.");
		if (r == 1)
			JOptionPane.showMessageDialog(frame, "Le produit a déjà été rendu.");
		emprunts();
		produitCourant = null;
	}

	public GUI() throws NumberFormatException, SQLException, ParseException, ClassNotFoundException {
		initialize();
	}

	private void initialize() throws NumberFormatException, SQLException, ParseException, ClassNotFoundException {
		Connect.init();
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 900);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		initAccueil(frame, springLayout);
		initInscription(frame, springLayout);
		initConnecte(frame, springLayout);
		initProfil(frame, springLayout);

		affichage();

	}
}
