package domain;

import java.util.Objects;

/**
 * Predstavlja korisnika u sistemu.
 * 
 * Sadrži informacije o ID-ju, imenu, prezimenu, korisničkom imenu, lozinki i rolama korisnika.
 * 
 * @author Radin
 */
public class User implements GenericEntity{
    
	/**
     * ID korisnika u bazi podataka.
     * Predstavlja jedinstveni identifikator za korisnika.
     */
    private Long id;
    /**
     * Ime korisnika.
     * Predstavlja ime korisnika kao String.
     */
    private String firstname;
    /**
     * Prezime korisnika.
     * Predstavlja prezime korisnika kao String.
     */
    private String lastname;
    /**
     * Korisničko ime.
     * Predstavlja korisničko ime kao String.
     */
    private String username;
    /**
     * Lozinka korisnika.
     * Predstavlja lozinku korisnika kao String.
     */
    private String password;
    /**
     * Uloga korisnika.
     * Predstavlja ulogu korisnika kao String.
     */
    private String role;

    /**
     * Konstruktor za inicijalizaciju korisnika sa svim atributima.
     * 
     * @param id - ID korisnika kao Long vrednost.
     * @param firstname - Ime korisnika kao String.
     * @param lastname - Prezime korisnika kao String.
     * @param username - Korisničko ime kao String.
     * @param password - Lozinka korisnika kao String.
     * @param role - Uloga korisnika kao String.
     */
    public User(Long id, String firstname, String lastname, String username, String password, String role) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Prazan konstruktor za kreiranje instance korisnika bez inicijalizacije atributa.
     */
    public User() {
    }

    
    /**
     * Vraća ID korisnika.
     * 
     * @return id - ID korisnika kao Long vrednost.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID korisnika.
     * 
     * @param id - Nova ID vrednost kao Long.
     * 
     * @throws NullPointerException - Ako je ID null.
     * @throws IllegalArgumentException - Ako je ID manji ili jednak 0.
     */
    public void setId(Long id) {
        if (id == null) {
            throw new NullPointerException("ID cannot be null.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
        this.id = id;
    }

    /**
     * Vraća ime korisnika.
     * 
     * @return firstname - Ime korisnika kao String.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja novo ime korisnika.
     * 
     * @param firstname - Novo ime korisnika kao String.
     * 
     * @throws IllegalArgumentException - Ako je ime null ili prazno.
     */
    public void setFirstname(String firstname) {
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }
    
    /**
     * Vraća prezime korisnika.
     * 
     * @return lastname - Prezime korisnika kao String.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlja novo prezime korisnika.
     * 
     * @param lastname - Novo prezime korisnika kao String.
     * 
     * @throws IllegalArgumentException - Ako je prezime null ili prazno.
     */
    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname;
    }

    /**
     * Vraća korisničko ime.
     * 
     * @return username - Korisničko ime kao String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja novo korisničko ime.
     * 
     * @param username - Novo korisničko ime kao String.
     * 
     * @throws IllegalArgumentException - Ako je korisničko ime null ili prazno.
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username;
    }

    /**
     * Vraća lozinku korisnika.
     * 
     * @return password - Lozinka korisnika kao String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja novu lozinku korisnika.
     * 
     * @param password - Nova lozinka korisnika kao String.
     * 
     * @throws IllegalArgumentException - Ako je lozinka null ili prazna.
     */
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.password = password;
    }

    /**
     * Vraća ulogu korisnika.
     * 
     * @return role - Uloga korisnika kao String.
     */
    public String getRole() {
        return role;
    }

    /**
     * Postavlja novu ulogu korisnika.
     * 
     * @param role - Nova uloga korisnika kao String.
     * 
     * @throws IllegalArgumentException - Ako je uloga null ili prazna.
     */
    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }
        this.role = role;
    }

    /**
     * Vraća hash code objekta korisnika na osnovu svih atributa.
     * 
     * @return hash - Hash code izračunat na osnovu ID-a, imena, prezimena, korisničkog imena, lozinke i uloge korisnika.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.firstname);
        hash = 31 * hash + Objects.hashCode(this.lastname);
        hash = 31 * hash + Objects.hashCode(this.username);
        hash = 31 * hash + Objects.hashCode(this.password);
        hash = 31 * hash + Objects.hashCode(this.role);
        return hash;
    }

    /**
     * Poredi dva korisnika prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca korisnika nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, firstname, lastname, username, password, role) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase User, ili se razlikuje po vrednosti nekog atributa</li>
     * </ul>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Vraća String reprezentaciju korisnika na osnovu svih atributa.
     * 
     * @return String - Reprezentacija korisnika u formatu "User{id=..., firstname=..., lastname=..., username=..., password=..., role=...}".
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "firstname, lastname, username, password, role";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "username", "password", "role"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return id + ", " + "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + "'" + username + "'" + ", " + "'" + password + "'" + ", " + "'" + role + "'";
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getString", "getString", "getString"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getWhereConditionEditOperation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
}

