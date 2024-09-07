package form;

import communication.Communication;
import domain.Game;
import domain.PlayedGame;
import domain.Team;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FrmAddResult je forma za unos rezultata igre između dva tima u sistem. 
 * Omogućava  korisniku da izabere igru, timove (domaći i gostujući) i unese broj poena koje su timovi postigli. 
 * Forma takođe vrši validaciju unesenih podataka pre nego što ih pošalje sistemu i obavještava korisnika o eventualnim greškama ili uspešno izvršenoj operaciji.
 * 
 * @author Radin
 */
public class FrmAddResult extends javax.swing.JDialog {

	/**
     * Kreira novu instancu forme za unos rezultata igre.
     * 
     * @param parent Glavni prozor aplikacije.
     * @param modal Ako je true, forma je modalna.
     * @throws Exception Ako dođe do greške pri inicijalizaciji.
     */
    public FrmAddResult(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        prepareView();
    }

    /**
     * Inicijalizuje formu
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtHomeTP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbtnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbcTeamH = new javax.swing.JComboBox<>();
        jbcGame1 = new javax.swing.JComboBox<>();
        jbcTeamA = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtAwayTP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Game:");

        jLabel2.setText("Home team:");

        jbtnAdd.setText("Add");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jLabel3.setText("Away team:");

        jLabel4.setText("home team points:");

        jLabel5.setText("away team points:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbcTeamA, 0, 168, Short.MAX_VALUE)
                    .addComponent(jbcGame1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbcTeamH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHomeTP)
                    .addComponent(txtAwayTP))
                .addGap(0, 152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnAdd)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jbcGame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbcTeamH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jbcTeamA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtHomeTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAwayTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jbtnAdd)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Event handler za dugme "Add". Validira unos, kreira novu statistiku igre
     * i dodaje je kroz komunikaciju sa serverom.
     * 
     * @param evt Dogadjaj kada se klikne na dugme "Add"
     */
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {                                        
        try {
        if (validateForm()) {
            
            
            List<PlayedGame> playedGames = Communication.getInstance().getAllPlayedGames(new PlayedGame());
            
            
            
            Game selectedGame = (Game) jbcGame1.getSelectedItem();
            if (selectedGame == null) {
                JOptionPane.showMessageDialog(this, "Please select a game.");
                return;
            }
            
            
            Team homeTeam = (Team) jbcTeamH.getSelectedItem();
            Team awayTeam = (Team) jbcTeamA.getSelectedItem();
            
            
            if (homeTeam == null || awayTeam == null) {
                JOptionPane.showMessageDialog(this, "Please select both home and away teams.");
                return;
            }
            
            
            for (PlayedGame playedGame : playedGames) {
                if(playedGame.getHomeTeam().getId().equals(homeTeam.getId()) && 
                        playedGame.getAwayTeam().getId().equals(awayTeam.getId()) && 
                        playedGame.getGame().getId().equals(selectedGame.getId())){
                    JOptionPane.showMessageDialog(this, "This result already exist");
                    return;
                }
            }
            
            
            int homeTeamPoints = Integer.parseInt(txtHomeTP.getText().trim());
            int awayTeamPoints = Integer.parseInt(txtAwayTP.getText().trim());
             
            
            
            PlayedGame playedGame = new PlayedGame();
            playedGame.setGame(selectedGame);
            playedGame.setHomeTeam(homeTeam);
            playedGame.setAwayTeam(awayTeam);
            playedGame.setHomeTeamPoints(homeTeamPoints);
            playedGame.setAwayTeamPoints(awayTeamPoints);
            
            
            Communication.getInstance().addPlayedGame(playedGame);
            
            JOptionPane.showMessageDialog(this, "PlayedGame successfully added.");
            this.dispose(); 
        }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid points (numeric values).");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                       

    

                
    /**
     * JLabel za prikaz oznake za igru.
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel za prikaz oznake za domaći tim.
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za prikaz oznake za gostujući tim.
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za prikaz oznake za broj poena domaćeg tima.
     */	
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel za prikaz oznake za broj poena gostujućeg tima.
     */
    private javax.swing.JLabel jLabel5;
    /**
     * JComboBox za izbor igre.
     */
    private javax.swing.JComboBox<Game> jbcGame1;
    /**
     * JComboBox za izbor gostujućeg tima.
     */
    private javax.swing.JComboBox<Team> jbcTeamA;
    /**
     * JComboBox za izbor domaćeg tima.
     */
    private javax.swing.JComboBox<Team> jbcTeamH;
    /**
     * JButton za dodavanje rezultata igre.
     */
    private javax.swing.JButton jbtnAdd;
    /**
     * JTextField za unos broja poena koje je postigao domaći tim.
     */
    private javax.swing.JTextField txtAwayTP;
    /**
     * JTextField za unos broja poena koje je postigao gostujući tim.
     */
    private javax.swing.JTextField txtHomeTP;
                 

    /**
     * Priprema vidljivost forme. Učitava podatke o igrama i timovima iz komunikacije sa serverom.
     * 
     * @throws Exception Ako dođe do greške pri komunikaciji sa serverom.
     */
    private void prepareView() throws Exception {
        try {
            
        List<PlayedGame> playedGames = Communication.getInstance().getAllPlayedGames(new PlayedGame());
            
  
        
        List<Game> games = Communication.getInstance().getAllGames(new Game());
            for (Game game : games) {
                jbcGame1.addItem(game);
            }

        
        List<Team> teams = Communication.getInstance().getAllTeams(new Team());
        for (Team team : teams) {
            jbcTeamA.addItem(team);
            jbcTeamH.addItem(team);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Server is not running at the moment\nPlease restart the application after the server is up and running again");
            throw ex;
        }
    }

    /**
     * Validira unos u formi. Proverava da li su uneti brojevi poena validni i da li nisu negativni.
     * 
     * @return true ako su svi uslovi zadovoljeni, false inače.
     */
    private boolean validateForm() {
      try {
        int homeTeamPoints = Integer.parseInt(txtHomeTP.getText().trim());
        int awayTeamPoints = Integer.parseInt(txtAwayTP.getText().trim());
        
        if (homeTeamPoints < 0 || awayTeamPoints < 0) {
                JOptionPane.showMessageDialog(this, "Points cannot be negative.");
                return false;
        }
        
        return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid points (numeric values).");
            return false;
        }
    }
}
