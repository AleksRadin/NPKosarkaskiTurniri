package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Predstavlja igru koja se odigrava u okviru lige.
 * 
 * Sadrži ID, datum i vreme igre, kao i ligu u kojoj se igra.
 * 
 * @author Radin
 */
public class Game implements GenericEntity{
	/**
     * ID igre u vidu Long vrednosti (ceo broj).
     */
    private Long id;
    /**
     * Datum kada se igra odigrala.
     */
    private LocalDate gameDate;
    /**
     * Vreme kada se igra odigrala.
     */
    private LocalTime gameTime;
    /**
     * Liga u kojoj je igra odigrana.
     */
    private League league;

    /**
     * Parametrizovani konstruktor koji kreira instancu igre sa specifičnim vrednostima za sva polja.
     * 
     * @param id - ID igre koji se dodeljuje prilikom kreiranja
     * @param gameDate - Datum kada se igra odigrala
     * @param gameTime - Vreme kada se igra odigrala
     * @param league - Liga u kojoj je igra odigrana
     */
    public Game(Long id, LocalDate gameDate, LocalTime gameTime, League league) {
        this.id = id;
        this.gameDate = gameDate;
        this.gameTime = gameTime;
        this.league = league;
    }

    /**
     * Prazan konstruktor za kreiranje instance igre sa podrazumevanim vrednostima za sva polja.
     */
    public Game() {
    }

    /**
     * Vraca ligu u kojoj je igra odigrana.
     * 
     * @return league - Liga kao objekat klase League.
     */
    public League getLeague() {
        return league;
    }

    /**
     * Postavlja novu ligu za igru.
     * 
     * @param league - Nova liga u kojoj je igra odigrana
     * 
     * @throws NullPointerException - ako se unese null vrednost za ligu
     */
    public void setLeague(League league) {
        if (league == null) {
            throw new NullPointerException("League cannot be null.");
        }
        this.league = league;
    }


    /**
     * Vraca ID igre.
     * 
     * @return id - ID igre kao Long vrednost (ceo broj).
     */
    public Long getId() {
        return id;
    }

    /**
     * Postavlja novu vrednost za ID igre.
     * 
     * @param id - Nova vrednost za ID igre
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
     * Vraca datum kada se igra odigrala.
     * 
     * @return gameDate - Datum igre kao LocalDate.
     */
    public LocalDate getGameDate() {
        return gameDate;
    }
    
    /**
     * Postavlja novi datum za igru.
     * 
     * @param gameDate - Novi datum igre
     * 
     * @throws NullPointerException - ako se unese null vrednost za datum
     */
    public void setGameDate(LocalDate gameDate) {
        if (gameDate == null) {
            throw new NullPointerException("Game date cannot be null.");
        }
        this.gameDate = gameDate;
    }

    /**
     * Vraca vreme kada se igra odigrala.
     * 
     * @return gameTime - Vreme igre kao LocalTime.
     */
    public LocalTime getGameTime() {
        return gameTime;
    }

    /**
     * Postavlja novo vreme za igru.
     * 
     * @param gameTime - Novo vreme igre
     * 
     * @throws NullPointerException - ako se unese null vrednost za vreme
     */
    public void setGameTime(LocalTime gameTime) {
        if (gameTime == null) {
            throw new NullPointerException("Game time cannot be null.");
        }
        this.gameTime = gameTime;
    }

    /**
     * Računa hash kod na osnovu svih atributa igre.
     * 
     * @return hash - Hash kod izračunat na osnovu ID-a igre, datuma igre, vremena igre i lige.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Poredi dve igre prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca igre nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase Game, ili se razlikuje po vrednosti nekog atributa</li>
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
        final Game other = (Game) obj;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.gameDate, other.gameDate) &&
                Objects.equals(this.gameTime, other.gameTime) &&
                Objects.equals(this.league, other.league);
    }

    
    /**
     * Vraća String reprezentaciju igre na osnovu identifikatora igre.
     * 
     * @return game - String reprezentacija igre u formatu "Game - ID", gde je ID identifikator igre.
     */
    @Override
    public String toString() {
        return String.format("Game - %d", id);
    }

    @Override
    public String getTableName() {
        return "game";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "game_date, game_time, league_id";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"id", "game_date", "game_time", "league_id"};
    }

    @Override
    public String getInsertValues() {
        return "'" + gameDate + "', '" + gameTime + "', " + league.getId();
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getDate", "getTime", "getLong"};
    }

    @Override
    public String getUpdateValues() {
        java.sql.Date sqlDate = java.sql.Date.valueOf(gameDate);
        java.sql.Time sqlTime = java.sql.Time.valueOf(gameTime);
        return "game_date = '" + sqlDate + "', game_time = '" + sqlTime + "', league_id = " + league.getId();
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
