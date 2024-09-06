package domain;

import java.util.Objects;

/**
 * Predstavlja sudiju u sistemu.
 * 
 * Sadrži ID, ime i prezime sudije.
 * 
 * @author Radin
 */
public class Referee implements GenericEntity{
	/**
     * ID sudije u bazi podataka. 
     * Predstavlja jedinstveni identifikator za sudiju.
     */
    private Long id;
    /**
     * Ime sudije.
     * Predstavlja ime sudije kao String.
     */
    private String firstname;
    /**
     * Prezime sudije.
     * Predstavlja prezime sudije kao String.
     */
    private String lastname;

    /**
     * Konstruktor za inicijalizaciju sudije sa svim atributima.
     * 
     * @param id - ID sudije kao Long vrednost.
     * @param firstname - Ime sudije kao String.
     * @param lastname - Prezime sudije kao String.
     */
    public Referee(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Prazan konstruktor za kreiranje instance sudije bez inicijalizacije atributa.
     */
    public Referee() {
    }

    
    /**
     * Vraća ID sudije.
     * 
     * @return id - ID sudije kao Long vrednost.
     */

    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID sudije.
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
     * Vraća ime sudije.
     * 
     * @return firstname - Ime sudije kao String.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja novo ime sudije.
     * 
     * @param firstname - Novo ime sudije kao String.
     * 
     * @throws NullPointerException - Ako je ime null.
     * @throws IllegalArgumentException - Ako je ime prazan String.
     */
    public void setFirstname(String firstname) {
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }

    /**
     * Vraća prezime sudije.
     * 
     * @return lastname - Prezime sudije kao String.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlja novo prezime sudije.
     * 
     * @param lastname - Novo prezime sudije kao String.
     * 
     * @throws NullPointerException - Ako je prezime null.
     * @throws IllegalArgumentException - Ako je prezime prazan String.
     */
    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname;
    }

    /**
     * Vraća hash code objekta sudije na osnovu svih atributa.
     * 
     * @return hash - Hash code izračunat na osnovu ID-a, imena i prezimena sudije.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.firstname);
        hash = 41 * hash + Objects.hashCode(this.lastname);
        return hash;
    }

    /**
     * Poredi dve sudije prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca sudije nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, firstname, lastname) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase Referee, ili se razlikuje po vrednosti nekog atributa</li>
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
        final Referee other = (Referee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        return Objects.equals(this.lastname, other.lastname);
    }

    /**
     * Vraća String reprezentaciju sudije na osnovu imena i prezimena.
     * 
     * @return String - Ime i prezime sudije kao String.
     */
    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "referee";
    }

     @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[]{"id", "firstname", "lastname"};
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "'" + ", " + "'" + lastname + "'";
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[]{"getLong", "getString", "getString"};
    }

    @Override
    public String getUpdateValues() {
        return "firstname = '" + firstname + "', " + "lastname = '" + lastname + "'";
    }

    @Override
    public String getWhereCondition() {
        return "id = " + id;
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "id = " + id;
    }

    
    
    
}
