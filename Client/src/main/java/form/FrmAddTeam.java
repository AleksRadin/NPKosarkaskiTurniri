package form;

import communication.Communication;
import domain.Player;
import domain.Team;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import player.state.PlayerPosition;
import table.PlayerTableModel;

/**
 * Klasa FrmAddTeam predstavlja formu za dodavanje tima u sistem. 
 * Ova forma omogućava korisniku da unese naziv tima, grad u kojem se tim nalazi, zemlju, godinu osnivanja i druge relevantne podatke. 
 * Forma takođe uključuje mehanizme za validaciju unosa kako bi se osiguralo da svi podaci budu pravilno uneseni pre nego što se pošalju sistemu.
 * 
 * @author  Radin
 */
public class FrmAddTeam extends javax.swing.JDialog {

	/**
     * Model tabele za prikaz igrača u formi.
     * Ovaj model koristi se za upravljanje i prikaz podataka o igračima u tabeli.
     */
    private PlayerTableModel playerTableModel;
    
    /**
     * Kreira novu instancu forme za dodavanje tima.
     * 
     * @param parent Glavni prozor koji će biti roditelj ove forme.
     * @param modal Da li forma treba da bude modalna ili ne.
     */
    public FrmAddTeam(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareView();
    }

    /**
     * Inicijalizuje komponente forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        txtFoundedIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbtnAdd1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbtnRemove = new javax.swing.JButton();
        jcbPosition = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("City:");

        jbtnAdd.setText("Save");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Country:");

        jLabel4.setText("FoundedIn:");

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
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Height:");

        jLabel6.setText("Weight:");

        jLabel7.setText("Firstname:");

        jLabel8.setText("Lastname:");

        jbtnAdd1.setText("Add to table");
        jbtnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAdd1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Birthday:");

        jLabel10.setText("Position:");

        jbtnRemove.setText("Remove");
        jbtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveActionPerformed(evt);
            }
        });

        jcbPosition.setEditable(true);
        jcbPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtCity)
                            .addComponent(txtCountry)
                            .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFirstname)
                                    .addComponent(txtLastname)
                                    .addComponent(txtBirthday)
                                    .addComponent(txtHeight)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(jcbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtnAdd1)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbtnAdd)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbtnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtFoundedIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jcbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbtnAdd1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jbtnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnAdd)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Čuva podatke o timu unesene u formu.
     * 
     * @param evt Događaj akcije koji se aktivira klikom na dugme za čuvanje.
     * @throws NumberFormatException ako polja za unos ne mogu da se parsiraju u brojeve.
     */
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
        if (validateForm()) {
            Team team = playerTableModel.getTeam();
            team.setCity(txtCity.getText());
            team.setCountry(txtCountry.getText());
            team.setFoundedIn(Integer.parseInt(txtFoundedIn.getText()));
            team.setName(txtName.getText());
            
            
            
            Communication.getInstance().saveTeam(team);
            
            JOptionPane.showMessageDialog(this, "Team successfully saved.");
            this.dispose();
        }
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                       

    /**
     * Dodaje igrača u tabelu na osnovu unesenih podataka.
     * 
     * @param evt Događaj akcije koji se aktivira klikom na dugme za dodavanje u tabelu.
     * @throws NumberFormatException ako polja za visinu ili težinu ne mogu da se parsiraju u brojeve.
     * @throws DateTimeParseException ako polje za datum rođenja ne može da se parsira u datum.
     */
    private void jbtnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String firstname = txtFirstname.getText().trim();
        String lastname = txtLastname.getText().trim();
        String birthday = txtBirthday.getText().trim();
        String selectedPosition = (String) jcbPosition.getSelectedItem();
        String height = txtHeight.getText().trim();
        String weight = txtWeight.getText().trim();



        if (playerVerification(firstname, lastname, birthday, height, weight, selectedPosition)) {
            try {
                Player player = new Player();
                player.setFirstname(firstname);
                player.setLastname(lastname);
                player.setBirthday(LocalDate.parse(birthday));
                player.setPosition(selectedPosition);
                player.setHeight(Double.parseDouble(height));
                player.setWeight(Double.parseDouble(weight));

                playerTableModel.addPlayer(player);
                clearInputFields();
                JOptionPane.showMessageDialog(this, "Player successfully added");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error while adding player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                        

    /**
     * Uklanja izabranog igrača iz tabele.
     * 
     * @param evt Događaj akcije koji se aktivira klikom na dugme za uklanjanje.
     */
    private void jbtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            playerTableModel.removePlayer(selectedRow);
            JOptionPane.showMessageDialog(this, "Player successfully removed");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a player to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                          

    /**
     * Rukuje događajem promene u combo boxu za pozicije.
     * 
     * @param evt Događaj akcije koji se aktivira promenom selektovanog elementa u combo boxu.
     */
    private void jcbPositionActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

  

    /**
     * JLabel za prikazivanje oznake "Firstname:".
     */                     
    private javax.swing.JLabel jLabel7;
    /**
     * JLabel za prikazivanje oznake "Country:".
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za prikazivanje oznake "Lastname:".
     */
    private javax.swing.JLabel jLabel8;
    /**
     * JLabel za prikazivanje oznake "Birthday:".
     */
    private javax.swing.JLabel jLabel9;
    /**
     * JLabel za prikazivanje oznake "Height:".
     */
    private javax.swing.JLabel jLabel5;
    /**
     * JLabel za prikazivanje oznake "Weight:".
     */
    private javax.swing.JLabel jLabel6;
    /**
     * JLabel za prikazivanje oznake "Position:".
     */
    private javax.swing.JLabel jLabel10;
    /**
     * JLabel za prikazivanje oznake "City:".
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za prikazivanje oznake "Founded In:".
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel za prikazivanje oznake "Name:".
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JScrollPane koji obuhvata polja za podatke o igraču.
     */
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * JTable za prikaz liste igrača ili drugih podataka.
     */
    private javax.swing.JTable jTable1;
    /**
     * JButton za dodavanje novog igrača.
     */
    private javax.swing.JButton jbtnAdd;
    /**
     * JButton za dodavanje igrača u tabelu
     */
    private javax.swing.JButton jbtnAdd1;
    /**
     * JButton za uklanjanje izabranog igrača.
     */
    private javax.swing.JButton jbtnRemove;
    /**
     * JComboBox za izbor pozicije igrača.
     */
    private javax.swing.JComboBox<String> jcbPosition;
    /**
     * JTextField za unos datuma rođenja igrača.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * JTextField za unos grada u kojem se tim nalazi.
     */
    private javax.swing.JTextField txtCity;
    /**
     * JTextField za unos zemlje u kojoj se tim nalazi.
     */
    private javax.swing.JTextField txtCountry;
    /**
     * JTextField za unos imena igrača.
     */
    private javax.swing.JTextField txtFirstname;
    /**
     * JTextField za unos godine osnivanja tima.
     */
    private javax.swing.JTextField txtFoundedIn;
    /**
     * JTextField za unos visine igrača.
     */
    private javax.swing.JTextField txtHeight;
    /**
     * JTextField za unos prezimena igrača.
     */
    private javax.swing.JTextField txtLastname;
    /**
     * JTextField za unos imena tima.
     */
    private javax.swing.JTextField txtName;
    /**
     * JTextField za unos težine igrača.
     */
    private javax.swing.JTextField txtWeight;                 

    /**
     * Validira unos u formi za dodavanje ili ažuriranje tima.
     * 
     * @return true ako su svi unosi u formi validni, false inače.
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
     * Verifikuje unose za igrača u formi.
     * 
     * @param firstname Ime igrača.
     * @param lastname Prezime igrača.
     * @param birthday Datum rođenja igrača.
     * @param height Visina igrača.
     * @param weight Težina igrača.
     * @param selectedPosition Pozicija igrača.
     * @return true ako su svi unosi za igrača validni, false inače.
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
     * Proverava da li je zadati datum u ispravnom formatu.
     * 
     * @param date datum u formatu YYYY-MM-DD
     * @return true ako je datum validan, false inače
     */
    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date); // Using Java's built-in date parsing
            return true;
            } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Metod za pripremu prikaza formi.
     * Ovaj metod inicijalizuje model tabele igrača, postavlja ga na JTable, i dodaje sve pozicije igrača u JComboBox. 
     * Takođe, postavlja JComboBox na null da se ne prikazuje nijedna selektovana stavka.
     */
    private void prepareView() {
        playerTableModel = new PlayerTableModel();
        jTable1.setModel(playerTableModel);
        for (PlayerPosition position : PlayerPosition.values()) {
            jcbPosition.addItem(position.name());
        }
        jcbPosition.setSelectedItem(null);
    }
    
    /**
     * Metod za čišćenje svih polja za unos na formi.
     * Ovaj metod postavlja tekst u svim tekstualnim poljima na prazan string i resetuje izbor u JComboBox na -1 (neodabrano).
     */
    private void clearInputFields() {
        txtFirstname.setText("");
        txtLastname.setText("");
        txtBirthday.setText("");
        jcbPosition.setSelectedIndex(-1);
        txtHeight.setText("");
        txtWeight.setText("");
    }
    
    
}
