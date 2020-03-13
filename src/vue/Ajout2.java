package vue;

import modele.Categorie;
import modele.Critere;
import modele.ValeurPossible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ajout2 extends JFrame implements ActionListener{
    private JPanel zone1 = new JPanel();

    private JLabel label_titre = new JLabel("TITRE");
    private JLabel label_categorie = new JLabel("Categorie");

    private ArrayList<Critere> crits= new ArrayList<Critere>();
    private ArrayList<ValeurPossible> vps= new ArrayList<ValeurPossible>();

    private String Titre;
    private Categorie cat;

    public Ajout2(String Titre, Categorie cat){
        this.Titre = Titre;
        this.cat = cat;

        //On créait des critères et on les ajoutes à la liste
        Critere crit1 = new Critere("Motorisation", "ComboBox", cat);
        crits.add(crit1);
        Critere crit2 = new Critere("Puissance din", "int", cat);
        crits.add(crit2);

        //On créait des vp et on les ajoutes à la liste vals1
        ValeurPossible vp1 = new ValeurPossible("Diesel", crit1);
        vps.add(vp1);
        ValeurPossible vp2 = new ValeurPossible("Essence", crit1);
        vps.add(vp2);
        ValeurPossible vp3 = new ValeurPossible("Electrique", crit1);
        vps.add(vp3);

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

        for (Critere crit:crits) {
            JLabel label = new JLabel(crit.getLabel());
            label.setPreferredSize(new Dimension(100,30));
            JPanel zone = new JPanel();
            this.getContentPane().add(zone);

            zone.add(label);

            switch(crit.getType()){
                case "ComboBox":
                    JComboBox<ValeurPossible> vpc = new JComboBox<ValeurPossible>();
                    vpc.setPreferredSize(new Dimension(100,30));
                    for (ValeurPossible vp:vps) {
                        vpc.addItem(vp);
                    }
                    zone.add(vpc);
                break;
                case "int":
                    JTextField vpi = new JTextField();
                    vpi.setPreferredSize(new Dimension(100,30));
                    zone.add(vpi);
                break;
                default:
                    JTextField vpd = new JTextField();
                    vpd.setPreferredSize(new Dimension(100,30));
                    zone.add(vpd);
                break;
            }

        }

        JButton suivant = new JButton("Suivant");
        suivant.setPreferredSize(new Dimension(100,30));
        suivant.addActionListener( this);

        JPanel zonef = new JPanel();
        zonef.add(suivant);
        this.getContentPane().add(zonef);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ajout3 a3 = new Ajout3(Titre, cat);
        this.dispose();
    }
}
