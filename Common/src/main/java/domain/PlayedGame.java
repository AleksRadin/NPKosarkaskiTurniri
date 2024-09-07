package domain;

import java.util.Objects;

/**
 * Predstavlja odigranu utakmicu.
 * 
 * Sadrži domaći tim, gostujući tim, utakmicu i rezultate timova.
 * 
 * @author Radin
 */
public class PlayedGame implements GenericEntity{
	/**
     * Domaći tim u odigranoj utakmici.
     */
    private Team homeTeam;
    /**
     * Gostujući tim u odigranoj utakmici.
     */
    private Team awayTeam;
    /**
     * Utakmica koja je odigrana.
     */
    private Game game;
    /**
     * Rezultati domaćeg tima.
     */
    private int homeTeamPoints;
    /**
     * Rezultati gostujućeg tima.
     */
    private int awayTeamPoints;

    /**
     * Konstruktor koji postavlja sve atribute odigrane utakmice.
     * 
     * @param homeTeam - Domaći tim.
     * @param awayTeam - Gostujući tim.
     * @param game - Utakmica.
     * @param homeTeamPoints - Rezultati domaćeg tima.
     * @param awayTeamPoints - Rezultati gostujućeg tima.
     */
    public PlayedGame(Team homeTeam, Team awayTeam, Game game, int homeTeamPoints, int awayTeamPoints) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.game = game;
        this.homeTeamPoints = homeTeamPoints;
        this.awayTeamPoints = awayTeamPoints;
    }

    /**
     * Default konstruktor.
     */
    public PlayedGame() {
    }
    
    

    /**
     * Vraća domaći tim u odigranoj utakmici.
     * 
     * @return homeTeam - Domaći tim.
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Postavlja novi domaći tim u odigranoj utakmici.
     * 
     * @param homeTeam - Novi domaći tim.
     * @throws NullPointerException - Ako je domaći tim null.
     */
    public void setHomeTeam(Team homeTeam) {
        if (homeTeam == null) {
            throw new NullPointerException("Home team cannot be null.");
        }
        this.homeTeam = homeTeam;
    }
    
    /**
     * Vraća gostujući tim u odigranoj utakmici.
     * 
     * @return awayTeam - Gostujući tim.
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Postavlja novi gostujući tim u odigranoj utakmici.
     * 
     * @param awayTeam - Novi gostujući tim.
     * @throws NullPointerException - Ako je gostujući tim null.
     */
    public void setAwayTeam(Team awayTeam) {
        if (awayTeam == null) {
            throw new NullPointerException("Away team cannot be null.");
        }
        this.awayTeam = awayTeam;
    }

    /**
     * Vraća utakmicu koja je odigrana.
     * 
     * @return game - Utakmica.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Postavlja novu utakmicu.
     * 
     * @param game - Nova utakmica.
     * @throws NullPointerException - Ako je utakmica null.
     */
    public void setGame(Game game) {
        if (game == null) {
            throw new NullPointerException("Game cannot be null.");
        }
        this.game = game;
    }

    /**
     * Vraća rezultate domaćeg tima.
     * 
     * @return homeTeamPoints - Rezultati domaćeg tima.
     */
    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    /**
     * Postavlja nove rezultate za domaći tim.
     * 
     * @param homeTeamPoints - Novi rezultati domaćeg tima.
     * @throws IllegalArgumentException - Ako su rezultati negativni.
     */
    public void setHomeTeamPoints(int homeTeamPoints) {
        if (homeTeamPoints < 0) {
            throw new IllegalArgumentException("Home team points cannot be negative.");
        }
        this.homeTeamPoints = homeTeamPoints;
    }

    /**
     * Vraća rezultate gostujućeg tima.
     * 
     * @return awayTeamPoints - Rezultati gostujućeg tima.
     */
    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    /**
     * Postavlja nove rezultate za gostujući tim.
     * 
     * @param awayTeamPoints - Novi rezultati gostujućeg tima.
     * @throws IllegalArgumentException - Ako su rezultati negativni.
     */
    public void setAwayTeamPoints(int awayTeamPoints) {
        if (awayTeamPoints < 0) {
            throw new IllegalArgumentException("Away team points cannot be negative.");
        }
        this.awayTeamPoints = awayTeamPoints;
    }

    /**
     * Vraća hash kod objekta odigrane utakmice, koristi sve atribute klase.
     * 
     * @return hashCode - Hash kod objekta.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.homeTeam);
        hash = 19 * hash + Objects.hashCode(this.awayTeam);
        hash = 19 * hash + Objects.hashCode(this.game);
        hash = 19 * hash + this.homeTeamPoints;
        hash = 19 * hash + this.awayTeamPoints;
        return hash;
    }

    /**
     * Poredi dve odigrane utakmice prema svim atributima.
     * 
     * @param obj - Predstavlja (drugi) objekat sa kojim će se porediti instanca odigrane utakmice nad kojom je pozvana metoda equals().
     * @return 
     * <ul>
     *     <li>true - ako su svi atributi (homeTeam, awayTeam, game, homeTeamPoints, awayTeamPoints) isti</li>
     *     <li>false - ako je unet null objekat, objekat nije klase PlayedGame, ili se razlikuje po vrednosti nekog atributa</li>
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
        final PlayedGame other = (PlayedGame) obj;
        if (this.homeTeamPoints != other.homeTeamPoints) {
            return false;
        }
        if (this.awayTeamPoints != other.awayTeamPoints) {
            return false;
        }
        if (!Objects.equals(this.homeTeam, other.homeTeam)) {
            return false;
        }
        if (!Objects.equals(this.awayTeam, other.awayTeam)) {
            return false;
        }
        return Objects.equals(this.game, other.game);
    }

    /**
     * Vraća String reprezentaciju objekta odigrane utakmice.
     * 
     * @return string - String reprezentacija objekta u formatu "PlayedGame{homeTeam=&lt;homeTeam&gt;, awayTeam=&lt;awayTeam&gt;, game=&lt;game&gt;, homeTeamPoints=&lt;homeTeamPoints&gt;, awayTeamPoints=&lt;awayTeamPoints&gt;}"
     */
    @Override
    public String toString() {
        return "PlayedGame{" + "homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", game=" + game + ", homeTeamPoints=" + homeTeamPoints + ", awayTeamPoints=" + awayTeamPoints + '}';
    }

    @Override
    public String getTableName() {
        return "played_game";
    }

    @Override
    public String getColumnNamesForInsert() {
         return "home_team_id, away_team_id, game_id, home_team_points, away_team_points";
    }

    @Override
    public String[] getColumnNamesForSelect() {
        return new String[] {"home_team_id", "away_team_id", "game_id", "home_team_points", "away_team_points"};
    }

    @Override
    public String getInsertValues() {
        return homeTeam.getId() + ", " + awayTeam.getId() + ", " + game.getId() + ", " + homeTeamPoints + ", " + awayTeamPoints;
    }

    @Override
    public String[] getResultSetMethods() {
        return new String[] {"getLong", "getLong", "getLong", "getInt", "getInt"};
    }

    @Override
    public String getUpdateValues() {
        return "home_team_id = " + homeTeam.getId() +
           ", away_team_id = " + awayTeam.getId() +
           ", game_id = " + game.getId() +
           ", home_team_points = " + homeTeamPoints +
           ", away_team_points = " + awayTeamPoints;
    }

    @Override
    public String getWhereCondition() {
        return "home_team_id = " + homeTeam.getId() +
           " AND away_team_id = " + awayTeam.getId() +
           " AND game_id = " + game.getId();
    }

    @Override
    public String getWhereConditionEditOperation() {
        return "home_team_id = " + homeTeam.getId() +
           " AND away_team_id = " + awayTeam.getId() +
           " AND game_id = " + game.getId();
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
