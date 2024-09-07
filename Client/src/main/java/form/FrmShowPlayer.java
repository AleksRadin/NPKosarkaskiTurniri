package form;

import communication.Communication;
import domain.Player;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import player.state.PlayerPosition;

/**
 * FrmShowPlayer za prikaz i pretragu igrača.
 * Omogućava pretragu igrača po prezimenu i prikaz detalja o odabranom igraču.
 * @author Radin
 */
public class FrmShowPlayer extends javax.swing.JDialog {

	/**
     * Kreira novi instancu dijaloga za prikaz igrača.
     * 
     * @param parent roditeljski prozor
     * @param modal da li je dijalog modalni
     */
    public FrmShowPlayer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareView();
    }

    /**
     * Ova metoda se poziva iz konstruktora za inicijalizaciju forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtSearchedPlayer = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        btnShowInfo = new javax.swing.JButton();
        jcbPlayers = new javax.swing.JComboBox<>();
        jPanelPlayer = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbPosition = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSearch2.setText("search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        btnShowInfo.setText("Show info");
        btnShowInfo.setEnabled(false);
        btnShowInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowInfoActionPerformed(evt);
            }
        });

        jcbPlayers.setEnabled(false);

        jPanelPlayer.setFocusable(false);

        jLabel4.setText("Position:");

        jLabel5.setText("Height:");

        jLabel6.setText("Weight:");

        txtFirstname.setEnabled(false);

        txtLastname.setEnabled(false);

        txtBirthday.setEnabled(false);

        txtHeight.setEnabled(false);

        jLabel2.setText("Firstname:");

        txtWeight.setEnabled(false);

        jLabel3.setText("Lastname:");

        jLabel7.setText("Birthday:");

        jcbPosition.setEditable(true);
        jcbPosition.setEnabled(false);

        javax.swing.GroupLayout jPanelPlayerLayout = new javax.swing.GroupLayout(jPanelPlayer);
        jPanelPlayer.setLayout(jPanelPlayerLayout);
        jPanelPlayerLayout.setHorizontalGroup(
            jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayerLayout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(jcbPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPlayerLayout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addGap(37, 37, 37)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFirstname)
                        .addComponent(txtLastname)
                        .addComponent(txtHeight)
                        .addComponent(txtWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        jPanelPlayerLayout.setVerticalGroup(
            jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlayerLayout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPlayerLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel7)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(24, 24, 24)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        jLabel1.setText("Enter player lastname:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearchedPlayer)
                            .addComponent(jcbPlayers, 0, 171, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch2)
                            .addComponent(btnShowInfo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearchedPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShowInfo)
                    .addComponent(jcbPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanelPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Prikazuje informacije o igraču na osnovu selektovanog imena u JComboBox.
     * 
     * @param evt događaj kada je kliknut dugme "Show Info"
     */
    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
            txtFirstname.setText("");
            txtLastname.setText("");
            txtBirthday.setText("");
            jcbPosition.setSelectedItem(null);
            txtHeight.setText("");
            txtWeight.setText("");
            jcbPlayers.removeAllItems();
            jcbPlayers.setSelectedItem(null);
            Player player = new Player();
            player.setLastname(txtSearchedPlayer.getText());

            List<Player> players = Communication.getInstance().getPlayers(player);

            jcbPlayers.removeAllItems();
            for (Player pl : players) {
                jcbPlayers.addItem(pl);
            }

            jcbPlayers.setEnabled(true);
            btnShowInfo.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Players have been found in the database.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }                                          

    /**
     * Pretražuje igrače na osnovu unesenog prezimena i ažurira JComboBox sa rezultatima.
     * 
     * @param evt događaj kada je kliknut dugme "Search"
     */
    private void btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        try {
            Player selectedPlayer = (Player) jcbPlayers.getSelectedItem();

            if (selectedPlayer == null) {
                JOptionPane.showMessageDialog(this, "Player data cannot be loaded");
                throw new Exception("Player data cannot be loaded");
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            txtFirstname.setText(selectedPlayer.getFirstname());
            txtLastname.setText(selectedPlayer.getLastname());
            txtBirthday.setText(formatter.format(selectedPlayer.getBirthday()));
            jcbPosition.setSelectedItem(selectedPlayer.getPosition());
            txtHeight.setText(String.valueOf(selectedPlayer.getHeight()));
            txtWeight.setText(String.valueOf(selectedPlayer.getWeight()));


            JOptionPane.showMessageDialog(this, "Player data loaded.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    

    }                                           

   

                   
    /**
     * JButton koje omogućava pretragu igrača na osnovu unesenog prezimena.
     */
    private javax.swing.JButton btnSearch2;
    /**
     * JButton koje omogućava prikaz informacija o selektovanom igraču.
     */
    private javax.swing.JButton btnShowInfo;
    /**
     * JLabel koja prikazuje tekst "Enter player lastname:".
     */
    private javax.swing.JLabel jLabel1;
    /**
     * JLabel koja prikazuje tekst "Firstname:".
     */
    private javax.swing.JLabel jLabel2;
    /**
     * JLabel koja prikazuje tekst "Lastname:".
     */
    private javax.swing.JLabel jLabel3;
    /**
     * JLabel koja prikazuje tekst "Position:".
     */
    private javax.swing.JLabel jLabel4;
    /**
     * JLabel koja prikazuje tekst "Height:".
     */
    private javax.swing.JLabel jLabel5;
    /**
     * JLabel koja prikazuje tekst "Weight:".
     */
    private javax.swing.JLabel jLabel6;
    /**
     * JLabel koja prikazuje tekst "Birthday:".
     */
    private javax.swing.JLabel jLabel7;
    /**
     * Panel koji sadrži polja za prikaz detalja o igraču.
     */
    private javax.swing.JPanel jPanelPlayer;
    /**
     * JComboBox koji prikazuje listu igrača pretraživanjem po prezimenu.
     */
    private javax.swing.JComboBox<Player> jcbPlayers;
    /**
     * JComboBox koji omogućava izbor pozicije igrača.
     */
    private javax.swing.JComboBox<String> jcbPosition;
    /**
     * JTextField za prikaz datuma rođenja igrača.
     */
    private javax.swing.JTextField txtBirthday;
    /**
     * JTextField za prikaz imena igrača.
     */
    private javax.swing.JTextField txtFirstname;
    /**
     * JTextField za prikaz visine igrača.
     */
    private javax.swing.JTextField txtHeight;
    /**
     * JTextField za prikaz prezimena igrača.
     */
    private javax.swing.JTextField txtLastname;
    /**
     * JTextField za unos prezimena igrača za pretragu.
     */
    private javax.swing.JTextField txtSearchedPlayer;
    /**
     * JTextField za prikaz težine igrača.
     */
    private javax.swing.JTextField txtWeight;
                

    /**
     * Priprema prikaz forme postavljanjem osnovnih postavki.
     */
    private void prepareView() {
        for (PlayerPosition position : PlayerPosition.values()) {
            jcbPosition.addItem(position.getDisplayName());
        }
        jcbPosition.setSelectedItem(null);
    }
}
