package form;

import communication.Communication;
import domain.Team;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FrmShowTeam za pretragu i prikaz informacija o timu.
 * Omogućava korisniku da pretražuje timove i prikazuje detalje o izabranom timu.
 * @author Radin
 */
public class FrmShowTeam extends javax.swing.JDialog {

	/**
     * Kreira novi dijalog za prikaz tima.
     *
     * @param parent roditeljski prozor
     * @param modal da li je dijalog modalni
     */
    public FrmShowTeam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora za inicijalizaciju forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        btnShowInfo = new javax.swing.JButton();
        jcbTeam = new javax.swing.JComboBox<>();
        jPanelTeam = new javax.swing.JPanel();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtFoundedIn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSearchedTeam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnShowInfo.setText("Show info");
        btnShowInfo.setEnabled(false);
        btnShowInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowInfoActionPerformed(evt);
            }
        });

        jcbTeam.setEnabled(false);

        jPanelTeam.setFocusable(false);

        jLabel8.setText("Name:");

        jLabel2.setText("City:");

        jLabel3.setText("Country:");

        jLabel4.setText("FoundedIn:");

        javax.swing.GroupLayout jPanelTeamLayout = new javax.swing.GroupLayout(jPanelTeam);
        jPanelTeam.setLayout(jPanelTeamLayout);
        jPanelTeamLayout.setHorizontalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeamLayout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4))
                    .addGap(37, 37, 37)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtName)
                        .addComponent(txtCity)
                        .addComponent(txtCountry)
                        .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
        jPanelTeamLayout.setVerticalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
            .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeamLayout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        jLabel1.setText("Enter team name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSearchedTeam)
                                .addComponent(jcbTeam, 0, 171, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSearch)
                                .addComponent(btnShowInfo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(48, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearchedTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShowInfo)
                        .addComponent(jcbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27)
                    .addComponent(jPanelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Akcija koja se izvršava kada se pritisne dugme za pretragu.
     * Pretražuje timove na osnovu unetog imena i prikazuje ih u kombinovanom okviru (drop-down listi). 
     * Omogućava dugme za prikaz informacija o timu.
     *
     * @param evt događaj pritiska na dugme
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            txtCity.setText("");
            txtCountry.setText("");
            txtFoundedIn.setText("");
            txtName.setText("");
            Team team = new Team();
            team.setName(txtSearchedTeam.getText());

            List<Team> teams = Communication.getInstance().getTeams(team);

            jcbTeam.removeAllItems();
            for (Team tm : teams) {
                jcbTeam.addItem(tm);
            }

            jcbTeam.setEnabled(true);
            btnShowInfo.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Teams have been found in the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                         

    /**
     * Akcija koja se izvršava kada se pritisne dugme za prikaz informacija.
     * Prikazuje detalje o izabranom timu u odgovarajućim tekstualnim poljima. 
     * Ako nijedan tim nije izabran, prikazuje poruku o grešci.
     *
     * @param evt događaj pritiska na dugme
     */
    private void btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            Team selectedTeam = (Team) jcbTeam.getSelectedItem();

            if (selectedTeam == null) {
                JOptionPane.showMessageDialog(this, "Team data cannot be loaded");
                throw new Exception("Team data cannot be loaded");
            }

            txtName.setText(selectedTeam.getName());
            txtFoundedIn.setText(String.valueOf(selectedTeam.getFoundedIn()));
            txtCity.setText(selectedTeam.getCity());
            txtCountry.setText(selectedTeam.getCountry());

            

            JOptionPane.showMessageDialog(this, "Team data loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }                                           

   

                   
    /**
     * JButton za pretragu timova na osnovu unetog imena tima.
     */
    private javax.swing.JButton btnSearch;
    /**
     * JButton za prikaz informacija o izabranom timu.
     */
    private javax.swing.JButton btnShowInfo;
    /**
     * JLabel za prikaz teksta "Enter team name:".
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel za prikaz teksta "City:".
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za prikaz teksta "Country:".
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za prikaz teksta "FoundedIn:".
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel za prikaz teksta "Name:".
     */
    private javax.swing.JLabel jLabel8;
    /**
     * Panel koji sadrži tekstualna polja za prikaz informacija o timu.
     */
    private javax.swing.JPanel jPanelTeam;
    /**
     * JComboBox za izbor tima iz pretraženih timova.
     */
    private javax.swing.JComboBox<Team> jcbTeam;
    /**
     * JTextField za unos i prikaz grada tima.
     */
    private javax.swing.JTextField txtCity;
    /**
     * JTextField za unos i prikaz države tima.
     */
    private javax.swing.JTextField txtCountry;
    /**
     * JTextField za unos i prikaz godine osnivanja tima.
     */
    private javax.swing.JTextField txtFoundedIn;
    /**
     * JTextField za unos i prikaz imena tima.
     */
    private javax.swing.JTextField txtName;
    /**
     * JTextField za unos imena tima koji se traži.
     */
    private javax.swing.JTextField txtSearchedTeam;
                
}
