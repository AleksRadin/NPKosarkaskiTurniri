package form;


import communication.Communication;
import domain.User;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * FrmLogin koja predstavlja prozor za prijavu korisnika.
 * Ova klasa omogućava korisnicima da se prijave koristeći svoje korisničko ime i lozinku.
 * Nakon uspešne prijave, korisnik će biti preusmeren na odgovarajući ekran na osnovu svoje uloge.
 * 
 * @author Radin
 */
public class FrmLogin extends javax.swing.JFrame {

	/**
     * Minimalna dužina za korisničko ime i lozinku.
     */
    private static final int REQUIRED_LENGTH = 4;
    
    /**
     * Kreira novi prozor za prijavu.
     */
    public FrmLogin() {
        initComponents();
    }

    /**
     * Ova metoda se poziva iz konstruktora da inicijalizuje formu.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGap(0, 120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Metoda koja se poziva kada se klikne na dugme za prijavu.
     * Ova metoda validira unete podatke i pokušava da se prijavi korisnik koristeći Communication klasu. 
     * Ako je prijava uspešna, otvara se odgovarajući prozor na osnovu uloge korisnika. 
     * U suprotnom, prikazuje se poruka o grešci.
     * 
     * @param evt događaj koji se desio kada je dugme za prijavu kliknuto
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {           
            String username = txtUsername.getText().trim();
            String password = String.copyValueOf(txtPassword.getPassword());
            validateFields(username, password);

            User user = Communication.getInstance().login(username, password);

            
            JOptionPane.showMessageDialog(this, "Login success. Welcome " + user.getUsername());
            
            
            switch (user.getRole()) {
                case "manager":
                    (new FrmManager(user.getRole())).setVisible(true);
                    break;
                case "user":
                    (new FrmUser(user.getRole())).setVisible(true);
                    break;
                case "administrator":
                    (new FrmAdministrator(user.getRole())).setVisible(true);
                    break;
                default:
                    throw new Exception("Unknown user role: " + user.getRole());
            }
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                        
   
                 
    /**
     * Dugme za prijavu koje pokreće proces prijave korisnika kada se klikne.
     */
    private javax.swing.JButton btnLogin;
    /**
     * Labela koja prikazuje tekst "Korisničko ime:" iznad polja za unos korisničkog imena.
     */
    private javax.swing.JLabel jLabel1;
    /**
     * Labela koja prikazuje tekst "Lozinka:" iznad polja za unos lozinke.
     */
    private javax.swing.JLabel jLabel2;
    /**
     * Polje za unos lozinke gde korisnik unosi svoju lozinku.
     */
    private javax.swing.JPasswordField txtPassword;
    /**
     * Polje za unos korisničkog imena gde korisnik unosi svoje korisničko ime.
     */
    private javax.swing.JTextField txtUsername;
                 


    /**
     * Metoda koja validira unete podatke (korisničko ime i lozinku).
     * Proverava da li su polja prazna ili prekratka i prikazuje odgovarajuće poruke o grešci ako validacija nije uspešna.
     * 
     * @param username korisničko ime uneseno u formi
     * @param password lozinka unesena u formi
     */
    private void validateFields(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields cannot be empty.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else if (username.length() < REQUIRED_LENGTH || password.length() < REQUIRED_LENGTH) {
            JOptionPane.showMessageDialog(this, "Fields must be at least " + REQUIRED_LENGTH + " characters long.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

   
}
