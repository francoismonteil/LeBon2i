package vue;
import modele.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accueil extends JFrame implements ActionListener {
    private Utilisateur user;
    private JPanel zone1 = new JPanel();
    private JPanel zone2 = new JPanel();
    private JTextField champ = new JTextField();
    private JButton recherche = new JButton("Rechercher");
    private JButton mesAnnonces = new JButton("Mes annonces");
    private JLabel prixMinLabel = new JLabel("Prix minimum : ");
    private JLabel prixMaxLabel = new JLabel("Prix maximum : ");
    private JLabel lieuLabel = new JLabel("Lieu : ");
    SpinnerModel value =
            new SpinnerNumberModel(0, //initial value
                    0, //minimum value
                    999999, //maximum value
                    1); //step
    private JSpinner prixMaxSpinner = new JSpinner(value);
    private JSpinner prixMinSpinner = new JSpinner(value);
    private JTextField lieu = new JTextField();
    public Accueil(Utilisateur u){
        user = u;
        this.setTitle("LeBon2i");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mesAnnonces.addActionListener(this);
        champ.setPreferredSize(new Dimension(100, 30));
        prixMinSpinner.setPreferredSize(new Dimension(70, 30));
        prixMaxSpinner.setPreferredSize(new Dimension(70, 30));
        lieu.setPreferredSize(new Dimension(100,30));
        this.setLayout(new GridLayout(2,2));
        this.getContentPane().add(zone1);
        this.getContentPane().add(zone2);
        this.getContentPane().add(mesAnnonces);
        zone1.add(champ);
        zone1.add(recherche);
        zone1.add(lieuLabel);
        zone1.add(lieu);
        zone2.add(prixMinLabel);
        zone2.add(prixMinSpinner);
        zone2.add(prixMaxLabel);
        zone2.add(prixMaxSpinner);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mesAnnonces) {
            MesAnnonces mA = new MesAnnonces(this.user);
        }
    }
}
