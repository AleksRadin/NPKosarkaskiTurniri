package form;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Predstavlja grafičku korisničku interfejs formu za podešavanje konfiguracije baze podataka.
 * 
 * Omogućava korisnicima da unesu i sačuvaju URL baze podataka, korisničko ime i lozinku.
 * 
 * @author Radin
 */
public class FrmSettings extends javax.swing.JFrame {

	/**
     * Konstruktor koji inicijalizuje grafičke komponente forme i priprema prikaz sa trenutnim podešavanjima.
     */
    public FrmSettings() {
        initComponents();
        prepareView();
    }

    /**
     * Ova metoda se poziva iz konstruktora za inicijalizaciju forme.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtUrl = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUrl.setEditable(false);

        jLabel1.setText("DB url:");

        jLabel2.setText("username:");

        jLabel3.setText("pasword:");

        jbtnSave.setText("save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSave)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Čuva trenutne podešene vrednosti u konfiguracioni fajl kada se klikne na dugme "Save".
     * 
     * @param evt događaj koji se dogodio prilikom klika na dugme
     */
    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String url = txtUrl.getText();
        String user = txtUser.getText();
        String password = String.copyValueOf(txtPass.getPassword());
        
         Properties props = new Properties();
        
        try {
            InputStream input = new FileInputStream("config/dbconfig.properties");
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        props.setProperty("url", url);
        props.setProperty("username", user);
        props.setProperty("password", password);
        
        try {
            OutputStream output = new FileOutputStream("config/dbconfig.properties");
            props.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        this.dispose();
    }                                        

    /**
     * Label za prikaz URL-a baze podataka.
     */             
    private javax.swing.JLabel jLabel1;
    /**
     * Label za prikaz korisničkog imena.
     */
    private javax.swing.JLabel jLabel2;
    /**
     * Label za prikaz lozinke.
     */
    private javax.swing.JLabel jLabel3;
    /**
     * Dugme za čuvanje podešavanja.
     */
    private javax.swing.JButton jbtnSave;
    /**
     * Polje za unos lozinke.
     */
    private javax.swing.JPasswordField txtPass;
    /**
     * Polje za unos URL-a baze podataka.
     */
    private javax.swing.JTextField txtUrl;
    /**
     * Polje za unos korisničkog imena.
     */
    private javax.swing.JTextField txtUser;                 

    /**
     * Priprema prikaz forme tako što učitava trenutne konfiguracije iz fajla i prikazuje ih u formi.
     */
    private void prepareView() {
        Properties props = new Properties();
        
        try {
            InputStream input = new FileInputStream("config/dbconfig.properties");
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        
        txtUrl.setText(url);
        txtUser.setText(username);
        txtPass.setText(password);
    }
}
