package vue;

import modele.Ville;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inscription extends JFrame implements ActionListener {

    public JButton button_inscription;
    private JTextField nom;
    private JTextField prenom;
    private JTextField date;
    private JTextField tel;
    private JTextField mail;
    private JPasswordField mdp;
    private JTextArea adresse;

    private EcouteurInscription ei = new EcouteurInscription(this);

    public JComboBox<Ville> combobox_ville = new JComboBox<Ville>();

    public Inscription(){
        this.setTitle("LeBon2i");
        this.setSize(300, 600);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1,1));
        JPanel zone1 = new JPanel();
        this.getContentPane().add(zone1);

        //Nom
        JLabel nom_label = new JLabel("Nom : ");
        zone1.add(nom_label);
        nom = new JTextField();
        zone1.add(nom);
        nom.setPreferredSize(new Dimension(250,30));
        //Prénom
        JLabel prenom_label = new JLabel("Prénom : ");
        zone1.add(prenom_label);
        prenom = new JTextField();
        zone1.add(prenom);
        prenom.setPreferredSize(new Dimension(250,30));
        //Date de naissance
        JLabel date_label = new JLabel("Date de naissance : ");
        zone1.add(date_label);
        date = new JTextField();
        zone1.add(date);
        date.setPreferredSize(new Dimension(250,30));
        //Adresse
        JLabel adresse_label = new JLabel("Adresse : ");
        zone1.add(adresse_label);
        adresse = new JTextArea();
        zone1.add(adresse);
        adresse.setPreferredSize(new Dimension(250,60));
        //Ville
        JLabel ville_label = new JLabel("Ville : ");
        zone1.add(ville_label);
        zone1.add(combobox_ville);
        ei.displayVille();
        combobox_ville.setPreferredSize(new Dimension(250,60));
        //Téléphone
        JLabel tel_label = new JLabel("Téléphone : ");
        zone1.add(tel_label);
        tel = new JTextField();
        zone1.add(tel);
        tel.setPreferredSize(new Dimension(250,30));
        //Mail
        JLabel mail_label = new JLabel("Email : ");
        zone1.add(mail_label);
        mail = new JTextField();
        zone1.add(mail);
        mail.setPreferredSize(new Dimension(250,30));
        //Mdp
        JLabel mdp_label = new JLabel("Mot de passe : ");
        zone1.add(mdp_label);
        mdp = new JPasswordField();
        zone1.add(mdp);
        mdp.setPreferredSize(new Dimension(250,30));
        //Bouton
        button_inscription = new JButton("Inscription");
        zone1.add(button_inscription);
        button_inscription.addActionListener(this);
        button_inscription.setPreferredSize(new Dimension(250,30));

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_inscription) {
            String n = nom.getText();
            String p = prenom.getText();
            String sDate1= date.getText();
            Date d = null;
            try {
                d = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            String a = adresse.getText();
            String t = tel.getText();
            String ma = mail.getText();
            String md = mdp.getText();
            Ville v = (Ville)combobox_ville.getSelectedItem();

            try {
                ei.addUtilisateur(p, n, d, a, t, ma, md, v);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }
}
