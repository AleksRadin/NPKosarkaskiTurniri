package form;

/**
 * FrmManager klasa koja predstavlja prozor za menadžera u aplikaciji.
 * Pruža meni za pristup funkcionalnostima kao što su dodavanje, izmena i prikaz podataka o igračima, timovima, trenerima, igrama i tabelama.
 * Menadžer može koristiti ovu formu za upravljanje timovima, igračima i drugim povezanim podacima.
 * 
 * @author Radin
 */
public class FrmManager extends javax.swing.JFrame {

	/**
     * Uloga korisnika (menadžera) koja je prosleđena ovom formi.
     */
    private String userRole;
    
    /**
     * Kreira novu instancu FrmManager forme sa prosleđenom ulogom korisnika.
     *
     * @param userRole Uloga korisnika (menadžera) koja se koristi za određivanje šta je dostupno u formi.
     */
    public FrmManager(String userRole) {
        this.userRole = userRole;
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora da bi inicijalizovala formu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("player");

        jMenuItem6.setText("show");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem11.setText("showStats");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("team");

        jMenuItem2.setText("add");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setText("edit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem8.setText("show");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("game");

        jMenuItem9.setText("show");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("leaderboard");

        jMenuItem10.setText("table");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("coach");

        jMenuItem1.setText("add");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem3.setText("edit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenuBar1.add(jMenu6);

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
     * Ova metoda se poziva kada se klikne na meni stavku za dodavanje trenera.
     * Otvara prozor za dodavanje novog trenera.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmAddCoach(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za dodavanje tima.
     * Otvara prozor za dodavanje novog tima.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmAddTeam(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za izmenu trenera.
     * Otvara prozor za izmenu postojećeg trenera.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmEditCoach(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za izmenu tima.
     * Otvara prozor za izmenu postojećeg tima.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmEditTeam(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za prikaz igrača.
     * Otvara prozor za prikaz svih igrača.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowPlayer(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za prikaz timova.
     * Otvara prozor za prikaz svih timova.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowTeam(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za prikaz igara.
     * Otvara prozor za prikaz svih igara.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {
             new FrmShowGame(this, true).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                          

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za prikaz tabele lidera.
     * Otvara prozor za prikaz tabele lidera sa obzirom na ulogu korisnika.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
             new FrmShowTable(this, true,userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    /**
     * Ova metoda se poziva kada se klikne na meni stavku za prikaz statistike igrača.
     * Otvara prozor za prikaz statistike igrača sa obzirom na ulogu korisnika.
     *
     * @param evt Događaj koji je izazvao ovu akciju.
     */
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        try {
             new FrmShowPlayerStats(this, true, userRole).setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }                                           

    

    /**
     * JMenu za upravljanje opcijama vezanim za igrače.
     */          
    private javax.swing.JMenu jMenu1;
    /**
     * JMenu za upravljanje opcijama vezanim za timove.
     */
    private javax.swing.JMenu jMenu2;
    /**
     * JMenu za upravljanje opcijama vezanim za dodavanje i izmenu timova.
     */
    private javax.swing.JMenu jMenu3;
    /**
     * JMenu za upravljanje opcijama vezanim za igre.
     */
    private javax.swing.JMenu jMenu4;
    /**
     * JMenu za upravljanje opcijama vezanim za tabelu lidera.
     */
    private javax.swing.JMenu jMenu5;
    /**
     * JMenu za upravljanje opcijama vezanim za trenere.
     */
    private javax.swing.JMenu jMenu6;
    /**
     * JMenuBar koji sadrži sve menije u okviru prozora.
     */
    private javax.swing.JMenuBar jMenuBar1;
    /**
     * JMenuItem za dodavanje novog trenera.
     */
    private javax.swing.JMenuItem jMenuItem1;
    /**
     * JMenuItem za prikaz tabele lidera.
     */
    private javax.swing.JMenuItem jMenuItem10;
    /**
     * JMenuItem za prikaz statistike igrača.
     */
    private javax.swing.JMenuItem jMenuItem11;
    /**
     * JMenuItem za dodavanje novog tima.
     */
    private javax.swing.JMenuItem jMenuItem2;
    /**
     * JMenuItem za izmenu postojećeg trenera.
     */
    private javax.swing.JMenuItem jMenuItem3;
    /**
     * JMenuItem za izmenu postojećeg tima.
     */
    private javax.swing.JMenuItem jMenuItem4;
    /**
     * JMenuItem za prikaz postojećih igrača.
     */
    private javax.swing.JMenuItem jMenuItem5;
    /**
     * JMenuItem za prikaz statistike igrača.
     */
    private javax.swing.JMenuItem jMenuItem6;
    /**
     * JMenuItem za prikaz tima.
     */
    private javax.swing.JMenuItem jMenuItem7;
    /**
     * JMenuItem za prikaz igara.
     */
    private javax.swing.JMenuItem jMenuItem8;
    /**
     * JMenuItem za prikaz svih igara.
     */
    private javax.swing.JMenuItem jMenuItem9;
                 
}
