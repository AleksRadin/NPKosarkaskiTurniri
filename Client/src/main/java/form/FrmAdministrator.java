package form;

/**
 * Glavna forma za administraciju, omogućava korisniku da upravlja igrama, rezultatima, statistikom igrača i tabelama.
 * Ova forma takođe koristi korisničku ulogu za filtriranje prikaza ili dostupnih opcija.
 * 
 * @author Radin
 */
public class FrmAdministrator extends javax.swing.JFrame {

	/**
     * Uloga korisnika koja definiše prava pristupa i mogućnosti u okviru forme.
     */
    private String userRole;
    /**
     * Kreira novu instancu forme za administratora sa zadatom ulogom korisnika.
     * 
     * @param userRole Uloga korisnika koja se koristi za filtriranje opcija u formi.
     */
    public FrmAdministrator(String userRole) {
        this.userRole = userRole;
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora da inicijalizuje formu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("game");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("add");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("add result");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("add player stats");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("player");

        jMenuItem4.setText("show stats");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("leaderboard");

        jMenuItem5.setText("table");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * Metod koji se poziva kada se akcija izvrši na meniju "game".
     * Trenutno je prazan i ne obavlja nikakvu funkcionalnost.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
 
    }                                      

    /**
     * Otvara formu za dodavanje nove igre.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
      try {
             new FrmAddGame(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Otvara formu za dodavanje rezultata igre.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmAddResult(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Otvara formu za dodavanje statistike igrača.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmAddPlayerStats(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Otvara formu za prikaz statistike igrača, filtriranu prema ulozi korisnika.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowPlayerStats(this, true, userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Otvara formu za prikaz tabele sa rang listom.
     * 
     * @param evt Događaj koji je pokrenuo ovu akciju.
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowTable(this, true, userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    
    /**
     * Menu za upravljanje opcijama vezanim za igre.
     */             
    private javax.swing.JMenu jMenu1;
    /**
     * Menu za upravljanje opcijama vezanim za igrače.
     */
    private javax.swing.JMenu jMenu2;
    /**
     * Menu za upravljanje opcijama vezanim za rang listu.
     */
    private javax.swing.JMenu jMenu3;
    /**
     * Menu bar koji sadrži sve menije.
     */
    private javax.swing.JMenuBar jMenuBar1;
    /**
     * Stavka menija za dodavanje nove igre.
     */
    private javax.swing.JMenuItem jMenuItem1;
    /**
     * Stavka menija za dodavanje rezultata igre.
     */
    private javax.swing.JMenuItem jMenuItem2;
    /**
     * Stavka menija za dodavanje statistike igrača.
     */
    private javax.swing.JMenuItem jMenuItem3;
    /**
     * Stavka menija za prikaz statistike igrača.
     */
    private javax.swing.JMenuItem jMenuItem4;
    /**
     * Stavka menija za prikaz tabele sa rang listom.
     */
    private javax.swing.JMenuItem jMenuItem5;
                 
}
