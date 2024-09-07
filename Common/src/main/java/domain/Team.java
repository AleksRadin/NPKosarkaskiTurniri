package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja tim u sistemu.
 * 
 * Sadrži ID, naziv tima, grad, zemlju i godinu osnivanja.
 * 
 * @author Radin
 */
public class Team implements GenericEntity{
    
	/**
     * ID tima u bazi podataka.
     * Predstavlja jedinstveni identifikator za tim.
     */
    private Long id;
    /**
     * Naziv tima.
     * Predstavlja naziv tima kao String.
     */
    private String name;
    /**
     * Grad u kojem se tim nalazi.
     * Predstavlja grad kao String.
     */
    private String city;
    /**
     * Zemlja u kojoj se tim nalazi.
     * Predstavlja zemlju kao String.
     */
    private String country;
    /**
     * Godina kada je tim osnovan.
     * Predstavlja godinu osnivanja tima kao ceo broj.
     */
    private int foundedIn;
    /**
     * Lista igrača koji pripadaju timu.
     * Predstavlja listu objekata klase {@link Player}.
     */
    List<Player> players = new ArrayList<>();

    /**
     * Konstruktor za inicijalizaciju tima sa svim atributima.
     * 
     * @param id - ID tima kao Long vrednost.
     * @param name - Naziv tima kao String.
     * @param city - Grad u kojem se tim nalazi kao String.
     * @param country - Zemlja u kojoj se tim nalazi kao String.
     * @param foundedIn - Godina osnivanja tima kao ceo broj.
     */
    public Team(Long id, String name, String city, String country, int foundedIn) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.foundedIn = foundedIn;
        this.players = new ArrayList<>();
    }

    /**
     * Prazan konstruktor za kreiranje instance tima bez inicijalizacije atributa.
     */
    public Team() {
        this.players = new ArrayList<>();
    }

    /**
     * Vraća listu igrača koji pripadaju timu.
     * 
     * @return players - Lista igrača kao {@link List} objekata klase {@link Player}.
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Postavlja novu listu igrača za tim.
     * 
     * @param players - Nova lista igrača kao {@link List} objekata klase {@link Player}.
     * 
     * @throws NullPointerException - Ako je lista igrača null.
     */
    public void setPlayers(List<Player> players) {
        if (players == null) {
            throw new NullPointerException("Players list cannot be null.");
        }
        this.players = players;
    }
    

    /**
     * Vraća ID tima.
     * 
     * @return id - ID tima kao Long vrednost.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID tima.
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
     * Vraća naziv tima.
     * 
     * @return name - Naziv tima kao String.
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja novi naziv tima.
     * 
     * @param name - Novi naziv tima kao String.
     * 
     * @throws NullPointerException - Ako je naziv null.
     * @throws IllegalArgumentException - Ako je naziv prazan String.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Vraća grad u kojem se tim nalazi.
     * 
     * @return city - Grad kao String.
     */
    public String getCity() {
        return city;
    }

    /**
     * Postavlja novi grad u kojem se tim nalazi.
     * 
     * @param city - Novi grad kao String.
     * 
     * @throws NullPointerException - Ako je grad null.
     * @throws IllegalArgumentException - Ako je grad prazan String.
     */
    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
        this.city = city;
    }
   
    /**
     * Vraća zemlju u kojoj se tim nalazi.
     * 
     * @return country - Zemlja kao String.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Postavlja novu zemlju u kojoj se tim nalazi.
     * 
     * @param country - Nova zemlja kao String.
     * 
     * @throws NullPointerException - Ako je zemlja null.
     * @throws IllegalArgumentException - Ako je zemlja prazan String.
     */
    public void setCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty.");
        }
        this.country = country;
    }

    /**
     * Vraća godinu kada je tim osnovan.
     * 
     * @return foundedIn - Godina osnivanja tima kao ceo broj.
     */
    public int getFoundedIn() {
        return foundedIn;
    }

    /**
     * Postavlja novu godinu kada je tim osnovan.
     * 
     * @param foundedIn - Nova godina osnivanja kao ceo broj.
     * 
     * @throws IllegalArgumentException - Ako je godina manja ili jednaka 0.
     */
    public void setFoundedIn(int foundedIn) {
        if (foundedIn <= 0) {
            throw new IllegalArgumentException("Founded year must be a positive number.");
        }
        this.foundedIn = foundedIn;
    }
    
    

    /**
     * Vraća hash code objekta tima na osnovu svih atributa.
     * 
     * @return hash - Hash code izračunat na osnovu ID-a, naziva, grada, zemlje i godine osnivanja tima.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.city);
        hash = 83 * hash + Objects.hashCode(this.country);
        hash = 83 * hash + this.foundedIn;
        return hash;
    }

    /**
     * Poredi dva tima prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca tima nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, name, city, country, foundedIn) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase Team, ili se razlikuje po vrednosti nekog atributa</li>
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
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.foundedIn != other.foundedIn) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return Objects.equals(this.country, other.country);
    }

        
    /**
     * Vraća String reprezentaciju tima na osnovu naziva, grada i zemlje tima.
     * 
     * @return String - Kombinacija naziva, grada i zemlje tima kao String.
     */
    @Override
    public String toString() {
        return name + " " + city + " " + country;
    }

    @Override
    public String getTableName() {
        return "team";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, city, country, foundedIn";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id","name", "city", "country", "foundedIn"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "'" + ", " + "'" + city + "'" + ", " + "'" + country + "'" + ", " +  foundedIn ;
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getString", "getInt"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', " + "city = '" + city + "', " + "country = '" + country + "', " + "foundedIn = " + foundedIn;
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
