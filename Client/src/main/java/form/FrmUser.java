package form;

/**
 * Glavna forma za korisnički interfejs koja prikazuje meni sa opcijama za prikaz informacija o igračima, timovima, igrama i rang listama, kao i statistici igrača. 
 * Ova klasa se koristi za rad sa korisničkim interfejsom u zavisnosti od uloge korisnika.
 * 
 * @author Radin
 */
public class FrmUser extends javax.swing.JFrame {

	/**
     * Uloga korisnika koja definiše pristupne privilegije i opcije.
     */
    private String userRole;
    /**
     * Konstruktor koji inicijalizuje formu sa zadatom ulogom korisnika.
     * 
     * @param role Uloga korisnika koja će biti dodeljena ovoj formi.
     */
    public FrmUser(String role) {
        this.userRole = userRole;
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora da bi inicijalizovala formu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("player");

        jMenuItem1.setText("show");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setText("show stats");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("team");

        jMenuItem2.setText("show");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("game");

        jMenuItem3.setText("show");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("leaderboard");

        jMenuItem4.setText("table");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * Akcija koja se izvršava kada se izabere opcija "show" iz menija "player".
     * Otvara formu za prikaz informacija o igračima.
     * 
     * @param evt Događaj koji se desio (klik na meni).
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowPlayer(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Akcija koja se izvršava kada se izabere opcija "show" iz menija "team".
     * Otvara formu za prikaz informacija o timovima.
     * 
     * @param evt Događaj koji se desio (klik na meni).
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowTeam(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Akcija koja se izvršava kada se izabere opcija "show" iz menija "game".
     * Otvara formu za prikaz informacija o igrama.
     * 
     * @param evt Događaj koji se desio (klik na meni).
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowGame(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Akcija koja se izvršava kada se izabere opcija "table" iz menija "leaderboard".
     * Otvara formu za prikaz rang liste u zavisnosti od uloge korisnika.
     * 
     * @param evt Događaj koji se desio (klik na meni).
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowTable(this, true, userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Akcija koja se izvršava kada se izabere opcija "show stats" iz menija "player".
     * Otvara formu za prikaz statistike igrača u zavisnosti od uloge korisnika.
     * 
     * @param evt Događaj koji se desio (klik na meni).
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowPlayerStats(this, true, userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    

    /**
     * Meni za opcije vezane za igrače.
     */
    private javax.swing.JMenu jMenu1;
    /**
     * Meni za opcije vezane za timove.
     */
    private javax.swing.JMenu jMenu2;
    /**
     * Meni za opcije vezane za igre.
     */
    private javax.swing.JMenu jMenu3;
    /**
     * Meni za opcije vezane za rang liste.
     */
    private javax.swing.JMenu jMenu4;
    /**
     * Meni bar koji sadrži sve menije aplikacije.
     */
    private javax.swing.JMenuBar jMenuBar1;
    /**
     * Meni stavka za prikaz informacija o igračima.
     */
    private javax.swing.JMenuItem jMenuItem1;
    /**
     * Meni stavka za prikaz statistike igrača.
     */
    private javax.swing.JMenuItem jMenuItem2;
    /**
     * Meni stavka za prikaz informacija o timovima.
     */
    private javax.swing.JMenuItem jMenuItem3;
    /**
     * Meni stavka za prikaz informacija o igrama.
     */
    private javax.swing.JMenuItem jMenuItem4;
    /**
     * Meni stavka za prikaz rang liste.
     */
    private javax.swing.JMenuItem jMenuItem5;
               
}
