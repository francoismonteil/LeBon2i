package vue;
import modele.Categorie;
import modele.SurCategorie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ajout extends JFrame implements ActionListener {
    private JPanel zone1 = new JPanel();
    private JPanel zone2 = new JPanel();
    private JPanel zone3 = new JPanel();
    private JPanel zone4 = new JPanel();

    private JLabel label_titre = new JLabel("Titre de l'annonce");
    private JTextField textField_titre = new JTextField();

    private JLabel label_surcategorie = new JLabel("Famille");
    private JComboBox<SurCategorie> combobox_surcategorie = new JComboBox<SurCategorie>();

    private JLabel label_categorie = new JLabel("Categorie");
    private JComboBox<Categorie> combobox_categorie = new JComboBox<Categorie>();

    private JButton button_suivant = new JButton("Suivant");

    private ArrayList<SurCategorie> surCats = new ArrayList<SurCategorie>();
    private ArrayList<Categorie> cats = new ArrayList<Categorie>();

    public Ajout(){
        //On créer des sur catégories et on les ajoutes à la liste
        SurCategorie scat1 = new SurCategorie("Véhicule");
        surCats.add(scat1);
        for (SurCategorie surCat: surCats) {
            this.combobox_surcategorie.addItem(surCat);
        }

        //On créer des catégories et on les ajoutes à la liste
        Categorie cat1 = new Categorie("Voiture", scat1);
        cats.add(cat1);
        Categorie cat2 = new Categorie("Voiture", scat1);
        cats.add(cat2);
        for (Categorie cat: cats) {
            this.combobox_categorie.addItem(cat);
        }

        this.setTitle("LeBon2i");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(7,1));
        this.getContentPane().add(zone1);
        this.getContentPane().add(zone2);
        this.getContentPane().add(zone3);
        this.getContentPane().add(zone4);

        label_titre.setPreferredSize(new Dimension(400,30));
        zone1.add(label_titre);
        textField_titre.setPreferredSize(new Dimension(400,30));
        zone1.add(textField_titre);

        label_surcategorie.setPreferredSize(new Dimension(400,30));
        zone2.add(label_surcategorie);
        combobox_surcategorie.setPreferredSize(new Dimension(400,30));
        zone2.add(combobox_surcategorie);

        label_categorie.setPreferredSize(new Dimension(400,30));
        zone3.add(label_categorie);
        combobox_categorie.setPreferredSize(new Dimension(400,30));
        zone3.add(combobox_categorie);

        button_suivant.setPreferredSize(new Dimension(100,30));
        zone4.add(button_suivant);
        button_suivant.addActionListener(this);

        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ajout2 a2 = new Ajout2(this.textField_titre.getText(), (Categorie)this.combobox_categorie.getSelectedItem());
        this.dispose();
    }
}
