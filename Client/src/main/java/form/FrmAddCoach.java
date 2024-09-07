package form;

import communication.Communication;
import domain.Coach;
import domain.Team;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FrmAddCoach je forma za dodavanje trenera u sistem. Omogućava unos imena, prezimena,
 * broja osvojenih šampionata i tima kojem trener pripada. 
 * Validira unos korisnika pre nego što pošalje podatke sistemu.
 * 
 * @author Radin
 */
public class FrmAddCoach extends javax.swing.JDialog {

	/**
     * Kreira novu formu FrmAddCoach
     * 
     * @param parent Nadređeni prozor
     * @param modal Ako je true, dijalog blokira unos u druge prozore dok je prikazan
     */
    public FrmAddCoach(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadTeamsIntoComboBox();
    }

    /**
     * Inicijalizuje komponente forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtChampionships = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jcbTeam = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Firstname:");

        jLabel2.setText("Lastname:");

        jLabel3.setText("Number of championships");

        jLabel4.setText("Team");

        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnAdd)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtChampionships, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTeam, 0, 150, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChampionships, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jbtnAdd)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Event handler za dugme "Dodaj". Validira unos, kreira novog trenera i dodaje ga kroz komunikaciju sa serverom.
     * 
     * @param evt Događaj pritiska na dugme
     */
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
        if (validateForm()) {
            Coach coach = new Coach();
            coach.setNumbOfChampionships(Integer.parseInt(txtChampionships.getText()));
            coach.setFirstname(txtFirstname.getText());
            coach.setLastname(txtLastname.getText());
            coach.setTeam((Team) jcbTeam.getSelectedItem());
            
            Communication.getInstance().addCoach(coach);
            
            JOptionPane.showMessageDialog(this, "Coach successfully added.");
            this.dispose();
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }                                       

   
    /**
     * JLabel za prikazivanje oznake "Firstname:".
     */               
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel za prikazivanje oznake "Lastname:".
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za prikazivanje oznake "Number of championships".
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za prikazivanje oznake "Team".
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JButton za dodavanje novog trenera.
     */
    private javax.swing.JButton jbtnAdd;
    /**
     * JComboBox za izbor tima kojem trener pripada.
     */
    private javax.swing.JComboBox<Team> jcbTeam;
    /**
     * JTextField za unos imena trenera.
     */
    private javax.swing.JTextField txtChampionships;
    /**
     * JTextField za unos prezimena trenera.
     */
    private javax.swing.JTextField txtFirstname;
    /**
     * JTextField za unos broja osvojenih šampionata trenera.
     */
    private javax.swing.JTextField txtLastname;                 

    
    /**
     * Validira formu za unos trenera.
     * 
     * @return true ako su svi unosi ispravni, inače false
     */
    private boolean validateForm() {
        if (txtChampionships.getText().isEmpty() || txtFirstname.getText().isEmpty() ||
        txtLastname.getText().isEmpty() || jcbTeam.getSelectedItem()==null) {
        JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
        return false;
        }
        
        String firstname = txtFirstname.getText().trim();
        String lastname = txtLastname.getText().trim();

        if (isNumeric(firstname) || isNumeric(lastname)) {
            JOptionPane.showMessageDialog(this, "Firstname and Lastname must be strings, not numbers");
            return false;
        }

        if (!isPositiveNumber(txtChampionships.getText())) {
            JOptionPane.showMessageDialog(this, "Number of championships must be a positive number");
            return false;
        }
        
        
        Team selectedTeam = (Team) jcbTeam.getSelectedItem();
        if (selectedTeam == null) {
            JOptionPane.showMessageDialog(this, "You must select a team");
            return false;
        }

        return true;
    }

    
    
    /**
     * Proverava da li je broj pozitivan.
     * 
     * @param number Tekstualni unos broja
     * @return true ako je broj pozitivan, inače false
     */
    private boolean isPositiveNumber(String number) {
        try {
            double value = Double.parseDouble(number);
            return value > 0;
            } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Proverava da li je uneti tekst numerički.
     * 
     * @param str Uneseni tekst
     * @return true ako je numerički, inače false
     */
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Učitava sve timove iz baze i puni JComboBox sa timovima.
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
        jcbTeam.setSelectedItem(null);
    }
    
}
