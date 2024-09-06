package domain;

import java.util.Objects;

/**
 * Predstavlja ligu u bazi podataka.
 * 
 * Sadrži ID, naziv, sezonu i pruža funkcionalnosti za rad sa bazom podataka u vezi sa ligama.
 * 
 * @author Radin
 */
public class League implements GenericEntity{
	/**
     * ID lige u bazi podataka. 
     * Predstavlja jedinstveni identifikator za ligu.
     */
    private Long id;
    /**
     * Naziv lige.
     * Predstavlja naziv lige kao String.
     */
    private String name;
    /**
     * Sezona lige.
     * Predstavlja sezonu lige kao String.
     */
    private String season;

    /**
     * Konstruktor za inicijalizaciju lige sa svim atributima.
     * 
     * @param id - ID lige kao Long vrednost.
     * @param name - Naziv lige kao String.
     * @param season - Sezona lige kao String.
     */
    public League(Long id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
    }

    /**
     * Prazan konstruktor za kreiranje instance lige bez inicijalizacije atributa.
     */
    public League() {
    }

    
    /**
     * Vraća ID lige.
     * 
     * @return id - ID lige kao Long vrednost.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID lige.
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
     * Vraća naziv lige.
     * 
     * @return name - Naziv lige kao String.
     */
    public String getName() {
        return name;
    }

    /**
     * Postavlja novi naziv lige.
     * 
     * @param name - Novi naziv lige kao String.
     * 
     * @throws NullPointerException - Ako je naziv null.
     * @throws IllegalArgumentException - Ako je naziv prazan String.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    /**
     * Vraća sezonu lige.
     * 
     * @return season - Sezona lige kao String.
     */
    public String getSeason() {
        return season;
    }
    

    /**
     * Postavlja novu sezonu lige.
     * 
     * @param season - Nova sezona lige kao String.
     * 
     * @throws NullPointerException - Ako je sezona null.
     * @throws IllegalArgumentException - Ako je sezona prazan String.
     */
    public void setSeason(String season) {
        if (season == null || season.isEmpty()) {
            throw new NullPointerException("Season cannot be null or empty.");
        }
        this.season = season;
    }

    /**
     * Vraća hash code objekta lige na osnovu svih atributa.
     * 
     * @return hash - Hash code izračunat na osnovu ID-a, naziva i sezone lige.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.season);
        return hash;
    }

    /**
     * Poredi dve lige prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca lige nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, name, season) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase League, ili se razlikuje po vrednosti nekog atributa</li>
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
        final League other = (League) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.season, other.season)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     * Vraća String reprezentaciju lige na osnovu naziva lige.
     * 
     * @return name - Naziv lige kao String.
     */
    @Override
    public String toString() {
        return name;
    }
    
     @Override
    public String getTableName() {
        return "league";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "name, season";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "name", "season"};
    }

    @Override
    public String getInsertValues() {
        return "'" + name + "', '" + season + "'";
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getString", "getString"};
    }

    @Override
    public String getUpdateValues() {
        return "name = '" + name + "', season = '" + season + "'";
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
