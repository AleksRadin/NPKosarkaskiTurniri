package form;

import communication.Communication;
import domain.Coach;
import domain.Team;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FrmEditCoach koja predstavlja prozor za uređivanje trenera.
 * Omogućava pretragu trenera po prezimenu, prikaz informacija o izabranom treneru, i izmenu podataka o treneru.
 * 
 * @author Radin
 */
public class FrmEditCoach extends javax.swing.JDialog {

	 /**
     * Kreira novi prozor za uređivanje trenera.
     * 
     * @param parent Roditeljski prozor
     * @param modal Da li je prozor modalan
     */
    public FrmEditCoach(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora kako bi se inicijalizovao prozor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearchedCoach = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnShowInfo = new javax.swing.JButton();
        jcbCoach = new javax.swing.JComboBox<>();
        jPanelPlayer = new javax.swing.JPanel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtChampionships = new javax.swing.JTextField();
        jcbTeam = new javax.swing.JComboBox<>();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Enter coach lastname:");

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

        jcbCoach.setEnabled(false);

        jPanelPlayer.setFocusable(false);

        txtFirstname.setEnabled(false);

        txtLastname.setEnabled(false);

        jLabel2.setText("Firstname:");

        jLabel3.setText("Lastname:");

        jLabel8.setText("Number of championships");

        jLabel4.setText("Team");

        txtChampionships.setEnabled(false);

        jcbTeam.setEnabled(false);

        javax.swing.GroupLayout jPanelPlayerLayout = new javax.swing.GroupLayout(jPanelPlayer);
        jPanelPlayer.setLayout(jPanelPlayerLayout);
        jPanelPlayerLayout.setHorizontalGroup(
            jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayerLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirstname)
                    .addComponent(txtLastname)
                    .addComponent(txtChampionships)
                    .addComponent(jcbTeam, 0, 125, Short.MAX_VALUE))
                .addGap(46, 46, 46))
            .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPlayerLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addContainerGap(295, Short.MAX_VALUE)))
        );
        jPanelPlayerLayout.setVerticalGroup(
            jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlayerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlayerLayout.createSequentialGroup()
                        .addComponent(txtChampionships, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayerLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(21, 21, 21)))
                .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPlayerLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addContainerGap(125, Short.MAX_VALUE)))
        );

        jbtnSave.setText("save");
        jbtnSave.setEnabled(false);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnSave)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchedCoach)
                            .addComponent(jcbCoach, 0, 171, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch)
                            .addComponent(btnShowInfo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanelPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchedCoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowInfo)
                    .addComponent(jcbCoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jPanelPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jbtnSave)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Akcija koja se izvršava kada se klikne na dugme za pretragu trenera.
     * Pretražuje trenere u bazi podataka prema prezimenu i prikazuje ih u JComboBox-u.
     * 
     * @param evt Događaj klika na dugme
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
        Coach coach = new Coach();
        coach.setLastname(txtSearchedCoach.getText());
        
        List<Coach> coaches  = Communication.getInstance().getCoaches(coach);
        
        jcbCoach.removeAllItems();
        for (Coach c : coaches) {
            jcbCoach.addItem(c);
        }
        
        jcbCoach.setEnabled(true);
        btnShowInfo.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Coaches  have been found in the database.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }                                         

    /**
     * Akcija koja se izvršava kada se klikne na dugme za prikaz informacija o treneru.
     * Učitava informacije o izabranom treneru i omogućava izmenu podataka.
     * 
     * @param evt Događaj klika na dugme
     */
    private void btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
    try {
        Coach selectedCoach = (Coach) jcbCoach.getSelectedItem();

        if (selectedCoach == null) {
            JOptionPane.showMessageDialog(this, "Coach data cannot be loaded");
            throw new Exception("Coach data cannot be loaded");
        }
        
        loadTeamsIntoComboBox();

        txtFirstname.setText(selectedCoach.getFirstname());
        txtLastname.setText(selectedCoach.getLastname());
        txtChampionships.setText(String.valueOf(selectedCoach.getNumbOfChampionships()));
        jcbTeam.setSelectedItem(selectedCoach.getTeam());

        txtFirstname.setEnabled(true);
        txtLastname.setEnabled(true);
        txtChampionships.setEnabled(true);
        jcbTeam.setEnabled(true);
        jbtnSave.setEnabled(true);
        
        
        JOptionPane.showMessageDialog(this, "Coach data loaded.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage()); 
    }

    }                                           

    /**
     * Akcija koja se izvršava kada se klikne na dugme za čuvanje izmena trenera.
     * Validira unos i ažurira podatke o treneru u bazi podataka.
     * 
     * @param evt Događaj klika na dugme
     */
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
    try {
        if (validateForm()) {
            Coach coach = (Coach) jcbCoach.getSelectedItem();
            if (coach == null) {
                throw new Exception("Coach data cannot be loaded");
            }

            coach.setFirstname(txtFirstname.getText());
            coach.setLastname(txtLastname.getText());
            coach.setNumbOfChampionships(Integer.parseInt(txtChampionships.getText()));
            coach.setTeam((Team) jcbTeam.getSelectedItem());

            Communication.getInstance().editCoach(coach);

            JOptionPane.showMessageDialog(this, "Coach successfully edited.");
            this.dispose();
        }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            }
    }                                        

   

    /**
     * JButton za pretragu trenera. 
     */               
    private javax.swing.JButton btnSearch;
    /**
     * JButton za prikaz informacija o izabranom treneru.
     */
    private javax.swing.JButton btnShowInfo;
    /**
     * JLabel za unos prezimena trenera koji se traži.
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel za unos imena trenera.
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za unos prezimena trenera.
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za izbor tima trenera.
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel za unos broja osvojenih šampionata.
     */
    private javax.swing.JLabel jLabel8;
    /**
     * JPanel koji sadrži polja za unos podataka o treneru.
     */
    private javax.swing.JPanel jPanelPlayer;
    /**
     * JButton za čuvanje izmena trenera.
     */
    private javax.swing.JButton jbtnSave;
    /**
     * JComboBox za izbor trenera sa liste.
     */
    private javax.swing.JComboBox<Coach> jcbCoach;
    /**
     * JComboBox za izbor tima trenera.
     */
    private javax.swing.JComboBox<Team> jcbTeam;
    /**
     * JTextField za unos broja osvojenih šampionata.
     */
    private javax.swing.JTextField txtChampionships;
    /**
     * JTextField za unos imena trenera.
     */
    private javax.swing.JTextField txtFirstname;
    /**
     * JTextField za unos prezimena trenera.
     */
    private javax.swing.JTextField txtLastname;
    /**
     * JTextField za unos prezimena trenera koji se traži.
     */
    private javax.swing.JTextField txtSearchedCoach;                 

    /**
     * Validira unos u formi za uređivanje trenera.
     * Proverava da li su svi obavezni podaci uneti i da li su u ispravnom formatu.
     * 
     * @return Da li su podaci validni
     */
    private boolean validateForm() {
        
        
        String firstname = txtFirstname.getText().trim();
        String lastname = txtLastname.getText().trim();
        String championshipsText = txtChampionships.getText().trim();
        
        if (firstname.isEmpty() || lastname.isEmpty() || championshipsText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.");
            return false;
        }

        if (isNumeric(firstname) || isNumeric(lastname)) {
            JOptionPane.showMessageDialog(this, "Firstname and Lastname must be strings, not numbers.");
            return false;
        }
       
        try {
            int championships = Integer.parseInt(championshipsText);
            if (championships < 0) {
                JOptionPane.showMessageDialog(this, "Number of championships must be a non-negative number.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Number of championships must be a numeric value.");
            return false;
        }

        return true;
    }   
    
    /**
     * Učitava sve timove iz baze podataka i dodaje ih u JComboBox za izbor tima.
     */

    private void loadTeamsIntoComboBox() {
        try {
        List<Team> teams = Communication.getInstance().getAllTeams(new Team()); 
        for (Team team : teams) {
            jcbTeam.addItem(team);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading teams: " + ex.getMessage());
        }
    }
    
    /**
     * Proverava da li je string numerička vrednost.
     * 
     * @param str String koji se proverava
     * @return Da li je string numerička vrednost
     */
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
