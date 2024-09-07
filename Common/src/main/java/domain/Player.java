package domain;

import java.time.LocalDate;
import java.util.Objects;
import player.state.PlayerPosition;
import player.state.PlayerState;

/**
 * Predstavlja igrača.
 * 
 * Sadrži ID, ime, prezime, datum rođenja, poziciju, visinu, težinu, i tim kojem pripada.
 * 
 * @author Radin
 */
public class Player implements GenericEntity{
    
	/**
	 * Jedinstveni identifikator igrača.
	 */
    private Long id;
    /**
     * Ime igrača.
     */
    private String firstname;
    /**
     * Prezime igrača.
     */
    private String lastname;
    /**
     * Datum rođenja igrača.
     */
    private LocalDate birthday;
    /**
     * Pozicija igrača na terenu.
     */
    private String position;
    /**
     * Visina igrača.
     */
    private double height;
    /**
     * Težina igrača.
     */
    private double weight;
    /**
     * Tim kojem igrač pripada.
     */
    private Team team;
    /**
     * Trenutno stanje igrača.
     */
    private PlayerState state;

    
    /**
     * Konstruktor za kreiranje objekta igrača sa svim potrebnim informacijama.
     * 
     * @param id Jedinstveni identifikator igrača.
     * @param firstname Ime igrača.
     * @param lastname Prezime igrača.
     * @param birthday Datum rođenja igrača.
     * @param position Pozicija igrača na terenu.
     * @param height Visina igrača u metrima.
     * @param weight Težina igrača u kilogramima.
     * @param team Tim kojem igrač pripada.
     * @param state Trenutno stanje igrača.
     */
    public Player(Long id, String firstname, String lastname, LocalDate birthday, String position, double height, double weight, Team team, PlayerState state) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.state = state;
    }

    
    /**
     * Prazan konstruktor za inicijalizaciju objekta igrača.
     */
    public Player() {
    }

    /**
     * Konstruktor za kreiranje objekta igrača sa svim informacijama osim tima.
     * 
     * @param id Jedinstveni identifikator igrača.
     * @param firstname Ime igrača.
     * @param lastname Prezime igrača.
     * @param birthday Datum rođenja igrača.
     * @param position Pozicija igrača na terenu.
     * @param height Visina igrača u metrima.
     * @param weight Težina igrača u kilogramima.
     * @param state Trenutno stanje igrača.
     */
    public Player(Long id, String firstname, String lastname, LocalDate birthday, String position, double height, double weight, PlayerState state) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.state = state;
    }
  


    /**
     * Postavlja stanje igrača na nepromenjeno.
     */
	public void loadPlayer(){
        state = PlayerState.UNCHANGED;
    }
    
	/**
     * Vraća jedinstveni identifikator igrača.
     * 
     * @return Jedinstveni identifikator igrača.
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja jedinstveni identifikator igrača.
     * 
     * @param id Jedinstveni identifikator igrača.
     * @throws NullPointerException Ako je ID null.
     * @throws IllegalArgumentException Ako je ID manji ili jednak 0.
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
     * Vraća ime igrača.
     * 
     * @return Ime igrača.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Postavlja ime igrača.
     * 
     * @param firstname Ime igrača.
     * @throws NullPointerException Ako je ime null ili prazno.
     */
    public void setFirstname(String firstname) {
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new NullPointerException("Firstname cannot be null or empty.");
        }
        this.firstname = firstname;
    }

    /**
     * Vraća prezime igrača.
     * 
     * @return Prezime igrača.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Postavlja prezime igrača.
     * 
     * @param lastname Prezime igrača.
     * @throws NullPointerException Ako je prezime null ili prazno.
     */
    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new NullPointerException("Lastname cannot be null or empty.");
        }
        this.lastname = lastname;
    }

    /**
     * Vraća datum rođenja igrača.
     * 
     * @return Datum rođenja igrača.
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Postavlja datum rođenja igrača.
     * 
     * @param birthday Datum rođenja igrača.
     * @throws NullPointerException Ako je datum rođenja null.
     * @throws IllegalArgumentException Ako je datum rođenja u budućnosti.
     */
    public void setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new NullPointerException("Birthday cannot be null.");
        }
        if (birthday.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthday cannot be in the future.");
        }
        this.birthday = birthday;
    }

    /**
     * Vraća poziciju igrača na terenu.
     * 
     * @return Pozicija igrača na terenu.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Postavlja poziciju igrača na terenu.
     * 
     * @param position Pozicija igrača na terenu.
     * @throws NullPointerException Ako je pozicija null ili prazna.
     */
    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new NullPointerException("Position cannot be null or empty.");
        }
        this.position = position;
    }

    /**
     * Vraća visinu igrača.
     * 
     * @return Visina igrača u metrima.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Postavlja visinu igrača.
     * 
     * @param height Visina igrača u metrima.
     * @throws IllegalArgumentException Ako je visina negativna.
     */
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative.");
        }
        this.height = height;
    }
    
    /**
     * Vraća težinu igrača.
     * 
     * @return Težina igrača u kilogramima.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Postavlja težinu igrača.
     * 
     * @param weight Težina igrača u kilogramima.
     * @throws IllegalArgumentException Ako je težina negativna.
     */
    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.weight = weight;
    }

    /**
     * Vraća tim kojem igrač pripada.
     * 
     * @return Tim kojem igrač pripada.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Postavlja tim kojem igrač pripada.
     * 
     * @param team Tim kojem igrač pripada.
     * @throws NullPointerException Ako je tim null.
     */
    public void setTeam(Team team) {
        if (team == null) {
            throw new NullPointerException("Team cannot be null.");
        }
        this.team = team;
    }

    /**
     * Vraća trenutno stanje igrača.
     * 
     * @return Trenutno stanje igrača.
     */
    public PlayerState getState() {
        return state;
    }

    /**
     * Postavlja trenutno stanje igrača.
     * 
     * @param state Trenutno stanje igrača.
     * @throws NullPointerException Ako je stanje null.
     */
    public void setState(PlayerState state) {
        if (state == null) {
            throw new NullPointerException("Player state cannot be null.");
        }
        this.state = state;
    }

    
    
    /**
     * Vraća hash kod objekta igrača koristeći sve atribute klase.
     * 
     * @return hashCode - Hash kod objekta.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.firstname);
        hash = 83 * hash + Objects.hashCode(this.lastname);
        hash = 83 * hash + Objects.hashCode(this.birthday);
        hash = 83 * hash + Objects.hashCode(this.position);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        return hash;
    }

    /**
     * Poredi dva objekta `Player` prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca `Player` na kojoj je pozvana metoda `equals()`.
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (id, firstname, lastname, birthday, position, height, weight) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase `Player`, ili se razlikuje po vrednosti nekog atributa</li>
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
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return Objects.equals(this.birthday, other.birthday);
    }

    /**
     * Vraća String reprezentaciju objekta `Player`.
     * 
     * @return string - String reprezentacija objekta u formatu "firstname lastname - position"
     */
    @Override
    public String toString() {
        return firstname + " " + lastname + " - " + position;
    }

    @Override
    public String getTableName() {
        return "player";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "firstname, lastname, birthday, position, height, weight, team_id";
    } 

    @Override
    public String[] getColumnNamesForSelect() {
        String[] columnNames = new String[] {"id", "firstname", "lastname", "birthday", "position", "height", "weight", "team_id"};
        return columnNames;
    }

    @Override
    public String getInsertValues() {
        return "'" + firstname + "'" + ", " + "'" + lastname + "'" + ", " + "'" + birthday + "'" + ", " + "'" + position + "'" + ", " + height + ", " + weight + ", " + team.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        String[] resultSetMethods = new String[] {"getLong", "getString", "getString", "getDate", "getString", "getDouble", "getDouble","getLong"};
        return resultSetMethods;
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = java.sql.Date.valueOf(birthday);
        return "firstname = '" + firstname + "', " + "lastname = '" + lastname + "', " + "birthday = '" + sqlDate + "', " + "position = '" + position + "', " + "height = " + height + ", " + "weight = " + weight + ", " + "team_id = " + team.getId();
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
