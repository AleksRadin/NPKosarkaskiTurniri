package form;

import java.io.IOException;
import server.Server;

/**
 * Predstavlja glavnu grafičku korisničku interfejs formu za upravljanje serverom.
 * 
 * Omogućava korisnicima da pokrenu i zaustave server, kao i da otvore formu za podešavanje.
 * 
 * @author Radin
 */
public class FrmMain extends javax.swing.JFrame {

	/**
     * Instanca servera koja upravlja radom servera.
     */
    private Server server;
    
    /**
     * Konstruktor koji inicijalizuje grafičke komponente forme.
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora za inicijalizaciju forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStartServer.setText("Start Server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setText("Stop Server");
        btnStopServer.setEnabled(false);
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        btnSettings.setText("Settings");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnStartServer)
                .addGap(67, 67, 67)
                .addComponent(btnStopServer)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * Pokreće server kada se klikne na dugme "Start Server".
     * 
     * @param evt događaj koji se dogodio prilikom klika na dugme
     */
    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {                                               
        server = new Server();
        server.start();
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);
        btnSettings.setEnabled(false);
    }                                              

    /**
     * Zaustavlja server kada se klikne na dugme "Stop Server".
     * 
     * @param evt događaj koji se dogodio prilikom klika na dugme
     */
    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {                                              
       try {
            server.stopServer();
            btnStartServer.setEnabled(true);
            btnStopServer.setEnabled(false);
            btnSettings.setEnabled(true);
        } catch (IOException ex) {
            System.out.println("Greska: " + ex.getMessage());
        }
    }                                             

    /**
     * Otvara formu za podešavanje kada se klikne na dugme "Settings".
     * 
     * @param evt događaj koji se dogodio prilikom klika na dugme
     */
    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {                                            
        new FrmSettings().setVisible(true);
    }                                           


    /**
     * Dugme za otvaranje forme za podešavanje.
     */              
    private javax.swing.JButton btnSettings;
    /**
     * Dugme za pokretanje servera.
     */  
    private javax.swing.JButton btnStartServer;
    /**
     * Dugme za zaustavljanje servera.
     */
    private javax.swing.JButton btnStopServer;                 
}
