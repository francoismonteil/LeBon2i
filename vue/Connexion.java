package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connexion extends JFrame implements ActionListener {

    private EcouteurConnexion ec = new EcouteurConnexion(this);
    private JPasswordField mdp;
    private JTextField mail;
    public JButton button_connexion;
    public JButton button_gotoinscription;
    public Connexion() {

        this.setTitle("LeBon2i");
        this.setSize(300, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1));
        JPanel zone1 = new JPanel();

        this.getContentPane().add(zone1);

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
        button_connexion = new JButton("Connexion");
        zone1.add(button_connexion);
        button_connexion.addActionListener(this);
        button_connexion.setPreferredSize(new Dimension(250,30));
        //Bouton
        button_gotoinscription = new JButton("Inscription");
        zone1.add(button_gotoinscription);
        button_gotoinscription.addActionListener(this);
        button_gotoinscription.setPreferredSize(new Dimension(250,30));

        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_gotoinscription) {
            Inscription i = new Inscription();
        } else if (e.getSource() == button_connexion) {
            String mail_utilisateur = mail.getText();
            String mdp_utilisateur = mdp.getText();
            boolean test = ec.getUtilisateur(mail_utilisateur,mdp_utilisateur);
            if (test)
            {
                Accueil a = new Accueil();
            }
        }
    }
}
