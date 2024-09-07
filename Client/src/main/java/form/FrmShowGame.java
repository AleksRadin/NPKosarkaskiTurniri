package form;

import communication.Communication;
import domain.Game;
import domain.ListOfReferees;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * FrmShowGame za prikaz informacija o igri.
 * Ova forma omogućava pretragu igara po datumu i prikaz informacija o izabranom meču, uključujući datum, vreme i sudije.
 * 
 * @author Radin
 */
public class FrmShowGame extends javax.swing.JDialog {

	/**
     * Kreira novu instancu dijaloga za prikaz igre.
     * 
     * @param parent glavni prozor koji se koristi kao roditelj
     * @param modal true ako je dijalog modalni
     */
    public FrmShowGame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora da inicijalizuje formu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbGame = new javax.swing.JComboBox<>();
        txtSearchedGame = new javax.swing.JTextField();
        jPanelTeam = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtGameDate = new javax.swing.JTextField();
        txtGameTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txthead = new javax.swing.JTextField();
        txtfirst = new javax.swing.JTextField();
        txtsecond = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnShowInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Enter game date:");

        jcbGame.setEnabled(false);

        jPanelTeam.setFocusable(false);

        jLabel5.setText("game date:");

        jLabel2.setText("game time:");

        jLabel3.setText("head referee:");

        jLabel4.setText("first referee:");

        jLabel6.setText("second referee:");

        javax.swing.GroupLayout jPanelTeamLayout = new javax.swing.GroupLayout(jPanelTeam);
        jPanelTeam.setLayout(jPanelTeamLayout);
        jPanelTeamLayout.setHorizontalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTeamLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanelTeamLayout.createSequentialGroup()
                        .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5))
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGameDate, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtGameTime)
                            .addComponent(txthead)
                            .addComponent(txtfirst)
                            .addComponent(txtsecond))))
                .addGap(63, 63, 63))
        );
        jPanelTeamLayout.setVerticalGroup(
            jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTeamLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGameDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGameTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelTeamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSearchedGame)
                        .addComponent(jcbGame, 0, 171, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnSearch)
                        .addComponent(btnShowInfo))
                    .addContainerGap(134, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanelTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearchedGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShowInfo)
                        .addComponent(jcbGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(351, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Pretražuje igre na osnovu unetog datuma i popunjava JComboBox sa pronađenim igrama.
     * Omogućava korisniku da odabere igru za koju želi da vidi dodatne informacije.
     * 
     * @param evt događaj koji se pokreće klikom na dugme "search"
     */
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            txtGameDate.setText("");
            txtGameTime.setText("");
            txthead.setText("");
            txtfirst.setText("");
            txtsecond.setText("");
            String searchedGameDate = txtSearchedGame.getText();
            LocalDate gameDate = LocalDate.parse(searchedGameDate);

            Game game = new Game();
            game.setGameDate(gameDate);

            List<Game> games = Communication.getInstance().getGames(game);

            jcbGame.removeAllItems();
            for (Game gm : games) {
                jcbGame.addItem(gm);
            }

            jcbGame.setEnabled(true);
            btnShowInfo.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Games have been found in the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                         

    /**
     * Prikazuje detalje o izabranoj igri, uključujući datum, vreme i sudije.
     * Omogućava korisniku da vidi sve relevantne informacije o igri nakon što je odabrana iz liste.
     * 
     * @param evt događaj koji se pokreće klikom na dugme "Show info"
     */
    private void btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
            Game selectedGame = (Game) jcbGame.getSelectedItem();

            if (selectedGame == null) {
                JOptionPane.showMessageDialog(this, "Game data cannot be loaded.");
                throw new Exception("Game data cannot be loaded.");
            }
            
            ListOfReferees list = new ListOfReferees();
            list.setGame(selectedGame);

            List<ListOfReferees> listOfReferees = Communication.getInstance().getListOfReferees(list);
            for (ListOfReferees listOfReferee : listOfReferees) {
                list = listOfReferee;
            }

        
        if (listOfReferees == null) {
            JOptionPane.showMessageDialog(this, "List of referees not found for the selected game.");
            throw new Exception("List of referees not found for the selected game.");
        }
            
            txtGameDate.setText(selectedGame.getGameDate().toString());
            txtGameTime.setText(selectedGame.getGameTime().toString());
            txthead.setText(list.getHeadReferee().getFirstname() + " " + list.getHeadReferee().getLastname());
            txtfirst.setText(list.getFirstReferee().getFirstname()+ " " + list.getFirstReferee().getLastname());
            txtsecond.setText(list.getSecondReferee().getFirstname()+ " " + list.getSecondReferee().getLastname());
            
            JOptionPane.showMessageDialog(this, "Game data loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }                                           

    

    /**
     * JButton za pretraživanje igre na osnovu unetog datuma.
     */              
    private javax.swing.JButton btnSearch;
    /**
     * JButton za prikazivanje informacija o selektovanoj igri.
     */
    private javax.swing.JButton btnShowInfo;
    /**
     * JLabel za prikazivanje oznake "Enter game date:".
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel za prikaz oznake "game date:".
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel za prikaz oznake "game time:".
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel za prikaz oznake "head referee:".
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel za prikaz oznake "first referee:".
     */
    private javax.swing.JLabel jLabel5;
    /**
     * JLabel za prikaz oznake "second referee:".
     */
    private javax.swing.JLabel jLabel6;
    /**
     * JPanel za prikaz informacija o igri.
     */
    private javax.swing.JPanel jPanelTeam;
    /**
     * JComboBox za izbor igre iz liste pronađenih igara.
     */
    private javax.swing.JComboBox<Game> jcbGame;
    /**
     * JTextField za unos ili prikaz datuma igre.
     */
    private javax.swing.JTextField txtGameDate;
    /**
     * JTextField za unos ili prikaz vremena igre.
     */
    private javax.swing.JTextField txtGameTime;
    /**
     * JTextField za unos datuma igre za pretragu.
     */
    private javax.swing.JTextField txtSearchedGame;
    /**
     * JTextField za prikaz imena glavnog sudije.
     */
    private javax.swing.JTextField txtfirst;
    /**
     * JTextField za prikaz imena prvog pomoćnog sudije.
     */
    private javax.swing.JTextField txthead;
    /**
     * JTextField za prikaz imena drugog pomoćnog sudije.
     */
    private javax.swing.JTextField txtsecond;
              
}
