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
 * FrmShowPlayerStats je dijalog forma koja omogućava prikaz statistike igrača u okviru odabrane utakmice. Forma nudi mogućnost izbora utakmice, 
 * tima i igrača, kao i pregled i eventualno izmenu statistike igrača za korisnike sa administratorskom rolom.
 * 
 * @author Radin
 */
public class FrmShowPlayerStats extends javax.swing.JDialog {

	/**
     * Lista svih odigranih utakmica.
     */
    List<PlayedGame> playedGames;
    /**
     * Lista svih timova.
     */
    List<Team> teams;
    /**
     * Lista svih igrača.
     */
    List<Player> players;
    /**
     * Statistika za određenog igrača.
     */
    PlayerStatistic playerStats;
    /**
     * Pokazatelj da li je forma u režimu izmene statistike.
     */
    private boolean isEditing = false;
    /**
     * Konstruktor koji inicijalizuje dijalog formu za prikaz statistike igrača.
     * 
     * @param parent nadređeni prozor forme
     * @param modal određuje da li je dijalog modalni
     * @param userRole uloga korisnika, koristi se za kontrolu vidljivosti 
     *                opcija za izmenu
     * @throws Exception u slučaju greške tokom pripreme prikaza
     */
    public FrmShowPlayerStats(java.awt.Frame parent, boolean modal, String userRole) throws Exception {
        super(parent, modal);
        initComponents();
        prepareView();
        jbtnEdit.setVisible("administrator".equals(userRole));
    }

    /**
     * Ova metoda inicijalizuje komponente forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

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
        jtxtMinutesPlayed = new javax.swing.JTextField();
        jtxtSteals = new javax.swing.JTextField();
        jtxtBlocks = new javax.swing.JTextField();
        jtxtPersonalFouls = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcbGames = new javax.swing.JComboBox<>();
        jcbTeams = new javax.swing.JComboBox<>();
        jcbPlayers = new javax.swing.JComboBox<>();
        jbtnGame = new javax.swing.JButton();
        jbtnTeam = new javax.swing.JButton();
        jbtnEdit = new javax.swing.JButton();
        jbtnShowPlayerStats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jtxtMinutesPlayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMinutesPlayedActionPerformed(evt);
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

        jLabel1.setText("Minutes played");

        jLabel2.setText("Points scored");

        jLabel3.setText("Three pointers made");

        jLabel4.setText("Three pointers attempted");

        jLabel5.setText("Free throws attempted");

        jLabel6.setText("Free throws made");

        jLabel7.setText("Rebounds offensive");

        jLabel8.setText("Rebounds defensive");

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

        jbtnEdit.setText("Edit");
        jbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditActionPerformed(evt);
            }
        });

        jbtnShowPlayerStats.setText("Show");
        jbtnShowPlayerStats.setEnabled(false);
        jbtnShowPlayerStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowPlayerStatsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbGames, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGame))
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnTeam))
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnShowPlayerStats))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jtxtThreePointersMade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtMinutesPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnEdit)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGame)
                    .addComponent(jbtnTeam)
                    .addComponent(jbtnShowPlayerStats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtxtSteals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnEdit)
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jtxtBlocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jtxtPersonalFouls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Obrada događaja kada se unesu poeni.
     * 
     * @param evt događaj koji pokreće akciju unosa poena
     */
    private void jtxtPointsScoredActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    /**
     * Obrada događaja kada se unesu pokušaji za tri poena.
     * 
     * @param evt događaj koji pokreće akciju unosa pokušaja za tri poena
     */
    private void jtxtThreePointersAttemptedActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          

    /**
     * Obrada događaja kada se unesu pogođeni slobodni bacanja.
     * 
     * @param evt događaj koji pokreće akciju unosa pogodaka sa slobodnih bacanja
     */
    private void jtxtFreeThrowsMadeActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    /**
     * Obrada događaja kada se unesu pogođeni pokušaji za tri poena.
     * 
     * @param evt događaj koji pokreće akciju unosa pogođenih trojki
     */
    private void jtxtThreePointersMadeActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obrada događaja kada se unesu pokušaji sa slobodnih bacanja.
     * 
     * @param evt događaj koji pokreće akciju unosa pokušaja sa slobodnih bacanja
     */
    private void jtxtFreeThrowsAttemptedActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    /**
     * Obrada događaja kada se unesu ofanzivni skokovi.
     * 
     * @param evt događaj koji pokreće akciju unosa ofanzivnih skokova
     */
    private void jtxtReboundsOffensiveActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obrada događaja kada se unesu defanzivni skokovi.
     * 
     * @param evt događaj koji pokreće akciju unosa defanzivnih skokova
     */
    private void jtxtReboundsDefensiveActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * Obrada događaja kada se unesu asistencije.
     * 
     * @param evt događaj koji pokreće akciju unosa asistencija
     */
    private void jtxtAssistsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * Obrada događaja kada se unesu minute igre.
     * 
     * @param evt događaj koji pokreće akciju unosa minuta igre
     */
    private void jtxtMinutesPlayedActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /**
     * Obrada događaja kada se unesu ukradene lopte.
     * 
     * @param evt događaj koji pokreće akciju unosa ukradenih lopti
     */
    private void jtxtStealsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * Obrada događaja kada se unesu blokade.
     * 
     * @param evt događaj koji pokreće akciju unosa blokada
     */

    private void jtxtBlocksActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    /**
     * Obrada događaja kada se unesu lične greške.
     * 
     * @param evt događaj koji pokreće akciju unosa ličnih grešaka
     */
    private void jtxtPersonalFoulsActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    /**
     * Obrada događaja kada se izabere utakmica iz padajuće liste.
     * 
     * @param evt događaj koji pokreće akciju izbora utakmice
     */
    private void jcbGamesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * Upravlja akcijom pritiska dugmeta za odabir igre.
     * Očisti postojeće stavke iz JComboBox-ova za timove i igrače, 
     * omogući izbor tima i onemogući izbor igrača.
     * Popunjava JComboBox timova na osnovu odabrane igre.
     * 
     * @param evt dogadjaj pritiska dugmeta
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
     * Upravlja akcijom pritiska dugmeta za odabir tima.
     * Očisti postojeće stavke iz JComboBox-a za igrače, 
     * omogući izbor igrača i omogući dugme za prikaz statistike igrača.
     * Popunjava JComboBox igrača na osnovu odabranog tima.
     * 
     * @param evt dogadjaj pritiska dugmeta
     */
    private void jbtnTeamActionPerformed(java.awt.event.ActionEvent evt) {                                         

        jcbPlayers.removeAllItems();
        jcbPlayers.setEnabled(true);
        jbtnShowPlayerStats.setEnabled(true);
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
     * Upravlja akcijom pritiska dugmeta za prikaz statistike igrača.
     * Preuzima statistiku za odabranog igrača u odabranoj igri 
     * i prikazuje je u odgovarajućim tekstualnim poljima.
     * Ako statistika ne postoji, prikazuje odgovarajuću poruku.
     * 
     * @param evt dogadjaj pritiska dugmeta
     */
    private void jbtnShowPlayerStatsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        Player player = (Player) jcbPlayers.getSelectedItem();
        Game game = (Game) jcbGames.getSelectedItem();
        PlayerStatistic playerStatistic = new PlayerStatistic();
        playerStatistic.setGame(game);
        playerStatistic.setPlayer(player);
        
        try {           
            playerStats = Communication.getInstance().getPlayerStats(playerStatistic);
            
            if (playerStats != null) {
                jtxtMinutesPlayed.setText(String.valueOf(playerStats.getMinutesPlayed()));
                jtxtPointsScored.setText(String.valueOf(playerStats.getPointsScored()));
                jtxtThreePointersAttempted.setText(String.valueOf(playerStats.getThreePointersAttempted()));
                jtxtThreePointersMade.setText(String.valueOf(playerStats.getThreePointersMade()));
                jtxtFreeThrowsAttempted.setText(String.valueOf(playerStats.getFreeThrowsAttempted()));
                jtxtFreeThrowsMade.setText(String.valueOf(playerStats.getFreeThrowsMade()));
                jtxtReboundsOffensive.setText(String.valueOf(playerStats.getReboundsOffensive()));
                jtxtReboundsDefensive.setText(String.valueOf(playerStats.getReboundsDefensive()));
                jtxtAssists.setText(String.valueOf(playerStats.getAssists()));
                jtxtSteals.setText(String.valueOf(playerStats.getSteals()));
                jtxtBlocks.setText(String.valueOf(playerStats.getBlocks()));
                jtxtPersonalFouls.setText(String.valueOf(playerStats.getPersonalFouls()));
            } else {
                
                JOptionPane.showMessageDialog(this, "No statistics available for the selected player and game.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to retrieve player statistics. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                   

    /**
     * Upravlja akcijom pritiska dugmeta za izmenu statistike igrača.
     * Ako je u modu za izmenu, omogućava unos podataka u polja i postavlja dugme za čuvanje.
     * Ako nije u modu za izmenu, proverava unos i čuva izmenjenu statistiku.
     * 
     * @param evt dogadjaj pritiska dugmeta
     */
    private void jbtnEditActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (!isEditing) {
            
            enableInputFields(true);
            jbtnEdit.setText("Save");
            jbtnGame.setEnabled(false);
            jbtnTeam.setEnabled(false);
            jbtnShowPlayerStats.setEnabled(false);
            jcbTeams.setEnabled(false);
            jcbGames.setEnabled(false);
            jcbPlayers.setEnabled(false);
        } else {           
            try {                
                PlayerStatistic playerStatistic = createPlayerStatisticFromInput();
                Communication.getInstance().editPlayerStats(playerStatistic);
                enableInputFields(false);
                jbtnEdit.setText("Edit"); 
                jbtnGame.setEnabled(true);
                jbtnTeam.setEnabled(true);
                jbtnShowPlayerStats.setEnabled(true);
                jcbTeams.setEnabled(true);
                jcbGames.setEnabled(true);
                jcbPlayers.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Operation Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
        isEditing = !isEditing;
    }                                        

    

    /**
     * JLabel koja prikazuje oznaku za minutažu
     */              
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel koja prikazuje oznaku za ukradene lopte
     */    
    private javax.swing.JLabel jLabel10;
    /**
     * JLabel koja prikazuje oznaku za blokove
     */    
    private javax.swing.JLabel jLabel11;
    /**
     * JLabel koja prikazuje oznaku za lične greške
     */    
    private javax.swing.JLabel jLabel12;
    /**
     * JLabel koja prikazuje oznaku za ostvarene poene
     */    
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel koja prikazuje oznaku za ostvarene trojke
     */    
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel koja prikazuje oznaku za pokušane trojke
     */    
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel koja prikazuje oznaku za ostvarena slobodna
     */    
    private javax.swing.JLabel jLabel5;
    /**
     * JLabel koja prikazuje oznaku za pokušana slobodna
     */    
    private javax.swing.JLabel jLabel6;
    /**
     * JLabel koja prikazuje oznaku za skokove u napadu
     */    
    private javax.swing.JLabel jLabel7;
    /**
     * JLabel koja prikazuje oznaku za skokove u odbrani
     */    
    private javax.swing.JLabel jLabel8;
    /**
     * JLabel koja prikazuje oznaku za asistencije
     */    
    private javax.swing.JLabel jLabel9;
    /**
     * JButton za izmenu podataka o igraču.
     */    
    private javax.swing.JButton jbtnEdit;
    /**
     * JButton za odabir igre.
     */
    private javax.swing.JButton jbtnGame;
    /**
     * JButton za prikaz statistike igrača.
     */
    private javax.swing.JButton jbtnShowPlayerStats;
    /**
     * JButton za odabir tima.
     */
    private javax.swing.JButton jbtnTeam;
    /**
     * JButton za odabir tima.
     */
    private javax.swing.JComboBox<Game> jcbGames;
    /**
     * JComboBox za odabir igrača.
     */
    private javax.swing.JComboBox<Player> jcbPlayers;
    /**
     * JComboBox za odabir tima.
     */
    private javax.swing.JComboBox<Team> jcbTeams;
    /**
     * JTextField za unos broja asistencija.
     */
    private javax.swing.JTextField jtxtAssists;
    /**
     * JTextField za unos broja blokada.
     */
    private javax.swing.JTextField jtxtBlocks;
    /**
     * JTextField za unos broja pokušaja slobodnih bacanja.
     */
    private javax.swing.JTextField jtxtFreeThrowsAttempted;
    /**
     * JTextField za unos broja postignutih slobodnih bacanja.
     */
    private javax.swing.JTextField jtxtFreeThrowsMade;
    /**
     * JTextField za unos broja odigranih minuta.
     */
    private javax.swing.JTextField jtxtMinutesPlayed;
    /**
     * JTextField za unos broja ličnih grešaka.
     */
    private javax.swing.JTextField jtxtPersonalFouls;
    /**
     * JTextField za unos broja postignutih poena.
     */
    private javax.swing.JTextField jtxtPointsScored;
    /**
     * JTextField za unos broja defanzivnih skokova.
     */
    private javax.swing.JTextField jtxtReboundsDefensive;
    /**
     * JTextField za unos broja ofanzivnih skokova.
     */
    private javax.swing.JTextField jtxtReboundsOffensive;
    /**
     * JTextField za unos broja ukradenih lopti.
     */
    private javax.swing.JTextField jtxtSteals;
    /**
     * JTextField za unos broja pokušaja trojki.
     */
    private javax.swing.JTextField jtxtThreePointersAttempted;
    /**
     * JTextField za unos broja postignutih trojki.
     */
    private javax.swing.JTextField jtxtThreePointersMade;                

    /**
     * Priprema inicijalni prikaz forme.
     * Preuzima sve odigrane igre, timove i igrače, te popunjava 
     * JComboBox igara dostupnim podacima.
     * 
     * @throws Exception ako dodje do greške prilikom preuzimanja podataka
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
        
        enableInputFields(false);
   
    }
    
    /**
     * Čisti sva tekstualna polja u formi.
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
     * Proverava da li je prosleđeni tekst pozitivan broj.
     * 
     * @param text tekst koji se proverava
     * @return true ako je broj pozitivan, false inače
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
     * Validira da li su sva prosleđena polja popunjena i da li su pozitivni brojevi.
     * 
     * @param fields lista stringova koji se proveravaju
     * @return true ako su svi uslovi zadovoljeni, false inače
     */
    private boolean validateFields(String... fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        for (String field : fields) {
            if (!isPositiveNumber(field)) {
                JOptionPane.showMessageDialog(this, "All numerical fields must be positive numbers!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    
    /**
     * Omogućava ili onemogućava unos podataka u tekstualna polja.
     * 
     * @param enable true za omogućavanje unosa, false za onemogućavanje
     */
    private void enableInputFields(boolean enable) {
        jtxtMinutesPlayed.setEnabled(enable);
        jtxtPointsScored.setEnabled(enable);
        jtxtThreePointersAttempted.setEnabled(enable);
        jtxtFreeThrowsMade.setEnabled(enable);
        jtxtThreePointersMade.setEnabled(enable);
        jtxtFreeThrowsAttempted.setEnabled(enable);
        jtxtReboundsOffensive.setEnabled(enable);
        jtxtReboundsDefensive.setEnabled(enable);
        jtxtAssists.setEnabled(enable);
        jtxtSteals.setEnabled(enable);
        jtxtBlocks.setEnabled(enable);
        jtxtPersonalFouls.setEnabled(enable);
    }
    
    /**
     * Kreira i vraća objekat PlayerStatistic na osnovu unetih podataka u polja forme.
     * 
     * @return novi objekat klase PlayerStatistic
     * @throws NumberFormatException ako uneti podaci nisu ispravni brojevi
     */
    private PlayerStatistic createPlayerStatisticFromInput() throws NumberFormatException {
        int minutesPlayed = Integer.parseInt(jtxtMinutesPlayed.getText());
        int pointsScored = Integer.parseInt(jtxtPointsScored.getText());
        int threePointersAttempted = Integer.parseInt(jtxtThreePointersAttempted.getText());
        int freeThrowsMade = Integer.parseInt(jtxtFreeThrowsMade.getText());
        int threePointersMade = Integer.parseInt(jtxtThreePointersMade.getText());
        int freeThrowsAttempted = Integer.parseInt(jtxtFreeThrowsAttempted.getText());
        int reboundsOffensive = Integer.parseInt(jtxtReboundsOffensive.getText());
        int reboundsDefensive = Integer.parseInt(jtxtReboundsDefensive.getText());
        int assists = Integer.parseInt(jtxtAssists.getText());
        int steals = Integer.parseInt(jtxtSteals.getText());
        int blocks = Integer.parseInt(jtxtBlocks.getText());
        int personalFouls = Integer.parseInt(jtxtPersonalFouls.getText());

        
        return new PlayerStatistic(playerStats.getId(), (Player)jcbPlayers.getSelectedItem(), (Game)jcbGames.getSelectedItem(), minutesPlayed, pointsScored, threePointersMade, threePointersAttempted, freeThrowsMade, freeThrowsAttempted, reboundsOffensive, reboundsDefensive, assists, steals, blocks, personalFouls);
    }
}
