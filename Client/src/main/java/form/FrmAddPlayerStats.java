package form;

import communication.Communication;
import domain.Game;
import domain.PlayedGame;
import domain.Player;
import domain.PlayerStatistic;
import domain.Team;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * FrmAddPlayerStats je forma za dodavanje statistike igrača za odabranu igru, tim i igrača.
 * Ova klasa pruža korisnički interfejs za unos statistike kao što su minuti igranja, poeni, trojke, slobodna bacanja i druge statistike.
 * 
 * @author Radin
 */
public class FrmAddPlayerStats extends javax.swing.JDialog {

	/**
	 * Lista svih odigranih utakmica. Ova lista se koristi za prikaz i selekciju utakmica u okviru forme za unos statistike igrača.
	 */
    List<PlayedGame> playedGames;
    /**
     * Lista svih timova. Ova lista se koristi za prikaz i selekciju timova u okviru forme za unos statistike igrača.
     */
    List<Team> teams;
    /**
     * Lista svih igrača. Ova lista se koristi za prikaz i selekciju igrača u okviru forme za unos statistike igrača.
     */
    List<Player> players;
    
    /**
     * Kreira novu formu za dodavanje statistike igrača.
     * 
     * @param parent Glavni prozor aplikacije
     * @param modal Ako je dijalog modalni
     * @throws Exception Ako dođe do greške pri inicijalizaciji
     */
    public FrmAddPlayerStats(java.awt.Frame parent, boolean modal) throws Exception {
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

        jcbGames = new javax.swing.JComboBox<>();
        jcbTeams = new javax.swing.JComboBox<>();
        jcbPlayers = new javax.swing.JComboBox<>();
        jbtnGame = new javax.swing.JButton();
        jbtnTeam = new javax.swing.JButton();
        jtxtMinutesPlayed = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtPointsScored = new javax.swing.JTextField();
        jtxtThreePointersAttempted = new javax.swing.JTextField();
        jtxtFreeThrowsMade = new javax.swing.JTextField();
        jtxtThreePointersMade = new javax.swing.JTextField();
        jtxtFreeThrowsAttempted = new javax.swing.JTextField();
        jtxtReboundsOffensive = new javax.swing.JTextField();
        jtxtReboundsDefensive = new javax.swing.JTextField();
        jtxtAssists = new javax.swing.JTextField();
        jtxtSteals = new javax.swing.JTextField();
        jtxtBlocks = new javax.swing.JTextField();
        jtxtPersonalFouls = new javax.swing.JTextField();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGamesActionPerformed(evt);
            }
        });

        jcbTeams.setEnabled(false);

        jcbPlayers.setEnabled(false);

        jbtnGame.setText("Choose");
        jbtnGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGameActionPerformed(evt);
            }
        });

        jbtnTeam.setText("Choose");
        jbtnTeam.setEnabled(false);
        jbtnTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTeamActionPerformed(evt);
            }
        });

        jtxtMinutesPlayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMinutesPlayedActionPerformed(evt);
            }
        });

        jLabel1.setText("Minutes played");

        jLabel2.setText("Points scored");

        jLabel3.setText("Three pointers made");

        jLabel4.setText("Three pointers attempted");

        jLabel5.setText("Free throws attempted");

        jLabel6.setText("Free throws made");

        jLabel7.setText("Rebounds offensive");

        jLabel8.setText("Rebounds defensive");

        jLabel9.setText("Assists");

        jLabel10.setText("Steals");

        jLabel11.setText("Blocks");

        jLabel12.setText("Personal fouls");

        jtxtPointsScored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPointsScoredActionPerformed(evt);
            }
        });

        jtxtThreePointersAttempted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtThreePointersAttemptedActionPerformed(evt);
            }
        });

        jtxtFreeThrowsMade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFreeThrowsMadeActionPerformed(evt);
            }
        });

        jtxtThreePointersMade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtThreePointersMadeActionPerformed(evt);
            }
        });

        jtxtFreeThrowsAttempted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFreeThrowsAttemptedActionPerformed(evt);
            }
        });

        jtxtReboundsOffensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtReboundsOffensiveActionPerformed(evt);
            }
        });

        jtxtReboundsDefensive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtReboundsDefensiveActionPerformed(evt);
            }
        });

        jtxtAssists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAssistsActionPerformed(evt);
            }
        });

        jtxtSteals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStealsActionPerformed(evt);
            }
        });

        jtxtBlocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBlocksActionPerformed(evt);
            }
        });

        jtxtPersonalFouls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtPersonalFoulsActionPerformed(evt);
            }
        });

        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbGames, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnGame))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnTeam))
                        .addGap(123, 123, 123)
                        .addComponent(jcbPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(84, 84, 84)
                                .addComponent(jtxtMinutesPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtxtPersonalFouls, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtSteals, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtAssists, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtReboundsDefensive, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtReboundsOffensive, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtFreeThrowsAttempted, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtFreeThrowsMade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtThreePointersAttempted, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtPointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtxtThreePointersMade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSave)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGame)
                    .addComponent(jbtnTeam))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtMinutesPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtPointsScored, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtThreePointersMade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtThreePointersAttempted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtFreeThrowsMade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtFreeThrowsAttempted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtReboundsOffensive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtReboundsDefensive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtxtAssists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtxtSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jtxtBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtPersonalFouls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSave))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Obavlja radnje koje treba da se izvrše kada se odabere igra iz liste igara.
     * 
     * @param evt Dogadjaj kada se odabere igra
     */
    private void jcbGamesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * Obavlja radnje koje treba da se izvrše kada se unesu minuti igranja.
     * 
     * @param evt Dogadjaj kada se unesu minuti igranja
     */
    private void jtxtMinutesPlayedActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj poena.
     * 
     * @param evt Dogadjaj kada se unese broj poena
     */
    private void jtxtPointsScoredActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    /**
	 * Obavlja radnje koje treba da se izvrše kada se unese broj trojki pokušanih.
	 * 
	 * @param evt Dogadjaj kada se unese broj trojki pokušanih
	 */
    private void jtxtThreePointersAttemptedActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj slobodnih bacanja postignutih.
     * 
     * @param evt Dogadjaj kada se unese broj slobodnih bacanja postignutih
     */
    private void jtxtFreeThrowsMadeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj trojki postignutih.
     * 
     * @param evt Dogadjaj kada se unese broj trojki postignutih
     */
    private void jtxtThreePointersMadeActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj slobodnih bacanja pokušanih.
     * 
     * @param evt Dogadjaj kada se unese broj slobodnih bacanja pokušanih
     */
    private void jtxtFreeThrowsAttemptedActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj ofanzivnih skokova.
     * 
     * @param evt Dogadjaj kada se unese broj ofanzivnih skokova
     */
    private void jtxtReboundsOffensiveActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj defanzivnih skokova.
     * 
     * @param evt Dogadjaj kada se unese broj defanzivnih skokova
     */
    private void jtxtReboundsDefensiveActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj asistencija.
     * 
     * @param evt Dogadjaj kada se unese broj asistencija
     */
    private void jtxtAssistsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj ukradenih lopti.
     * 
     * @param evt Dogadjaj kada se unese broj ukradenih lopti
     */
    private void jtxtStealsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj blokada.
     * 
     * @param evt Dogadjaj kada se unese broj blokada
     */
    private void jtxtBlocksActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * Obavlja radnje koje treba da se izvrše kada se unese broj ličnih grešaka.
     * 
     * @param evt Dogadjaj kada se unese broj ličnih grešaka
     */
    private void jtxtPersonalFoulsActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /**
     * Obavlja radnje koje treba da se izvrše kada se klikne na dugme za izbor igre.
     * Od kojih je najbitnija da popunjava jcbTeams sa timovima za tu utakmicu
     * 
     * @param evt Dogadjaj kada se klikne na dugme za izbor igre
     */
    private void jbtnGameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        jcbTeams.removeAllItems();
        jcbPlayers.removeAllItems();
        jbtnTeam.setEnabled(true);
        jcbTeams.setEnabled(true);
        jcbPlayers.setEnabled(false);
        clearTextFields();
        
        Game game = (Game) jcbGames.getSelectedItem();
        Set<Long> addedTeamIds = new HashSet<>();
        
        for (Team team : teams) {
            for (PlayedGame playedGame : playedGames) {
                if(playedGame.getGame().getId().equals(game.getId()) && 
                    (playedGame.getHomeTeam().getId().equals(team.getId()) || playedGame.getAwayTeam().getId().equals(team.getId()))){
                    if (!addedTeamIds.contains(team.getId())) {
                        jcbTeams.addItem(team);
                        addedTeamIds.add(team.getId());
                    }
                     break;
                }
            }
        }
    }                                        

    /**
     * Obavlja radnje koje treba da se izvrše kada se klikne na dugme za izbor tima.
     * Od kojih je najvažnija je da popunjava jcbPlazers sa igračima iz tog tima
     * 
     * @param evt Dogadjaj kada se klikne na dugme za izbor tima
     */
    private void jbtnTeamActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        jcbPlayers.removeAllItems();
        jcbPlayers.setEnabled(true);
        clearTextFields();

        Team team = (Team) jcbTeams.getSelectedItem();
        Set<Long> addedPlayerIds = new HashSet<>();
        
        for (Player player : players) {
            if(player.getTeam().getId().equals(team.getId())){
                if (!addedPlayerIds.contains(player.getId())) {
                        jcbPlayers.addItem(player);
                        addedPlayerIds.add(player.getId());
                    }
            }
        }
    }                                        

    /**
     * Obavlja radnje koje treba da se izvrše kada se klikne na dugme za čuvanje podataka.
     * 
     * Event handler za dugme "Sačuvaj". Validira unos, kreira novu statistiku igrača i
     * dodaje je kroz komunikaciju sa serverom.
     * 
     * @param evt Dogadjaj kada se klikne na dugme za čuvanje podataka
     */
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        
        String minutesPlayedText = jtxtMinutesPlayed.getText().trim();
        String pointsScoredText = jtxtPointsScored.getText().trim();
        String threePointersAttemptedText = jtxtThreePointersAttempted.getText().trim();
        String freeThrowsMadeText = jtxtFreeThrowsMade.getText().trim();
        String threePointersMadeText = jtxtThreePointersMade.getText().trim();
        String freeThrowsAttemptedText = jtxtFreeThrowsAttempted.getText().trim();
        String reboundsOffensiveText = jtxtReboundsOffensive.getText().trim();
        String reboundsDefensiveText = jtxtReboundsDefensive.getText().trim();
        String assistsText = jtxtAssists.getText().trim();
        String stealsText = jtxtSteals.getText().trim();
        String blocksText = jtxtBlocks.getText().trim();
        String personalFoulsText = jtxtPersonalFouls.getText().trim();
        
        
        Game selectedGame = (Game) jcbGames.getSelectedItem();
        Player selectedPlayer = (Player) jcbPlayers.getSelectedItem();
        
        if(selectedGame == null || selectedPlayer == null){
            JOptionPane.showMessageDialog(this, "Please make all selections!", "Validation Error", JOptionPane.ERROR_MESSAGE); 
            return;
        }
        
        if (!validateFields(minutesPlayedText, pointsScoredText, threePointersAttemptedText, 
                        freeThrowsMadeText, threePointersMadeText, freeThrowsAttemptedText,
                        reboundsOffensiveText, reboundsDefensiveText, assistsText,
                        stealsText, blocksText, personalFoulsText)) {
            return;
        }
        
        

        
        int minutesPlayed = Integer.parseInt(minutesPlayedText);
        int pointsScored = Integer.parseInt(pointsScoredText);
        int threePointersAttempted = Integer.parseInt(threePointersAttemptedText);
        int freeThrowsMade = Integer.parseInt(freeThrowsMadeText);
        int threePointersMade = Integer.parseInt(threePointersMadeText);
        int freeThrowsAttempted = Integer.parseInt(freeThrowsAttemptedText);
        int reboundsOffensive = Integer.parseInt(reboundsOffensiveText);
        int reboundsDefensive = Integer.parseInt(reboundsDefensiveText);
        int assists = Integer.parseInt(assistsText);
        int steals = Integer.parseInt(stealsText);
        int blocks = Integer.parseInt(blocksText);
        int personalFouls = Integer.parseInt(personalFoulsText);
        
        PlayerStatistic playerStatistic = new PlayerStatistic(
            null, 
            selectedPlayer,
            selectedGame,
            minutesPlayed,
            pointsScored,
            threePointersMade,
            threePointersAttempted,
            freeThrowsMade,
            freeThrowsAttempted,
            reboundsOffensive,
            reboundsDefensive,
            assists,
            steals,
            blocks,
            personalFouls
        );
        
        try {
            Communication.getInstance().addPlayerStats(playerStatistic);
            
            jcbTeams.removeAllItems();
            jcbTeams.setEnabled(false);
            jcbPlayers.removeAllItems();
            jbtnTeam.setEnabled(false);        
            jcbPlayers.setEnabled(false);
            clearTextFields();
        } catch (Exception ex) {
            Logger.getLogger(FrmAddPlayerStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }                                        

    
    
    /**
     * 	JLabel koja označava polje za odigrane minute     
     */
    private javax.swing.JLabel jLabel1;
    /**
     * 	JLabel koja označava polje za ukradene lopte    
     */
    private javax.swing.JLabel jLabel10;
    /**
     * 	JLabel koja označava polje za blokove
     */
    private javax.swing.JLabel jLabel11;
    /**
     * 	JLabel koja označava polje za lične prekršaje     
     */
    private javax.swing.JLabel jLabel12;
    /**
     * 	JLabel koja označava polje za ostvarene poene   
     */
    private javax.swing.JLabel jLabel2;
    /**
     * 	JLabel koja označava polje za ostvarene trojke 
     */
    private javax.swing.JLabel jLabel3;
    /**
     * 	JLabel koja označava polje za pokušane trojke  
     */
    private javax.swing.JLabel jLabel4;
    /**
     * 	JLabel koja označava polje za pokušana slobodna  
     */
    private javax.swing.JLabel jLabel5;
    /**
     * 	JLabel koja označava polje za uspešna slobodna
     */
    private javax.swing.JLabel jLabel6;
    /**
     * 	JLabel koja označava polje za skokove u napadu 
     */
    private javax.swing.JLabel jLabel7;
    /**
     * 	JLabel koja označava polje za skokove u odbrani 
     */
    private javax.swing.JLabel jLabel8;
    /**
     * 	JLabel koja označava polje za asistencije  
     */
    private javax.swing.JLabel jLabel9;
    /**
     * JButton za izbor igre.
     */
    private javax.swing.JButton jbtnGame;
    /**
     * JButton za čuvanje podataka.
     */
    private javax.swing.JButton jbtnSave;
    /**
     * JButton za izbor tima.
     */
    private javax.swing.JButton jbtnTeam;
    /**
     * JComboBox za izbor igre.
     */
    private javax.swing.JComboBox<Game> jcbGames;
    /**
     * JComboBox za izbor igrača.
     */
    private javax.swing.JComboBox<Player> jcbPlayers;
    /**
     * JComboBox za izbor tima.
     */
    private javax.swing.JComboBox<Team> jcbTeams;
    /**
     * JTextField za unos asistencija.
     */
    private javax.swing.JTextField jtxtAssists;
    /**
     * JTextField za unos blokada.
     */
    private javax.swing.JTextField jtxtBlocks;
    /**
     * JTextField za unos pokušaja slobodnih bacanja.
     */
    private javax.swing.JTextField jtxtFreeThrowsAttempted;
    /**
     * JTextField za unos izvedenih slobodnih bacanja.
     */
    private javax.swing.JTextField jtxtFreeThrowsMade;
    /**
     * JTextField za unos minuta igranih u igri.
     */
    private javax.swing.JTextField jtxtMinutesPlayed;
    /**
     * JTextField za unos ličnih grešaka.
     */
    private javax.swing.JTextField jtxtPersonalFouls;
    /**
     * JTextField za unos bodova.
     */
    private javax.swing.JTextField jtxtPointsScored;
    /**
     * JTextField za unos defanzivnih skokova.
     */
    private javax.swing.JTextField jtxtReboundsDefensive;
    /**
     * JTextField za unos ofanzivnih skokova.
     */
    private javax.swing.JTextField jtxtReboundsOffensive;
    /**
     * JTextField za unos ukradenih lopti.
     */
    private javax.swing.JTextField jtxtSteals;
    /**
     * JTextField za unos pokušaja trojki.
     */
    private javax.swing.JTextField jtxtThreePointersAttempted;
    /**
     * JTextField za unos postignutih trojki.
     */
    private javax.swing.JTextField jtxtThreePointersMade;                 

    
    /**
     * Priprema prikaz za učitavanje igara, timova i igrača.
     * 
     * @throws Exception Ako dođe do greške prilikom učitavanja podataka
     */
    private void prepareView() throws Exception {
        
        playedGames = Communication.getInstance().getAllPlayedGames(new PlayedGame());
        teams = Communication.getInstance().getAllTeams(new Team());
        players = Communication.getInstance().getAllPlayers(new Player());
        
        Set<Long> addedGameIds = new HashSet<>();
        
        List<Game> games = Communication.getInstance().getAllGames(new Game());
        for (Game game : games) {
            for (PlayedGame playedGame : playedGames) {
                if (!addedGameIds.contains(game.getId())) {
                    jcbGames.addItem(game);
                    addedGameIds.add(game.getId());
                }
                break;
            }
        }
   
    }
    
    /**
     * Čisti sve tekstualne polja u formi.
     */
    private void clearTextFields() {
        jtxtMinutesPlayed.setText("");
        jtxtPointsScored.setText("");
        jtxtThreePointersMade.setText("");
        jtxtThreePointersAttempted.setText("");
        jtxtFreeThrowsMade.setText("");
        jtxtFreeThrowsAttempted.setText("");
        jtxtReboundsOffensive.setText("");
        jtxtReboundsDefensive.setText("");
        jtxtAssists.setText("");
        jtxtSteals.setText("");
        jtxtBlocks.setText("");
        jtxtPersonalFouls.setText("");
    }
    
    /**
     * Proverava da li je dati tekst pozitivan broj.
     * 
     * @param text Tekst koji treba proveriti
     * @return true ako je tekst pozitivan broj, false inače
     */
    private boolean isPositiveNumber(String text) {
        try {
            double value = Double.parseDouble(text);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Validira unesene podatke iz više tekstualnih polja.
     * 
     * @param fields Tekstualna polja koja treba da se validiraju
     * @return true ako su svi podaci validni, false inače
     */
    private boolean validateFields(String... fields) {
        // Check if any field is empty
        for (String field : fields) {
            if (field.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Check if all fields are positive numbers
        for (String field : fields) {
            if (!isPositiveNumber(field)) {
                JOptionPane.showMessageDialog(this, "All numerical fields must be positive numbers!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
}
