package vue;
import DAO.UtilisateurDao;
import DAO.ValeurPossibleDao;
import JPA.JpaUtilisateurDao;
import JPA.JpaValeurPossibleDao;
import modele.Categorie;
import modele.SurCategorie;
import modele.Utilisateur;
import modele.Ville;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Collection;

public class Ajout extends JFrame implements ActionListener {
    private EcouteurAjout ea = new EcouteurAjout(this);

    private JPanel zone1;
    public JPanel zoneCrit = new JPanel();
    public JComboBox<SurCategorie> combobox_surcategorie = new JComboBox<SurCategorie>();
    public JComboBox<Categorie> combobox_categorie = new JComboBox<Categorie>();
    private JButton button_ajouter;
    private JTextField textField_titre;
    private JTextArea text_description;
    private JTextField text_prix;
    private UtilisateurDao utilisateurManager = new JpaUtilisateurDao();

    public Ajout(){
        this.setTitle("LeBon2i");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3,1));
        //Définition des deux premières zones
        zone1 = new JPanel();
        this.getContentPane().add(zone1);

        //Partie titre
        JLabel label_titre = new JLabel("Titre de l'annonce");
        label_titre.setPreferredSize(new Dimension(150,30));
        zone1.add(label_titre);
        textField_titre = new JTextField();
        textField_titre.setPreferredSize(new Dimension(250,30));
        zone1.add(textField_titre);

        //Partie sur catégorie
        this.ea.displaySurCategorie();
        this.combobox_surcategorie.addActionListener(this);
        JLabel label_surcategorie = new JLabel("Famille");
        label_surcategorie.setPreferredSize(new Dimension(150,30));
        zone1.add(label_surcategorie);
        combobox_surcategorie.setPreferredSize(new Dimension(250,30));
        zone1.add(combobox_surcategorie);

        //Partie Catégorie
        JLabel label_categorie = new JLabel("Categorie");
        label_categorie.setPreferredSize(new Dimension(150,30));
        combobox_categorie.setPreferredSize(new Dimension(250,30));
        combobox_categorie.addActionListener(this);
        zone1.add(label_categorie);
        SurCategorie selectedSurCategorie = (SurCategorie)combobox_surcategorie.getSelectedItem();
        ea.displayCategories(selectedSurCategorie);
        zone1.add(combobox_categorie);

        //On ajoute la zone des critères en dessous des catégories
        this.getContentPane().add(zoneCrit);

        //Zone description
        JPanel zoneDescription = new JPanel();
        JLabel label_description = new JLabel("Description :");
        label_description.setPreferredSize(new Dimension(400,30));
        zoneDescription.add(label_description);
        text_description = new JTextArea();
        text_description.setPreferredSize(new Dimension(400,60));
        text_description.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        zoneDescription.add(text_description);

        JLabel label_prix = new JLabel("Prix :");
        label_prix.setPreferredSize(new Dimension(150,30));
        zoneDescription.add(label_prix);
        text_prix = new JTextField();
        text_prix.setPreferredSize(new Dimension(250, 30));
        zoneDescription.add(text_prix);
        button_ajouter = new JButton("Ajouter cette annonce");
        button_ajouter.setPreferredSize(new Dimension(400, 30));
        button_ajouter.addActionListener(this);
        zoneDescription.add(button_ajouter);
        this.getContentPane().add(zoneDescription);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combobox_surcategorie) {
            SurCategorie selectedSurCategorie = (SurCategorie)combobox_surcategorie.getSelectedItem();
            ea.displayCategories(selectedSurCategorie);
        }else if (e.getSource() == combobox_categorie){
            Categorie selectedCategorie = (Categorie)combobox_categorie.getSelectedItem();
            this.zone1.setVisible(false);
            this.zoneCrit.setVisible(false);
            if(selectedCategorie != null) {
                ea.displayCriteres(selectedCategorie);
            }
            this.zoneCrit.setVisible(true);
            this.zone1.setVisible(true);
        }else if (e.getSource() == button_ajouter){
            String titre = textField_titre.getText();
            String description = text_description.getText();
            float prix = Float.parseFloat(text_prix.getText());
            Utilisateur utilisateur = utilisateurManager.find(Utilisateur.class, 1);
            Categorie categorie = (Categorie)combobox_categorie.getSelectedItem();
            Ville ville = utilisateur.getVille();
            try {
                if(ea.addAnnonce(titre, description, prix, null, utilisateur, categorie, ville)){
                    this.dispose();
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }


}
