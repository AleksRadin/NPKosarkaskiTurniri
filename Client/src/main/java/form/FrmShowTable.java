package form;

import communication.Communication;
import domain.League;
import domain.PlayedGame;
import domain.Team;
import domain.TeamStatistic;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import table.TeamTableModel;

/**
 * FrmShowTable je JDialog forma koja se koristi za prikaz i upravljanje tabelom rangiranja timova unutar izabrane lige.
 * Dohvata podatke vezane za timove, statistike i utakmice, i ažurira statistike timova na osnovu izabrane lige.
 * 
 * Ova forma omogućava administratorima da ažuriraju statistike timova 
 * slanjem izmena serveru i omogućava selekciju različitih liga kako bi se filtrirali 
 * relevantni timovi i njihove statistike.
 * 
 * @author Radin
 */
public class FrmShowTable extends javax.swing.JDialog {

	/**
	 * Lista timova relevantnih za trenutno izabranu ligu.
	 */
    List<Team> relevantTeams  = new ArrayList<>();
    /**
     * Lista statistika timova relevantnih za trenutno izabranu ligu.
     */
    List<TeamStatistic> relevantStats = new ArrayList<>();
    /**
     * Lista svih timova dostupnih u sistemu.
     */
    List<Team> teams;
    /**
     * Lista svih statistika timova dostupnih u sistemu.
     */
    List<TeamStatistic> teamStatistics;
    /**
     * Lista svih liga dostupnih u sistemu.
     */
    List<League> leagues;
    /**
     * Lista svih odigranih utakmica dostupnih u sistemu.
     */
    List<PlayedGame> playedGames;
    /**
     * Trenutno izabrana liga za filtriranje timova i statistike.
     */
    League league;
    /**
     * Model tabele koji se koristi za prikaz statistike timova u tabeli.
     */
    private TeamTableModel teamTableModel;
    /**
     * Uloga korisnika koja određuje koje funkcionalnosti su dostupne.
     * Na primer, samo korisnik sa ulogom "administrator" može da vidi dugme za ažuriranje.
     */
    String userRole;
    
    /**
     * Kreira novu FrmShowTable dijalog formu.
     * 
     * @param parent roditeljski okvir ove dijalog forme
     * @param modal određuje da li dijalog blokira unos korisnika u druge prozore
     * @param userRole uloga trenutnog korisnika (npr. "administrator")
     */
    public FrmShowTable(java.awt.Frame parent, boolean modal, String userRole) {
        super(parent, modal);
        this.userRole = userRole;
        initComponents();
        prepareTable();
        
        jbtnUpdate.setVisible("administrator".equals(userRole));
        jcbLeague.addActionListener(e -> onLeagueSelectionChanged());
    }

    /**
     * Ova metoda se poziva iz konstruktora kako bi se inicijalizovao prozor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtnUpdate = new javax.swing.JButton();
        jcbLeague = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jcbLeague, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnUpdate)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbtnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jcbLeague, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    
    /**
     * Ova metoda se poziva kada se klikne na dugme 'Update'.
     * Ažurira statistike relevantnih timova na osnovu izabrane lige.
     * Ako statistika tima već postoji, ažurira je; u suprotnom dodaje novu statistiku.
     * 
     * @param evt događaj akcije kada se klikne na dugme 'Update'
     */
    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {     
            League league = leagues.get(0);

            teamTableModel.updateStatistics(teams, playedGames, league);
            jTable1.setModel(teamTableModel);

            List<TeamStatistic> teamStatNew = teamTableModel.getTeamStatistics();
            
            boolean pass = false;
            
            for (TeamStatistic newStat : teamStatNew) {
                for (TeamStatistic oldTeamStatistic : teamStatistics) {
                    if(newStat.getTeam().getId().equals(oldTeamStatistic.getTeam().getId()) 
                        && newStat.getLeague().getId().equals(oldTeamStatistic.getLeague().getId())){
                            newStat.setId(oldTeamStatistic.getId());
                            System.out.println(oldTeamStatistic.getId());
                            Communication.getInstance().editTeamStat(newStat);
                            pass = true;
                    }
                }
                if(pass == false){
                    Communication.getInstance().addTeamStat(newStat);                   
                }
                pass = false;
            }
                       
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can't update statistics for this tournament.");
            ex.printStackTrace();
        }
    }                                          

   

    /**
     * JScrollPane za prikaz skrolujućeg panela koji sadrži tabelu.
     */              
    private javax.swing.JScrollPane jScrollPane1;
    /**
     * JTable koja prikazuje podatke o timovima i njihovim statistikama.
     */

    private javax.swing.JTable jTable1;
    /**
     * JButton koje se koristi za ažuriranje statistike timova u tabeli.
     */
    private javax.swing.JButton jbtnUpdate;
    /**
     * JComboBox za izbor lige.
     */
    private javax.swing.JComboBox<League> jcbLeague;
                

    
    /**
     * Priprema tabelu učitavanjem svih timova, statistika, liga i odigranih utakmica.
     * Inicijalizuje ligu i popunjava combo box za izbor lige.
     */
    private void prepareTable() {
        
        
        
        
        try {
            teams = Communication.getInstance().getAllTeams(new Team());
            teamStatistics = Communication.getInstance().getAllTeamStats(new TeamStatistic());
            leagues = Communication.getInstance().getAllLeagues(new League());
            playedGames = Communication.getInstance().getAllPlayedGames(new PlayedGame());           
                       
            
            for (League league1 : leagues) {
                jcbLeague.addItem(league1);
            }
            
            jcbLeague.setSelectedItem(null);
                            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Cant find rang list for this tournament");
            ex.printStackTrace();
        }
    }

    /**
     * Metoda koja se poziva kada se promeni izbor lige. 
     * Filtrira timove i njihove statistike na osnovu izabrane lige i 
     * ažurira tabelu sa relevantnim podacima.
     */
    private void onLeagueSelectionChanged() {
         league = (League) jcbLeague.getSelectedItem();
    
        
        relevantTeams.clear();
        relevantStats.clear();

        
        for (Team team : teams) {
            for (PlayedGame playedGame : playedGames) {
                if (playedGame.getHomeTeam().getId().equals(team.getId()) || 
                    playedGame.getAwayTeam().getId().equals(team.getId())) {

                    if (playedGame.getGame().getLeague().getId().equals(league.getId())) {
                        relevantTeams.add(team);
                        break; 
                    }
                }
            }
        }

        
        for (Team relevantTeam : relevantTeams) {
            for (TeamStatistic teamStatistic : teamStatistics) {
                if (relevantTeam.getId().equals(teamStatistic.getTeam().getId())) {
                    teamStatistic.setTeam(relevantTeam);
                    relevantStats.add(teamStatistic);
                    break; 
                }
            }
        }

        // Update the table model with the filtered statistics
        teamTableModel = new TeamTableModel(relevantStats);
        jTable1.setModel(teamTableModel);
    }
}
