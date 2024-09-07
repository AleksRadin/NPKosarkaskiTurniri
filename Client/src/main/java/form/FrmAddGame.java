package form;

import communication.Communication;
import domain.Game;
import domain.League;
import domain.ListOfReferees;
import domain.PlayedGame;
import domain.Referee;
import domain.Team;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * FrmAddGame je forma za dodavanje utakmica u sistem. 
 * Omogućava unos datuma, vremena i lige za novu utakmicu, kao i dodeljivanje sudija utakmici. 
 * Validira unos korisnika pre nego što pošalje podatke sistemu i obaveštava korisnika o eventualnim greškama.
 * 
 * @author Radin
 */
public class FrmAddGame extends javax.swing.JDialog {
    
	/**
     * Lista sudija dostupnih za dodeljivanje utakmici.
     */
    private List<Referee> referees;
    /**
     * Lista liga dostupnih za dodeljivanje utakmici.
     */
    private List<League> leagues;
    /**
     * Kreira novu instancu forme za dodavanje utakmice.
     * 
     * @param parent glavni prozor aplikacije
     * @param modal da li forma treba da bude modalna
     * @throws Exception ako dođe do greške prilikom pripreme forme
     */
    public FrmAddGame(java.awt.Frame parent, boolean modal) throws Exception {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGameDate = new javax.swing.JTextField();
        txtGameTime = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbLeague = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("game date:");

        jLabel2.setText("game time:");

        jbtnAdd.setText("add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("league");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtGameDate, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txtGameTime, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbLeague, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnAdd)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGameDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbLeague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jbtnAdd)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Akcija koja se izvršava kada se klikne na dugme za dodavanje utakmice.
     * Ova metoda validira unos, kreira novu utakmicu, dodeljuje sudije i dodaje utakmicu u sistem. 
     * Ako nije dovoljno sudija, obaveštava korisnika o grešci.
     * 
     * @param evt događaj koji se dogodio prilikom klika na dugme
     */
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
        if (validateForm()) {
            Game game = new Game();
            game.setGameDate(LocalDate.parse(txtGameDate.getText()));
            game.setGameTime(LocalTime.parse(txtGameTime.getText()));
            game.setLeague((League) jcbLeague.getSelectedItem());
            
            
            Communication.getInstance().addGame(game);
            
            Game game1 = new Game();
            List<Game> games = Communication.getInstance().getGames(game);
            for (Game g : games) {
                game1 = g;
            }
            
            
            if (referees.size() >= 3) {
                List<Referee> shuffledReferees = new ArrayList<>(referees);
                Collections.shuffle(shuffledReferees);

                
                Referee headReferee = shuffledReferees.get(0);
                Referee firstReferee = shuffledReferees.get(1);
                Referee secondReferee = shuffledReferees.get(2);
                
                ListOfReferees listOfReferees = new ListOfReferees(headReferee, firstReferee, secondReferee, game1);
                
                
                Communication.getInstance().addListOfReferees(listOfReferees);
            } else {
                JOptionPane.showMessageDialog(this, "Not enough referees available.");
            }
            
            JOptionPane.showMessageDialog(this, "Game successfully added.");
            this.dispose(); 
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }                 
    }                                       

    
    /**
     * JLabel koja prikazuje oznaku za unos datuma utakmice.
     */              
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel koja prikazuje oznaku za unos vremena utakmice.
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel koja prikazuje oznaku za izbor lige.
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JButton za dodavanje nove utakmice. Koristi se za potvrđivanje unosa i slanje podataka.
     */
    private javax.swing.JButton jbtnAdd;
    /**
     * JComboBox koji omogućava izbor lige za utakmicu.
     */
    private javax.swing.JComboBox<League> jcbLeague;
    /**
     * JTextField za unos datuma utakmice u formatu YYYY-MM-DD.
     */
    private javax.swing.JTextField txtGameDate;
    /**
     * JTextField za unos vremena utakmice u formatu HH:mm.
     */
    private javax.swing.JTextField txtGameTime;          

    /**
     * Validira unos u formi.
     * Ova metoda proverava da li su svi obavezni podaci uneti i da li su u ispravnom formatu.
     * 
     * @return true ako je forma validna, false inače
     */
    private boolean validateForm() {
        if (txtGameDate.getText().isEmpty() || txtGameTime.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "You must fill out all the fields on the form.");
        return false;
    }

    if (!isValidDate(txtGameDate.getText())) {
        JOptionPane.showMessageDialog(this, "Game date must be a valid date in the format YYYY-MM-DD.");
        return false;
    }

    if (!isValidTime(txtGameTime.getText())) {
        JOptionPane.showMessageDialog(this, "Game time must be a valid time in the format HH:mm.");
        return false;
    }

    return true;
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
     * Proverava da li je zadato vreme u ispravnom formatu.
     * 
     * @param time vreme u formatu HH:mm
     * @return true ako je vreme validno, false inače
     */
    private boolean isValidTime(String time) {
        try {
            LocalTime.parse(time); // Using Java's built-in time parsing
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Priprema formu za rad.
     * Ova metoda učitava dostupne lige i sudije iz sistema i popunjava odgovarajuće komponente na formi.
     * 
     * @throws Exception ako dođe do greške prilikom pripreme forme
     */
    private void prepareView() throws Exception {
        try {
        
        referees = Communication.getInstance().getAllReferees(new Referee());
        leagues = Communication.getInstance().getAllLeagues(new League());
        
            for (League league : leagues) {
                jcbLeague.addItem(league);
            }
            jcbLeague.setSelectedIndex(0);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Server is not running at the moment\nPlease restart the application after the server is up and running again");
            throw ex;
        }
    }
}

