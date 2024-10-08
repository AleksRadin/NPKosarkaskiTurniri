package form;

import communication.Communication;
import domain.Player;
import domain.Team;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import player.state.PlayerPosition;
import player.state.PlayerState;
import table.PlayerTableModel;

/**
 * Klasa FrmEditTeam predstavlja dijalog za uređivanje tima i igrača.
 * Ova klasa omogućava pretragu tima, prikaz informacija o timu i igračima, kao i dodavanje, ažuriranje i brisanje igrača u timu.
 * 
 * @author Radin
 */
public class FrmEditTeam extends javax.swing.JDialog {

	/**
	 * Model tabele za prikaz igrača u dijalogu za uređivanje tima.
	 * Ova instanca modela se koristi za prikaz i manipulaciju podacima o igračima u tabeli u korisničkom interfejsu.
	 */
    private PlayerTableModel playerTableModel;
    /**
     * ID tima koji se trenutno uređuje.
     * Ova vrednost predstavlja jedinstveni identifikator tima i koristi se za pretragu i manipulaciju podacima o timu u bazi podataka ili u aplikaciji.
     */
    private Long teamId;
    
   
    
    /**
     * Kreira novi dijalog za uređivanje tima.
     * 
     * @param parent roditeljski prozor u kojem se dijalog prikazuje
     * @param modal da li dijalog blokira unos u druge prozore
     */
    public FrmEditTeam(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        prepareView();
        playerTableModel = new PlayerTableModel();
        jTable1.setModel(playerTableModel);
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        Player selectedPlayer = ((PlayerTableModel) jTable1.getModel()).getTeam().getPlayers().get(selectedRow);
                        txtFirstname.setText(selectedPlayer.getFirstname());
                        txtLastname.setText(selectedPlayer.getLastname());
                        txtBirthday.setText(selectedPlayer.getBirthday().toString());
                        jcbPosition.setSelectedItem(selectedPlayer.getPosition());
                        txtHeight.setText(Double.toString(selectedPlayer.getHeight()));
                        txtWeight.setText(Double.toString(selectedPlayer.getWeight()));
                        
                        
                        txtFirstname.setEnabled(true);
                        txtLastname.setEnabled(true);
                        txtBirthday.setEnabled(true);
                        jcbPosition.setEnabled(true);
                        txtHeight.setEnabled(true);
                        txtWeight.setEnabled(true);
                        jbtnAdd.setEnabled(false);
                        jbtnUpdate.setEnabled(true);
                        jbtnDelete.setEnabled(true);
                        
                        jbtnDeselect.setEnabled(true);
                        
                        
                    }
                }
            }
        });
        
        
                
        
    }

    /**
     * Inicijalizuje komponente forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearchedTeam = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        btnShowInfo = new javax.swing.JButton();
        jcbTeam = new javax.swing.JComboBox<>();
        jPanelTeam = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jcbPosition = new javax.swing.JComboBox<>();
        jTable1 = new javax.swing.JTable();
        jPanelTeam1 = new javax.swing.JPanel();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtFoundedIn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jbtnUpdate = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnAdd = new javax.swing.JButton();
        jbtnDeselect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Enter team name:");

        btnSearch.setText("search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jbtnSave.setText("save");
        jbtnSave.setEnabled(false);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
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

        jLabel8.setText("Lastname:");

        jLabel10.setText("Height:");

        jLabel11.setText("Birthday:");

        jLabel12.setText("Weight:");

        jLabel13.setText("Position:");

        txtFirstname.setToolTipText("");
        txtFirstname.setEnabled(false);

        txtLastname.setEnabled(false);

        txtBirthday.setEnabled(false);

        txtHeight.setEnabled(false);

        jLabel14.setText("Firstname:");

        txtWeight.setEnabled(false);

        jcbPosition.setEditable(true);
        jcbPosition.setEnabled(false);

        javax.swing.GroupLayout jPanelTeamLayout = new javax.swing.GroupLayout(jPanelTeam);
        jPanelTeam.setLayout(jPanelTeamLayout);
        jPanelTeamLayout.setHorizontalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTeamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeamLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel8)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12))
                    .addGap(37, 37, 37)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFirstname)
                        .addComponent(txtLastname)
                        .addComponent(txtHeight)
                        .addComponent(txtWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(txtBirthday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addContainerGap(74, Short.MAX_VALUE)))
        );
        jPanelTeamLayout.setVerticalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTeamLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jcbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeamLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel13)
                    .addGap(24, 24, 24)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jPanelTeam1.setFocusable(false);

        txtCity.setEnabled(false);

        txtCountry.setEnabled(false);

        txtFoundedIn.setEnabled(false);

        jLabel9.setText("Name:");

        jLabel5.setText("City:");

        jLabel6.setText("Country:");

        jLabel7.setText("FoundedIn:");

        txtName.setEnabled(false);

        javax.swing.GroupLayout jPanelTeam1Layout = new javax.swing.GroupLayout(jPanelTeam1);
        jPanelTeam1.setLayout(jPanelTeam1Layout);
        jPanelTeam1Layout.setHorizontalGroup(
            jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeam1Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addGap(37, 37, 37)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtName)
                        .addComponent(txtCity)
                        .addComponent(txtCountry)
                        .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );
        jPanelTeam1Layout.setVerticalGroup(
            jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
            .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelTeam1Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelTeam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        jbtnUpdate.setText("Update");
        jbtnUpdate.setEnabled(false);
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnDelete.setText("Delete");
        jbtnDelete.setEnabled(false);
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnAdd.setText("Add");
        jbtnAdd.setEnabled(false);
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnDeselect.setText("Deselect");
        jbtnDeselect.setEnabled(false);
        jbtnDeselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeselectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSearchedTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearch)
                                    .addComponent(btnShowInfo))
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelTeam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelTeam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 459, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnSave)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnDeselect)
                                .addGap(31, 31, 31)
                                .addComponent(jbtnAdd)
                                .addGap(27, 27, 27)
                                .addComponent(jbtnDelete)
                                .addGap(27, 27, 27)
                                .addComponent(jbtnUpdate)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchedTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnShowInfo)
                            .addComponent(jcbTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnUpdate)
                            .addComponent(jbtnDelete)
                            .addComponent(jbtnAdd)
                            .addComponent(jbtnDeselect)))
                    .addComponent(jPanelTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jbtnSave)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>                        

    
    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za pretragu timova. 
     * Ovaj metod koristi tekst iz polja za pretragu da pronađe timove u bazi podataka i prikazuje ih u padajućem meniju za selekciju timova.
     * 
     * @param evt događaj koji se desio kada je dugme za pretragu kliknuto.
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
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
     * Ovaj metod se poziva kada korisnik klikne na dugme za čuvanje izmena tima.
     * Ovaj metod validira formu, ažurira informacije o timu i šalje ih na server.
     * 
     * @param evt događaj koji se desio kada je dugme za čuvanje kliknuto.
     */
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
        if (validateForm()) {
            int foundedIn = Integer.parseInt(txtFoundedIn.getText());


            Team team = playerTableModel.getTeam();
            team.setId(teamId);
            team.setFoundedIn(foundedIn);
            team.setName(txtName.getText());
            team.setCity(txtCity.getText());
            team.setCountry(txtCountry.getText());
                       
            System.out.println(team.getId());
            
            
            Communication.getInstance().editTeam(team);

            JOptionPane.showMessageDialog(this, "Team successfully edited.");
            this.dispose();
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Founded In must be a valid number.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                        

    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za prikaz informacija o timu.
     * Ovaj metod učitava podatke o izabranom timu i prikazuje ih u odgovarajućim poljima forme, kao i učitava igrače tog tima u tabelu.
     * 
     * @param evt događaj koji se desio kada je dugme za prikaz kliknuto.
     */
    private void btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            Team selectedTeam = (Team) jcbTeam.getSelectedItem();

        if (selectedTeam == null) {
            JOptionPane.showMessageDialog(this, "Team data cannot be loaded");
            throw new Exception("Team data cannot be loaded");
        }
            Player player = new Player();
            List<Player> players = Communication.getInstance().getAllPlayers(player);
            
            for (Player player1 : players) {
                player1.setState(PlayerState.UNCHANGED);
            }
            
            for (Player player1 : players) {
                if(player1.getTeam().getId().equals(selectedTeam.getId())){
                    playerTableModel.loadPlayer(player1);
                }
            }
            
            teamId = selectedTeam.getId();
        
            txtName.setText(selectedTeam.getName());
            txtFoundedIn.setText(String.valueOf(selectedTeam.getFoundedIn()));
            txtCity.setText(selectedTeam.getCity());
            txtCountry.setText(selectedTeam.getCountry());

            txtName.setEnabled(true);
            txtFoundedIn.setEnabled(true);
            txtCity.setEnabled(true);
            txtCountry.setEnabled(true);
            jbtnSave.setEnabled(true);
            jbtnDeselect.setEnabled(true);

            JOptionPane.showMessageDialog(this, "Team data loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }                                           

    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za ažuriranje igrača.
     * Ovaj metod validira podatke forme i ažurira informacije o izabranom igraču u tabeli.
     * 
     * @param evt događaj koji se desio kada je dugme za ažuriranje kliknuto.
     */
    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Retrieve form data
            String firstname = txtFirstname.getText();
            String lastname = txtLastname.getText();
            String birthday = txtBirthday.getText();
            String height = txtHeight.getText();
            String weight = txtWeight.getText();
            String positionText = (String) jcbPosition.getSelectedItem();

            // Validate the form data
            if (playerVerification(firstname, lastname, birthday, height, weight, positionText)) {
                PlayerTableModel model = (PlayerTableModel) jTable1.getModel();
                Player selectedPlayer = model.getTeam().getPlayers().get(selectedRow);

                selectedPlayer.setFirstname(firstname);
                selectedPlayer.setLastname(lastname);
                selectedPlayer.setBirthday(LocalDate.parse(birthday));
                selectedPlayer.setPosition(positionText);
                selectedPlayer.setHeight(Double.parseDouble(height));
                selectedPlayer.setWeight(Double.parseDouble(weight));

                model.updatedPlayer(selectedPlayer);
            }
        }
    }                                          

    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za brisanje igrača.
     * Ovaj metod briše izabranog igrača iz tabele nakon što korisnik potvrdi brisanje.
     * 
     * @param evt događaj koji se desio kada je dugme za brisanje kliknuto.
     */
    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = jTable1.getSelectedRow();
    
        if (selectedRow != -1) {

            PlayerTableModel model = (PlayerTableModel) jTable1.getModel();


            Player selectedPlayer = model.getTeam().getPlayers().get(selectedRow);


            int confirm = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to delete this player?", 
                    "Confirm Deletion", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {

                model.deletePlayer(selectedPlayer);


                txtFirstname.setText("");
                txtLastname.setText("");
                txtBirthday.setText("");
                jcbPosition.setSelectedItem(null);
                txtHeight.setText("");
                txtWeight.setText("");


                JOptionPane.showMessageDialog(this, "Player successfully deleted.");
            }
        } else {
            
            JOptionPane.showMessageDialog(this, "Please select a player to delete.");
        }
    }                                          

    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za poništavanje selekcije igrača.
     * 
     * @param evt događaj koji se desio kada je dugme za poništavanje kliknuto.
     */
    private void jbtnDeselectActionPerformed(java.awt.event.ActionEvent evt) {                                             
        txtFirstname.setEnabled(true);
        txtLastname.setEnabled(true);
        txtBirthday.setEnabled(true);
        jcbPosition.setEnabled(true);
        txtHeight.setEnabled(true);
        txtWeight.setEnabled(true);
        
        jTable1.clearSelection();
    
        
        txtFirstname.setText("");
        txtLastname.setText("");
        txtBirthday.setText("");
        jcbPosition.setSelectedIndex(-1); 
        txtHeight.setText("");
        txtWeight.setText("");

        
        jbtnAdd.setEnabled(true);
        jbtnUpdate.setEnabled(false);
        jbtnDelete.setEnabled(false);
        jbtnDeselect.setEnabled(false);
    }                                            

    /**
     * Ovaj metod se poziva kada korisnik klikne na dugme za dodavanje novog igrača.
     * Ovaj metod validira podatke forme i dodaje novog igrača u tabelu ako su podaci validni.
     * 
     * @param evt događaj koji se desio kada je dugme za dodavanje kliknuto.
     */
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String firstname = txtFirstname.getText();
        String lastname = txtLastname.getText();
        String birthday = txtBirthday.getText();
        String height = txtHeight.getText();
        String weight = txtWeight.getText();
        String selectedPosition = (String) jcbPosition.getSelectedItem();

    
    if (playerVerification(firstname, lastname, birthday, height, weight, selectedPosition)) {
        Player newPlayer = new Player();
        newPlayer.setFirstname(firstname);
        newPlayer.setLastname(lastname);
        newPlayer.setBirthday(LocalDate.parse(birthday));
        newPlayer.setPosition(selectedPosition); 
        newPlayer.setHeight(Double.parseDouble(height));
        newPlayer.setWeight(Double.parseDouble(weight));

        PlayerTableModel model = (PlayerTableModel) jTable1.getModel();
        model.addPlayer(newPlayer);

        
        txtFirstname.setText("");
        txtLastname.setText("");
        txtBirthday.setText("");
        jcbPosition.setSelectedIndex(-1); 
        txtHeight.setText("");
        txtWeight.setText("");
    }
        
    }                                       

    

                        
    /**
     * JButton za pretragu timova.
     */
    private javax.swing.JButton btnSearch;
    /**
     * JButton za prikaz informacija o timu.
     */
    private javax.swing.JButton btnShowInfo;
    /**
     * JLabel koja prikazuje oznaku za izbor tima.
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel koja prikazuje oznaku za unos visine.
     */
    private javax.swing.JLabel jLabel10;
    /**
     * JLabel koja prikazuje oznaku za unos datuma rodjenja.
     */
    private javax.swing.JLabel jLabel11;
    /**
     * JLabel koja prikazuje oznaku za unos težine.
     */
    private javax.swing.JLabel jLabel12;
    /**
     * JLabel koja prikazuje oznaku za odabir pozicije.
     */
    private javax.swing.JLabel jLabel13;
    /**
     * JLabel koja prikazuje oznaku za unos imena.
     */
    private javax.swing.JLabel jLabel14;
    /**
     * JLabel koja prikazuje oznaku za unos grada.
     */
    private javax.swing.JLabel jLabel5;
    /**
     * JLabel koja prikazuje oznaku za unos države.
     */
    private javax.swing.JLabel jLabel6;
    /**
     * JLabel koja prikazuje oznaku za unos godine osnivanja.
     */
    private javax.swing.JLabel jLabel7;
    /**
     * JLabel koja prikazuje oznaku za unos prezimena.
     */
    private javax.swing.JLabel jLabel8;
    /**
     * JLabel koja prikazuje oznaku za unos naziva.
     */
    private javax.swing.JLabel jLabel9;
    /**
     * JPanel koji obuhvata podatke o igraču.
     */
    private javax.swing.JPanel jPanelTeam;
    /**
     * JPanel koji obuhvata podatke o timu.
     */
    private javax.swing.JPanel jPanelTeam1;
    /**
     * JTable koji obuhvata JTable za prikaz podataka.
     */
    private javax.swing.JTable jTable1;
    /**
     * JButton za dodavanje igrača u tabelu
     */
    private javax.swing.JButton jbtnAdd;
    /**
     * JButton za brisanje izabranog igrača.
     */
    private javax.swing.JButton jbtnDelete;
    /**
     * JButton za poništavanje selekcije u tabeli.
     */
    private javax.swing.JButton jbtnDeselect;
    /**
     * JButton za čuvanje izmena tima.
     */
    private javax.swing.JButton jbtnSave;
    /**
     * JButton za ažuriranje informacija o timu.
     */
    private javax.swing.JButton jbtnUpdate;
    /**
     * Padajući meni za izbor pozicije igrača.
     */
    private javax.swing.JComboBox<String> jcbPosition;
    /**
     * Padajući meni za izbor tima.
     */
    private javax.swing.JComboBox<Team> jcbTeam;
    /**
     * Polje za unos datuma rođenja igrača.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * Polje za unos grada tima.
     */
    private javax.swing.JTextField txtCity;
    /**
     * Polje za unos države tima.
     */
    private javax.swing.JTextField txtCountry;
    /**
     * Polje za unos imena igrača.
     */
    private javax.swing.JTextField txtFirstname;
    /**
     * Polje za unos godine osnivanja tima.
     */
    private javax.swing.JTextField txtFoundedIn;
    /**
     * Polje za unos visine igrača.
     */
    private javax.swing.JTextField txtHeight;
    /**
     * Polje za unos prezimena igrača.
     */
    private javax.swing.JTextField txtLastname;
    /**
     * Polje za unos imena tima.
     */
    private javax.swing.JTextField txtName;
    /**
     * Polje za unos imena tima za pretragu.
     */
    private javax.swing.JTextField txtSearchedTeam;
    /**
     * Polje za unos težine igrača.
     */
    private javax.swing.JTextField txtWeight;
                  

    
    /**
     * Ovaj metod validira podatke unete u formu za tim.
     * 
     * @return true ako su svi podaci validni, false inače.
     */
    private boolean validateForm() {
        if (txtCity.getText().isEmpty() || txtCountry.getText().isEmpty() || txtFoundedIn.getText().isEmpty() || txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form");
            return false;
        }

        if (!isPositiveNumber(txtFoundedIn.getText()) || txtFoundedIn.getText().length() != 4) {
            JOptionPane.showMessageDialog(this, "Founded year must be a positive number with exactly 4 digits");
            return false;
        }

        if (isNumeric(txtName.getText())) {
            JOptionPane.showMessageDialog(this, "Name cannot be a number. It must be a string.");
            return false;
        }

        if (isNumeric(txtCity.getText())) {
            JOptionPane.showMessageDialog(this, "City cannot be a number. It must be a string.");
            return false;
        }

        if (isNumeric(txtCountry.getText())) {
            JOptionPane.showMessageDialog(this, "Country cannot be a number. It must be a string.");
            return false;
        }
        return true;
    }
    
    /**
     * Ovaj metod proverava validnost podataka unetih u formu za igrače.
     * 
     * @param firstname ime igrača
     * @param lastname prezime igrača
     * @param birthday datum rođenja igrača
     * @param height visina igrača
     * @param weight težina igrača
     * @param position pozicija igrača
     * @return true ako su svi podaci validni, false inače
     */
    private boolean playerVerification(String firstname, String lastname, String birthday, String height, String weight, String selectedPosition) {
        
        if (firstname.isEmpty() || lastname.isEmpty() || birthday.isEmpty() || selectedPosition == null || height.isEmpty() || weight.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        
        if (isNumeric(firstname)) {
            JOptionPane.showMessageDialog(this, "Firstname cannot be a number. It must be a string.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (isNumeric(lastname)) {
            JOptionPane.showMessageDialog(this, "Lastname cannot be a number. It must be a string.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        
        try {
            LocalDate.parse(birthday); 
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Birthday must be a valid date in the format yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        
        try {
            double parsedHeight = Double.parseDouble(height);
            if (parsedHeight <= 0) {
                JOptionPane.showMessageDialog(this, "Height must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            double parsedWeight = Double.parseDouble(weight);
            if (parsedWeight <= 0) {
                JOptionPane.showMessageDialog(this, "Weight must be a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Height and weight must be valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        boolean isValidPosition = false;
        for (PlayerPosition position : PlayerPosition.values()) {
            if (position.name().equals(selectedPosition)) {
                isValidPosition = true;
                break;
            }
        }

        if (!isValidPosition) {
            JOptionPane.showMessageDialog(this, "Position must be one of the predefined values: " 
                    + String.join(", ", Arrays.stream(PlayerPosition.values()).map(Enum::name).toArray(String[]::new)), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; 
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
     * Proverava da li je broj pozitivan.
     * 
     * @param number Tekstualni unos broja
     * @return true ako je broj pozitivan, inače false
     */
    private boolean isPositiveNumber(String number) {
        try {
        int value = Integer.parseInt(number);
        return value > 0;
        } catch (NumberFormatException e) {
        return false;
        }
    }
    
    /**
     * Ovaj metod priprema prikaz tako što dodaje sve vrednosti iz `PlayerPosition` enum-a u padajući meni (JComboBox). Nakon dodavanja svih pozicija, selektuje `null` 
     * kako bi se osiguralo da nijedna pozicija nije selektovana pre nego što korisnik izabere.
     */
    private void prepareView() {
        for (PlayerPosition position : PlayerPosition.values()) {
            jcbPosition.addItem(position.name());
        }
        jcbPosition.setSelectedItem(null);
    }

}
