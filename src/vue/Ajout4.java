package vue;

import modele.Categorie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ajout4 extends JFrame implements ActionListener {

    private JPanel zone1 = new JPanel();
    private JPanel zone2 = new JPanel();
    private JPanel zonef = new JPanel();

    private JLabel label_titre = new JLabel("TITRE");
    private JLabel label_categorie = new JLabel("Categorie");

    private JLabel label_description = new JLabel("Description");
    private JTextPane text_description = new JTextPane();

    public Ajout4(String Titre, Categorie cat){
        this.setTitle("LeBon2i");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(7,1));
        this.getContentPane().add(zone1);

        label_titre.setPreferredSize(new Dimension(400,30));
        zone1.add(label_titre);
        label_titre.setText(Titre);

        label_categorie.setPreferredSize(new Dimension(400,30));
        zone1.add(label_categorie);
        label_categorie.setText(cat.toString());

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
