package domain;

import java.util.Objects;

/**
 * Predstavlja trenera u sistemu, koji je povezan sa određenim timom i sadrži informacije o njegovom imenu, prezimenu, broju osvojenih šampionata i timu.
 * 
 * @author Radin
 */
public class Coach implements GenericEntity{
	/**
     * ID trenera u vidu Long vrednosti (ceo broj).
     */
    private Long id;
    /**
     * Ime trenera kao String.
     */
    private String firstname;
    /**
     * Prezime trenera kao String.
     */
    private String lastname;
    /**
     * Broj osvojenih šampionata kao ceo broj.
     */
    private int numbOfChampionships;
    /**
     * Tim sa kojim je trener povezan.
     */
    private Team team;

    /**
     * Parametrizovani konstruktor koji kreira instancu trenera sa specifičnim vrednostima za sva polja.
     * 
     * @param id - ID trenera koji mu se dodeljuje prilikom kreiranja
     * @param firstname - Ime trenera
     * @param lastname - Prezime trenera
     * @param numbOfChampionships - Broj osvojenih šampionata
     * @param team - Tim sa kojim je trener povezan
     */
    public Coach(Long id, String firstname, String lastname, int numbOfChampionships, Team team) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numbOfChampionships = numbOfChampionships;
        this.team = team;
    }

    /**
     * Prazan konstruktor za kreiranje instace trenera sa podrazumevanim vrednostima za sva polja.
     */
    public Coach() {
    }

    /**
     * Vraca ID trenera.
     * 
     * @return id - ID trenera kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID trenera.
     * 
     * @param id - Nova vrednost za ID trenera
     * 
     * @throws NullPointerException - ako se unese null vrednost za ID
     * @throws IllegalArgumentException - ako je ID manji ili jednak 0
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
     * Vraca ime trenera.
     * 
     * @return firstname - Ime trenera kao String.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja novu vrednost za ime trenera.
     * 
     * @param firstname - Nova vrednost za ime trenera
     * 
     * @throws NullPointerException - ako se unese null vrednost za ime
     * @throws IllegalArgumentException - ako je ime prazan String
     */
    public void setFirstname(String firstname) {
        if (firstname == null || firstname.isEmpty()) {
            throw new NullPointerException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }

    /**
     * Vraca prezime trenera.
     * 
     * @return lastname - Prezime trenera kao String.
     */
    public String getLastname() {
        return lastname;
    }

    
    /**
     * Postavlja novu vrednost za prezime trenera.
     * 
     * @param lastname - Nova vrednost za prezime trenera
     * 
     * @throws NullPointerException - ako se unese null vrednost za prezime
     * @throws IllegalArgumentException - ako je prezime prazan String
     */
    public void setLastname(String lastname) {
        if (lastname == null || lastname.isEmpty()) {
            throw new NullPointerException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname;
    }

    /**
     * Vraca broj osvojenih šampionata.
     * 
     * @return numbOfChampionships - Broj osvojenih šampionata kao ceo broj.
     */
    public int getNumbOfChampionships() {
        return numbOfChampionships;
    }

    /**
     * Postavlja novu vrednost za broj osvojenih šampionata.
     * 
     * @param numbOfChampionships - Nova vrednost za broj osvojenih šampionata
     * 
     * @throws IllegalArgumentException - ako je broj osvojenih šampionata negativan
     */
    public void setNumbOfChampionships(int numbOfChampionships) {
        if (numbOfChampionships < 0) {
            throw new IllegalArgumentException("Number of championships cannot be negative.");
        }
        this.numbOfChampionships = numbOfChampionships;
    }

    /**
     * Vraca tim sa kojim je trener povezan.
     * 
     * @return team - Tim kao objekat klase Team.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Postavlja novi tim za trenera.
     * 
     * @param team - Novi tim sa kojim je trener povezan
     * 
     * @throws NullPointerException - ako se unese null vrednost za tim
     */
    public void setTeam(Team team) {
        if (team == null) {
            throw new NullPointerException("Team cannot be null.");
        }
        this.team = team;
    }

    /**
     * Racuna hash code na osnovu svih atributa trenera.
     * 
     * @return hash - Hash code izracunat na osnovu svih atributa trenera.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + this.numbOfChampionships;
        hash = 97 * hash + Objects.hashCode(this.team);
        return hash;
    }

    /**
     * Poredi dva trenera prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim ce se porediti instanca trenera nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase Coach, ili se razlikuje po vrednosti nekog atributa</li>
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
        final Coach other = (Coach) obj;
        if (this.numbOfChampionships != other.numbOfChampionships) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.team, other.team);
    }

    /**
     * Vraca String reprezentaciju trenera na osnovu imena i prezimena.
     * 
     * @return coach - String reprezentacija trenera u formatu "firstname - lastname".
     */
    @Override
    public String toString() {
        return firstname + " - " + lastname;
    }
    
    
        @Override
    public String getTableName() {
        return "coach";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, number_of_championships, team_id";
    } 

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "number_of_championships", "team_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + numbOfChampionships + ", " + team.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getInt", "getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "firstname = '" + firstname + "', " + "lastname = '" + lastname + "', " + "number_of_championships = " + numbOfChampionships + ", " + "team_id = " + team.getId();
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
