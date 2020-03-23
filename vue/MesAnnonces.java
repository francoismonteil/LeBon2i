package vue;

import DAO.AnnonceDao;
import JPA.JpaAnnonceDao;
import modele.Annonce;
import modele.Utilisateur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

public class MesAnnonces extends JFrame implements ActionListener {
    private Utilisateur utilisateur;
    private AnnonceDao annonceManager = new JpaAnnonceDao();
    private Collection<Annonce> annonces;
    private JTable table_annonces;
    private Modification modification;
    private int ligneModifie = -1;

    public MesAnnonces(Utilisateur utilisateur){
        this.utilisateur = utilisateur;
        this.annonces = annonceManager.findByUtilisateur(utilisateur.getIdUtilisateurs());

        this.setTitle("LeBon2i");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(1,1));

        //Titre de la page
        JPanel zone1 = new JPanel();
        JLabel label_titrePage = new JLabel("Mes Annonces");
        label_titrePage.setPreferredSize(new Dimension(400,30));
        zone1.add(label_titrePage);
        this.getContentPane().add(zone1);

        //Tableau des annonces
        Vector<String> entetes = new Vector<String>();
        entetes.addElement("ID");
        entetes.addElement("Titre");
        entetes.addElement("Catégorie");
        entetes.addElement("Prix");
        Vector<Vector> donnees = new Vector<>();
        for (Annonce a:annonces) {
            Vector<String> row = new Vector<>();
            row.addElement(String.valueOf(a.getIdAnnonces()));
            row.addElement(a.toString());
            row.addElement(a.getCategorie().getLabel());
            String prix = String.valueOf(a.getPrix());
            row.addElement(prix + "€");
            donnees.addElement(row);
        }

        table_annonces = new JTable(donnees, entetes);
        table_annonces.getSelectionModel().addListSelectionListener(event -> {
            if (table_annonces.getSelectedRow() > -1 && modification == null) {
                Annonce a = annonceManager.find(Annonce.class, Integer.parseInt((String)table_annonces.getValueAt(table_annonces.getSelectedRow(), 0)));
                modification = new Modification(this, a);
                this.ligneModifie = table_annonces.getSelectedRow();
            }
        });

        table_annonces.setPreferredSize(new Dimension(450,400));
        zone1.add(table_annonces);

        //Zone button ajout
        JButton button_ajout = new JButton("Ajouter une annonce");
        button_ajout.setPreferredSize(new Dimension(400,30));
        button_ajout.addActionListener(this);
        zone1.add(button_ajout);
        this.getContentPane().add(zone1);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ajout a = new Ajout(utilisateur, this);
    }

    public void refreshTable(Annonce a){
        DefaultTableModel model = (DefaultTableModel) table_annonces.getModel();
        model.addRow(new String[]{String.valueOf(a.getIdAnnonces()), a.getTitre(), a.getCategorie().toString(), a.getPrix()+" €"});
    }

    public void refreshRow(Annonce a){
        this.modification = null;
        this.table_annonces.getModel().setValueAt(String.valueOf(a.getIdAnnonces()), ligneModifie, 0);
        this.table_annonces.getModel().setValueAt(a.getTitre(), ligneModifie, 1);
        this.table_annonces.getModel().setValueAt(a.getCategorie().getLabel(), ligneModifie, 2);
        this.table_annonces.getModel().setValueAt(a.getPrix()+"€", ligneModifie, 3);
        this.table_annonces.clearSelection();
    }
}
