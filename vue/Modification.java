package vue;
import modele.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modification extends JFrame implements ActionListener {
    private EcouteurModification ea;

    private JPanel zone1;
    public JPanel zoneCrit = new JPanel();
    public JComboBox<SurCategorie> combobox_surcategorie = new JComboBox<SurCategorie>();
    public JComboBox<Categorie> combobox_categorie = new JComboBox<Categorie>();
    private JButton button_modifier;
    private JTextField textField_titre;
    private MesAnnonces mesAnnonces;
    private Annonce annonce;

    public Modification(MesAnnonces mesAnnonces, Annonce annonce){
        this.mesAnnonces = mesAnnonces;
        this.annonce = annonce;
        this.ea = new EcouteurModification(this, this.annonce);
        this.setTitle("LeBon2i");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        this.setLayout(new GridLayout(3,1));
        //Définition des deux premières zones
        zone1 = new JPanel();
        this.getContentPane().add(zone1);

        //Partie titre + surcatégorie + catégorie
        JLabel label_titre = new JLabel("Titre de l'annonce");
        label_titre.setPreferredSize(new Dimension(150,30));
        zone1.add(label_titre);
        textField_titre = new JTextField();
        textField_titre.setText(annonce.getTitre());
        textField_titre.setPreferredSize(new Dimension(250,30));
        zone1.add(textField_titre);

        this.ea.displaySurCategorie(1);
        this.combobox_surcategorie.addActionListener(this);
        JLabel label_surcategorie = new JLabel("Famille");
        label_surcategorie.setPreferredSize(new Dimension(150,30));
        zone1.add(label_surcategorie);
        combobox_surcategorie.setPreferredSize(new Dimension(250,30));
        zone1.add(combobox_surcategorie);

        JLabel label_categorie = new JLabel("Categorie");
        label_categorie.setPreferredSize(new Dimension(150,30));
        combobox_categorie.setPreferredSize(new Dimension(250,30));
        combobox_categorie.addActionListener(this);
        zone1.add(label_categorie);
        SurCategorie selectedSurCategorie = (SurCategorie)combobox_surcategorie.getSelectedItem();
        ea.displayCategories(selectedSurCategorie, 1);
        zone1.add(combobox_categorie);

        //On ajoute la zone des critères en dessous des catégories
        this.getContentPane().add(zoneCrit);

        //Partie description + prix + bouton modifier
        JPanel zoneDescription = new JPanel();
        button_modifier = new JButton("Modifier l'annonce");
        button_modifier.setPreferredSize(new Dimension(400,30));
        button_modifier.addActionListener(this);
        zoneDescription.add(button_modifier);
        this.getContentPane().add(zoneDescription);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_modifier) {
            this.annonce.setTitre(this.textField_titre.getText());
            mesAnnonces.refreshRow(this.annonce);
            this.dispose();
        }else if (e.getSource() == combobox_surcategorie) {
            SurCategorie selectedSurCategorie = (SurCategorie)combobox_surcategorie.getSelectedItem();
            ea.displayCategories(selectedSurCategorie, 0);
        }else if (e.getSource() == combobox_categorie){
            Categorie selectedCategorie = (Categorie)combobox_categorie.getSelectedItem();
            this.zone1.setVisible(false);
            this.zoneCrit.setVisible(false);
            if(selectedCategorie != null) {
                ea.displayCriteres(selectedCategorie);
            }
            this.zoneCrit.setVisible(true);
            this.zone1.setVisible(true);
        }
    }

    @Override
    public void dispose() {
        mesAnnonces.refreshRow(this.annonce);
        super.dispose();
    }
}
