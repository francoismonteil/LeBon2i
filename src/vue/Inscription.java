package vue;

import javax.swing.*;
import java.awt.*;

public class Inscription extends JFrame {

    public Inscription(){
        this.setTitle("LeBon2i");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box b1 = Box.createHorizontalBox();
        b1.add(new JLabel("Username : "));
        b1.add(new JTextField());
        b1.setMaximumSize(new Dimension(250,30));
        //Idem
        Box b2 = Box.createHorizontalBox();
        b2.add(new JLabel("Password : "));
        b2.add(new JTextField());
        b2.setMaximumSize(new Dimension(250,30));
        //Idem
        Box b3 = Box.createHorizontalBox();
        b3.add(new JButton("Connexion"));
        b3.add(new JButton("Inscription"));
        b3.setMaximumSize(new Dimension(250,30));
        //On crée un conteneur avec gestion verticale
        Box b4 = Box.createVerticalBox();
        b4.add(b1);
        b4.add(b2);
        b4.add(b3);

        this.getContentPane().add(b4);
        this.setVisible(true);
    }
}
