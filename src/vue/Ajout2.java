package vue;

import modele.Categorie;

import javax.swing.*;
import java.awt.*;

public class Ajout2 extends JFrame {
    private JPanel zone1 = new JPanel();
    private JPanel zone2 = new JPanel();
    private JPanel zone3 = new JPanel();
    private JPanel zone4 = new JPanel();
    private JPanel zone5 = new JPanel();

    private JLabel label_titre = new JLabel("TITRE");
    private JLabel label_categorie = new JLabel("Categorie");

    public Ajout2(String Titre, Categorie cat){
        this.setTitle("LeBon2i");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(7,1));
        this.getContentPane().add(zone1);
        this.getContentPane().add(zone2);
        this.getContentPane().add(zone3);
        this.getContentPane().add(zone4);
        this.getContentPane().add(zone5);

        label_titre.setPreferredSize(new Dimension(400,30));
        zone1.add(label_titre);
        label_titre.setText(Titre);

        label_categorie.setPreferredSize(new Dimension(400,30));
        zone1.add(label_categorie);
        label_categorie.setText(cat.toString());

        this.setVisible(true);
    }
}
